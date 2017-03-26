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
package br.uefs.ecomp.WINMonster.persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Interface que representa uma entidade de sa�da p�s-compacta��o.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public interface SaidaPersistencia  {
    
    /**
     * Grava o texto decodificado na entidade de saida.
     * @param textoDecodificado texto decodificado que ser� salvo na entidade
     * @throws java.io.FileNotFoundException caso n�o seja encontrado o endere�o
     * @throws java.io.IOException caso ocorra erro de sa�da
     */
    public void gravarTexto(String textoDecodificado) throws FileNotFoundException, IOException;
    
    /**
     * Obt�m o endere�o no qual a entidade foi armazenada.
     * @return endere�o da entidade 
     * @throws IOException caso ocorra erro de sa�da
     */
    public String obterEndereco() throws IOException;
    
}
