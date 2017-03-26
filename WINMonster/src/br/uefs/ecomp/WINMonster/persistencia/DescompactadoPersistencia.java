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
     * Obt�m a �rvore de Huffman salva na entidade descompactada.
     * @return refer�ncia para a �rvore de huffman
     * @throws java.io.FileNotFoundException caso a entidade n�o seja encontrada
     * @throws IOException caso ocorra algum erro de entrada ou sa�da
     * @throws ClassNotFoundException caso alguma classe necess�ria � execu��o n�o seja encontrada
     */
    public ArvoreHuffman obterArvore() throws FileNotFoundException, IOException, ClassNotFoundException;
    
    /**
     * Obt�m o texto codificado na entidade descompactada.
     * @return texto codificado
     * @throws java.io.FileNotFoundException caso a entidade n�o seja encontrada
     * @throws IOException caso ocorra algum erro de entrada ou sa�da
     * @throws ClassNotFoundException caso alguma classe necess�ria � execu��o n�o seja encontrada
     */
    public String obterTextoCodificado() throws FileNotFoundException, IOException, ClassNotFoundException;
    
    /**
     * Obt�m o n�mero de caracteres diferentes contidos no texto original.
     * @return n�mero de caracteres contidos no texto original
     * @throws java.io.FileNotFoundException caso a entidade n�o seja encontrada
     * @throws IOException caso ocorra algum erro de entrada ou sa�da
     * @throws ClassNotFoundException caso alguma classe necess�ria � execu��o n�o seja encontrada
     */
    public int obterNumCaracteres() throws FileNotFoundException, IOException, ClassNotFoundException;
    
     /**
     * Verifica se a integridade foi mantida na descompacta��o.
     * @param textoDecodificado texto obtido ap�s a decodifica��o
     * @throws java.io.FileNotFoundException caso a entidade n�o seja encontrada
     * @throws IOException caso ocorra algum erro de entrada ou sa�da
     * @throws ClassNotFoundException caso alguma classe necess�ria � execu��o n�o seja encontrada
     * @throws IntegridadeVioladaException caso a integridade do texto tenha sido violada
     */
    public void verificarIntegridade(String textoDecodificado) throws FileNotFoundException, IOException, ClassNotFoundException, IntegridadeVioladaException;
    
     /**
     * Obt�m o nome original da entidade antes da compacta��o.
     * @return nome original da entidade
     * @throws java.io.FileNotFoundException caso a entidade n�o seja encontrada
     * @throws IOException caso ocorra algum erro de entrada ou sa�da
     * @throws ClassNotFoundException caso alguma classe necess�ria � execu��o n�o seja encontrada
     */
    public String obterNomeOriginal() throws FileNotFoundException, IOException, ClassNotFoundException;
    
}

