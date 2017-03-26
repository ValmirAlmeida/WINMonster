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

import br.uefs.ecomp.WINMonster.persistencia.Arquivo.ArquivoEntrada;
import br.uefs.ecomp.WINMonster.persistencia.Arquivo.ArquivoDescompactado;
import br.uefs.ecomp.WINMonster.persistencia.Arquivo.ArquivoCompactado;
import br.uefs.ecomp.WINMonster.persistencia.Arquivo.ArquivoSaida;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Classe para intermediar o relacionamento entre a camada de negócios e os aspectos de persistência próprios do problema.
 * Aqui será definido o tipo efetivo de persistência a ser utilizado.
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
     * Obtém uma instância de entidade de compactação.
     * @param destino local onde a entidade compactada será armazenada
     * @return referência de CompactadoPersistencia
     * @throws FileNotFoundException caso não seja encontrado o destino informado
     * @throws IOException caso ocorra erro de entrada/saída
     */
    public static CompactadoPersistencia obterEntidadeCompactacao(String destino) throws FileNotFoundException, IOException {
        return new ArquivoCompactado(destino); //retorna a referência para uma nova instância de arquivo compactado
    }
    
    /**
     * Obtém uma instância de entidade de descompactação.
     * @param caminho local onde a entidade de descompactação está armazenada
     * @return referência de DescompactadoPersistencia
     * @throws FileNotFoundException caso não seja encontrado o destino informado
     * @throws IOException caso ocorra erro de entrada/saída
     */
    public static DescompactadoPersistencia obterEntidadeDescompactacao(String caminho) throws FileNotFoundException, IOException {
        return new ArquivoDescompactado(caminho); //retorna a referência para uma nova instância de arquivo descompactado
    }
    
    /**
     * Obtém uma instância da entidade de entrada.
     * @param caminho localização da entidade de entrada
     * @return referência de EntradaPersistencia
     * @throws FileNotFoundException caso não seja encontrado o destino informado
     * @throws IOException caso ocorra erro de entrada/saída
     */
    public static EntradaPersistencia obterEntidadeEntrada(String caminho) throws FileNotFoundException, IOException {
        return new ArquivoEntrada(caminho); //retorna a referência para uma nova instância de arquivo de entrada
    }

    /**
     * Obtém uma instância de entidade de saída.
     * @param nomeSaida nome da entidade de saída, servirá também como localização desta saída.
     * @return referência de SaidaPersistencia
     * @throws FileNotFoundException caso não seja encontrado o destino informado
     * @throws IOException caso ocorra erro de entrada/saída
     */
    public static SaidaPersistencia obterEntidadeSaida(String nomeSaida) throws FileNotFoundException, IOException {
        return new ArquivoSaida(nomeSaida); //retorna a referência para uma nova instância de arquvio de saida
    }
    
    
    
}
