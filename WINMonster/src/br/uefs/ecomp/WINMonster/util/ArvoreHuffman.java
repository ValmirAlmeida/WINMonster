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

import java.io.Serializable;

/**
 * Classe respons�vel por representar uma �rvore de Huffman.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 * @see br.uefs.ecomp.WINMonster.util.NoHuffman
 * @see br.uefs.ecomp.WINMonster.util.Priorizavel
 * @see java.io.Serializable
 */
public class ArvoreHuffman implements Priorizavel, Serializable {
    
    /* Raiz da �rvore. */
    public NoHuffman raiz;
    
    /**
     * Cria uma nova inst�ncia de �rvore de Huffman.
     * @param conteudo conte�do da raiz da �rvore
     */
    public ArvoreHuffman(CaractereHuffman conteudo) {
        this.raiz = new NoHuffman(conteudo); //cria uma nova inst�ncia de NoHuffman e atribui a refer�ncia ao atributo "raiz"
    }
    
    /**
     * Cria uma nova inst�ncia de �rvore de Huffman.
     * @param raiz raiz da �rvore
     */
    public ArvoreHuffman(NoHuffman raiz) {
        this.raiz = raiz; //atribui a refer�ncia recebida ao atributo "raiz"
    }

    /**
     * Obt�m a raiz da �rvore.
     * @return refer�ncia para raiz da �rvore
     */
    public NoHuffman getRaiz() {
        return raiz; //retorna a refer�ncia do atributo "raiz"
    }

    /**
     * Configura a raiz da �rvore.
     * @param raiz refer�ncia para a raiz da �rvore
     */
    public void setRaiz(NoHuffman raiz) {
        this.raiz = raiz; //atribui a refer�ncia recebida ao atributo "raiz"
    }
    
    /**
     * Obt�m frequ�ncia total de caracteres da �rvore.
     * @return frequ�ncia total de caracteres da �rvore
     */
    public int obterFrequenciaTotal() {
        return raiz.getConteudo().getFrequencia(); //retorna a frequ�ncia total
    }
    
    /**
     * Verifica se essa �rvore tem ou n�o prioridade em rela��o a uma �rvore recebida por par�metro. A �rvore com
     * maior prioridade � aquela que possui a menor frequ�ncia.
     * @param obj �rvore que ser� comparada com essa
     * @return <code>true</code>, se a frequ�ncia dessa �rvore for menor que a da �vore recebida por par�metro; <code>false</code>, caso contr�rio
     */
    @Override
    public boolean isMinhaPrioridade(Object obj) {
        ArvoreHuffman comparada = (ArvoreHuffman) obj; //obt�m a refer�ncia do objeto recebido por par�metro como ArvoreHuffman
        return comparada.obterFrequenciaTotal() > this.obterFrequenciaTotal(); //retorna o resultado da compara��o, indicando se a frequ�ncia da �rvore recebida por par�metro � menor do que a frequ�ncia dessa �rvore
    }

}
