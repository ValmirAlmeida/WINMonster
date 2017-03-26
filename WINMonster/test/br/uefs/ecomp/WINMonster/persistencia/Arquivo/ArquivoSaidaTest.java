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
        Huffman huffman = new Huffman("Adeus vida social! O que eu estava pensando quando...?\n"); //obtém uma nova instância do algoritmo de Huffman
        String textoCodificado = huffman.codificar(); //realiza codificação
        Scanner leitorEntrada = null; //leitor de entrada para verificar se o arquivo foi salvo adequadamente
       
        try {        
            arqSaida.gravarTexto(huffman.decodificar(textoCodificado)); //tenta gravar o texto decodificado no arquivo
            
            leitorEntrada = new Scanner(new FileReader(arqSaida.obterEndereco())); //direciona o fluxo de entrada para o local onde o arquivo foi salvo
            
        } catch (FileNotFoundException ex) { //caso não seja encontrado diretório
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        }
        
        assertEquals("Adeus vida social! O que eu estava pensando quando...?", leitorEntrada.nextLine()); //verifica se a frase lida é a mesma que foi gravada
        /* É importante destacar que o método nextLine() desconsidera a quebra de linha, por isso, ela foi desconsiderada na
        verificação.
        */
    }
    
    @Test
    public void testGravarTextoHTMLSucesso() {
        arqSaida = new ArquivoSaida("test/br/uefs/ecomp/WINMonster/resources/testeEscritaHTML.html");
        Huffman huffman = new Huffman("Adeus vida social! O que eu estava pensando quando...?\n"); //obtém uma nova instância do algoritmo de Huffman
        String textoCodificado = huffman.codificar(); //realiza codificação
        Scanner leitorEntrada = null; //leitor de entrada para verificar se o arquivo foi salvo adequadamente
       
        try {        
            arqSaida.gravarTexto(huffman.decodificar(textoCodificado)); //tenta gravar o texto decodificado no arquivo
            
            leitorEntrada = new Scanner(new FileReader(arqSaida.obterEndereco())); //direciona o fluxo de entrada para o local onde o arquivo foi salvo
            
        } catch (FileNotFoundException ex) { //caso não seja encontrado diretório
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        }
        
        assertEquals("Adeus vida social! O que eu estava pensando quando...?", leitorEntrada.nextLine()); //verifica se a frase lida é a mesma que foi gravada
        /* É importante destacar que o método nextLine() desconsidera a quebra de linha, por isso, ela foi desconsiderada na
        verificação.
        */
    }
    
    @Test
    public void testGravarTextoCSucesso() {
        arqSaida = new ArquivoSaida("test/br/uefs/ecomp/WINMonster/resources/testeEscritaC.c");
        Huffman huffman = new Huffman("Adeus vida social! O que eu estava pensando quando...?\n"); //obtém uma nova instância do algoritmo de Huffman
        String textoCodificado = huffman.codificar(); //realiza codificação
        Scanner leitorEntrada = null; //leitor de entrada para verificar se o arquivo foi salvo adequadamente
       
        try {        
            arqSaida.gravarTexto(huffman.decodificar(textoCodificado)); //tenta gravar o texto decodificado no arquivo
            
            leitorEntrada = new Scanner(new FileReader(arqSaida.obterEndereco())); //direciona o fluxo de entrada para o local onde o arquivo foi salvo
            
        } catch (FileNotFoundException ex) { //caso não seja encontrado diretório
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        }
        
        assertEquals("Adeus vida social! O que eu estava pensando quando...?", leitorEntrada.nextLine()); //verifica se a frase lida é a mesma que foi gravada
        /* É importante destacar que o método nextLine() desconsidera a quebra de linha, por isso, ela foi desconsiderada na
        verificação.
        */
    }
    
    @Test
    public void testGravarTextoCPPSucesso() {
        arqSaida = new ArquivoSaida("test/br/uefs/ecomp/WINMonster/resources/testeEscritaCPP.cpp");
        Huffman huffman = new Huffman("Adeus vida social! O que eu estava pensando quando...?\n"); //obtém uma nova instância do algoritmo de Huffman
        String textoCodificado = huffman.codificar(); //realiza codificação
        Scanner leitorEntrada = null; //leitor de entrada para verificar se o arquivo foi salvo adequadamente
       
        try {        
            arqSaida.gravarTexto(huffman.decodificar(textoCodificado)); //tenta gravar o texto decodificado no arquivo
            
            leitorEntrada = new Scanner(new FileReader(arqSaida.obterEndereco())); //direciona o fluxo de entrada para o local onde o arquivo foi salvo
            
        } catch (FileNotFoundException ex) { //caso não seja encontrado diretório
            fail();
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        }
        
        assertEquals("Adeus vida social! O que eu estava pensando quando...?", leitorEntrada.nextLine()); //verifica se a frase lida é a mesma que foi gravada
        /* É importante destacar que o método nextLine() desconsidera a quebra de linha, por isso, ela foi desconsiderada na
        verificação.
        */
    }
    
    @Test
    public void testGravarTextoEmLocalInexistente() {
        arqSaida = new ArquivoSaida("test/br/uefs/ecomp/WINMonster/r3so4rc3s/aqui.txt"); //cria um arquivo de saída em local inexistente
        Huffman huffman = new Huffman("Adeus vida social! O que eu estava pensando quando...?\n"); //obtém uma nova instância do algoritmo de Huffman
        String textoCodificado = huffman.codificar(); //realiza codificação
       
        try {        
            arqSaida.gravarTexto(huffman.decodificar(textoCodificado)); //tenta gravar o texto decodificado no arquivo
        } catch (FileNotFoundException ex) { //caso não seja encontrado diretório
            assertTrue(true);
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            fail();
        }
    
    }


}
