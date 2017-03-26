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
 * Essa interface estabele que seja definida uma prioridade entre dois objetos comparados.
 * @author Valmir Vinicius
 */
public interface Priorizavel {
    
    /**
     * Define se a prioridade Ã© do objeto atual ou do objeto passado por parÃ¢metro.
     * @param obj objeto que serÃ¡ comparado com o atual
     * @return <code>true</code>, se a prioridade for do objeto atual; <code>false</code>, caso contrÃ¡rio.
     */
    public boolean isMinhaPrioridade(Object obj);
    
}
