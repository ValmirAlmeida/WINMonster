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
 * Classe que implementa uma lista encadeada. 
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class ListaEncadeada {
    
    /** Referência para o primeiro nó da lista. */
    private No primeiro;

    /** Tamanho da lista encadeada.*/
    private int tamanho;


    /**
     * Verifica se a lista encadeada está vazia.
     * 
     * @return <code>true</code>, se o primeiro nó da lista for uma referência <code>null</code>; <code>false</code>, caso contrário
     */
    public boolean estaVazia() {
	return this.primeiro == null; //verifica se o primeiro nó da lista possui uma referência null e retorna o resultado booleano da comparação
    }

    /** 
     * Retorna a quantidade de nós da lista encadeada.
     *
     * @return número de nós da lista encadeada
     */
    public int obterTamanho() {
        return this.tamanho; //retorna o atributo correspondente ao tamanho da lista
    }

    /**
     * Cria um novo nó com o objeto recebido e o define como primeiro da lista.
     * 
     * @param obj referência para o objeto que se deseja alocar no primeiro nó da lista
     */
    public void inserir(Object obj) {
        No novoNo; //conterá a referência para o novo nó que será criado
        No auxiliarNo; //nó auxiliar para percorrer a lista

        novoNo = new No(obj, null); //instancia um novo nó com o objeto recebido e definindo o próximo como null

        if (this.estaVazia() == true) { //verifica se a lista está vazia
            this.primeiro = novoNo; //caso a lista esteja vazia o novo nó criado é definido como o primeiro
        } else {
            novoNo.setProximo(this.primeiro); //define o primeiro como próximo do novo nó
            this.primeiro = novoNo; //define o primeiro como novo nó
        }

        this.tamanho++; //incrementa um no tamanho da lista
    }


    /**
     * Remove o Ãºltimo nÃ³ da lista encadeada, se a lista nÃ£o estiver vazia,
     * retornando a referÃªncia para o objeto contido no nÃ³ removido.
     *
     * @return referÃªncia para o objeto contido no Ãºltimo nÃ³ da lista;
     * <code>null</code>, caso a lista esteja vazia
     */
    public Object remover() {
	No atual; //referência para um nó atual afim de auxiliar no percorrimento da lista
	No anterior = null; //referência para um nó anterior para auxiliar no percorrimento da lista
		
	atual = this.primeiro; //obtém a referência do primeiro nó
		
	if(this.estaVazia() == true){ //verifica se a lista está vazia
            return null; //caso a lista esteja vazia retorna uma referência null
	}
		
	/* No laço de repetição abaixo a lista é percorrida enquanto o último nó dela não é encontrado, de forma a obter
	 * a referência para este último nó e utilizá-la no processso de remover no final da lista. */
	while(atual.getProximo() != null){ //verifica se o nó atual contém uma referência não null para próximo nó, isto é, se o nó atual não é o último da lista
            anterior = atual; //obtém a referência do nó anterior ao atual
            atual = atual.getProximo(); //obtém a referência para o nó que sucede o atual na lista
	}	
		
	anterior.setProximo(null); //configura como null a referência de próximo do nó anterior ao último
		
	this.tamanho--; //diminui em um o tamanho da lista
		
	return atual.getObj(); //retorna o objeto contido no nó removido da lista
    }


    /**
     * Cria um Array com todos os objetos que estão contidos nos nós da lista.
     * @return array com todos os objetos da lista
     */
    public Object[] obterArray() {
        No auxiliar = this.primeiro; //nó auxiliar para percorrer a lista
        Object[] array = new Object[this.tamanho]; //cria um novo Array de objetos genéricos
        int contador = 0; //contador auxiliar

        while (auxiliar != null) { //enquanto a referência do nó não for nula
            array[contador++] = auxiliar.getObj(); //adiciona o objeto no Array e incrementa o contador
            auxiliar = auxiliar.getProximo(); //obtém a referência do próximo nó
        }

        return array; //retorna a referência do Array criado
    }

    /**
     * Retorna um iterador para percorrer a lista encadeada em sequÃªncia.
     *
     * @return iterador da lista encadeada
     */
    public Iterador iterador() {
        return new IteradorLista(primeiro); //cria uma nova instancia de iterador passando a referÃªncia para o primeiro nÃ³ da lista e o retorna
    }

}
