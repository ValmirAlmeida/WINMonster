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
 * Interface que permite percorrer e acessar elementos de diversas estruturas de dados, como listas encadeadas, pilhas e filas.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 * 
 */
public interface Iterador {
	
    /**
     * Verifica se existe um pr�ximo elemento na estrutura de dados acessada, retornando <code>true</code> apenas se n�o foi 
     * atingido o final dessa estrutura.
     *
     * @return <code>true</code>, caso exista mais elementos na estrutura; <code>false</code>, caso contr�rio.
     */
    public boolean temProximo();

    /**
     * Retorna a refer�ncia para o elemento atual da estrutura e avan�a uma posi��o do cursor.
     *
     * @return refer�ncia para o elemento atual
    */
    public Object obterProximo();

}
