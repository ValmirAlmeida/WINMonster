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
 * Essa interface estabele que seja definida uma prioridade entre dois objetos comparados.
 * @author Valmir Vinicius
 */
public interface Priorizavel {
    
    /**
     * Define se a prioridade é do objeto atual ou do objeto passado por parâmetro.
     * @param obj objeto que será comparado com o atual
     * @return <code>true</code>, se a prioridade for do objeto atual; <code>false</code>, caso contrário.
     */
    public boolean isMinhaPrioridade(Object obj);
    
}
