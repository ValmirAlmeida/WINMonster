/**
 * Componente Curricular: MÛdulo Integrado de ProgramaÁ„o
 * Autor: Valmir Vinicius de Almeida Santos
 * Autor: Iago Almeida
 * Data: 06-04-2016
 *
 * Declaro que este cÛdigo foi elaborado por mim de forma individual e
 * n„o contÈm nenhum trecho de cÛdigo de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e p·ginas ou documentos 
 * eletrÙnicos da Internet. Qualquer trecho de cÛdigo de outra autoria que
 * uma citaÁ„o para o  n„o a minha est· destacado com  autor e a fonte do
 * cÛdigo, e estou ciente que estes trechos n„o ser„o considerados para fins
 * de avaliaÁ„o. Alguns trechos do cÛdigo podem coincidir com de outros
 * colegas pois estes foram discutidos em sessıes tutorias.
 */
package br.uefs.ecomp.WINMonster.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class FilaPrioridadeTest {
    FilaPrioridade fila;
    
    public FilaPrioridadeTest() {
    }
    
    @Before
    public void setUp() {
        fila = new FilaPrioridade();
    }


    @Test
    public void testEstaVazia() {
        
        assertTrue(fila.estaVazia()); //certifica que a fila est√° vazia 
        fila.inserir(new ArvoreHuffman(new CaractereHuffman('v', 2))); //insere um objeto
        assertFalse(fila.estaVazia()); //certifica que a fila n√£o est√° vazia
        fila.removerInicio(); //remove o objeto inserido
        assertTrue(fila.estaVazia()); //certifica que a fila est√° novamente vazia
    }

    @Test
    public void testObterTamanho() {
        assertEquals(0, fila.obterTamanho()); //certifica que o tamanho inicial da fila √© 0
        fila.inserir(new ArvoreHuffman(new CaractereHuffman('v', 2))); //insere um objeto
        fila.inserir(new ArvoreHuffman(new CaractereHuffman('a', 3))); //insere um objeto
        assertEquals(2, fila.obterTamanho()); //verifica o tamanho da fila ap√≥s duas inser√ß√µes
        fila.removerInicio(); //remove um objeto da fila
        assertEquals(1, fila.obterTamanho()); //verifica que o novo tamanho da fila √© 1

    }

    /**
     * Test of inserir method, of class FilaPrioridade.
     */
    @Test
    public void testInserir() {
        
        /* Cria objetos e os insere na fila. */
        ArvoreHuffman arvore1 = new ArvoreHuffman(new CaractereHuffman('c', 3));
        fila.inserir(arvore1);
        ArvoreHuffman arvore2 = new ArvoreHuffman(new CaractereHuffman('b', 10));
        fila.inserir(arvore2);
        ArvoreHuffman arvore3 = new ArvoreHuffman(new CaractereHuffman('a', 1));
        fila.inserir(arvore3);
        ArvoreHuffman arvore4 = new ArvoreHuffman(new CaractereHuffman('d', 300));
        fila.inserir(arvore4);
        
        assertEquals(4, fila.obterTamanho()); //verifica o tamanho da fila

        /* Certifica que os objetos inseridos s√£o removidos da fila na ordem correta. */
        ArvoreHuffman arvoreTeste = (ArvoreHuffman) fila.removerInicio();
        assertEquals(arvore3.getRaiz().getConteudo().getCaractere(), arvoreTeste.getRaiz().getConteudo().getCaractere());
        
        arvoreTeste = (ArvoreHuffman) fila.removerInicio();
        assertEquals(arvore1.getRaiz().getConteudo().getCaractere(), arvoreTeste.getRaiz().getConteudo().getCaractere());
        
        arvoreTeste = (ArvoreHuffman) fila.removerInicio();
        assertEquals(arvore2.getRaiz().getConteudo().getCaractere(), arvoreTeste.getRaiz().getConteudo().getCaractere());
        
        arvoreTeste = (ArvoreHuffman) fila.removerInicio();
        assertEquals(arvore4.getRaiz().getConteudo().getCaractere(), arvoreTeste.getRaiz().getConteudo().getCaractere());
        
        assertNull(fila.removerInicio());
        assertTrue(fila.estaVazia());
    }

    /**
     * Test of removerInicio method, of class FilaPrioridade.
     */
    @Test
    public void testRemoverInicio() {
        
        /** Insere objetos na fila. */
        ArvoreHuffman arvore1 = new ArvoreHuffman(new CaractereHuffman('c', 3));
        fila.inserir(arvore1);
        ArvoreHuffman arvore2 = new ArvoreHuffman(new CaractereHuffman('b', 10));
        fila.inserir(arvore2);
        ArvoreHuffman arvore3 = new ArvoreHuffman(new CaractereHuffman('a', 1));
        fila.inserir(arvore3);
        ArvoreHuffman arvore4 = new ArvoreHuffman(new CaractereHuffman('d', 300));
        fila.inserir(arvore4);
        
        assertEquals(4, fila.obterTamanho()); //certifica-se de que o tamanho da fila est√° correto
        
        /* Certifica que os objetos inseridos s√£o removidos da fila na ordem correta. */
        ArvoreHuffman arvoreTeste = (ArvoreHuffman) fila.removerInicio();
        assertEquals(arvore3.getRaiz().getConteudo().getCaractere(), arvoreTeste.getRaiz().getConteudo().getCaractere());
        
        arvoreTeste = (ArvoreHuffman) fila.removerInicio();
        assertEquals(arvore1.getRaiz().getConteudo().getCaractere(), arvoreTeste.getRaiz().getConteudo().getCaractere());
        
        arvoreTeste = (ArvoreHuffman) fila.removerInicio();
        assertEquals(arvore2.getRaiz().getConteudo().getCaractere(), arvoreTeste.getRaiz().getConteudo().getCaractere());
        
        arvoreTeste = (ArvoreHuffman) fila.removerInicio();
        assertEquals(arvore4.getRaiz().getConteudo().getCaractere(), arvoreTeste.getRaiz().getConteudo().getCaractere());
    }
    
    @Test
    public void testRemoverFilaVazia() {
        assertNull(fila.removerInicio()); //verifica se uma refer√™ncia nula √© obtida ao tentar remover da fila vazia
    }

    /**
     * Test of recuperarInicio method, of class FilaPrioridade.
     */
    @Test
    public void testRecuperarInicio() {
        /* Cria objetos e os insere na fila. */
        ArvoreHuffman arvore1 = new ArvoreHuffman(new CaractereHuffman('c', 3));
        fila.inserir(arvore1);
        ArvoreHuffman arvore2 = new ArvoreHuffman(new CaractereHuffman('b', 10));
        fila.inserir(arvore2);
        ArvoreHuffman arvore3 = new ArvoreHuffman(new CaractereHuffman('a', 1));
        fila.inserir(arvore3);
        ArvoreHuffman arvore4 = new ArvoreHuffman(new CaractereHuffman('d', 300));
        fila.inserir(arvore4);
        
        ArvoreHuffman recuperada = (ArvoreHuffman) fila.recuperarInicio(); //recupera o primeiro objeto da fila
        
        assertEquals(arvore3.getRaiz().getConteudo().getCaractere(), recuperada.getRaiz().getConteudo().getCaractere()); //verifica se o objeto recuperado condiz com o que foi anteriormente inserido
        
        fila.removerInicio(); //remove o primeiro objeto da fila
        
        recuperada = (ArvoreHuffman) fila.recuperarInicio(); //recupera o primeiro objeto da fila
        
        assertEquals(arvore1.getRaiz().getConteudo().getCaractere(), recuperada.getRaiz().getConteudo().getCaractere()); //verifica se o objeto recuperado condiz com o que foi anteriormente inserido
        
        fila.removerInicio(); //remove o primeiro objeto da fila
        
        recuperada = (ArvoreHuffman) fila.recuperarInicio(); //recupera o primeiro objeto da fila
        
        assertEquals(arvore2.getRaiz().getConteudo().getCaractere(), recuperada.getRaiz().getConteudo().getCaractere()); //verifica se o objeto recuperado condiz com o que foi anteriormente inserido
        
        fila.removerInicio(); //remove o primeiro objeto da fila
        
        recuperada = (ArvoreHuffman) fila.recuperarInicio(); //recupera o primeiro objeto da fila
        
        assertEquals(arvore4.getRaiz().getConteudo().getCaractere(), recuperada.getRaiz().getConteudo().getCaractere()); //verifica se o objeto recuperado condiz com o que foi anteriormente inserido
        
        fila.removerInicio(); //remove o primeiro objeto da fila
        
        assertNull(fila.recuperarInicio()); //certifica-se de que a fila est√° vazia ap√≥s a remo√ß√£o de todos os objetos
    }
    
    @Test
    public void testRecuperarInicioFilaVazia() {
        assertNull(fila.recuperarInicio()); //verifica se uma refer√™ncia nula √© retornada ao tentar obter o in√≠cio da fila vazia
    }
   

    
}
