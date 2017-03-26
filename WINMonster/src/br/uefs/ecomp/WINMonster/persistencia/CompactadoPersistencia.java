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
     * Grava os dados necessários na entidade compactada.
     * @param arvore árvore de huffman utilizada na descompressão
     * @param numCaracteres número de caracteres, fundamental para a reconstrução do dicionário de huffman
     * @param textoCodificado texto codificado após a aplicaçãodo algoritmo de huffman
     * @param codigoHash código de hash para verificar a integridade do arquivo no momento da descompressão
     * @param nomeArquivo nome do arquivo original antes da compactação
     * @throws FileNotFoundException caso o arquivo não seja encontrado
     * @throws java.io.IOException caso ocorra erro durante o salvamento da entidade compactada
     * 
     */
    public void gravarDados(ArvoreHuffman arvore, int numCaracteres, String textoCodificado, long codigoHash, String nomeArquivo) throws FileNotFoundException, IOException;
    
    /**
     * Converte o texto codificado que será salvo na entidade compactada para a sua representação em BitSet.
     * @param textoCodificado texto codificado após a aplicação do algoritmo de huffman
     * @return referência para o BitSet que representa o texto codificado
     */
    public BitSet converterTextoEmBitSet(String textoCodificado);
    
    /**
     * Obtém o endereço no qual a entidade compactada foi salva.
     * @return endereço no qual a entidade compactada foi salva
     * @throws IOException caso ocorra erro de entrada ou saída
     */
    public String obterDestino() throws IOException;
    
}
