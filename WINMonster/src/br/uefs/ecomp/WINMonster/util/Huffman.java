/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Valmir Vinicius de Almeida Santos
 * Autor: Iago Almeida
 * Data: 06-04-2016
 *
 * Declaro que este código foi elaborado por mim de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e páginas ou documentos 
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 */
package br.uefs.ecomp.WINMonster.util;

/**
 * Classe responsável por implementar o algoritmo de Huffman.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class Huffman {
    /** Árvore de huffman gerada na codificação. */
    private ArvoreHuffman arvore;
    
    /** Texto original. */
    private char[] textoOriginal;
    
    /** Dicionário gerado na codificação. */
    private String[][] dicionario;
    
    /**
     * Obtém uma nova instância do algoritmo de Huffman.
     * @param texto texto que será codificado.
     */
    public Huffman(String texto) {
        textoOriginal = texto.toCharArray(); //obtém o array da String
    }
    
    /**
     * Obtém uma nova instância do algoritmo de Huffman.
     * @param arvore que será usada para decodificação
     * @param numCaracteres número de caracteres diferentes no texto a ser decodificado
     */
    public Huffman(ArvoreHuffman arvore, int numCaracteres) {
        this.arvore = arvore; //define a árvore de huffman
        dicionario = new String[2][numCaracteres]; //cria uma nova instância de matriz para o dicionário
        geradorCodigos(arvore.getRaiz(), new StringBuffer()); //gera os códigos
    }
    
    /**
     * Obtém o dicionário.
     * @return dicionário usaddo na codificação
     */
    public String[][] getDicionario() {
        return dicionario; //retorna o atributo "dicionário"
    }
    
    /**
     * Obtém a árvore de Huffman.
     * @return referência para a árvore de Huffman
     */
    public ArvoreHuffman getArvore() {
        return arvore; //retorna o atributo "árvore"
    }
    
 
    /**
     * Calcula a frequência de cada letra no texto informado. Retorna um vetor com os caracteres de Huffman criados.
     * @return array com as respectivas frequências dos caracteres
     */
    private Object[] calcularFrequencias() {
        ListaEncadeada frequencias = new ListaEncadeada(); //cria instância de lista encadeada para armazenar frequências
        Iterador it; //referência auxiliar para o iterador da lista encadeada
        CaractereHuffman caractereAuxiliar; //caractere de huffman auxiliar para buscas
        boolean encontrou = false; //boleano para indicar se o caractere já foi cadastrado anteriormente
        
        for(int i = 0; i<textoOriginal.length; i++) {
            char c = textoOriginal[i]; //obtém o caractere do texto
            
            it = frequencias.iterador(); //obtém o iterador da lista encadeada
            
           while(it.temProximo()) { //verifica se há um próximo caractere na lista
                caractereAuxiliar = (CaractereHuffman) it.obterProximo(); //obtém um caractere de huffman da lista
                if(caractereAuxiliar.getCaractere().equals(c)) { //verifica se o caractere obtido do texto na iteração é um caractere de huffman já registrado na lista
                    encontrou = true; //altera o valor do boleano indicando que o caractere já foi encontrado
                    caractereAuxiliar.atualizarFrequencia(); //atualiza a frequência do caractere
                } 
            }
            
            if(!encontrou) { //caso o caractere de huffman não esteja previamente cadastrado
                frequencias.inserir(new CaractereHuffman(c, 1)); //cria um novo caractere de huffman e o insere na lista
            }
            
            encontrou = false; //alterar o valor do boleano para outra iteração
        }
        
        return frequencias.obterArray(); //retorna o Array com os caracteres contabilizados
    }
    
    /**
     * Cria a fila de prioridade da qual será gerada a árvore de Huffman.
     * @param frequencias
     * @return fila de prioridade contendo "subávores" de huffman
     */
    private FilaPrioridade gerarFilaPrioridade(Object[] frequencias) {
        FilaPrioridade filaHuffman = new FilaPrioridade(); //cria uma nova instância de fila de prioridade
        NoHuffman noArvore; //nó auxiliar para inserção na fila

        for(Object c : frequencias) { //percorre o Array com os caracteres de huffman
            noArvore = new NoHuffman((CaractereHuffman) c); //cria um novo nó da árvore
            
            filaHuffman.inserir(new ArvoreHuffman(noArvore)); //cria uma nova árvore e a insere na fila de prioridade
        }
        
        return filaHuffman; //retorna a referência para a fila criada
    }
    
    /**
     * Cria uma árvore de Huffman para realizar codificação.
     */
    private void gerarArvore() {
        FilaPrioridade fila = gerarFilaPrioridade(calcularFrequencias()); //chama, respectivamente, o método de calcular a frequência e gerar Fila de prioridade. Atribui a referência de fila obtida à variável.
        ArvoreHuffman removida1, removida2, subArvore; //referências auxiliares para o processo de criar a árvore
        
        while(fila.obterTamanho() != 1) { //enquanto o tamanho da fila não for 1
            removida1 = (ArvoreHuffman) fila.removerInicio(); //remove a primeira árvore
            removida2 = (ArvoreHuffman) fila.removerInicio(); //remove a segunda árvore
            
            subArvore = new ArvoreHuffman(new NoHuffman(removida1.getRaiz(), removida2.getRaiz(), new CaractereHuffman(removida1.obterFrequenciaTotal() + removida2.obterFrequenciaTotal()))); //cria uma subárvore cujo filho à esquerda da raiz é a raiz da primeira árvore removida da fila e cujo filho à direita da raiz é a raiz da segunda árvore removida da fila
            
            fila.inserir(subArvore); //insere a subArvore criada na fila novamente
        }
        
        this.arvore = (ArvoreHuffman) fila.removerInicio(); //atribui a referência da árvore criada ao atributo "arvore"
    }
    
    /**
     * Gera os códigos para cada caractere do texto e os armazena no dicionário.
     * @param atual nó da árvore de huffman que está sendo verificado na iteração
     * @param codigo armazena os códigos que estão sendo gerados
     */      
    private void geradorCodigos(NoHuffman atual, StringBuffer codigo) {
        if(atual != null) { //se o nó não for correspondente ao caso base da recursão, isto é, se o nó de huffman atual não for nulo
            if(atual.isFolha()) { //verifica se o nó atual é folha
                int coluna = obterColunaLivre(); //obtém a coluna livre do dicionário
                
                /* Insere o cóigo gerado e o seu caractere respondente no dicionário. */
                dicionario[0][coluna] = atual.getConteudo().getCaractere().toString();
                dicionario[1][coluna] = codigo.toString();
                
                return; //finaliza o caso de recursão atual
            }

            codigo.append("0"); //adiciona um "0" no código
            geradorCodigos(atual.getFilhoEsquerda(), codigo); //chama o método passando o filho da esquerda e o código gerado até o momento
            codigo.deleteCharAt(codigo.length()-1);//remove o ultimo caractere inserido
            codigo.append("1"); //adiciona um "1" no código
            geradorCodigos(atual.getFilhoDireita(),  codigo); //chama o método passando o filho da direita e o código gerado até o momento
            codigo.deleteCharAt(codigo.length()-1);//remove o ultimo caractere inserido
        }
    }
    
    /**
     * Realiza a codificação do texto.
     * @return texto codificado
     */
    public String codificar() {
        StringBuffer textoCodificado = new StringBuffer(); //cria uma nova StringBuffer para armazenar o texto codificado
        
        if(dicionario == null) { //se o dicionário for nulo, isto é, se a codificação não tiver sido realizada anteriormente
            gerarArvore(); //gera a árvore de huffman
            dicionario = new String[2][calcularFrequencias().length]; //cria uma nova instância de dicionário de acordo com o número de caracteres do texto
            geradorCodigos(arvore.getRaiz(), new StringBuffer()); //chama o método de codificação que vai preencher o dicionário
        }
            
        for(int i = 0; i<textoOriginal.length; i++) { //percorre cada caractere do texto original
            textoCodificado.append(obterCodigoNoDicionario(textoOriginal[i])); //busca no dicionário o código correspondente a cada caractere do texto e adiciona no texto codificado
        }
        
        return textoCodificado.toString(); //retorna a versão String do texto codificado
    }
    
    
    /**
     * Realiza a decodificação do texto.
     * @param textoCodificado texto codificado
     * @return texto decodificado
     */
    public String decodificar(String textoCodificado) {
        StringBuffer textoDecodificado = new StringBuffer(); //cria nova instância de StringBuffer para armazenar o texto decodificado
        StringBuffer auxiliar = new StringBuffer(); //StringBuffer auxiliar
        String letra = null; //String para armazenar cada letra obtida do dicionário
        int contador = 0; //contador para controlar as iteraÃ§Ãµes de acordo com a quantidade de caracteres no texto codificado
        
        while(contador<textoCodificado.length()) { //enquanto a quantidade de caracteres no texto codificado for maior que o contador

            while(letra == null) { //enquanto a referência "letra" for nula, isto é, enquanto não tiver sido encontrada uma letra válida no dicionário
                auxiliar.append(textoCodificado.charAt(contador++)); //obtém um caractere do texto incrementado e adiciona na StringBuffer auxiliar utilizada para buscas no dicionário e incrementa o contador
                letra = obterLetraNoDicionario(auxiliar.toString()); //obtém uma referência nula ou de uma letra no dicionário
            }
            
            textoDecodificado.append(letra); //adiciona a letra encontrada no texto codificado
            letra = null; //torna a referêcia de "letra" nula
            auxiliar = new StringBuffer(); //cria uma nova instÃ¢ncia de StringBuffer para auxiliar
        }
        
        return textoDecodificado.toString(); //retorna a representação em String do texto decodificado
    }
    
    /**
     * Obtém o código de uma dada letra no dicionário.
     * @param letra letra que se deseja obter o código
     * @return código da letra
     */
    private String obterCodigoNoDicionario(Character letra) {
        int colunas = dicionario[0].length; //obtém número de colunas do dicionário
        
        for(int i = 0; i < colunas; i++) { //percorre as colunas do dicionario
            if(dicionario[0][i].equals(letra.toString())) { //letra selecionada é a letra busc
                return dicionario[1][i]; //retorna o código
            }
        }
        
        return null; 
    }
    
    /**
     * Obtém a letra no dicionário a partir de um dado código.
     * @param codigo código para o qual se deseja obter a letra
     * @return letra correspondente ao código
     */
    private String obterLetraNoDicionario(String codigo) {
        int colunas = dicionario[0].length; //obtém número de colunas do dicionário
        
        for(int i = 0; i < colunas; i++) { //percorre as colunas do dicionario
            if(dicionario[1][i].equals(codigo)) { //verifica se o código selecionado é o buscado
                return dicionario[0][i]; //retorna a letra referente ao código
            }
        }
        
        return null; 
    }

    /**
     * Obtém uma coluna livre do dicionário, isto é, uma coluna na qual pode ser realizada inserção.
     * @return número da coluna livre
     */
    private int obterColunaLivre() {
        int qtdColunas = dicionario[0].length; //obtém o número de colunas do dicionário
        
        for(int coluna = 0; coluna < qtdColunas; coluna++) { //percorre as colunas do dicionário
            if(dicionario[0][coluna] == null && dicionario[1][coluna] == null) { //se ambas as linhas da coluna estiverem desocupadas
                return coluna; //retorna o número da coluna
            }
        }
        
        return 0; //retorna 0 quando o dicionário está completamente vazio
    }
    
    
    
    
}
