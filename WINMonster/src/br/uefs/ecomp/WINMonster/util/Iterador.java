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
 * Interface que permite percorrer e acessar elementos de diversas estruturas de dados, como listas encadeadas, pilhas e filas.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 * 
 */
public interface Iterador {
	
    /**
     * Verifica se existe um próximo elemento na estrutura de dados acessada, retornando <code>true</code> apenas se não foi 
     * atingido o final dessa estrutura.
     *
     * @return <code>true</code>, caso exista mais elementos na estrutura; <code>false</code>, caso contrário.
     */
    public boolean temProximo();

    /**
     * Retorna a referência para o elemento atual da estrutura e avança uma posição do cursor.
     *
     * @return referência para o elemento atual
    */
    public Object obterProximo();

}
