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
 * Classe respons�vel por modelar um n� da fila de prioridade;
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class NoFila {
    /** Refer�ncia para o pr�ximo n�. */
    private NoFila proximo;
    
    /** Objeto contido no n�. */
    private Priorizavel objeto;
    
    /**
     * Obt�m uma nova inst�ncia de NoFila.
     * @param objeto objeto que estar� no n�
     */
    public NoFila(Priorizavel objeto) {
        this.objeto = objeto; //atribui a refer�ncia recebida ao atributo "objeto"
    }

    /**
     * Obt�m o pr�ximo n� da fila.
     * @return refer�ncia para o pr�ximo n� da fila
     */
    public NoFila getProximo() {
        return proximo; //retorna o atributo "proximo"
    }
    
    /**
     * Configura o pr�ximo n� da fila.
     * @param proximo refer�ncia para o pr�ximo n� da fila
     */
    public void setProximo(NoFila proximo) {
        this.proximo = proximo; //atribui a refer�ncia recebida ao atributo "pr�ximo"
    }

    /**
     * Obt�m o objeto contido no n� da fila.
     * @return the objeto
     */
    public Priorizavel getObjeto() {
        return objeto; //retorna o atributo "objeto"
    }
}
