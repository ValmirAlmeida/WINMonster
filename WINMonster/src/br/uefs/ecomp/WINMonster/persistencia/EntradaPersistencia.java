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
package br.uefs.ecomp.WINMonster.persistencia;

import br.uefs.ecomp.WINMonster.exceptions.EntradaVaziaException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Interface que representa qualquer entidade de entrada que possa ser compactada no programa.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public interface EntradaPersistencia {
    
    /**
     * Obt�m o texto original contido na entidade de entrada.
     * @return texto original contido na entidad de entrada 
     * @throws java.io.FileNotFoundException caso a entidade n�o seja encontrada
     * @throws java.io.IOException caso ocorra erro de entrada 
     * @throws EntradaVaziaException caso a entrada esteja vazia
     */
    public String obterTextoOriginal() throws FileNotFoundException, IOException, EntradaVaziaException;
    
    /**
     * Obt�m o caminho para a entidade de entrada.
     * @return caminho da entidade de entrada
     * @throws java.io.FileNotFoundException caso a entidade n�o seja encontrada
     * @throws java.io.IOException caso ocorra erro de entrada
     */
    public String obterCaminho() throws FileNotFoundException, IOException;
    
    /**
     * Obt�m o nome original da entidade de entrada, bem como a sua extens�o.
     * @return nome original da entidade de entrada
     */
    public String obterNome();
    
}
