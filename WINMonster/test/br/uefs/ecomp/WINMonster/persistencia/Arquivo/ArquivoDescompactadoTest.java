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
import br.uefs.ecomp.WINMonster.util.ArvoreHuffman;
import br.uefs.ecomp.WINMonster.util.Huffman;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArquivoDescompactadoTest {
    
    private ArquivoDescompactado arqDescompactado;
    private Huffman huffman;
    
    
    @Before
    public void setUp() {
        arqDescompactado = new ArquivoDescompactado("test/br/uefs/ecomp/WINMonster/resources/ArquivoTeste.monster"); //abre o arquivo que ser� descompactado
        huffman = new Huffman("Minha vida social acabou no primeiro dia de MI Programa��o\n"); //obt�m uma inst�ncia do algoritmo de huffman
    }
    

    @Test
    public void testObterArvoreSucesso() {
        ArvoreHuffman obtida = null; //�rvore obtida do arquivo
        huffman.codificar(); //realiza a codifica��o
        
        try {
            obtida = arqDescompactado.obterArvore(); //tenta obter a �rvore do arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        }
        
        assertEquals(huffman.getArvore().obterFrequenciaTotal(), obtida.obterFrequenciaTotal()); //verifica se as �rvores obtidas s�o correspondentes
    }
    
     @Test
    public void testObterArvoreArquivoInexistente() {
        arqDescompactado = new ArquivoDescompactado("umFalseteDaMelody"); //tenta abrir um arquivo para descompacta��o em local inv�lido
        ArvoreHuffman obtida = null; //�rvore obtida do arquivo
        huffman.codificar(); //realiza a codifica��o
        
        try {
            obtida = arqDescompactado.obterArvore(); //tenta obter a �rvore do arquivo
            fail();
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        }
        
        assertNull(obtida); //certifica-se que o valor da variavel obtida n�o foi modificado
    }

    @Test
    public void testObterTextoCodificadoSucesso() {
        String textoCodificadoHuffman = huffman.codificar(); //realiza a codifica�ao
        String textoCodificadoArquivo = null; //texto codificado que ser� obtido do arquivo
        
        try {
            textoCodificadoArquivo = arqDescompactado.obterTextoCodificado(); //tenta obter o texto codificado contido no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        }
        
        assertEquals(textoCodificadoHuffman, textoCodificadoArquivo); //verifica se os valores dos textos codificados s�o iguais
    }
    
    @Test
    public void testObterTextoCodificadoArquivoInexistente() {
        arqDescompactado = new ArquivoDescompactado("umFalseteDaMelody"); //tenta abrir um arquivo para descompacta��o em local inv�lido
        String textoCodificadoHuffman = huffman.codificar(); //realiza a codifica�ao
        String textoCodificadoArquivo = null; //texto codificado que ser� obtido do arquivo
        
        try {
            textoCodificadoArquivo = arqDescompactado.obterTextoCodificado(); //tenta obter o texto codificado contido no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        }
        
        assertNull(textoCodificadoArquivo); //certifica-se que o valor da variavel que conteria o texto codificado do arquivo n�o foi modificado
    }

    @Test
    public void testObterNumCaracteresSucesso() {
        huffman.codificar(); //realiza a codifica��o
        int numCaracteresEsperado = huffman.getDicionario()[1].length; //n�mero de caracteres esperado
        int numCaracteresObtido = 0; //n�mero de caracteres que ser� obtido do arquivo
        
        try {
            numCaracteresObtido = arqDescompactado.obterNumCaracteres(); //tenta obter o n�mero de caracteres contido no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        }
        
        assertEquals(numCaracteresEsperado, numCaracteresObtido); //verifica se o n�mero de caracteres lido � igual ao esperado
    }
    
    @Test
    public void testObterNumCaracteresArquivoInexistente() {
        arqDescompactado = new ArquivoDescompactado("umFalseteDaMelody"); //tenta abrir um arquivo para descompacta��o em local inv�lido
        huffman.codificar(); //realiza a codifica��o
        int numCaracteresEsperado = huffman.getDicionario()[1].length; //n�mero de caracteres esperado
        int numCaracteresObtido = -1; //n�mero de caracteres que ser� obtido do arquivo
        
        try {
            numCaracteresObtido = arqDescompactado.obterNumCaracteres(); //tenta obter o n�mero de caracteres contido no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        }
        
        assertEquals(numCaracteresObtido, -1); //verifica se o n�mero de caracteres lido n�o foi alterado
    }

    @Test
    public void testObterNomeOriginal() {
        String nomeEsperado = "ArquivoTeste.txt"; //nome do arquivo que dever� ser obtido do arquivo descompactado
        String nomeObtido = null; //nome do arquivo que ser� obtido do arquivo descompactado
        
        try {
            nomeObtido = arqDescompactado.obterNomeOriginal(); //tenta obter o nome original do arquivo antes da compacta��o
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        }
        
        assertEquals(nomeEsperado, nomeObtido); //verifica se o nome obtido condiz com o esperado
    }
    
    @Test
    public void testObterNomeOriginalSucesso() {
        arqDescompactado = new ArquivoDescompactado("umFalseteDaMelody"); //tenta abrir um arquivo para descompacta��o em local inv�lido
        String nomeEsperado = "ArquivoTeste.txt"; //nome do arquivo que dever� ser obtido do arquivo descompactado
        String nomeObtido = null; //nome do arquivo que ser� obtido do arquivo descompactado
        
        try {
            nomeObtido = arqDescompactado.obterNomeOriginal(); //tenta obter o nome original do arquivo antes da compacta��o
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        }
        
        assertNull(nomeObtido); //verifica se a vari�vel que conteria o nome original continua com um valor nulo
    }
    
    @Test
    public void testIsIntegroSucesso() {
        String textoDecodificado; //texto decodificado que ser� obtido pelo algoritmo de Huffman
        huffman.codificar(); //realiza codifica��o
        
        try {
            textoDecodificado = huffman.decodificar(arqDescompactado.obterTextoCodificado()); //decodifica o texto codificado contido no arquivo
            
            arqDescompactado.verificarIntegridade(textoDecodificado); //verifica se o descompactado est� integro
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        } catch (IntegridadeVioladaException ex) { //caso a integridade do arquivo tenha sido violada
            fail();
        }
    }
    
    @Test
    public void testIsIntegroErro() {
        
        try {
            arqDescompactado.verificarIntegridade("MI Programa��o"); //verifica se o descompactado est� integro
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        } catch (IntegridadeVioladaException ex) { //caso a integridade do arquivo tenha sido violada
            assertTrue(true);
        }
    }
    
}
