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
     * Obt�m uma nova inst�ncia de arquivo descompactado.
     * @param enderecoArquivo endere�o do arquivo que ser� descompactado
     */
    public ArquivoDescompactado(String enderecoArquivo) {
        super(enderecoArquivo); //configura o endere�o do arquivo descompactado
    }
    
    /**
     * Obt�m a �rvore de Huffman salva no arquivo descompactado.
     * @return refer�ncia para a �rvore de huffman
     * @throws FileNotFoundException caso o arquivo n�o seja encontrado
     * @throws IOException caso ocorra algum erro de entrada ou sa�da
     * @throws ClassNotFoundException caso alguma classe necess�ria � execu��o n�o seja encontrada
     */
    @Override
    public ArvoreHuffman obterArvore() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream fluxoEntrada = new ObjectInputStream(new FileInputStream(super.obterEndereco())); //cria um fluxo de entrada e o direciona para o endere�o do arquivo a ser descompactado
        ArvoreHuffman arvore = null; //refer�ncia para �rvore de huffman
        
        try {
           
           fluxoEntrada.readObject(); //l� um objeto e avan�a
           arvore = (ArvoreHuffman) fluxoEntrada.readObject(); //l� a �rvore de huffman
           fluxoEntrada.close(); //fecha o fluxo
           
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            throw ex;
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria � execu��o n�o seja encontrada
           throw ex;
        }
        
        return arvore; 
    }

    /**
     * Obt�m o texto codificado no arquivo descompactado.
     * @return texto codificado
     * @throws java.io.FileNotFoundException caso o arquivo n�o seja encontrado
     * @throws IOException caso ocorra algum erro de entrada ou sa�da
     * @throws ClassNotFoundException caso alguma classe necess�ria � execu��o n�o seja encontrada
     */
    @Override
    public String obterTextoCodificado() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream fluxoEntrada; //fluxo de entrada do arquivo
        StringBuilder textoCodificado = new StringBuilder(); //string auxiliar para concatena��o
        BitSet textoBit; //representa��o em bitset do texto codificado
        
        try {
            fluxoEntrada = new ObjectInputStream(new FileInputStream(super.obterEndereco())); //direciona o fluxo de entrada
            textoBit = (BitSet) fluxoEntrada.readObject(); //obt�m o bitset do arquivo
            fluxoEntrada.close(); //fecha o fluxo de entrada
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            throw ex;
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria � execu��o n�o seja encontrada
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
        
        return textoCodificado.toString(); //retorna a representa��o em string do texto codificado

    }


     /**
     * Obt�m o n�mero de caracteres diferentes contidos no texto original.
     * @return n�mero de caracteres contidos no texto original
     * @throws java.io.FileNotFoundException caso o arquivo n�o seja encontrado
     * @throws IOException caso ocorra algum erro de entrada ou sa�da
     * @throws ClassNotFoundException caso alguma classe necess�ria � execu��o n�o seja encontrada
     */
    @Override
    public int obterNumCaracteres() throws IOException, ClassNotFoundException  {
        ObjectInputStream fluxoEntrada; //fluxo de entrada do arquivo
        int numCaracteres = 0; //n�mero de caracteres a ser lido do arquivo
        
        try {
           fluxoEntrada = new ObjectInputStream(new FileInputStream(super.obterEndereco())); //direciona o fluxo de entrada
           fluxoEntrada.readObject(); //l� um objeto e avan�a
           fluxoEntrada.readObject(); //l� um objeto e avan�a
           numCaracteres = fluxoEntrada.readInt(); //obt�m o inteiro desejado
           fluxoEntrada.close(); //fecha o fluxo
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
           throw ex;
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria � execu��o n�o seja encontrada
           throw ex;
        }
        
        return numCaracteres; //retorna o valor lido
    }

     /**
     * Verifica se a integridade do arquivo foi mantida na descompacta��o.
     * @param textoDecodificado texto obtido ap�s a decodifica��o
     * @throws java.io.FileNotFoundException caso o arquivo n�o seja encontrado
     * @throws IOException caso ocorra algum erro de entrada ou sa�da
     * @throws ClassNotFoundException caso alguma classe necess�ria � execu��o n�o seja encontrada
     * @throws IntegridadeVioladaException caso a integridade do texto tenha sido violada
     */
    @Override
    public void verificarIntegridade(String textoDecodificado) throws FileNotFoundException, IOException, ClassNotFoundException, IntegridadeVioladaException {
        ObjectInputStream fluxoEntrada; //fluxo de entrada do arquivo
        long codigoHash; //c�digo hash que ser� lido do arquivo
        
        try {
           fluxoEntrada = new ObjectInputStream(new FileInputStream(super.obterEndereco())); //direciona o fluxo de entrada
           fluxoEntrada.readObject(); //l� um objeto e avan�a
           fluxoEntrada.readObject(); //l� um objeto e avan�a
           fluxoEntrada.readInt(); //l� um inteiro e avan�a
           fluxoEntrada.readUTF(); //l� uma string e avan�a
           codigoHash = fluxoEntrada.readLong(); //l� o c�digo hash
           
           fluxoEntrada.close(); //fecha o fluxo
           
           if(codigoHash != Hash.obterHash(textoDecodificado)) {  //verifica se o c�digo de Hash obtido � diferente daquele gerado a partir do texto decodificado
               throw new IntegridadeVioladaException(); 
           }

        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
           throw ex;
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria � execu��o n�o seja encontrada
           throw ex;
        }
        
    }

     /**
     * Obt�m o nome original do arquivo antes da compacta��o.
     * @return nome original do arquivo
     * @throws java.io.FileNotFoundException caso o arquivo n�o seja encontrado
     * @throws IOException caso ocorra algum erro de entrada ou sa�da
     * @throws ClassNotFoundException caso alguma classe necess�ria � execu��o n�o seja encontrada
     */
    @Override
    public String obterNomeOriginal() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream fluxoEntrada; //fluxo de entrada do arquivo
        String nomeArquivo; //nome que ser� lido
        
        try {
           fluxoEntrada = new ObjectInputStream(new FileInputStream(super.obterEndereco())); //direciona o fluxo de entrada
           fluxoEntrada.readObject(); //l� um objeto e avan�a
           fluxoEntrada.readObject(); //l� um objeto e avan�a
           fluxoEntrada.readInt(); //l� um inteiro e avan�a
           nomeArquivo = fluxoEntrada.readUTF(); //l� uma string e avan�a
           
           fluxoEntrada.close(); //fecha o fluxo
           
           return nomeArquivo; //retorna o nome do arquivo original
           
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
           throw ex;
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria � execu��o n�o seja encontrada
           throw ex;
        }
    }
    
}
