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

public class ListaEncadeadaTest {
    
    private ListaEncadeada lista;
    
    @Before
    public void setUp() {
        lista = new ListaEncadeada();
    }

    
    @Test
    public void testEstaVazia() {
        assertTrue(lista.estaVazia());
        lista.inserir(new CaractereHuffman('b',5)); //insere um novo objeto na lista
        
        assertFalse(lista.estaVazia());
    }

    @Test
    public void testInserirSucesso() {
        assertTrue(lista.estaVazia()); //verifica se a lista está vazia
        assertEquals(0,lista.obterTamanho()); //verifica o tamanho da lista
        
        CaractereHuffman caractere = new CaractereHuffman('c', 3); 
        lista.inserir(caractere); //insere um novo objeto na lista
        
        assertEquals(1, lista.obterTamanho()); 
        
        Iterador i = lista.iterador(); //obtém o iterador da lista
        assertTrue(i.temProximo()); //verifica se há um próximo
        
        lista.inserir(new CaractereHuffman('b',5)); //insere um novo objeto na lista
        assertEquals(lista.obterTamanho(), 2); 
        
        i = lista.iterador();
        assertTrue(i.temProximo());
        CaractereHuffman caractereTeste = (CaractereHuffman) i.obterProximo();
        assertEquals('b', caractereTeste.getCaractere().charValue());
        assertEquals(5, caractereTeste.getFrequencia());
        
        assertTrue(i.temProximo());
        caractereTeste = (CaractereHuffman) i.obterProximo();
        assertEquals('c', caractereTeste.getCaractere().charValue());
        assertEquals(3, caractereTeste.getFrequencia());
        
        assertFalse(i.temProximo());
        
    }

    public void testRemoverSucesso() {
        lista.inserir(new CaractereHuffman('c', 3)); //insere um novo objeto na lista
        
        lista.inserir(new CaractereHuffman('b', 5)); //insere um novo objeto na lista
        
        CaractereHuffman removido = (CaractereHuffman) lista.remover(); //remove o objeto da lista
        
        /* Verifica se os valores condizem com o objeto inserido. */
        assertEquals('c', removido.getCaractere().charValue());
        assertEquals(3, removido.getFrequencia());
        

         CaractereHuffman removido2 = (CaractereHuffman) lista.remover();
        
        /* Verifica se os valores condizem com o objeto inserido. */
        assertEquals('b', removido2.getCaractere().charValue());
        assertEquals(5, removido2.getFrequencia());
    }
    
    @Test
    public void testRemoverVazia() {
        assertTrue(lista.estaVazia());
        assertEquals(null, lista.remover()); //tenta remover da lista vazia
        assertEquals(null, lista.remover());
    }

    @Test
    public void testObterArray() {
        lista.inserir(new CaractereHuffman('c', 3)); //insere um novo objeto na lista
        
        lista.inserir(new CaractereHuffman('b',5)); //insere um novo objeto na lista
        
        Object[] listaArray = lista.obterArray();
        
        assertEquals(2, listaArray.length);
        
        assertEquals('b', ((CaractereHuffman) listaArray[0]).getCaractere().charValue());
        assertEquals('c', ((CaractereHuffman) listaArray[1]).getCaractere().charValue());
    }

    @Test
    public void testIterador() {
        lista.inserir(new CaractereHuffman('c', 3)); //insere um novo objeto na lista
        
        lista.inserir(new CaractereHuffman('b',5)); //insere um novo objeto na lista
        
        Iterador i = lista.iterador();
        
        /* Verifica se o iterador funciona corretamente. */
        assertTrue(i.temProximo());
        i.obterProximo();
        assertTrue(i.temProximo());
        i.obterProximo();
        assertFalse(i.temProximo());
    }
    
}
