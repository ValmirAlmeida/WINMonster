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

import br.uefs.ecomp.WINMonster.exceptions.IntegridadeVioladaException;
import br.uefs.ecomp.WINMonster.persistencia.DescompactadoPersistencia;
import br.uefs.ecomp.WINMonster.util.ArvoreHuffman;
import br.uefs.ecomp.WINMonster.util.Hash;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.BitSet;

/**
 * Classe que representa um arquivo que pode ser descompactado no programa.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class ArquivoDescompactado extends Arquivo implements DescompactadoPersistencia {

    /**
     * Obtém uma nova instância de arquivo descompactado.
     * @param enderecoArquivo endereço do arquivo que será descompactado
     */
    public ArquivoDescompactado(String enderecoArquivo) {
        super(enderecoArquivo); //configura o endereço do arquivo descompactado
    }
    
    /**
     * Obtém a árvore de Huffman salva no arquivo descompactado.
     * @return referência para a árvore de huffman
     * @throws FileNotFoundException caso o arquivo não seja encontrado
     * @throws IOException caso ocorra algum erro de entrada ou saída
     * @throws ClassNotFoundException caso alguma classe necessária à execução não seja encontrada
     */
    @Override
    public ArvoreHuffman obterArvore() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream fluxoEntrada = new ObjectInputStream(new FileInputStream(super.obterEndereco())); //cria um fluxo de entrada e o direciona para o endereço do arquivo a ser descompactado
        ArvoreHuffman arvore = null; //referência para árvore de huffman
        
        try {
           
           fluxoEntrada.readObject(); //lê um objeto e avança
           arvore = (ArvoreHuffman) fluxoEntrada.readObject(); //lê a árvore de huffman
           fluxoEntrada.close(); //fecha o fluxo
           
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            throw ex;
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária à execução não seja encontrada
           throw ex;
        }
        
        return arvore; 
    }

    /**
     * Obtém o texto codificado no arquivo descompactado.
     * @return texto codificado
     * @throws java.io.FileNotFoundException caso o arquivo não seja encontrado
     * @throws IOException caso ocorra algum erro de entrada ou saída
     * @throws ClassNotFoundException caso alguma classe necessária à execução não seja encontrada
     */
    @Override
    public String obterTextoCodificado() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream fluxoEntrada; //fluxo de entrada do arquivo
        StringBuilder textoCodificado = new StringBuilder(); //string auxiliar para concatenação
        BitSet textoBit; //representação em bitset do texto codificado
        
        try {
            fluxoEntrada = new ObjectInputStream(new FileInputStream(super.obterEndereco())); //direciona o fluxo de entrada
            textoBit = (BitSet) fluxoEntrada.readObject(); //obtém o bitset do arquivo
            fluxoEntrada.close(); //fecha o fluxo de entrada
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            throw ex;
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária à execução não seja encontrada
           throw ex;
        }
        
        /** Percorre o BitSet obtido, verificando o valor booleano contido e criando uma StringBuffer a partir deste valor. */
        for(int i = 0; i<textoBit.length()-1; i++) {
            if(textoBit.get(i)) {
                textoCodificado.append("1");
            } else {
                textoCodificado.append("0");
            }
        }
        
        return textoCodificado.toString(); //retorna a representação em string do texto codificado

    }


     /**
     * Obtém o número de caracteres diferentes contidos no texto original.
     * @return número de caracteres contidos no texto original
     * @throws java.io.FileNotFoundException caso o arquivo não seja encontrado
     * @throws IOException caso ocorra algum erro de entrada ou saída
     * @throws ClassNotFoundException caso alguma classe necessária à execução não seja encontrada
     */
    @Override
    public int obterNumCaracteres() throws IOException, ClassNotFoundException  {
        ObjectInputStream fluxoEntrada; //fluxo de entrada do arquivo
        int numCaracteres = 0; //número de caracteres a ser lido do arquivo
        
        try {
           fluxoEntrada = new ObjectInputStream(new FileInputStream(super.obterEndereco())); //direciona o fluxo de entrada
           fluxoEntrada.readObject(); //lê um objeto e avança
           fluxoEntrada.readObject(); //lê um objeto e avança
           numCaracteres = fluxoEntrada.readInt(); //obtém o inteiro desejado
           fluxoEntrada.close(); //fecha o fluxo
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
           throw ex;
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária à execução não seja encontrada
           throw ex;
        }
        
        return numCaracteres; //retorna o valor lido
    }

     /**
     * Verifica se a integridade do arquivo foi mantida na descompactação.
     * @param textoDecodificado texto obtido após a decodificação
     * @throws java.io.FileNotFoundException caso o arquivo não seja encontrado
     * @throws IOException caso ocorra algum erro de entrada ou saída
     * @throws ClassNotFoundException caso alguma classe necessária à execução não seja encontrada
     * @throws IntegridadeVioladaException caso a integridade do texto tenha sido violada
     */
    @Override
    public void verificarIntegridade(String textoDecodificado) throws FileNotFoundException, IOException, ClassNotFoundException, IntegridadeVioladaException {
        ObjectInputStream fluxoEntrada; //fluxo de entrada do arquivo
        long codigoHash; //código hash que será lido do arquivo
        
        try {
           fluxoEntrada = new ObjectInputStream(new FileInputStream(super.obterEndereco())); //direciona o fluxo de entrada
           fluxoEntrada.readObject(); //lê um objeto e avança
           fluxoEntrada.readObject(); //lê um objeto e avança
           fluxoEntrada.readInt(); //lê um inteiro e avança
           fluxoEntrada.readUTF(); //lê uma string e avança
           codigoHash = fluxoEntrada.readLong(); //lê o código hash
           
           fluxoEntrada.close(); //fecha o fluxo
           
           if(codigoHash != Hash.obterHash(textoDecodificado)) {  //verifica se o código de Hash obtido é diferente daquele gerado a partir do texto decodificado
               throw new IntegridadeVioladaException(); 
           }

        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
           throw ex;
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária à execução não seja encontrada
           throw ex;
        }
        
    }

     /**
     * Obtém o nome original do arquivo antes da compactação.
     * @return nome original do arquivo
     * @throws java.io.FileNotFoundException caso o arquivo não seja encontrado
     * @throws IOException caso ocorra algum erro de entrada ou saída
     * @throws ClassNotFoundException caso alguma classe necessária à execução não seja encontrada
     */
    @Override
    public String obterNomeOriginal() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream fluxoEntrada; //fluxo de entrada do arquivo
        String nomeArquivo; //nome que será lido
        
        try {
           fluxoEntrada = new ObjectInputStream(new FileInputStream(super.obterEndereco())); //direciona o fluxo de entrada
           fluxoEntrada.readObject(); //lê um objeto e avança
           fluxoEntrada.readObject(); //lê um objeto e avança
           fluxoEntrada.readInt(); //lê um inteiro e avança
           nomeArquivo = fluxoEntrada.readUTF(); //lê uma string e avança
           
           fluxoEntrada.close(); //fecha o fluxo
           
           return nomeArquivo; //retorna o nome do arquivo original
           
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
           throw ex;
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária à execução não seja encontrada
           throw ex;
        }
    }
    
}
