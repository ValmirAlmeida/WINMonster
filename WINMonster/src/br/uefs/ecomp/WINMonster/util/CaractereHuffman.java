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

import java.io.Serializable;


/**
 * Representa um caractere a ser inserido na árvore de Huffman durante o processo de codificação de uma sequência.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 * @see java.io.Serializable
 */
public class CaractereHuffman implements Serializable {
   /* Caracter a ser inserido na árvore. */
    private Character caractere;
    
    /* Frequência com que o caractere se repete na sequência. */
    private int frequencia;
    
    /**
     * Obtém uma nova instância de CaractereHuffman.
     * @param caractere caractere contido no CaractereHuffman
     * @param frequencia frequencia do caractere
     */
    public CaractereHuffman(Character caractere, int frequencia) {
        this.caractere = caractere; //atribui a referência recebida ao atributo "caractere"
        this.frequencia = frequencia; //atribui o valor recebido ao atributo "frequencia"
    }
    
    /**
     * Obtém uma nova instância de CaractereHuffman.
     * @param frequencia frequencia do caractere
     */
    public CaractereHuffman(int frequencia) {
       this.frequencia = frequencia; //atribui o valor recebido ao atributo "frequencia"
    } 

    /**
     * Obtém o caractere.
     * @return caractere armazenado
     */
    public Character getCaractere() {
        return caractere; //retorna o atributo "caractere"
    }

    /**
     * Obtém a frequência armazenada.
     * @return frequência do caractere
     */
    public int getFrequencia() {
        return frequencia; //retorna o atributo "frequencia"
    }

    /**
     * Incrementa em um a frequência desse caractere.
     */
    public void atualizarFrequencia() {
        this.frequencia++; //incrementa em um a frequência
    }

}
