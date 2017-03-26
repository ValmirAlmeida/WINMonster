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
 * Classe responsável por modelar um nó da fila de prioridade;
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class NoFila {
    /** Referência para o próximo nó. */
    private NoFila proximo;
    
    /** Objeto contido no nó. */
    private Priorizavel objeto;
    
    /**
     * Obtém uma nova instância de NoFila.
     * @param objeto objeto que estará no nó
     */
    public NoFila(Priorizavel objeto) {
        this.objeto = objeto; //atribui a referência recebida ao atributo "objeto"
    }

    /**
     * Obtém o próximo nó da fila.
     * @return referência para o próximo nó da fila
     */
    public NoFila getProximo() {
        return proximo; //retorna o atributo "proximo"
    }
    
    /**
     * Configura o próximo nó da fila.
     * @param proximo referência para o próximo nó da fila
     */
    public void setProximo(NoFila proximo) {
        this.proximo = proximo; //atribui a referência recebida ao atributo "próximo"
    }

    /**
     * Obtém o objeto contido no nó da fila.
     * @return the objeto
     */
    public Priorizavel getObjeto() {
        return objeto; //retorna o atributo "objeto"
    }
}
