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

import br.uefs.ecomp.WINMonster.util.ArvoreHuffman;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.BitSet;

/**
 * Interface que representa uma entidade compactada no contexto do programa.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 * 
 */
public interface CompactadoPersistencia {
    
    /**
     * Grava os dados necess�rios na entidade compactada.
     * @param arvore �rvore de huffman utilizada na descompress�o
     * @param numCaracteres n�mero de caracteres, fundamental para a reconstru��o do dicion�rio de huffman
     * @param textoCodificado texto codificado ap�s a aplica��odo algoritmo de huffman
     * @param codigoHash c�digo de hash para verificar a integridade do arquivo no momento da descompress�o
     * @param nomeArquivo nome do arquivo original antes da compacta��o
     * @throws FileNotFoundException caso o arquivo n�o seja encontrado
     * @throws java.io.IOException caso ocorra erro durante o salvamento da entidade compactada
     * 
     */
    public void gravarDados(ArvoreHuffman arvore, int numCaracteres, String textoCodificado, long codigoHash, String nomeArquivo) throws FileNotFoundException, IOException;
    
    /**
     * Converte o texto codificado que ser� salvo na entidade compactada para a sua representa��o em BitSet.
     * @param textoCodificado texto codificado ap�s a aplica��o do algoritmo de huffman
     * @return refer�ncia para o BitSet que representa o texto codificado
     */
    public BitSet converterTextoEmBitSet(String textoCodificado);
    
    /**
     * Obt�m o endere�o no qual a entidade compactada foi salva.
     * @return endere�o no qual a entidade compactada foi salva
     * @throws IOException caso ocorra erro de entrada ou sa�da
     */
    public String obterDestino() throws IOException;
    
}
