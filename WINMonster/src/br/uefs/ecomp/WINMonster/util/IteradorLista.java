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
 * Classe que implementa a interface Iterador especificadamente para uma lista encadeada.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */

public class IteradorLista implements Iterador {

	
    /** N� atual. */
    private No atual;
	
    /**
     * Constr�i um novo iterador para uma lista encadeada a partir do seu primeiro n�.
     *
     * @param primeiro primeiro n� da lista encadeada
     */
    public IteradorLista(No primeiro){
        this.atual = primeiro; //inicializa a refer�ncia de atual com a refer�ncia para o primeiro n� da lista
    }

	
    /**
     * Verifica se existem pr�ximos n�s na lista encadeada, retornando <code>true</code> apenas se isso for verdade.
     * 
     * @return <code>true</code>, se existem mais elementos na lista encadeada; <code>false</code>, caso contr�rio
     */
    @Override
    public boolean temProximo() {
	return !(this.atual == null); //verifica se o n� atual possui refer�ncia nula e retorna a nega��o da condi��o
    }


    /**
     * Recupera o objeto contido no n� atual e muda a refer�ncia desse n� para o pr�ximo da lista.
     * 
     * @return refer�ncia para o objeto contido no n� atual
     */
    @Override
    public Object obterProximo() {
        Object auxiliarObjeto; //auxiliar para guardar a refer�ncia do objeto contido no n� atual
		
        auxiliarObjeto = this.atual.getObj(); //obt�m o objeto contido no n� atual
	this.atual = this.atual.getProximo(); //muda a refer�ncia do atributo atual para o pr�ximo n� da lista
		
        return auxiliarObjeto; //retorna a refer�ncia do objeto obtido
}

}
