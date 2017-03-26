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
 * Classe que implementa uma lista encadeada. 
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class ListaEncadeada {
    
    /** Refer�ncia para o primeiro n� da lista. */
    private No primeiro;

    /** Tamanho da lista encadeada.*/
    private int tamanho;


    /**
     * Verifica se a lista encadeada est� vazia.
     * 
     * @return <code>true</code>, se o primeiro n� da lista for uma refer�ncia <code>null</code>; <code>false</code>, caso contr�rio
     */
    public boolean estaVazia() {
	return this.primeiro == null; //verifica se o primeiro n� da lista possui uma refer�ncia null e retorna o resultado booleano da compara��o
    }

    /** 
     * Retorna a quantidade de n�s da lista encadeada.
     *
     * @return n�mero de n�s da lista encadeada
     */
    public int obterTamanho() {
        return this.tamanho; //retorna o atributo correspondente ao tamanho da lista
    }

    /**
     * Cria um novo n� com o objeto recebido e o define como primeiro da lista.
     * 
     * @param obj refer�ncia para o objeto que se deseja alocar no primeiro n� da lista
     */
    public void inserir(Object obj) {
        No novoNo; //conter� a refer�ncia para o novo n� que ser� criado
        No auxiliarNo; //n� auxiliar para percorrer a lista

        novoNo = new No(obj, null); //instancia um novo n� com o objeto recebido e definindo o pr�ximo como null

        if (this.estaVazia() == true) { //verifica se a lista est� vazia
            this.primeiro = novoNo; //caso a lista esteja vazia o novo n� criado � definido como o primeiro
        } else {
            novoNo.setProximo(this.primeiro); //define o primeiro como pr�ximo do novo n�
            this.primeiro = novoNo; //define o primeiro como novo n�
        }

        this.tamanho++; //incrementa um no tamanho da lista
    }


    /**
     * Remove o último nó da lista encadeada, se a lista não estiver vazia,
     * retornando a referência para o objeto contido no nó removido.
     *
     * @return referência para o objeto contido no último nó da lista;
     * <code>null</code>, caso a lista esteja vazia
     */
    public Object remover() {
	No atual; //refer�ncia para um n� atual afim de auxiliar no percorrimento da lista
	No anterior = null; //refer�ncia para um n� anterior para auxiliar no percorrimento da lista
		
	atual = this.primeiro; //obt�m a refer�ncia do primeiro n�
		
	if(this.estaVazia() == true){ //verifica se a lista est� vazia
            return null; //caso a lista esteja vazia retorna uma refer�ncia null
	}
		
	/* No la�o de repeti��o abaixo a lista � percorrida enquanto o �ltimo n� dela n�o � encontrado, de forma a obter
	 * a refer�ncia para este �ltimo n� e utiliz�-la no processso de remover no final da lista. */
	while(atual.getProximo() != null){ //verifica se o n� atual cont�m uma refer�ncia n�o null para pr�ximo n�, isto �, se o n� atual n�o � o �ltimo da lista
            anterior = atual; //obt�m a refer�ncia do n� anterior ao atual
            atual = atual.getProximo(); //obt�m a refer�ncia para o n� que sucede o atual na lista
	}	
		
	anterior.setProximo(null); //configura como null a refer�ncia de pr�ximo do n� anterior ao �ltimo
		
	this.tamanho--; //diminui em um o tamanho da lista
		
	return atual.getObj(); //retorna o objeto contido no n� removido da lista
    }


    /**
     * Cria um Array com todos os objetos que est�o contidos nos n�s da lista.
     * @return array com todos os objetos da lista
     */
    public Object[] obterArray() {
        No auxiliar = this.primeiro; //n� auxiliar para percorrer a lista
        Object[] array = new Object[this.tamanho]; //cria um novo Array de objetos gen�ricos
        int contador = 0; //contador auxiliar

        while (auxiliar != null) { //enquanto a refer�ncia do n� n�o for nula
            array[contador++] = auxiliar.getObj(); //adiciona o objeto no Array e incrementa o contador
            auxiliar = auxiliar.getProximo(); //obt�m a refer�ncia do pr�ximo n�
        }

        return array; //retorna a refer�ncia do Array criado
    }

    /**
     * Retorna um iterador para percorrer a lista encadeada em sequência.
     *
     * @return iterador da lista encadeada
     */
    public Iterador iterador() {
        return new IteradorLista(primeiro); //cria uma nova instancia de iterador passando a referência para o primeiro nó da lista e o retorna
    }

}
