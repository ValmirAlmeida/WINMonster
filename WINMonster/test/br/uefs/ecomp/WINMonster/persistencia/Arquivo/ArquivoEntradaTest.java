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

import br.uefs.ecomp.WINMonster.exceptions.EntradaVaziaException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArquivoEntradaTest {
    private ArquivoEntrada arqEntrada;
 
    @Test
    public void testObterTextoOriginalTXTSucesso()  {
        arqEntrada = new ArquivoEntrada("test/br/uefs/ecomp/WINMonster/resources/ArquivoTeste.txt"); //obtém uma nova instância de arquivo de entrada
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programação\n", arqEntrada.obterTextoOriginal()); //verifica se o texto obtido condiz com o que se espera
        } catch (FileNotFoundException ex) { //caso não seja encontrado diretório
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        } catch (EntradaVaziaException ex) { //caso a entidade de entrada esteja vazia
            fail();
        }
    }
    
    @Test
    public void testObterTextoOriginalHTMLSucesso() {
        arqEntrada = new ArquivoEntrada("test/br/uefs/ecomp/WINMonster/resources/ArquivoTesteHTML.html"); //obtém uma nova instância de arquivo de entrada
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programação\n", arqEntrada.obterTextoOriginal()); //verifica se o texto obtido condiz com o que se espera
        } catch (FileNotFoundException ex) { //caso não seja encontrado diretório
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        } catch (EntradaVaziaException ex) { //caso a entidade de entrada esteja vazia
            fail();
        }
    }
    
    @Test
    public void testObterTextoOriginalCSucesso() {
        arqEntrada = new ArquivoEntrada("test/br/uefs/ecomp/WINMonster/resources/ArquivoTesteC.c"); //obtém uma nova instância de arquivo de entrada
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programação\n", arqEntrada.obterTextoOriginal()); //verifica se o texto obtido condiz com o que se espera
        } catch (FileNotFoundException ex) { //caso não seja encontrado diretório
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        } catch (EntradaVaziaException ex) { //caso a entidade de entrada esteja vazia
            fail();
        }
    }
    
    @Test
    public void testObterTextoOriginalCPPSucesso() {
        arqEntrada = new ArquivoEntrada("test/br/uefs/ecomp/WINMonster/resources/ArquivoTesteCPP.cpp"); //obtém uma nova instância de arquivo de entrada
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programação\n", arqEntrada.obterTextoOriginal()); //verifica se o texto obtido condiz com o que se espera
        } catch (FileNotFoundException ex) { //caso não seja encontrado diretório
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        } catch (EntradaVaziaException ex) { //caso a entidade de entrada esteja vazia
            fail();
        }
    }
    
    @Test
    public void testObterTextoOriginalArquivoInexistente()  {
        arqEntrada = new ArquivoEntrada("esseArquivoNaoExiste.txt"); //obtém uma nova instância de arquivo de entrada
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programação\n", arqEntrada.obterTextoOriginal()); //verifica se o texto obtido condiz com o que se espera
        } catch (FileNotFoundException ex) { //caso não seja encontrado diretório
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        } catch (EntradaVaziaException ex) { //caso a entidade de entrada esteja vazia
            fail();
        }
    }
    
    @Test
    public void testObterTextoOriginalArquivoVazio()  {
        arqEntrada = new ArquivoEntrada("test/br/uefs/ecomp/WINMonster/resources/ArquivoVazio.txt"); //obtém uma nova instância de arquivo de entrada
        try {
            assertEquals("Minha vida social acabou no primeiro dia de MI Programação\n", arqEntrada.obterTextoOriginal()); //verifica se o texto obtido condiz com o que se espera
        } catch (FileNotFoundException ex) { //caso não seja encontrado diretório
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        } catch (EntradaVaziaException ex) { //caso a entidade de entrada esteja vazia
            assertTrue(true);
        }
    }
    
    

    
}
