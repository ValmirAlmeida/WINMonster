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
 * Classe respons�vel por moldar os n�s da lista encadeada.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */

public class No {

    /** Refer�ncia para objeto gen�rico contido no n�. */
    private Object obj;
	
    /** Refer�ncia para o pr�ximo n� na lista. */
    private No proximo;
	
    /**
    * Constr�i um novo n� e inicializa seus atributos com os dados especificados.
    *
    * @param obj refer�ncia para o objeto que estar� no n�
    * @param proximo refer�ncia para o pr�ximo n� na lista
    */
    public No(Object obj, No proximo){
	/* Inicializa os atributos do n� com as informa��es recebidas. */
	this.obj = obj;
	this.proximo = proximo;
    }

    /**
     * M�todo para obten��o da refer�ncia para o objeto contido no n�.
     *
     * @return refer�ncia para o objeto contido no n�
     */
    public Object getObj(){
	return this.obj; //retorna a refer�ncia do atributo "objGenerico"
    }
	
    /**
     * M�todo para obten��o da refer�ncia para o pr�ximo n� da lista.
     *
     * @return refer�ncia para o pr�ximo n� da lista
     */
    public No getProximo(){
	return this.proximo; //retorna a refer�ncia do atributo "proximo"
    }
	
    /**
     * Configura o objeto que estar� contido no n�.
     *
     * @param obj refer�ncia para o objeto que estar� contido no n�
    */
    public void setObj(Object obj){
    	this.obj = obj; //atribui a refer�ncia recebida por par�metro ao atributo "objeto"
    }
	
    /**
     * Configura o pr�ximo n� da lista.
     *
     * @param proximo refer�ncia para o pr�ximo n� da lista
     */
    public void setProximo(No proximo){
    	this.proximo = proximo; //atribui a refer�ncia recebida por par�metro ao atributo "proximo"
    }

}
