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

import br.uefs.ecomp.WINMonster.persistencia.Arquivo.ArquivoEntrada;
import br.uefs.ecomp.WINMonster.persistencia.Arquivo.ArquivoDescompactado;
import br.uefs.ecomp.WINMonster.persistencia.Arquivo.ArquivoCompactado;
import br.uefs.ecomp.WINMonster.persistencia.Arquivo.ArquivoSaida;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Classe para intermediar o relacionamento entre a camada de neg�cios e os aspectos de persist�ncia pr�prios do problema.
 * Aqui ser� definido o tipo efetivo de persist�ncia a ser utilizado.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class Fachada {
    
    /**
     * Construtor privado, afim de impedir o instanciamento da classe.
     */
    private Fachada(){};
    
    /**
     * Obt�m uma inst�ncia de entidade de compacta��o.
     * @param destino local onde a entidade compactada ser� armazenada
     * @return refer�ncia de CompactadoPersistencia
     * @throws FileNotFoundException caso n�o seja encontrado o destino informado
     * @throws IOException caso ocorra erro de entrada/sa�da
     */
    public static CompactadoPersistencia obterEntidadeCompactacao(String destino) throws FileNotFoundException, IOException {
        return new ArquivoCompactado(destino); //retorna a refer�ncia para uma nova inst�ncia de arquivo compactado
    }
    
    /**
     * Obt�m uma inst�ncia de entidade de descompacta��o.
     * @param caminho local onde a entidade de descompacta��o est� armazenada
     * @return refer�ncia de DescompactadoPersistencia
     * @throws FileNotFoundException caso n�o seja encontrado o destino informado
     * @throws IOException caso ocorra erro de entrada/sa�da
     */
    public static DescompactadoPersistencia obterEntidadeDescompactacao(String caminho) throws FileNotFoundException, IOException {
        return new ArquivoDescompactado(caminho); //retorna a refer�ncia para uma nova inst�ncia de arquivo descompactado
    }
    
    /**
     * Obt�m uma inst�ncia da entidade de entrada.
     * @param caminho localiza��o da entidade de entrada
     * @return refer�ncia de EntradaPersistencia
     * @throws FileNotFoundException caso n�o seja encontrado o destino informado
     * @throws IOException caso ocorra erro de entrada/sa�da
     */
    public static EntradaPersistencia obterEntidadeEntrada(String caminho) throws FileNotFoundException, IOException {
        return new ArquivoEntrada(caminho); //retorna a refer�ncia para uma nova inst�ncia de arquivo de entrada
    }

    /**
     * Obt�m uma inst�ncia de entidade de sa�da.
     * @param nomeSaida nome da entidade de sa�da, servir� tamb�m como localiza��o desta sa�da.
     * @return refer�ncia de SaidaPersistencia
     * @throws FileNotFoundException caso n�o seja encontrado o destino informado
     * @throws IOException caso ocorra erro de entrada/sa�da
     */
    public static SaidaPersistencia obterEntidadeSaida(String nomeSaida) throws FileNotFoundException, IOException {
        return new ArquivoSaida(nomeSaida); //retorna a refer�ncia para uma nova inst�ncia de arquvio de saida
    }
    
    
    
}
