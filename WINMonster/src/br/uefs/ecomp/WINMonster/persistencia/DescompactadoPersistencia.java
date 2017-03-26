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

import br.uefs.ecomp.WINMonster.exceptions.IntegridadeVioladaException;
import br.uefs.ecomp.WINMonster.util.ArvoreHuffman;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Interface que representa uma entidade capaz de ser descompactada pelo programa.
 * @author Valmir Vinicius
 * @author Iago Almeida
 * @see br.uefs.ecomp.WINMonster.util.ArvoreHuffman
 * @see java.io.IOException
 * @see java.util.BitSet
 */
public interface DescompactadoPersistencia {
    
    /**
     * Obtém a árvore de Huffman salva na entidade descompactada.
     * @return referência para a árvore de huffman
     * @throws java.io.FileNotFoundException caso a entidade não seja encontrada
     * @throws IOException caso ocorra algum erro de entrada ou saída
     * @throws ClassNotFoundException caso alguma classe necessária à execução não seja encontrada
     */
    public ArvoreHuffman obterArvore() throws FileNotFoundException, IOException, ClassNotFoundException;
    
    /**
     * Obtém o texto codificado na entidade descompactada.
     * @return texto codificado
     * @throws java.io.FileNotFoundException caso a entidade não seja encontrada
     * @throws IOException caso ocorra algum erro de entrada ou saída
     * @throws ClassNotFoundException caso alguma classe necessária à execução não seja encontrada
     */
    public String obterTextoCodificado() throws FileNotFoundException, IOException, ClassNotFoundException;
    
    /**
     * Obtém o número de caracteres diferentes contidos no texto original.
     * @return número de caracteres contidos no texto original
     * @throws java.io.FileNotFoundException caso a entidade não seja encontrada
     * @throws IOException caso ocorra algum erro de entrada ou saída
     * @throws ClassNotFoundException caso alguma classe necessária à execução não seja encontrada
     */
    public int obterNumCaracteres() throws FileNotFoundException, IOException, ClassNotFoundException;
    
     /**
     * Verifica se a integridade foi mantida na descompactação.
     * @param textoDecodificado texto obtido após a decodificação
     * @throws java.io.FileNotFoundException caso a entidade não seja encontrada
     * @throws IOException caso ocorra algum erro de entrada ou saída
     * @throws ClassNotFoundException caso alguma classe necessária à execução não seja encontrada
     * @throws IntegridadeVioladaException caso a integridade do texto tenha sido violada
     */
    public void verificarIntegridade(String textoDecodificado) throws FileNotFoundException, IOException, ClassNotFoundException, IntegridadeVioladaException;
    
     /**
     * Obtém o nome original da entidade antes da compactação.
     * @return nome original da entidade
     * @throws java.io.FileNotFoundException caso a entidade não seja encontrada
     * @throws IOException caso ocorra algum erro de entrada ou saída
     * @throws ClassNotFoundException caso alguma classe necessária à execução não seja encontrada
     */
    public String obterNomeOriginal() throws FileNotFoundException, IOException, ClassNotFoundException;
    
}

