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
        String endArqCompactado = null; //endere�o do arquivo compactado
        
        try {
            endArqCompactado = controller.compactar("test/br/uefs/ecomp/WINMonster/resources/ArquivoTeste.txt"); //tenta realizar a compacta��o
        } catch (FileNotFoundException ex) { //caso o arquivo a ser compactado n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (EntradaVaziaException ex) {
            fail();
        }
        
        File compactado = new File(endArqCompactado);
        assertTrue(compactado.exists());
    }
    
    @Test
    public void testCompactarInexistente() {
        String endArqCompactado = null; //endere�o do arquivo compactado
        
        try {
            endArqCompactado = controller.compactar("issoNaoExisteVaiAcontecerUmBugMonstruoso"); //tenta realizar a compacta��o
            fail();
        } catch (FileNotFoundException ex) { //caso o arquivo a ser compactado n�o seja encontrado
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (EntradaVaziaException ex) {
            fail();
        }
        
        assertNull(endArqCompactado);
    }
    
    @Test
    public void testCompactarVazio() {
        String endArqCompactado = null; //endere�o do arquivo compactado
        
        try {
            endArqCompactado = controller.compactar("test/br/uefs/ecomp/WINMonster/resources/ArquivoVazio.txt"); //tenta realizar a compacta��o
            fail();
        } catch (FileNotFoundException ex) { //caso o arquivo a ser compactado n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (EntradaVaziaException ex) {
            assertTrue(true);
        }
        
        assertNull(endArqCompactado);
    }
    
    @Test
    public void testDescompactarSucesso()  {
        ArquivoEntrada arqEntrada; //arquivo de entrada para testar o arquivo descompactado
        String endArqDescompactado = null; //endere�o do arquivo descompactado
        
        try {
            endArqDescompactado = controller.descompactar("test/br/uefs/ecomp/WINMonster/resources/ArquivoTeste.monster"); //tenta realizar a descompacta��o
        } catch (IntegridadeVioladaException ex) { //caso a integridade do arquivo tenha sido violada
            fail();
        } catch(FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        }
        
        arqEntrada = new ArquivoEntrada(endArqDescompactado);
        
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programa��o\n", arqEntrada.obterTextoOriginal()); //verifica se o texto do arquivo condiz com o esperado
        } catch(FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            fail();
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (EntradaVaziaException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        }
    }
    
    @Test
    public void testDescompactarInexistente()  {
        ArquivoEntrada arqEntrada = null; //arquivo de entrada para testar o arquivo descompactado
        String endArqDescompactado = null; //endere�o do arquivo descompactado
        
        try {
            endArqDescompactado = controller.descompactar("arquivoNaoExisteN�Gente"); //tenta realizar a descompacta��o
            fail();
        } catch (IntegridadeVioladaException ex) { //caso a integridade do arquivo tenha sido violada
            fail();
        } catch(FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            fail();
        } catch (ClassNotFoundException ex) { //caso alguma classe necess�ria n�o seja encontrada em tempo de execu��o
            fail();
        }

    }
    
    @Test
    public void testVerificarEntradaSucesso() {
        
        /* Cria File's para realiza��o dos testes. */
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
        } catch (FormatoInvalidoException ex) { //caso seja lan�ada a exce��o
            fail();
        }
    }
    
    @Test
    public void testVerificarEntradaErro() {
        
        /* Cria File's para realiza��o dos testes. */
        File arqPNG = new File("src/br/uefs/ecomp/WINMonster/resources/no.png"); 
        File arqHTML = new File("test/br/uefs/ecomp/WINMonster/resources/HTMLTeste.html");
        
        try {
            WINMonsterController.verificarEntrada(arqPNG.getName(), true); //tenta verificar se a entrada � v�lida
            fail();
        } catch (FormatoInvalidoException ex) { //caso seja lan�ada a exce��o
            assertTrue(true);
        }
        
       try {
            WINMonsterController.verificarEntrada(arqHTML.getName(), false); //tenta verificar se a entrada � v�lida
            fail();
        } catch (FormatoInvalidoException ex) { //caso seja lan�ada a exce��o
            assertTrue(true);
        }
    }
    
}
