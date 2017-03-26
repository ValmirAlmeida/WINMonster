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
     * Obt�m uma nova inst�ncia de arquivo compactado.
     * @param destinoSaida lugar no qual o arquivo compactado ser� salvo
     */
    public ArquivoCompactado(String destinoSaida) {
        super(destinoSaida.substring(0, destinoSaida.lastIndexOf(".")) +".monster"); //obt�m a substring do endere�o original para que o arquivo compactado seja salvo na mesma pasta do arquivo original
    }
    
     /**
     * Grava os dados necess�rios no arquivo compactado.
     * @param arvore �rvore de huffman utilizada na descompress�o
     * @param numCaracteres n�mero de caracteres, fundamental para a reconstru��o do dicion�rio de huffman
     * @param textoCodificado texto codificado ap�s a aplica��odo algoritmo de huffman
     * @param codigoHash c�digo de hash para verificar a integridade do arquivo no momento da descompress�o
     * @param nomeArquivo nome do arquivo original antes da compacta��o
     * @throws FileNotFoundException caso o arquivo n�o seja encontrado
     * @throws java.io.IOException caso ocorra erro durante o salvamento da entidade compactada
     * 
     */
    @Override
    public void gravarDados(ArvoreHuffman arvore, int numCaracteres, String textoCodificado, long codigoHash, String nomeArquivo) throws FileNotFoundException, IOException {
        ObjectOutputStream fluxoSaida; //fluxo de saida
        
        try {
            fluxoSaida = new ObjectOutputStream(new FileOutputStream(super.getArquivo())); //direciona o fluxo de sa�da para  o local no qual o arquivo compactado ser� salvo
           
            /* Grava os dados no arquivo. */
            fluxoSaida.writeObject(converterTextoEmBitSet(textoCodificado));
            fluxoSaida.writeObject(arvore);
            fluxoSaida.writeInt(numCaracteres);
            fluxoSaida.writeUTF(nomeArquivo);
            fluxoSaida.writeLong(codigoHash);
            
            fluxoSaida.close(); //fecha o fluxo de saida
            
        } catch (FileNotFoundException e) { //caso o arquivo n�o seja encontrado
            throw e;
        } catch (IOException e) { //caso ocorra erro durante o salvamento da entidade compactada
            throw e; 
        }
        
    }

    /**
     * Converte o texto codificado que ser� salvo no arquivo compactado para a sua representa��o em BitSet.
     * @param textoCodificado texto codificado ap�s a aplica��o do algoritmo de huffman
     * @return refer�ncia para o BitSet que representa o texto codificado
     */
    @Override
    public BitSet converterTextoEmBitSet(String textoCodificado) {
        BitSet textoBit = new BitSet(); //cria uma nova instância de BitSet
        int cont = 0; //contador auxiliar
        
       for(int i = 0; i<textoCodificado.length(); i++) { //percorre a string que cont�m o texto codificado
          if(textoCodificado.charAt(i) == '1') { //se o caractere for 1
              textoBit.set(i, true); //adiciona um valor true
          } else {
              textoBit.set(i, false); //adiciona um valor false
          }
          
       }
       
       textoBit.set(textoCodificado.length(), true); //adiciona um marcador de fim do BitSet
       
       return textoBit; //retorna a representa��o em BitSet do texto
    }
    
    /**
     * Obt�m o endere�o no qual o arquivo compactado foi salvo.
     * @return endere�o no qual o arquivo compactado foi salvo.
     * @throws IOException caso ocorra erro de entrada ou sa�da
     */
    @Override
    public String obterDestino() throws IOException {
        try {
            return super.obterEndereco(); //obt�m o endere�o na superclasse
        } catch (IOException ex) { //caso ocorra erro durante o salvamento da entidade compactada
            throw ex;
        }
    }

}
