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
 * Classe responsável por moldar os nós da lista encadeada.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */

public class No {

    /** Referência para objeto genérico contido no nó. */
    private Object obj;
	
    /** Referência para o próximo nó na lista. */
    private No proximo;
	
    /**
    * Constrói um novo nó e inicializa seus atributos com os dados especificados.
    *
    * @param obj referência para o objeto que estará no nó
    * @param proximo referência para o próximo nó na lista
    */
    public No(Object obj, No proximo){
	/* Inicializa os atributos do nó com as informações recebidas. */
	this.obj = obj;
	this.proximo = proximo;
    }

    /**
     * Método para obtenção da referência para o objeto contido no nó.
     *
     * @return referência para o objeto contido no nó
     */
    public Object getObj(){
	return this.obj; //retorna a referência do atributo "objGenerico"
    }
	
    /**
     * Método para obtenção da referência para o próximo nó da lista.
     *
     * @return referência para o próximo nó da lista
     */
    public No getProximo(){
	return this.proximo; //retorna a referência do atributo "proximo"
    }
	
    /**
     * Configura o objeto que estará contido no nó.
     *
     * @param obj referência para o objeto que estará contido no nó
    */
    public void setObj(Object obj){
    	this.obj = obj; //atribui a referência recebida por parâmetro ao atributo "objeto"
    }
	
    /**
     * Configura o próximo nó da lista.
     *
     * @param proximo referência para o próximo nó da lista
     */
    public void setProximo(No proximo){
    	this.proximo = proximo; //atribui a referência recebida por parâmetro ao atributo "proximo"
    }

}
