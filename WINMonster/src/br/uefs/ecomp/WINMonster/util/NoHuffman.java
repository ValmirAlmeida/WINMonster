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
 * Classe responsável por modelar um nó da árvore de Huffman.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 * @see java.io.Serializable
 */
public class NoHuffman implements Serializable {
    
    /** Caractere de huffman contido no nó. */
    private CaractereHuffman conteudo;
    
    /** Nó filho à direira. */
    private NoHuffman filhoDireita;
    
    /** Nó filho à esquerda. */
    private NoHuffman filhoEsquerda;
    
    /**
     * Obtém uma nova instância do nó de Huffman.
     * @param conteudo caracte de huffman que estará contido no nó
     */
    public NoHuffman(CaractereHuffman conteudo) {
        this.conteudo = conteudo; //atribui a referência recebida ao atributo "conteudo"
    }
    
    /**
     * Obtém uma nova instância de nó de Huffman.
     * @param filhoEsquerda nó filho à esquerda
     * @param filhoDireita nó filho à direita
     * @param conteudo caracte de huffman que estará contido no nó
     */
    public NoHuffman(NoHuffman filhoEsquerda, NoHuffman filhoDireita, CaractereHuffman conteudo) {
        this.filhoEsquerda = filhoEsquerda; //atribui a referência de filho à esquerda recebida ao atributo "filhoEsquerda"
        this.filhoDireita = filhoDireita; //atribui a referência de filho à direita recebida ao atributo "filhoDireita"
        this.conteudo = conteudo; //atribui a referência recebida ao atributo "conteudo"
    }

    /**
     * Obtém o caractere de huffman contido no nó.
     * @return caractere de huffman contido no nó
     */
    public CaractereHuffman getConteudo() {
        return conteudo; //retorna o atributo "conteudo"
    }

    /**
     * Obtém o filho à direita.
     * @return referência para o nó filho à direita
     */
    public NoHuffman getFilhoDireita() {
        return filhoDireita; //retorna o atributo "filhoDireita"
    }

    /**
     * Obtém o filho à esquerda.
     * @return referência para o nó filho à esquerda
     */
    public NoHuffman getFilhoEsquerda() {
        return filhoEsquerda; //retorna o atributo "filhoEsquerda"
    }

    /**
     * Verifica se o nó é uma folha.
     * @return <code>true</code>, se o nó for uma folha; <code>false</code>, caso contrário.
     */
    public boolean isFolha(){
        return getFilhoDireita() == null && getFilhoEsquerda() ==null; //verifica se ambos os nós do nó são nulos e retorna o resultado
    }
    

}
