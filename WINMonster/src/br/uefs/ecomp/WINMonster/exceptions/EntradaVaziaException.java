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
package br.uefs.ecomp.WINMonster.exceptions;

/**
 * Exceção lançada ao tentar compactar uma entrada vazia, sem informações.
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class EntradaVaziaException extends Exception {
    
   /**
    * Cria uma nova instância da exceção com uma mensagem predefinida.
    */
    public EntradaVaziaException() {
        super("O arquivo aberto está vazio.");
    }
	
    /**
     * Cria uma nova instância da exceção com uma mensagem predefinida e uma exceção que a causou.
     * @param causa causa da exceção
     */
    public EntradaVaziaException(Throwable causa) {
	super("O arquivo aberto está vazio.", causa);
    }
}
