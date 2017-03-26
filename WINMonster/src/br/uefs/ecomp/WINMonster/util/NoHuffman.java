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
 * Classe respons�vel por modelar um n� da �rvore de Huffman.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 * @see java.io.Serializable
 */
public class NoHuffman implements Serializable {
    
    /** Caractere de huffman contido no n�. */
    private CaractereHuffman conteudo;
    
    /** N� filho � direira. */
    private NoHuffman filhoDireita;
    
    /** N� filho � esquerda. */
    private NoHuffman filhoEsquerda;
    
    /**
     * Obt�m uma nova inst�ncia do n� de Huffman.
     * @param conteudo caracte de huffman que estar� contido no n�
     */
    public NoHuffman(CaractereHuffman conteudo) {
        this.conteudo = conteudo; //atribui a refer�ncia recebida ao atributo "conteudo"
    }
    
    /**
     * Obt�m uma nova inst�ncia de n� de Huffman.
     * @param filhoEsquerda n� filho � esquerda
     * @param filhoDireita n� filho � direita
     * @param conteudo caracte de huffman que estar� contido no n�
     */
    public NoHuffman(NoHuffman filhoEsquerda, NoHuffman filhoDireita, CaractereHuffman conteudo) {
        this.filhoEsquerda = filhoEsquerda; //atribui a refer�ncia de filho � esquerda recebida ao atributo "filhoEsquerda"
        this.filhoDireita = filhoDireita; //atribui a refer�ncia de filho � direita recebida ao atributo "filhoDireita"
        this.conteudo = conteudo; //atribui a refer�ncia recebida ao atributo "conteudo"
    }

    /**
     * Obt�m o caractere de huffman contido no n�.
     * @return caractere de huffman contido no n�
     */
    public CaractereHuffman getConteudo() {
        return conteudo; //retorna o atributo "conteudo"
    }

    /**
     * Obt�m o filho � direita.
     * @return refer�ncia para o n� filho � direita
     */
    public NoHuffman getFilhoDireita() {
        return filhoDireita; //retorna o atributo "filhoDireita"
    }

    /**
     * Obt�m o filho � esquerda.
     * @return refer�ncia para o n� filho � esquerda
     */
    public NoHuffman getFilhoEsquerda() {
        return filhoEsquerda; //retorna o atributo "filhoEsquerda"
    }

    /**
     * Verifica se o n� � uma folha.
     * @return <code>true</code>, se o n� for uma folha; <code>false</code>, caso contr�rio.
     */
    public boolean isFolha(){
        return getFilhoDireita() == null && getFilhoEsquerda() ==null; //verifica se ambos os n�s do n� s�o nulos e retorna o resultado
    }
    

}
