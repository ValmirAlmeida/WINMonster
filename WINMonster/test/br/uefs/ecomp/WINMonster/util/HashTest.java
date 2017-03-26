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

import org.junit.Test;
import static org.junit.Assert.*;

public class HashTest {

    
    @Test
    public void testObterHash() {
        /* Os valores usados para compara��es foram obtidos experimentalmente com base no algoritmo 
        utilizado para construir o m�todo de Hash.
        */
        
        assertEquals(20, Hash.obterHash("O que eu estava pensando quando?"));
        assertEquals(10, Hash.obterHash("Vida social is over"));
        assertEquals(6, Hash.obterHash("Ol�, WINMonster! Tchau, vida social."));
        assertEquals(15, Hash.obterHash("Falta apenas 1 PBL pra acabar!!!!! (se eu passar)"));
    }
    
}
