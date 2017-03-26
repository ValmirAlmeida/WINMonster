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
        arqDescompactado = new ArquivoDescompactado("test/br/uefs/ecomp/WINMonster/resources/ArquivoTeste.monster"); //abre o arquivo que será descompactado
        huffman = new Huffman("Minha vida social acabou no primeiro dia de MI Programação\n"); //obtém uma instância do algoritmo de huffman
    }
    

    @Test
    public void testObterArvoreSucesso() {
        ArvoreHuffman obtida = null; //árvore obtida do arquivo
        huffman.codificar(); //realiza a codificação
        
        try {
            obtida = arqDescompactado.obterArvore(); //tenta obter a árvore do arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        }
        
        assertEquals(huffman.getArvore().obterFrequenciaTotal(), obtida.obterFrequenciaTotal()); //verifica se as árvores obtidas são correspondentes
    }
    
     @Test
    public void testObterArvoreArquivoInexistente() {
        arqDescompactado = new ArquivoDescompactado("umFalseteDaMelody"); //tenta abrir um arquivo para descompactação em local inválido
        ArvoreHuffman obtida = null; //árvore obtida do arquivo
        huffman.codificar(); //realiza a codificação
        
        try {
            obtida = arqDescompactado.obterArvore(); //tenta obter a árvore do arquivo
            fail();
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        }
        
        assertNull(obtida); //certifica-se que o valor da variavel obtida não foi modificado
    }

    @Test
    public void testObterTextoCodificadoSucesso() {
        String textoCodificadoHuffman = huffman.codificar(); //realiza a codificaçao
        String textoCodificadoArquivo = null; //texto codificado que será obtido do arquivo
        
        try {
            textoCodificadoArquivo = arqDescompactado.obterTextoCodificado(); //tenta obter o texto codificado contido no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        }
        
        assertEquals(textoCodificadoHuffman, textoCodificadoArquivo); //verifica se os valores dos textos codificados são iguais
    }
    
    @Test
    public void testObterTextoCodificadoArquivoInexistente() {
        arqDescompactado = new ArquivoDescompactado("umFalseteDaMelody"); //tenta abrir um arquivo para descompactação em local inválido
        String textoCodificadoHuffman = huffman.codificar(); //realiza a codificaçao
        String textoCodificadoArquivo = null; //texto codificado que será obtido do arquivo
        
        try {
            textoCodificadoArquivo = arqDescompactado.obterTextoCodificado(); //tenta obter o texto codificado contido no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        }
        
        assertNull(textoCodificadoArquivo); //certifica-se que o valor da variavel que conteria o texto codificado do arquivo não foi modificado
    }

    @Test
    public void testObterNumCaracteresSucesso() {
        huffman.codificar(); //realiza a codificação
        int numCaracteresEsperado = huffman.getDicionario()[1].length; //número de caracteres esperado
        int numCaracteresObtido = 0; //número de caracteres que será obtido do arquivo
        
        try {
            numCaracteresObtido = arqDescompactado.obterNumCaracteres(); //tenta obter o número de caracteres contido no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        }
        
        assertEquals(numCaracteresEsperado, numCaracteresObtido); //verifica se o número de caracteres lido é igual ao esperado
    }
    
    @Test
    public void testObterNumCaracteresArquivoInexistente() {
        arqDescompactado = new ArquivoDescompactado("umFalseteDaMelody"); //tenta abrir um arquivo para descompactação em local inválido
        huffman.codificar(); //realiza a codificação
        int numCaracteresEsperado = huffman.getDicionario()[1].length; //número de caracteres esperado
        int numCaracteresObtido = -1; //número de caracteres que será obtido do arquivo
        
        try {
            numCaracteresObtido = arqDescompactado.obterNumCaracteres(); //tenta obter o número de caracteres contido no arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        }
        
        assertEquals(numCaracteresObtido, -1); //verifica se o número de caracteres lido não foi alterado
    }

    @Test
    public void testObterNomeOriginal() {
        String nomeEsperado = "ArquivoTeste.txt"; //nome do arquivo que deverá ser obtido do arquivo descompactado
        String nomeObtido = null; //nome do arquivo que será obtido do arquivo descompactado
        
        try {
            nomeObtido = arqDescompactado.obterNomeOriginal(); //tenta obter o nome original do arquivo antes da compactação
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        }
        
        assertEquals(nomeEsperado, nomeObtido); //verifica se o nome obtido condiz com o esperado
    }
    
    @Test
    public void testObterNomeOriginalSucesso() {
        arqDescompactado = new ArquivoDescompactado("umFalseteDaMelody"); //tenta abrir um arquivo para descompactação em local inválido
        String nomeEsperado = "ArquivoTeste.txt"; //nome do arquivo que deverá ser obtido do arquivo descompactado
        String nomeObtido = null; //nome do arquivo que será obtido do arquivo descompactado
        
        try {
            nomeObtido = arqDescompactado.obterNomeOriginal(); //tenta obter o nome original do arquivo antes da compactação
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        }
        
        assertNull(nomeObtido); //verifica se a variável que conteria o nome original continua com um valor nulo
    }
    
    @Test
    public void testIsIntegroSucesso() {
        String textoDecodificado; //texto decodificado que será obtido pelo algoritmo de Huffman
        huffman.codificar(); //realiza codificação
        
        try {
            textoDecodificado = huffman.decodificar(arqDescompactado.obterTextoCodificado()); //decodifica o texto codificado contido no arquivo
            
            arqDescompactado.verificarIntegridade(textoDecodificado); //verifica se o descompactado está integro
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        } catch (IntegridadeVioladaException ex) { //caso a integridade do arquivo tenha sido violada
            fail();
        }
    }
    
    @Test
    public void testIsIntegroErro() {
        
        try {
            arqDescompactado.verificarIntegridade("MI Programação"); //verifica se o descompactado está integro
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        } catch (IntegridadeVioladaException ex) { //caso a integridade do arquivo tenha sido violada
            assertTrue(true);
        }
    }
    
}
