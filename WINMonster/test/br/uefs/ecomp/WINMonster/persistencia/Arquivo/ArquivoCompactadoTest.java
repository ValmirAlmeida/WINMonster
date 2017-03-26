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
        Huffman huffman = new Huffman("Nesse momento estou criando um teste"); //obtém uma nova instância do algoritmo de Huffman
        arqCompactado = new ArquivoCompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoTXT.monster"); //obtém uma instância de arquivo compactado
        String textoCodificado = huffman.codificar(); //realiza a codificação e obtém o código

        
        try {
            arqCompactado.gravarDados(huffman.getArvore(), huffman.getDicionario()[1].length, textoCodificado, Hash.obterHash("Nesse momento estou criando um teste"), "testeCompactacaoTXT.txt"); //tenta gravar os dados no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        }
        
        /* Foi necessário obter uma instância de arquivo descompactado para verificar se as informações estavam sendo salvas
        corretamente no arquivo compactado.
        */
        ArquivoDescompactado arqDescompactado = new ArquivoDescompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoTXT.monster");
        
        try {
            /* Verifica se os dados armazenados estão corretos. */
            assertEquals(huffman.getArvore().obterFrequenciaTotal(), arqDescompactado.obterArvore().obterFrequenciaTotal());
            assertEquals(huffman.getDicionario()[1].length, arqDescompactado.obterNumCaracteres());
            assertEquals(textoCodificado, arqDescompactado.obterTextoCodificado());
            arqDescompactado.verificarIntegridade("Nesse momento estou criando um teste");
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        } catch (IntegridadeVioladaException ex) {
            fail();
        }
    }

     @Test
    public void testGravarDadosHTMLSucesso() {
        Huffman huffman = new Huffman("Nesse momento estou criando um teste"); //obtém uma nova instância do algoritmo de Huffman
        arqCompactado = new ArquivoCompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoHTML.monster"); //obtém uma instância de arquivo compactado
        String textoCodificado = huffman.codificar(); //realiza a codificação e obtém o código

        
        try {
            arqCompactado.gravarDados(huffman.getArvore(), huffman.getDicionario()[1].length, textoCodificado, Hash.obterHash("Nesse momento estou criando um teste"), "testeCompactacaoHTML.html"); //tenta gravar os dados no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        }
        
        /* Foi necessário obter uma instância de arquivo descompactado para verificar se as informações estavam sendo salvas
        corretamente no arquivo compactado.
        */
        ArquivoDescompactado arqDescompactado = new ArquivoDescompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoHTML.monster");
        
        try {
            /* Verifica se os dados armazenados estão corretos. */
            assertEquals(huffman.getArvore().obterFrequenciaTotal(), arqDescompactado.obterArvore().obterFrequenciaTotal());
            assertEquals(huffman.getDicionario()[1].length, arqDescompactado.obterNumCaracteres());
            assertEquals(textoCodificado, arqDescompactado.obterTextoCodificado());
            arqDescompactado.verificarIntegridade("Nesse momento estou criando um teste");
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        } catch (IntegridadeVioladaException ex) {
            fail();
        }
    }
    
    @Test
    public void testGravarDadosCSucesso() {
        Huffman huffman = new Huffman("Nesse momento estou criando um teste"); //obtém uma nova instância do algoritmo de Huffman
        arqCompactado = new ArquivoCompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoC.monster"); //obtém uma instância de arquivo compactado
        String textoCodificado = huffman.codificar(); //realiza a codificação e obtém o código

        
        try {
            arqCompactado.gravarDados(huffman.getArvore(), huffman.getDicionario()[1].length, textoCodificado, Hash.obterHash("Nesse momento estou criando um teste"), "testeCompactacaoC.c"); //tenta gravar os dados no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        }
        
        /* Foi necessário obter uma instância de arquivo descompactado para verificar se as informações estavam sendo salvas
        corretamente no arquivo compactado.
        */
        ArquivoDescompactado arqDescompactado = new ArquivoDescompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoC.monster");
        
        try {
            /* Verifica se os dados armazenados estão corretos. */
            assertEquals(huffman.getArvore().obterFrequenciaTotal(), arqDescompactado.obterArvore().obterFrequenciaTotal());
            assertEquals(huffman.getDicionario()[1].length, arqDescompactado.obterNumCaracteres());
            assertEquals(textoCodificado, arqDescompactado.obterTextoCodificado());
            arqDescompactado.verificarIntegridade("Nesse momento estou criando um teste");
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        } catch (IntegridadeVioladaException ex) {
            fail();
        }
    }
    
     @Test
    public void testGravarDadosCPPSucesso() {
        Huffman huffman = new Huffman("Nesse momento estou criando um teste"); //obtém uma nova instância do algoritmo de Huffman
        arqCompactado = new ArquivoCompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoCPP.monster"); //obtém uma instância de arquivo compactado
        String textoCodificado = huffman.codificar(); //realiza a codificação e obtém o código

        
        try {
            arqCompactado.gravarDados(huffman.getArvore(), huffman.getDicionario()[1].length, textoCodificado, Hash.obterHash("Nesse momento estou criando um teste"), "testeCompactacaoCPP.cpp"); //tenta gravar os dados no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        }
        
        /* Foi necessário obter uma instância de arquivo descompactado para verificar se as informações estavam sendo salvas
        corretamente no arquivo compactado.
        */
        ArquivoDescompactado arqDescompactado = new ArquivoDescompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoCPP.monster");
        
        try {
            /* Verifica se os dados armazenados estão corretos. */
            assertEquals(huffman.getArvore().obterFrequenciaTotal(), arqDescompactado.obterArvore().obterFrequenciaTotal());
            assertEquals(huffman.getDicionario()[1].length, arqDescompactado.obterNumCaracteres());
            assertEquals(textoCodificado, arqDescompactado.obterTextoCodificado());
            arqDescompactado.verificarIntegridade("Nesse momento estou criando um teste");
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        } catch (IntegridadeVioladaException ex) {
            fail();
        }
    }
    
    @Test
    public void testConverterTextoEmBitSet() {
        Huffman huffman = new Huffman("Olá, WINMonster! Adeus, vida social!"); //obtém uma nova instância do algoritmo de Huffman
        String textoCodificado = huffman.codificar(); //realiza codificação
        arqCompactado = new ArquivoCompactado("test/br/uefs/ecomp/WINMonster/resources/testeCompactacaoCPP.monster"); //obtém uma instância de arquivo compactado
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
        
        assertEquals(textoCodificado, textoPosConversao.toString()); //verifica se a String construida é igual a String gerada pelo algoritmo de Huffman
    }


}
