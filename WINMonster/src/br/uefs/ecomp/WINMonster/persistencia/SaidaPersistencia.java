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
package br.uefs.ecomp.WINMonster.persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Interface que representa uma entidade de saída pós-compactação.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public interface SaidaPersistencia  {
    
    /**
     * Grava o texto decodificado na entidade de saida.
     * @param textoDecodificado texto decodificado que será salvo na entidade
     * @throws java.io.FileNotFoundException caso não seja encontrado o endereço
     * @throws java.io.IOException caso ocorra erro de saída
     */
    public void gravarTexto(String textoDecodificado) throws FileNotFoundException, IOException;
    
    /**
     * Obtém o endereço no qual a entidade foi armazenada.
     * @return endereço da entidade 
     * @throws IOException caso ocorra erro de saída
     */
    public String obterEndereco() throws IOException;
    
}
