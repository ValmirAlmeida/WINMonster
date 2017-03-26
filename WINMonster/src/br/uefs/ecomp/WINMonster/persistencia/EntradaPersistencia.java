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
     * Obtém o texto original contido na entidade de entrada.
     * @return texto original contido na entidad de entrada 
     * @throws java.io.FileNotFoundException caso a entidade não seja encontrada
     * @throws java.io.IOException caso ocorra erro de entrada 
     * @throws EntradaVaziaException caso a entrada esteja vazia
     */
    public String obterTextoOriginal() throws FileNotFoundException, IOException, EntradaVaziaException;
    
    /**
     * Obtém o caminho para a entidade de entrada.
     * @return caminho da entidade de entrada
     * @throws java.io.FileNotFoundException caso a entidade não seja encontrada
     * @throws java.io.IOException caso ocorra erro de entrada
     */
    public String obterCaminho() throws FileNotFoundException, IOException;
    
    /**
     * Obtém o nome original da entidade de entrada, bem como a sua extensão.
     * @return nome original da entidade de entrada
     */
    public String obterNome();
    
}
