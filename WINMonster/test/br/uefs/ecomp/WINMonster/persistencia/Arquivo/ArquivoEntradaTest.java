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

import br.uefs.ecomp.WINMonster.exceptions.EntradaVaziaException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArquivoEntradaTest {
    private ArquivoEntrada arqEntrada;
 
    @Test
    public void testObterTextoOriginalTXTSucesso()  {
        arqEntrada = new ArquivoEntrada("test/br/uefs/ecomp/WINMonster/resources/ArquivoTeste.txt"); //obt�m uma nova inst�ncia de arquivo de entrada
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programa��o\n", arqEntrada.obterTextoOriginal()); //verifica se o texto obtido condiz com o que se espera
        } catch (FileNotFoundException ex) { //caso n�o seja encontrado diret�rio
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        } catch (EntradaVaziaException ex) { //caso a entidade de entrada esteja vazia
            fail();
        }
    }
    
    @Test
    public void testObterTextoOriginalHTMLSucesso() {
        arqEntrada = new ArquivoEntrada("test/br/uefs/ecomp/WINMonster/resources/ArquivoTesteHTML.html"); //obt�m uma nova inst�ncia de arquivo de entrada
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programa��o\n", arqEntrada.obterTextoOriginal()); //verifica se o texto obtido condiz com o que se espera
        } catch (FileNotFoundException ex) { //caso n�o seja encontrado diret�rio
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        } catch (EntradaVaziaException ex) { //caso a entidade de entrada esteja vazia
            fail();
        }
    }
    
    @Test
    public void testObterTextoOriginalCSucesso() {
        arqEntrada = new ArquivoEntrada("test/br/uefs/ecomp/WINMonster/resources/ArquivoTesteC.c"); //obt�m uma nova inst�ncia de arquivo de entrada
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programa��o\n", arqEntrada.obterTextoOriginal()); //verifica se o texto obtido condiz com o que se espera
        } catch (FileNotFoundException ex) { //caso n�o seja encontrado diret�rio
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        } catch (EntradaVaziaException ex) { //caso a entidade de entrada esteja vazia
            fail();
        }
    }
    
    @Test
    public void testObterTextoOriginalCPPSucesso() {
        arqEntrada = new ArquivoEntrada("test/br/uefs/ecomp/WINMonster/resources/ArquivoTesteCPP.cpp"); //obt�m uma nova inst�ncia de arquivo de entrada
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programa��o\n", arqEntrada.obterTextoOriginal()); //verifica se o texto obtido condiz com o que se espera
        } catch (FileNotFoundException ex) { //caso n�o seja encontrado diret�rio
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        } catch (EntradaVaziaException ex) { //caso a entidade de entrada esteja vazia
            fail();
        }
    }
    
    @Test
    public void testObterTextoOriginalArquivoInexistente()  {
        arqEntrada = new ArquivoEntrada("esseArquivoNaoExiste.txt"); //obt�m uma nova inst�ncia de arquivo de entrada
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programa��o\n", arqEntrada.obterTextoOriginal()); //verifica se o texto obtido condiz com o que se espera
        } catch (FileNotFoundException ex) { //caso n�o seja encontrado diret�rio
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        } catch (EntradaVaziaException ex) { //caso a entidade de entrada esteja vazia
            fail();
        }
    }
    
    @Test
    public void testObterTextoOriginalArquivoVazio()  {
        arqEntrada = new ArquivoEntrada("test/br/uefs/ecomp/WINMonster/resources/ArquivoVazio.txt"); //obt�m uma nova inst�ncia de arquivo de entrada
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programa��o\n", arqEntrada.obterTextoOriginal()); //verifica se o texto obtido condiz com o que se espera
        } catch (FileNotFoundException ex) { //caso n�o seja encontrado diret�rio
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        } catch (EntradaVaziaException ex) { //caso a entidade de entrada esteja vazia
            assertTrue(true);
        }
    }
    
    

    
}
