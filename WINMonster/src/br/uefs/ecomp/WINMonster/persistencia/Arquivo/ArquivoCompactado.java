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
package br.uefs.ecomp.WINMonster.persistencia.Arquivo;

import br.uefs.ecomp.WINMonster.persistencia.CompactadoPersistencia;
import br.uefs.ecomp.WINMonster.util.ArvoreHuffman;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.BitSet;

/**
 * Classe que representa um arquivo compactado no contexto do programa.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class ArquivoCompactado extends Arquivo implements CompactadoPersistencia {
    /**
     * Obtém uma nova instância de arquivo compactado.
     * @param destinoSaida lugar no qual o arquivo compactado será salvo
     */
    public ArquivoCompactado(String destinoSaida) {
        super(destinoSaida.substring(0, destinoSaida.lastIndexOf(".")) +".monster"); //obtém a substring do endereço original para que o arquivo compactado seja salvo na mesma pasta do arquivo original
    }
    
     /**
     * Grava os dados necessários no arquivo compactado.
     * @param arvore árvore de huffman utilizada na descompressão
     * @param numCaracteres número de caracteres, fundamental para a reconstrução do dicionário de huffman
     * @param textoCodificado texto codificado após a aplicaçãodo algoritmo de huffman
     * @param codigoHash código de hash para verificar a integridade do arquivo no momento da descompressão
     * @param nomeArquivo nome do arquivo original antes da compactação
     * @throws FileNotFoundException caso o arquivo não seja encontrado
     * @throws java.io.IOException caso ocorra erro durante o salvamento da entidade compactada
     * 
     */
    @Override
    public void gravarDados(ArvoreHuffman arvore, int numCaracteres, String textoCodificado, long codigoHash, String nomeArquivo) throws FileNotFoundException, IOException {
        ObjectOutputStream fluxoSaida; //fluxo de saida
        
        try {
            fluxoSaida = new ObjectOutputStream(new FileOutputStream(super.getArquivo())); //direciona o fluxo de saída para  o local no qual o arquivo compactado será salvo
           
            /* Grava os dados no arquivo. */
            fluxoSaida.writeObject(converterTextoEmBitSet(textoCodificado));
            fluxoSaida.writeObject(arvore);
            fluxoSaida.writeInt(numCaracteres);
            fluxoSaida.writeUTF(nomeArquivo);
            fluxoSaida.writeLong(codigoHash);
            
            fluxoSaida.close(); //fecha o fluxo de saida
            
        } catch (FileNotFoundException e) { //caso o arquivo não seja encontrado
            throw e;
        } catch (IOException e) { //caso ocorra erro durante o salvamento da entidade compactada
            throw e; 
        }
        
    }

    /**
     * Converte o texto codificado que será salvo no arquivo compactado para a sua representação em BitSet.
     * @param textoCodificado texto codificado após a aplicação do algoritmo de huffman
     * @return referência para o BitSet que representa o texto codificado
     */
    @Override
    public BitSet converterTextoEmBitSet(String textoCodificado) {
        BitSet textoBit = new BitSet(); //cria uma nova instÃ¢ncia de BitSet
        int cont = 0; //contador auxiliar
        
       for(int i = 0; i<textoCodificado.length(); i++) { //percorre a string que contém o texto codificado
          if(textoCodificado.charAt(i) == '1') { //se o caractere for 1
              textoBit.set(i, true); //adiciona um valor true
          } else {
              textoBit.set(i, false); //adiciona um valor false
          }
          
       }
       
       textoBit.set(textoCodificado.length(), true); //adiciona um marcador de fim do BitSet
       
       return textoBit; //retorna a representação em BitSet do texto
    }
    
    /**
     * Obtém o endereço no qual o arquivo compactado foi salvo.
     * @return endereço no qual o arquivo compactado foi salvo.
     * @throws IOException caso ocorra erro de entrada ou saída
     */
    @Override
    public String obterDestino() throws IOException {
        try {
            return super.obterEndereco(); //obtém o endereço na superclasse
        } catch (IOException ex) { //caso ocorra erro durante o salvamento da entidade compactada
            throw ex;
        }
    }

}
