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
 * Classe que implementa a interface Iterador especificadamente para uma lista encadeada.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */

public class IteradorLista implements Iterador {

	
    /** Nó atual. */
    private No atual;
	
    /**
     * Constrói um novo iterador para uma lista encadeada a partir do seu primeiro nó.
     *
     * @param primeiro primeiro nó da lista encadeada
     */
    public IteradorLista(No primeiro){
        this.atual = primeiro; //inicializa a referência de atual com a referência para o primeiro nó da lista
    }

	
    /**
     * Verifica se existem próximos nós na lista encadeada, retornando <code>true</code> apenas se isso for verdade.
     * 
     * @return <code>true</code>, se existem mais elementos na lista encadeada; <code>false</code>, caso contrário
     */
    @Override
    public boolean temProximo() {
	return !(this.atual == null); //verifica se o nó atual possui referência nula e retorna a negação da condição
    }


    /**
     * Recupera o objeto contido no nó atual e muda a referência desse nó para o próximo da lista.
     * 
     * @return referência para o objeto contido no nó atual
     */
    @Override
    public Object obterProximo() {
        Object auxiliarObjeto; //auxiliar para guardar a referência do objeto contido no nó atual
		
        auxiliarObjeto = this.atual.getObj(); //obtém o objeto contido no nó atual
	this.atual = this.atual.getProximo(); //muda a referência do atributo atual para o próximo nó da lista
		
        return auxiliarObjeto; //retorna a referência do objeto obtido
}

}
