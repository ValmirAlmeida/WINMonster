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
        String resultadoEsperado = "10110010011001111100001101101110110101111011101110010001011010100"; //resultado que deve ser gerado apÃ³s a codificaÃ§Ã£o
        String resultadoObtido = huffman.codificar(); //código obtido
        String dicionario[][] = huffman.getDicionario();
        String caractereAuxiliar; //caractere auxiliar para verificação da codificação
        
        System.out.println(resultadoObtido);

        for(int i = 0; i < dicionario[1].length; i++) { //percorre todo o dicionário gerado na codificação
            caractereAuxiliar = dicionario[0][i]; //obtém cada caractere armazenado no dicionário
            
            /* O código esperado para cada caractere foi obtido por meio de teste experimental baseado na implementação
            do algoritmo de Huffman. */
            switch (caractereAuxiliar) { //seleciona o caractere
                /* Verifica em qual caso o caractere se encaixa ou se não há nenhum caso para o caractere
                selecionado, nesse último caso indicando erro.
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
        
        assertEquals(resultadoEsperado, resultadoObtido); //verifica se o resultado esperado é igual ao obtido durante a codificação
    }

    @Test
    public void testDecodificar() {
        String textoCodificado = huffman.codificar(); //codifica o texto
        
        assertEquals("SUSIE SAYS IT IS EASY\n", huffman.decodificar(textoCodificado)); //verifica se o texto decodificado é igual ao texto original
    }

    
}
