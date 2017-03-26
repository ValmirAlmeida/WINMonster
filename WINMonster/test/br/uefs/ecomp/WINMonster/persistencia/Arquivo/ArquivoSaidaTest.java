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

import br.uefs.ecomp.WINMonster.util.Huffman;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArquivoSaidaTest {
    private ArquivoSaida arqSaida;

    @Test
    public void testGravarTextoTXTSucesso() {
        arqSaida = new ArquivoSaida("test/br/uefs/ecomp/WINMonster/resources/testeEscritaTXT.txt");
        Huffman huffman = new Huffman("Adeus vida social! O que eu estava pensando quando...?\n"); //obt�m uma nova inst�ncia do algoritmo de Huffman
        String textoCodificado = huffman.codificar(); //realiza codifica��o
        Scanner leitorEntrada = null; //leitor de entrada para verificar se o arquivo foi salvo adequadamente
       
        try {        
            arqSaida.gravarTexto(huffman.decodificar(textoCodificado)); //tenta gravar o texto decodificado no arquivo
            
            leitorEntrada = new Scanner(new FileReader(arqSaida.obterEndereco())); //direciona o fluxo de entrada para o local onde o arquivo foi salvo
            
        } catch (FileNotFoundException ex) { //caso n�o seja encontrado diret�rio
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        }
        
        assertEquals("Adeus vida social! O que eu estava pensando quando...?", leitorEntrada.nextLine()); //verifica se a frase lida � a mesma que foi gravada
        /* � importante destacar que o m�todo nextLine() desconsidera a quebra de linha, por isso, ela foi desconsiderada na
        verifica��o.
        */
    }
    
    @Test
    public void testGravarTextoHTMLSucesso() {
        arqSaida = new ArquivoSaida("test/br/uefs/ecomp/WINMonster/resources/testeEscritaHTML.html");
        Huffman huffman = new Huffman("Adeus vida social! O que eu estava pensando quando...?\n"); //obt�m uma nova inst�ncia do algoritmo de Huffman
        String textoCodificado = huffman.codificar(); //realiza codifica��o
        Scanner leitorEntrada = null; //leitor de entrada para verificar se o arquivo foi salvo adequadamente
       
        try {        
            arqSaida.gravarTexto(huffman.decodificar(textoCodificado)); //tenta gravar o texto decodificado no arquivo
            
            leitorEntrada = new Scanner(new FileReader(arqSaida.obterEndereco())); //direciona o fluxo de entrada para o local onde o arquivo foi salvo
            
        } catch (FileNotFoundException ex) { //caso n�o seja encontrado diret�rio
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        }
        
        assertEquals("Adeus vida social! O que eu estava pensando quando...?", leitorEntrada.nextLine()); //verifica se a frase lida � a mesma que foi gravada
        /* � importante destacar que o m�todo nextLine() desconsidera a quebra de linha, por isso, ela foi desconsiderada na
        verifica��o.
        */
    }
    
    @Test
    public void testGravarTextoCSucesso() {
        arqSaida = new ArquivoSaida("test/br/uefs/ecomp/WINMonster/resources/testeEscritaC.c");
        Huffman huffman = new Huffman("Adeus vida social! O que eu estava pensando quando...?\n"); //obt�m uma nova inst�ncia do algoritmo de Huffman
        String textoCodificado = huffman.codificar(); //realiza codifica��o
        Scanner leitorEntrada = null; //leitor de entrada para verificar se o arquivo foi salvo adequadamente
       
        try {        
            arqSaida.gravarTexto(huffman.decodificar(textoCodificado)); //tenta gravar o texto decodificado no arquivo
            
            leitorEntrada = new Scanner(new FileReader(arqSaida.obterEndereco())); //direciona o fluxo de entrada para o local onde o arquivo foi salvo
            
        } catch (FileNotFoundException ex) { //caso n�o seja encontrado diret�rio
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        }
        
        assertEquals("Adeus vida social! O que eu estava pensando quando...?", leitorEntrada.nextLine()); //verifica se a frase lida � a mesma que foi gravada
        /* � importante destacar que o m�todo nextLine() desconsidera a quebra de linha, por isso, ela foi desconsiderada na
        verifica��o.
        */
    }
    
    @Test
    public void testGravarTextoCPPSucesso() {
        arqSaida = new ArquivoSaida("test/br/uefs/ecomp/WINMonster/resources/testeEscritaCPP.cpp");
        Huffman huffman = new Huffman("Adeus vida social! O que eu estava pensando quando...?\n"); //obt�m uma nova inst�ncia do algoritmo de Huffman
        String textoCodificado = huffman.codificar(); //realiza codifica��o
        Scanner leitorEntrada = null; //leitor de entrada para verificar se o arquivo foi salvo adequadamente
       
        try {        
            arqSaida.gravarTexto(huffman.decodificar(textoCodificado)); //tenta gravar o texto decodificado no arquivo
            
            leitorEntrada = new Scanner(new FileReader(arqSaida.obterEndereco())); //direciona o fluxo de entrada para o local onde o arquivo foi salvo
            
        } catch (FileNotFoundException ex) { //caso n�o seja encontrado diret�rio
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        }
        
        assertEquals("Adeus vida social! O que eu estava pensando quando...?", leitorEntrada.nextLine()); //verifica se a frase lida � a mesma que foi gravada
        /* � importante destacar que o m�todo nextLine() desconsidera a quebra de linha, por isso, ela foi desconsiderada na
        verifica��o.
        */
    }
    
    @Test
    public void testGravarTextoEmLocalInexistente() {
        arqSaida = new ArquivoSaida("test/br/uefs/ecomp/WINMonster/r3so4rc3s/aqui.txt"); //cria um arquivo de sa�da em local inexistente
        Huffman huffman = new Huffman("Adeus vida social! O que eu estava pensando quando...?\n"); //obt�m uma nova inst�ncia do algoritmo de Huffman
        String textoCodificado = huffman.codificar(); //realiza codifica��o
       
        try {        
            arqSaida.gravarTexto(huffman.decodificar(textoCodificado)); //tenta gravar o texto decodificado no arquivo
        } catch (FileNotFoundException ex) { //caso n�o seja encontrado diret�rio
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            fail();
        }
    
    }


}
