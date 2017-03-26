/**
 * Componente Curricular: M�dulo Integrado de Programa��o
 * Autor: Valmir Vinicius de Almeida Santos
 * Autor: Iago Almeida
 * Data: 06-04-2016
 *
 * Declaro que este c�digo foi elaborado por mim de forma individual e
 * n�o cont�m nenhum trecho de c�digo de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e p�ginas ou documentos 
 * eletr�nicos da Internet. Qualquer trecho de c�digo de outra autoria que
 * uma cita��o para o  n�o a minha est� destacado com  autor e a fonte do
 * c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins
 * de avalia��o. Alguns trechos do c�digo podem coincidir com de outros
 * colegas pois estes foram discutidos em sess�es tutorias.
 */
package br.uefs.ecomp.WINMonster.util;

/**
 * Classe respons�vel por implementar o algoritmo de Huffman.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class Huffman {
    /** �rvore de huffman gerada na codifica��o. */
    private ArvoreHuffman arvore;
    
    /** Texto original. */
    private char[] textoOriginal;
    
    /** Dicion�rio gerado na codifica��o. */
    private String[][] dicionario;
    
    /**
     * Obt�m uma nova inst�ncia do algoritmo de Huffman.
     * @param texto texto que ser� codificado.
     */
    public Huffman(String texto) {
        textoOriginal = texto.toCharArray(); //obt�m o array da String
    }
    
    /**
     * Obt�m uma nova inst�ncia do algoritmo de Huffman.
     * @param arvore que ser� usada para decodifica��o
     * @param numCaracteres n�mero de caracteres diferentes no texto a ser decodificado
     */
    public Huffman(ArvoreHuffman arvore, int numCaracteres) {
        this.arvore = arvore; //define a �rvore de huffman
        dicionario = new String[2][numCaracteres]; //cria uma nova inst�ncia de matriz para o dicion�rio
        geradorCodigos(arvore.getRaiz(), new StringBuffer()); //gera os c�digos
    }
    
    /**
     * Obt�m o dicion�rio.
     * @return dicion�rio usaddo na codifica��o
     */
    public String[][] getDicionario() {
        return dicionario; //retorna o atributo "dicion�rio"
    }
    
    /**
     * Obt�m a �rvore de Huffman.
     * @return refer�ncia para a �rvore de Huffman
     */
    public ArvoreHuffman getArvore() {
        return arvore; //retorna o atributo "�rvore"
    }
    
 
    /**
     * Calcula a frequ�ncia de cada letra no texto informado. Retorna um vetor com os caracteres de Huffman criados.
     * @return array com as respectivas frequ�ncias dos caracteres
     */
    private Object[] calcularFrequencias() {
        ListaEncadeada frequencias = new ListaEncadeada(); //cria inst�ncia de lista encadeada para armazenar frequ�ncias
        Iterador it; //refer�ncia auxiliar para o iterador da lista encadeada
        CaractereHuffman caractereAuxiliar; //caractere de huffman auxiliar para buscas
        boolean encontrou = false; //boleano para indicar se o caractere j� foi cadastrado anteriormente
        
        for(int i = 0; i<textoOriginal.length; i++) {
            char c = textoOriginal[i]; //obt�m o caractere do texto
            
            it = frequencias.iterador(); //obt�m o iterador da lista encadeada
            
           while(it.temProximo()) { //verifica se h� um pr�ximo caractere na lista
                caractereAuxiliar = (CaractereHuffman) it.obterProximo(); //obt�m um caractere de huffman da lista
                if(caractereAuxiliar.getCaractere().equals(c)) { //verifica se o caractere obtido do texto na itera��o � um caractere de huffman j� registrado na lista
                    encontrou = true; //altera o valor do boleano indicando que o caractere j� foi encontrado
                    caractereAuxiliar.atualizarFrequencia(); //atualiza a frequ�ncia do caractere
                } 
            }
            
            if(!encontrou) { //caso o caractere de huffman n�o esteja previamente cadastrado
                frequencias.inserir(new CaractereHuffman(c, 1)); //cria um novo caractere de huffman e o insere na lista
            }
            
            encontrou = false; //alterar o valor do boleano para outra itera��o
        }
        
        return frequencias.obterArray(); //retorna o Array com os caracteres contabilizados
    }
    
    /**
     * Cria a fila de prioridade da qual ser� gerada a �rvore de Huffman.
     * @param frequencias
     * @return fila de prioridade contendo "sub�vores" de huffman
     */
    private FilaPrioridade gerarFilaPrioridade(Object[] frequencias) {
        FilaPrioridade filaHuffman = new FilaPrioridade(); //cria uma nova inst�ncia de fila de prioridade
        NoHuffman noArvore; //n� auxiliar para inser��o na fila

        for(Object c : frequencias) { //percorre o Array com os caracteres de huffman
            noArvore = new NoHuffman((CaractereHuffman) c); //cria um novo n� da �rvore
            
            filaHuffman.inserir(new ArvoreHuffman(noArvore)); //cria uma nova �rvore e a insere na fila de prioridade
        }
        
        return filaHuffman; //retorna a refer�ncia para a fila criada
    }
    
    /**
     * Cria uma �rvore de Huffman para realizar codifica��o.
     */
    private void gerarArvore() {
        FilaPrioridade fila = gerarFilaPrioridade(calcularFrequencias()); //chama, respectivamente, o m�todo de calcular a frequ�ncia e gerar Fila de prioridade. Atribui a refer�ncia de fila obtida � vari�vel.
        ArvoreHuffman removida1, removida2, subArvore; //refer�ncias auxiliares para o processo de criar a �rvore
        
        while(fila.obterTamanho() != 1) { //enquanto o tamanho da fila n�o for 1
            removida1 = (ArvoreHuffman) fila.removerInicio(); //remove a primeira �rvore
            removida2 = (ArvoreHuffman) fila.removerInicio(); //remove a segunda �rvore
            
            subArvore = new ArvoreHuffman(new NoHuffman(removida1.getRaiz(), removida2.getRaiz(), new CaractereHuffman(removida1.obterFrequenciaTotal() + removida2.obterFrequenciaTotal()))); //cria uma sub�rvore cujo filho � esquerda da raiz � a raiz da primeira �rvore removida da fila e cujo filho � direita da raiz � a raiz da segunda �rvore removida da fila
            
            fila.inserir(subArvore); //insere a subArvore criada na fila novamente
        }
        
        this.arvore = (ArvoreHuffman) fila.removerInicio(); //atribui a refer�ncia da �rvore criada ao atributo "arvore"
    }
    
    /**
     * Gera os c�digos para cada caractere do texto e os armazena no dicion�rio.
     * @param atual n� da �rvore de huffman que est� sendo verificado na itera��o
     * @param codigo armazena os c�digos que est�o sendo gerados
     */      
    private void geradorCodigos(NoHuffman atual, StringBuffer codigo) {
        if(atual != null) { //se o n� n�o for correspondente ao caso base da recurs�o, isto �, se o n� de huffman atual n�o for nulo
            if(atual.isFolha()) { //verifica se o n� atual � folha
                int coluna = obterColunaLivre(); //obt�m a coluna livre do dicion�rio
                
                /* Insere o c�igo gerado e o seu caractere respondente no dicion�rio. */
                dicionario[0][coluna] = atual.getConteudo().getCaractere().toString();
                dicionario[1][coluna] = codigo.toString();
                
                return; //finaliza o caso de recurs�o atual
            }

            codigo.append("0"); //adiciona um "0" no c�digo
            geradorCodigos(atual.getFilhoEsquerda(), codigo); //chama o m�todo passando o filho da esquerda e o c�digo gerado at� o momento
            codigo.deleteCharAt(codigo.length()-1);//remove o ultimo caractere inserido
            codigo.append("1"); //adiciona um "1" no c�digo
            geradorCodigos(atual.getFilhoDireita(),  codigo); //chama o m�todo passando o filho da direita e o c�digo gerado at� o momento
            codigo.deleteCharAt(codigo.length()-1);//remove o ultimo caractere inserido
        }
    }
    
    /**
     * Realiza a codifica��o do texto.
     * @return texto codificado
     */
    public String codificar() {
        StringBuffer textoCodificado = new StringBuffer(); //cria uma nova StringBuffer para armazenar o texto codificado
        
        if(dicionario == null) { //se o dicion�rio for nulo, isto �, se a codifica��o n�o tiver sido realizada anteriormente
            gerarArvore(); //gera a �rvore de huffman
            dicionario = new String[2][calcularFrequencias().length]; //cria uma nova inst�ncia de dicion�rio de acordo com o n�mero de caracteres do texto
            geradorCodigos(arvore.getRaiz(), new StringBuffer()); //chama o m�todo de codifica��o que vai preencher o dicion�rio
        }
            
        for(int i = 0; i<textoOriginal.length; i++) { //percorre cada caractere do texto original
            textoCodificado.append(obterCodigoNoDicionario(textoOriginal[i])); //busca no dicion�rio o c�digo correspondente a cada caractere do texto e adiciona no texto codificado
        }
        
        return textoCodificado.toString(); //retorna a vers�o String do texto codificado
    }
    
    
    /**
     * Realiza a decodifica��o do texto.
     * @param textoCodificado texto codificado
     * @return texto decodificado
     */
    public String decodificar(String textoCodificado) {
        StringBuffer textoDecodificado = new StringBuffer(); //cria nova inst�ncia de StringBuffer para armazenar o texto decodificado
        StringBuffer auxiliar = new StringBuffer(); //StringBuffer auxiliar
        String letra = null; //String para armazenar cada letra obtida do dicion�rio
        int contador = 0; //contador para controlar as iterações de acordo com a quantidade de caracteres no texto codificado
        
        while(contador<textoCodificado.length()) { //enquanto a quantidade de caracteres no texto codificado for maior que o contador

            while(letra == null) { //enquanto a refer�ncia "letra" for nula, isto �, enquanto n�o tiver sido encontrada uma letra v�lida no dicion�rio
                auxiliar.append(textoCodificado.charAt(contador++)); //obt�m um caractere do texto incrementado e adiciona na StringBuffer auxiliar utilizada para buscas no dicion�rio e incrementa o contador
                letra = obterLetraNoDicionario(auxiliar.toString()); //obt�m uma refer�ncia nula ou de uma letra no dicion�rio
            }
            
            textoDecodificado.append(letra); //adiciona a letra encontrada no texto codificado
            letra = null; //torna a refer�cia de "letra" nula
            auxiliar = new StringBuffer(); //cria uma nova instância de StringBuffer para auxiliar
        }
        
        return textoDecodificado.toString(); //retorna a representa��o em String do texto decodificado
    }
    
    /**
     * Obt�m o c�digo de uma dada letra no dicion�rio.
     * @param letra letra que se deseja obter o c�digo
     * @return c�digo da letra
     */
    private String obterCodigoNoDicionario(Character letra) {
        int colunas = dicionario[0].length; //obt�m n�mero de colunas do dicion�rio
        
        for(int i = 0; i < colunas; i++) { //percorre as colunas do dicionario
            if(dicionario[0][i].equals(letra.toString())) { //letra selecionada � a letra busc
                return dicionario[1][i]; //retorna o c�digo
            }
        }
        
        return null; 
    }
    
    /**
     * Obt�m a letra no dicion�rio a partir de um dado c�digo.
     * @param codigo c�digo para o qual se deseja obter a letra
     * @return letra correspondente ao c�digo
     */
    private String obterLetraNoDicionario(String codigo) {
        int colunas = dicionario[0].length; //obt�m n�mero de colunas do dicion�rio
        
        for(int i = 0; i < colunas; i++) { //percorre as colunas do dicionario
            if(dicionario[1][i].equals(codigo)) { //verifica se o c�digo selecionado � o buscado
                return dicionario[0][i]; //retorna a letra referente ao c�digo
            }
        }
        
        return null; 
    }

    /**
     * Obt�m uma coluna livre do dicion�rio, isto �, uma coluna na qual pode ser realizada inser��o.
     * @return n�mero da coluna livre
     */
    private int obterColunaLivre() {
        int qtdColunas = dicionario[0].length; //obt�m o n�mero de colunas do dicion�rio
        
        for(int coluna = 0; coluna < qtdColunas; coluna++) { //percorre as colunas do dicion�rio
            if(dicionario[0][coluna] == null && dicionario[1][coluna] == null) { //se ambas as linhas da coluna estiverem desocupadas
                return coluna; //retorna o n�mero da coluna
            }
        }
        
        return 0; //retorna 0 quando o dicion�rio est� completamente vazio
    }
    
    
    
    
}
