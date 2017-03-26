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
package br.uefs.ecomp.WINMonster.controller;

import br.uefs.ecomp.WINMonster.exceptions.EntradaVaziaException;
import br.uefs.ecomp.WINMonster.exceptions.FormatoInvalidoException;
import br.uefs.ecomp.WINMonster.exceptions.IntegridadeVioladaException;
import br.uefs.ecomp.WINMonster.persistencia.Arquivo.ArquivoEntrada;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Valmir Vinicius
 */
public class WINMonsterControllerTest {
    
    private WINMonsterController controller;
    
    
    @Before
    public void setUp() {
        controller = new WINMonsterController();
    }

    @Test
    public void testCompactarSucesso() {
        String endArqCompactado = null; //endereço do arquivo compactado
        
        try {
            endArqCompactado = controller.compactar("test/br/uefs/ecomp/WINMonster/resources/ArquivoTeste.txt"); //tenta realizar a compactação
        } catch (FileNotFoundException ex) { //caso o arquivo a ser compactado não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (EntradaVaziaException ex) {
            fail();
        }
        
        File compactado = new File(endArqCompactado);
        assertTrue(compactado.exists());
    }
    
    @Test
    public void testCompactarInexistente() {
        String endArqCompactado = null; //endereço do arquivo compactado
        
        try {
            endArqCompactado = controller.compactar("issoNaoExisteVaiAcontecerUmBugMonstruoso"); //tenta realizar a compactação
            fail();
        } catch (FileNotFoundException ex) { //caso o arquivo a ser compactado não seja encontrado
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (EntradaVaziaException ex) {
            fail();
        }
        
        assertNull(endArqCompactado);
    }
    
    @Test
    public void testCompactarVazio() {
        String endArqCompactado = null; //endereço do arquivo compactado
        
        try {
            endArqCompactado = controller.compactar("test/br/uefs/ecomp/WINMonster/resources/ArquivoVazio.txt"); //tenta realizar a compactação
            fail();
        } catch (FileNotFoundException ex) { //caso o arquivo a ser compactado não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (EntradaVaziaException ex) {
            assertTrue(true);
        }
        
        assertNull(endArqCompactado);
    }
    
    @Test
    public void testDescompactarSucesso()  {
        ArquivoEntrada arqEntrada; //arquivo de entrada para testar o arquivo descompactado
        String endArqDescompactado = null; //endereço do arquivo descompactado
        
        try {
            endArqDescompactado = controller.descompactar("test/br/uefs/ecomp/WINMonster/resources/ArquivoTeste.monster"); //tenta realizar a descompactação
        } catch (IntegridadeVioladaException ex) { //caso a integridade do arquivo tenha sido violada
            fail();
        } catch(FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        }
        
        arqEntrada = new ArquivoEntrada(endArqDescompactado);
        
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programação\n", arqEntrada.obterTextoOriginal()); //verifica se o texto do arquivo condiz com o esperado
        } catch(FileNotFoundException ex) { //caso o arquivo não seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (EntradaVaziaException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        }
    }
    
    @Test
    public void testDescompactarInexistente()  {
        ArquivoEntrada arqEntrada = null; //arquivo de entrada para testar o arquivo descompactado
        String endArqDescompactado = null; //endereço do arquivo descompactado
        
        try {
            endArqDescompactado = controller.descompactar("arquivoNaoExisteNéGente"); //tenta realizar a descompactação
            fail();
        } catch (IntegridadeVioladaException ex) { //caso a integridade do arquivo tenha sido violada
            fail();
        } catch(FileNotFoundException ex) { //caso o arquivo não seja encontrado
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necessária não seja encontrada em tempo de execução
            fail();
        }

    }
    
    @Test
    public void testVerificarEntradaSucesso() {
        
        /* Cria File's para realização dos testes. */
        File arqTxt = new File("test/br/uefs/ecomp/WINMonster/resources/ArquivoTeste.txt");
        File arqHTML = new File("test/br/uefs/ecomp/WINMonster/resources/HTMLTeste.html");
        File arqC = new File("test/br/uefs/ecomp/WINMonster/resources/CTeste.c");
        File arqCPP = new File("test/br/uefs/ecomp/WINMonster/resources/CTeste.cpp");
        File arqMONSTER = new File("test/br/uefs/ecomp/WINMonster/resources/ArquivoTeste.monster");
        
        try {
            /* Verifica as entradas para todos os tipos que podem ser compactados e descompactados. */
            WINMonsterController.verificarEntrada(arqTxt.getName(), true);
            WINMonsterController.verificarEntrada(arqHTML.getName(), true);
            WINMonsterController.verificarEntrada(arqC.getName(), true);
            WINMonsterController.verificarEntrada(arqCPP.getName(), true);
            WINMonsterController.verificarEntrada(arqMONSTER.getName(), false);
        } catch (FormatoInvalidoException ex) { //caso seja lançada a exceção
            fail();
        }
    }
    
    @Test
    public void testVerificarEntradaErro() {
        
        /* Cria File's para realização dos testes. */
        File arqPNG = new File("src/br/uefs/ecomp/WINMonster/resources/no.png"); 
        File arqHTML = new File("test/br/uefs/ecomp/WINMonster/resources/HTMLTeste.html");
        
        try {
            WINMonsterController.verificarEntrada(arqPNG.getName(), true); //tenta verificar se a entrada é válida
            fail();
        } catch (FormatoInvalidoException ex) { //caso seja lançada a exceção
            assertTrue(true);
        }
        
       try {
            WINMonsterController.verificarEntrada(arqHTML.getName(), false); //tenta verificar se a entrada é válida
            fail();
        } catch (FormatoInvalidoException ex) { //caso seja lançada a exceção
            assertTrue(true);
        }
    }
    
}
