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
 * Classe responsável por implementar uma fila de prioridade no sistema. O parâmetro de prioridade é definido na classe do
 * objeto que será inserido na fila, por meio da interface Priorizavel.
 * 
 * @author Valmir Vinicius.
 * @author Iago Almeida.
 * 
 * @see br.uefs.ecomp.WINMonster.util.NoFila
 * @see br.uefs.ecomp.WINMonster.util.Priorizavel
 */
public class FilaPrioridade {
    
    /** Referência para o primeiro nó da fila. */
    private NoFila primeiro;
    
    /** Tamanho atual da fila. */
    private int tamanho;

    /**
     * Verifica se a fila está vazia.
     * @return <code>true</code>, caso a fila esteja vazia; <code>false</code>, caso contrário.
     */
    public boolean estaVazia() {
        return tamanho == 0;
    }

    /**
     * Retorna o tamanho atual da fila.
     * @return tamanho atual da fila
     */
    public int obterTamanho() {
        return tamanho;
    }

    /**
     * Insere na fila um objeto que implementa a interface Priorizavel, com base na sua prioridade.
     * @param novoObjeto referência para o novo objeto que será inserido na fila
     */
    public void inserir(Priorizavel novoObjeto) {
        NoFila novoNo = new NoFila(novoObjeto); //cria um novo nó com o objeto recebido
        NoFila atual = primeiro; //referência auxiliar para o primeiro nó da fila 
        NoFila anterior = null; //referência auxiliar para um nó anterior enquanto a fila estiver sendo percorrida
            
        /** No laço de repetição abaixo a fila é percorrida enquanto não for atingido um fim da fila ou a prioridade não
         * for do objeto a ser inserido. Se ao final da iteração atual tiver uma referência nula é porque o novo objeto
         * deve ser inserido ao final da fila.
         */
        while(atual != null && !novoObjeto.isMinhaPrioridade(atual.getObjeto())) { //verifica se a referência de atual não é nula e se a prioridade de inserção não é do novo objeto
            anterior = atual; //anterior recebe a referência de atual
            atual = atual.getProximo(); //atual passa a referenciar o seu próximo
        }
            
        novoNo.setProximo(atual); //o novo nó passa a referenciar o atual
        
        if(anterior == null) { //verifica se o nó anterior ao que será inserido é nulo, ou seja, se a inserção vai ser no começo da fila
            primeiro = novoNo; //faz o primeiro nó referenciar o novo nó
        } else {
            anterior.setProximo(novoNo); //faz com que o nó anterior passe a referenciar o novo nó
        }
        
        tamanho++; //incrementa o tamanho da fila
    }

    /**
     * Remove o primeiro item da fila.
     * @return referência para o primeiro objeto da fila, se a fila não estiver vazia; <code>null</code>, caso contrário.
     */
    public Object removerInicio() {
        if(estaVazia()) { //verifica se a fila está vazia
            return null;
        }
        
        Priorizavel removido = primeiro.getObjeto(); //obtém referência para o objeto que será removido
        
        primeiro = primeiro.getProximo(); //avança para o próximo nó
        
        tamanho--; //decrementa o tamanho da fila
        
        return removido; //retorna a referência do objeto contido no nó removido
    }

    /**
     * Retorna o primeiro item da fila.
     * @return referência para o primeiro objeto da fila; <code>null</code>, caso a fila esteja vazia.
     */
    public Object recuperarInicio() {
        if(estaVazia()) { //verifica se a fila está vazia
            return null;
        }
        
        return primeiro.getObjeto(); //retorna a referência do primeiro objeto da fila
    }
    

}
