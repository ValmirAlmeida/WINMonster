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
import br.uefs.ecomp.WINMonster.util.Hash;
import br.uefs.ecomp.WINMonster.util.Huffman;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.BitSet;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArquivoCompactadoTest {
    
    private ArquivoCompactado arqCompactado;

    @Test
    public void testGravarDadosTXTSucesso() {
        Huffman huffman = new Huffman("Nesse momento estou criando um teste"); //obt�m uma nova inst�ncia do algoritmo de Huffman
        arqCompactado = new ArquivoCompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoTXT.monster"); //obt�m uma inst�ncia de arquivo compactado
        String textoCodificado = huffman.codificar(); //realiza a codifica��o e obt�m o c�digo

        
        try {
            arqCompactado.gravarDados(huffman.getArvore(), huffman.getDicionario()[1].length, textoCodificado, Hash.obterHash("Nesse momento estou criando um teste"), "testeCompactacaoTXT.txt"); //tenta gravar os dados no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        }
        
        /* Foi necess�rio obter uma inst�ncia de arquivo descompactado para verificar se as informa��es estavam sendo salvas
        corretamente no arquivo compactado.
        */
        ArquivoDescompactado arqDescompactado = new ArquivoDescompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoTXT.monster");
        
        try {
            /* Verifica se os dados armazenados est�o corretos. */
            assertEquals(huffman.getArvore().obterFrequenciaTotal(), arqDescompactado.obterArvore().obterFrequenciaTotal());
            assertEquals(huffman.getDicionario()[1].length, arqDescompactado.obterNumCaracteres());
            assertEquals(textoCodificado, arqDescompactado.obterTextoCodificado());
            arqDescompactado.verificarIntegridade("Nesse momento estou criando um teste");
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        } catch (IntegridadeVioladaException ex) {
            fail();
        }
    }

     @Test
    public void testGravarDadosHTMLSucesso() {
        Huffman huffman = new Huffman("Nesse momento estou criando um teste"); //obt�m uma nova inst�ncia do algoritmo de Huffman
        arqCompactado = new ArquivoCompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoHTML.monster"); //obt�m uma inst�ncia de arquivo compactado
        String textoCodificado = huffman.codificar(); //realiza a codifica��o e obt�m o c�digo

        
        try {
            arqCompactado.gravarDados(huffman.getArvore(), huffman.getDicionario()[1].length, textoCodificado, Hash.obterHash("Nesse momento estou criando um teste"), "testeCompactacaoHTML.html"); //tenta gravar os dados no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        }
        
        /* Foi necess�rio obter uma inst�ncia de arquivo descompactado para verificar se as informa��es estavam sendo salvas
        corretamente no arquivo compactado.
        */
        ArquivoDescompactado arqDescompactado = new ArquivoDescompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoHTML.monster");
        
        try {
            /* Verifica se os dados armazenados est�o corretos. */
            assertEquals(huffman.getArvore().obterFrequenciaTotal(), arqDescompactado.obterArvore().obterFrequenciaTotal());
            assertEquals(huffman.getDicionario()[1].length, arqDescompactado.obterNumCaracteres());
            assertEquals(textoCodificado, arqDescompactado.obterTextoCodificado());
            arqDescompactado.verificarIntegridade("Nesse momento estou criando um teste");
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        } catch (IntegridadeVioladaException ex) {
            fail();
        }
    }
    
    @Test
    public void testGravarDadosCSucesso() {
        Huffman huffman = new Huffman("Nesse momento estou criando um teste"); //obt�m uma nova inst�ncia do algoritmo de Huffman
        arqCompactado = new ArquivoCompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoC.monster"); //obt�m uma inst�ncia de arquivo compactado
        String textoCodificado = huffman.codificar(); //realiza a codifica��o e obt�m o c�digo

        
        try {
            arqCompactado.gravarDados(huffman.getArvore(), huffman.getDicionario()[1].length, textoCodificado, Hash.obterHash("Nesse momento estou criando um teste"), "testeCompactacaoC.c"); //tenta gravar os dados no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        }
        
        /* Foi necess�rio obter uma inst�ncia de arquivo descompactado para verificar se as informa��es estavam sendo salvas
        corretamente no arquivo compactado.
        */
        ArquivoDescompactado arqDescompactado = new ArquivoDescompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoC.monster");
        
        try {
            /* Verifica se os dados armazenados est�o corretos. */
            assertEquals(huffman.getArvore().obterFrequenciaTotal(), arqDescompactado.obterArvore().obterFrequenciaTotal());
            assertEquals(huffman.getDicionario()[1].length, arqDescompactado.obterNumCaracteres());
            assertEquals(textoCodificado, arqDescompactado.obterTextoCodificado());
            arqDescompactado.verificarIntegridade("Nesse momento estou criando um teste");
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        } catch (IntegridadeVioladaException ex) {
            fail();
        }
    }
    
     @Test
    public void testGravarDadosCPPSucesso() {
        Huffman huffman = new Huffman("Nesse momento estou criando um teste"); //obt�m uma nova inst�ncia do algoritmo de Huffman
        arqCompactado = new ArquivoCompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoCPP.monster"); //obt�m uma inst�ncia de arquivo compactado
        String textoCodificado = huffman.codificar(); //realiza a codifica��o e obt�m o c�digo

        
        try {
            arqCompactado.gravarDados(huffman.getArvore(), huffman.getDicionario()[1].length, textoCodificado, Hash.obterHash("Nesse momento estou criando um teste"), "testeCompactacaoCPP.cpp"); //tenta gravar os dados no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        }
        
        /* Foi necess�rio obter uma inst�ncia de arquivo descompactado para verificar se as informa��es estavam sendo salvas
        corretamente no arquivo compactado.
        */
        ArquivoDescompactado arqDescompactado = new ArquivoDescompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoCPP.monster");
        
        try {
            /* Verifica se os dados armazenados est�o corretos. */
            assertEquals(huffman.getArvore().obterFrequenciaTotal(), arqDescompactado.obterArvore().obterFrequenciaTotal());
            assertEquals(huffman.getDicionario()[1].length, arqDescompactado.obterNumCaracteres());
            assertEquals(textoCodificado, arqDescompactado.obterTextoCodificado());
            arqDescompactado.verificarIntegridade("Nesse momento estou criando um teste");
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        } catch (IntegridadeVioladaException ex) {
            fail();
        }
    }
    
    @Test
    public void testConverterTextoEmBitSet() {
        Huffman huffman = new Huffman("Ol�, WINMonster! Adeus, vida social!"); //obt�m uma nova inst�ncia do algoritmo de Huffman
        String textoCodificado = huffman.codificar(); //realiza codifica��o
        arqCompactado = new ArquivoCompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoCPP.monster"); //obt�m uma inst�ncia de arquivo compactado
        BitSet textoBitSet = arqCompactado.converterTextoEmBitSet(textoCodificado);
        StringBuffer textoPosConversao = new StringBuffer();
        
        for(int i = 0; i < textoBitSet.length(); i++) { //percorre o bitset gerado
            if(textoBitSet.get(i)) { //se o valor obtido for true
                textoPosConversao.append("1");
            } else { //se o valor obtido for false
                textoPosConversao.append("0");
            }
        }
        
        textoPosConversao.deleteCharAt(textoBitSet.length()-1); //remove o demarcador de fim de BitSet
        
        assertEquals(textoCodificado, textoPosConversao.toString()); //verifica se a String construida � igual a String gerada pelo algoritmo de Huffman
    }


}
