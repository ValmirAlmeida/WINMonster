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

import org.junit.Test;
import static org.junit.Assert.*;

public class HashTest {

    
    @Test
    public void testObterHash() {
        /* Os valores usados para comparações foram obtidos experimentalmente com base no algoritmo 
        utilizado para construir o método de Hash.
        */
        
        assertEquals(20, Hash.obterHash("O que eu estava pensando quando?"));
        assertEquals(10, Hash.obterHash("Vida social is over"));
        assertEquals(6, Hash.obterHash("Olá, WINMonster! Tchau, vida social."));
        assertEquals(15, Hash.obterHash("Falta apenas 1 PBL pra acabar!!!!! (se eu passar)"));
    }
    
}
