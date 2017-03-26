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
 * Representa um caractere a ser inserido na �rvore de Huffman durante o processo de codifica��o de uma sequ�ncia.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 * @see java.io.Serializable
 */
public class CaractereHuffman implements Serializable {
   /* Caracter a ser inserido na �rvore. */
    private Character caractere;
    
    /* Frequ�ncia com que o caractere se repete na sequ�ncia. */
    private int frequencia;
    
    /**
     * Obt�m uma nova inst�ncia de CaractereHuffman.
     * @param caractere caractere contido no CaractereHuffman
     * @param frequencia frequencia do caractere
     */
    public CaractereHuffman(Character caractere, int frequencia) {
        this.caractere = caractere; //atribui a refer�ncia recebida ao atributo "caractere"
        this.frequencia = frequencia; //atribui o valor recebido ao atributo "frequencia"
    }
    
    /**
     * Obt�m uma nova inst�ncia de CaractereHuffman.
     * @param frequencia frequencia do caractere
     */
    public CaractereHuffman(int frequencia) {
       this.frequencia = frequencia; //atribui o valor recebido ao atributo "frequencia"
    } 

    /**
     * Obt�m o caractere.
     * @return caractere armazenado
     */
    public Character getCaractere() {
        return caractere; //retorna o atributo "caractere"
    }

    /**
     * Obt�m a frequ�ncia armazenada.
     * @return frequ�ncia do caractere
     */
    public int getFrequencia() {
        return frequencia; //retorna o atributo "frequencia"
    }

    /**
     * Incrementa em um a frequ�ncia desse caractere.
     */
    public void atualizarFrequencia() {
        this.frequencia++; //incrementa em um a frequ�ncia
    }

}
