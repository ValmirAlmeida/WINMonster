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
package br.uefs.ecomp.WINMonster.controller;
import br.uefs.ecomp.WINMonster.exceptions.EntradaVaziaException;
import br.uefs.ecomp.WINMonster.exceptions.FormatoInvalidoException;
import br.uefs.ecomp.WINMonster.exceptions.IntegridadeVioladaException;
import br.uefs.ecomp.WINMonster.persistencia.CompactadoPersistencia;
import br.uefs.ecomp.WINMonster.persistencia.DescompactadoPersistencia;
import br.uefs.ecomp.WINMonster.persistencia.EntradaPersistencia;
import br.uefs.ecomp.WINMonster.persistencia.Fachada;
import br.uefs.ecomp.WINMonster.persistencia.SaidaPersistencia;
import br.uefs.ecomp.WINMonster.util.Hash;
import br.uefs.ecomp.WINMonster.util.Huffman;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Camada de negócios da aplicação, responsável por gerenciar os processos de compactação e descompactação.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class WINMonsterController {
    
    /** Algoritmo de Huffman utilizado para compactação e descompactação. */
    private static Huffman algoritmoHuffman;
    
    /**
     * Obtém a instância do algoritmo de Huffman utilizado.
     * @return referência para o algoritmo de huffman
     */
    public Huffman getAlgoritmoHuffman() {
        return algoritmoHuffman;
    }
    
    /**
     * Realiza a compactação de uma entidade presente no caminho de entrada.
     * @param caminhoEntrada localização da entidade que será compactada
     * @return endereço no qual foi alocada a entidade após a compactação
     * @throws FileNotFoundException caso a entidade não seja encontrada no caminho
     * @throws IOException caso ocorra erros de entrada ou saída
     * @throws EntradaVaziaException caso seja aberto um arquivo vazio
     */
    public String compactar(String caminhoEntrada) throws FileNotFoundException, IOException, EntradaVaziaException {
        EntradaPersistencia entrada; //entidade de entrada
        CompactadoPersistencia entidadeCompactacao = null; //referência para uma nova entidade compactada
        String textoCodificado; //variável que conterá o texto codificado
        
        try {
            entrada = Fachada.obterEntidadeEntrada(caminhoEntrada); //obtém uma instância da entidade de entrada
          
            algoritmoHuffman = new Huffman(entrada.obterTextoOriginal()); //obtém uma nova instância do algoritmo de Huffman a partir do texto original
            textoCodificado = algoritmoHuffman.codificar(); //codifica o texto

            entidadeCompactacao = Fachada.obterEntidadeCompactacao(entrada.obterCaminho()); //obtém a referência para uma nova entidade compactada
            entidadeCompactacao.gravarDados(algoritmoHuffman.getArvore(), algoritmoHuffman.getDicionario()[1].length, textoCodificado, Hash.obterHash(entrada.obterTextoOriginal()), entrada.obterNome()); //faz uma tentiva de gravação dos dados necessários ao processo de compactação na entidade compactada
        } catch (FileNotFoundException ex) { //caso a entidade não seja encontrada
            throw ex;
        } catch (IOException ex) { //caso ocorra erro de entrada ou saída
            throw ex;
        }
        
        return entidadeCompactacao.obterDestino(); //retorna o caminho para o local onde a entidade compactada foi salva
    }
    
    /**
     * Realiza a descompactação de uma entidade compactada localizada no endereço recebido por parâmetro.
     * @param caminhoEntrada localização da entidade que será descompactada
     * @return endereço no qual foi alocado o arquivo descompactado
     * @throws IntegridadeVioladaException caso a integridade do arquivo descompactado tenha sido violada
     * @throws FileNotFoundException caso o arquivo não seja encontrado
     * @throws IOException caso ocorra erro de entrada ou saída
     * @throws ClassNotFoundException caso alguma das classes dos dados salvos no arquivo compactado não seja encontrada em tempo de execução
     */
    public String descompactar(String caminhoEntrada) throws IntegridadeVioladaException, FileNotFoundException, IOException, ClassNotFoundException {
        DescompactadoPersistencia entidadeDescompactada; //entidade descompactada
        String textoDecodificado; //texto decodificado
        SaidaPersistencia entidadeSaida = null; //entidade que será salva após o processo de descompactação
        
        try {
            entidadeDescompactada = Fachada.obterEntidadeDescompactacao(caminhoEntrada); //obtém uma nova entidade para a realização de descompactação
            algoritmoHuffman = new Huffman(entidadeDescompactada.obterArvore(), entidadeDescompactada.obterNumCaracteres()); //cria uma nova instância de algoritmo de Huffman, com base na Árvore e no número de caracteres lidos do arquivo que serão descompactados
                        
            textoDecodificado = algoritmoHuffman.decodificar(entidadeDescompactada.obterTextoCodificado()); //realiza a decodificação
            
            entidadeDescompactada.verificarIntegridade(textoDecodificado); //verifica se a integridade do arquivo não foi violada
            
            entidadeSaida = Fachada.obterEntidadeSaida(entidadeDescompactada.obterNomeOriginal()); //obtém uma nova instância de entidade de saída
            entidadeSaida.gravarTexto(textoDecodificado); //grava o texto decodificado na entidade de saída
        } catch (ClassNotFoundException ex) { //caso não seja encontrada alguma classe necessária em tempo de execução
            throw ex;
        } catch (FileNotFoundException ex) { //caso a entidade não seja encontrada no destino
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            throw ex;
        } catch (IntegridadeVioladaException ex) {
            throw ex;
        }
        
        return entidadeSaida.obterEndereco(); //retorna o endereço no qual foi salvo o arquivo após a descompactação
    }
    
    /**
     * Verifica se a extensão da entrada condiz com os formatos que podem ser compactados e descompactados.
     * @param nomeEntrada nome da entidade de entrada
     * @param compactacao <code>true</code>, caso se deseje verificar a entrada para um processo de compactação; <code>false</code>, caso contrário.
     * @throws FormatoInvalidoException caso o formato de entrada seja inválido
     */
    public static void verificarEntrada(String nomeEntrada, boolean compactacao) throws FormatoInvalidoException {
        String extensao = nomeEntrada.substring(nomeEntrada.lastIndexOf(".")); //obtém a extensão da entrada
            
        if(compactacao) { //caso seja verificação para compactação
            if(!extensao.equals(".txt") && !extensao.equals(".cpp") && !extensao.equals(".c") && !extensao.equals(".html")) { //caso a entrada seja diferente de algum dos formatos que se espera
             throw new FormatoInvalidoException();
            }  
        } else { //caso seja verificação para descompactação
            if(!extensao.equals(".monster")) { //verifica se o formato é diferente daquele que pode ser descompactado pelo programa
                throw new FormatoInvalidoException();
            }
        }
    }
    


}
