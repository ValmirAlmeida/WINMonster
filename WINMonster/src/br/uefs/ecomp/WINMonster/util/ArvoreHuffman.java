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
 * Classe responsável por representar uma árvore de Huffman.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 * @see br.uefs.ecomp.WINMonster.util.NoHuffman
 * @see br.uefs.ecomp.WINMonster.util.Priorizavel
 * @see java.io.Serializable
 */
public class ArvoreHuffman implements Priorizavel, Serializable {
    
    /* Raiz da árvore. */
    public NoHuffman raiz;
    
    /**
     * Cria uma nova instância de árvore de Huffman.
     * @param conteudo conteúdo da raiz da árvore
     */
    public ArvoreHuffman(CaractereHuffman conteudo) {
        this.raiz = new NoHuffman(conteudo); //cria uma nova instância de NoHuffman e atribui a referência ao atributo "raiz"
    }
    
    /**
     * Cria uma nova instância de árvore de Huffman.
     * @param raiz raiz da árvore
     */
    public ArvoreHuffman(NoHuffman raiz) {
        this.raiz = raiz; //atribui a referência recebida ao atributo "raiz"
    }

    /**
     * Obtém a raiz da árvore.
     * @return referência para raiz da árvore
     */
    public NoHuffman getRaiz() {
        return raiz; //retorna a referência do atributo "raiz"
    }

    /**
     * Configura a raiz da árvore.
     * @param raiz referência para a raiz da árvore
     */
    public void setRaiz(NoHuffman raiz) {
        this.raiz = raiz; //atribui a referência recebida ao atributo "raiz"
    }
    
    /**
     * Obtém frequência total de caracteres da árvore.
     * @return frequência total de caracteres da árvore
     */
    public int obterFrequenciaTotal() {
        return raiz.getConteudo().getFrequencia(); //retorna a frequência total
    }
    
    /**
     * Verifica se essa árvore tem ou não prioridade em relação a uma árvore recebida por parâmetro. A árvore com
     * maior prioridade é aquela que possui a menor frequência.
     * @param obj árvore que será comparada com essa
     * @return <code>true</code>, se a frequência dessa árvore for menor que a da ávore recebida por parâmetro; <code>false</code>, caso contrário
     */
    @Override
    public boolean isMinhaPrioridade(Object obj) {
        ArvoreHuffman comparada = (ArvoreHuffman) obj; //obtém a referência do objeto recebido por parâmetro como ArvoreHuffman
        return comparada.obterFrequenciaTotal() > this.obterFrequenciaTotal(); //retorna o resultado da comparação, indicando se a frequência da árvore recebida por parâmetro é menor do que a frequência dessa árvore
    }

}
