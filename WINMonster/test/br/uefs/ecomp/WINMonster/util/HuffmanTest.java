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
package br.uefs.ecomp.WINMonster.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HuffmanTest {
    
    private Huffman huffman;
    
    @Before
    public void setUp() {
        huffman = new Huffman("SUSIE SAYS IT IS EASY\n");
    }

    @Test
    public void testCodificar() {
        String resultadoEsperado = "10110010011001111100001101101110110101111011101110010001011010100"; //resultado que deve ser gerado após a codificação
        String resultadoObtido = huffman.codificar(); //c�digo obtido
        String dicionario[][] = huffman.getDicionario();
        String caractereAuxiliar; //caractere auxiliar para verifica��o da codifica��o
        
        System.out.println(resultadoObtido);

        for(int i = 0; i < dicionario[1].length; i++) { //percorre todo o dicion�rio gerado na codifica��o
            caractereAuxiliar = dicionario[0][i]; //obt�m cada caractere armazenado no dicion�rio
            
            /* O c�digo esperado para cada caractere foi obtido por meio de teste experimental baseado na implementa��o
            do algoritmo de Huffman. */
            switch (caractereAuxiliar) { //seleciona o caractere
                /* Verifica em qual caso o caractere se encaixa ou se n�o h� nenhum caso para o caractere
                selecionado, nesse �ltimo caso indicando erro.
                */
                case "A":
                    assertEquals("000", dicionario[1][i]);
                    break;
                case "E":
                    assertEquals("001", dicionario[1][i]);
                    break;
                case "I":
                    assertEquals("011", dicionario[1][i]);
                    break;
                case "S":
                    assertEquals("10", dicionario[1][i]);
                    break;
                case "T":
                    assertEquals("0101", dicionario[1][i]);
                    break;
                case "U":
                    assertEquals("1100", dicionario[1][i]);
                    break;
                case "Y":
                    assertEquals("1101", dicionario[1][i]);
                    break;
                case " ":
                    assertEquals("111", dicionario[1][i]);
                    break;
                case "\n":
                    assertEquals("0100", dicionario[1][i]);
                    break;
                default:
                    fail();
                    break;
            }
        }
        
        assertEquals(resultadoEsperado, resultadoObtido); //verifica se o resultado esperado � igual ao obtido durante a codifica��o
    }

    @Test
    public void testDecodificar() {
        String textoCodificado = huffman.codificar(); //codifica o texto
        
        assertEquals("SUSIE SAYS IT IS EASY\n", huffman.decodificar(textoCodificado)); //verifica se o texto decodificado � igual ao texto original
    }

    
}
