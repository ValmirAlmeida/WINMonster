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
 * Classe respons�vel por implementar uma fila de prioridade no sistema. O par�metro de prioridade � definido na classe do
 * objeto que ser� inserido na fila, por meio da interface Priorizavel.
 * 
 * @author Valmir Vinicius.
 * @author Iago Almeida.
 * 
 * @see br.uefs.ecomp.WINMonster.util.NoFila
 * @see br.uefs.ecomp.WINMonster.util.Priorizavel
 */
public class FilaPrioridade {
    
    /** Refer�ncia para o primeiro n� da fila. */
    private NoFila primeiro;
    
    /** Tamanho atual da fila. */
    private int tamanho;

    /**
     * Verifica se a fila est� vazia.
     * @return <code>true</code>, caso a fila esteja vazia; <code>false</code>, caso contr�rio.
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
     * @param novoObjeto refer�ncia para o novo objeto que ser� inserido na fila
     */
    public void inserir(Priorizavel novoObjeto) {
        NoFila novoNo = new NoFila(novoObjeto); //cria um novo n� com o objeto recebido
        NoFila atual = primeiro; //refer�ncia auxiliar para o primeiro n� da fila 
        NoFila anterior = null; //refer�ncia auxiliar para um n� anterior enquanto a fila estiver sendo percorrida
            
        /** No la�o de repeti��o abaixo a fila � percorrida enquanto n�o for atingido um fim da fila ou a prioridade n�o
         * for do objeto a ser inserido. Se ao final da itera��o atual tiver uma refer�ncia nula � porque o novo objeto
         * deve ser inserido ao final da fila.
         */
        while(atual != null && !novoObjeto.isMinhaPrioridade(atual.getObjeto())) { //verifica se a refer�ncia de atual n�o � nula e se a prioridade de inser��o n�o � do novo objeto
            anterior = atual; //anterior recebe a refer�ncia de atual
            atual = atual.getProximo(); //atual passa a referenciar o seu pr�ximo
        }
            
        novoNo.setProximo(atual); //o novo n� passa a referenciar o atual
        
        if(anterior == null) { //verifica se o n� anterior ao que ser� inserido � nulo, ou seja, se a inser��o vai ser no come�o da fila
            primeiro = novoNo; //faz o primeiro n� referenciar o novo n�
        } else {
            anterior.setProximo(novoNo); //faz com que o n� anterior passe a referenciar o novo n�
        }
        
        tamanho++; //incrementa o tamanho da fila
    }

    /**
     * Remove o primeiro item da fila.
     * @return refer�ncia para o primeiro objeto da fila, se a fila n�o estiver vazia; <code>null</code>, caso contr�rio.
     */
    public Object removerInicio() {
        if(estaVazia()) { //verifica se a fila est� vazia
            return null;
        }
        
        Priorizavel removido = primeiro.getObjeto(); //obt�m refer�ncia para o objeto que ser� removido
        
        primeiro = primeiro.getProximo(); //avan�a para o pr�ximo n�
        
        tamanho--; //decrementa o tamanho da fila
        
        return removido; //retorna a refer�ncia do objeto contido no n� removido
    }

    /**
     * Retorna o primeiro item da fila.
     * @return refer�ncia para o primeiro objeto da fila; <code>null</code>, caso a fila esteja vazia.
     */
    public Object recuperarInicio() {
        if(estaVazia()) { //verifica se a fila est� vazia
            return null;
        }
        
        return primeiro.getObjeto(); //retorna a refer�ncia do primeiro objeto da fila
    }
    

}
