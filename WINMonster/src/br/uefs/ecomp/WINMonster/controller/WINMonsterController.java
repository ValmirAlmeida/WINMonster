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
 * Camada de neg�cios da aplica��o, respons�vel por gerenciar os processos de compacta��o e descompacta��o.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class WINMonsterController {
    
    /** Algoritmo de Huffman utilizado para compacta��o e descompacta��o. */
    private static Huffman algoritmoHuffman;
    
    /**
     * Obt�m a inst�ncia do algoritmo de Huffman utilizado.
     * @return refer�ncia para o algoritmo de huffman
     */
    public Huffman getAlgoritmoHuffman() {
        return algoritmoHuffman;
    }
    
    /**
     * Realiza a compacta��o de uma entidade presente no caminho de entrada.
     * @param caminhoEntrada localiza��o da entidade que ser� compactada
     * @return endere�o no qual foi alocada a entidade ap�s a compacta��o
     * @throws FileNotFoundException caso a entidade n�o seja encontrada no caminho
     * @throws IOException caso ocorra erros de entrada ou sa�da
     * @throws EntradaVaziaException caso seja aberto um arquivo vazio
     */
    public String compactar(String caminhoEntrada) throws FileNotFoundException, IOException, EntradaVaziaException {
        EntradaPersistencia entrada; //entidade de entrada
        CompactadoPersistencia entidadeCompactacao = null; //refer�ncia para uma nova entidade compactada
        String textoCodificado; //vari�vel que conter� o texto codificado
        
        try {
            entrada = Fachada.obterEntidadeEntrada(caminhoEntrada); //obt�m uma inst�ncia da entidade de entrada
          
            algoritmoHuffman = new Huffman(entrada.obterTextoOriginal()); //obt�m uma nova inst�ncia do algoritmo de Huffman a partir do texto original
            textoCodificado = algoritmoHuffman.codificar(); //codifica o texto

            entidadeCompactacao = Fachada.obterEntidadeCompactacao(entrada.obterCaminho()); //obt�m a refer�ncia para uma nova entidade compactada
            entidadeCompactacao.gravarDados(algoritmoHuffman.getArvore(), algoritmoHuffman.getDicionario()[1].length, textoCodificado, Hash.obterHash(entrada.obterTextoOriginal()), entrada.obterNome()); //faz uma tentiva de grava��o dos dados necess�rios ao processo de compacta��o na entidade compactada
        } catch (FileNotFoundException ex) { //caso a entidade n�o seja encontrada
            throw ex;
        } catch (IOException ex) { //caso ocorra erro de entrada ou sa�da
            throw ex;
        }
        
        return entidadeCompactacao.obterDestino(); //retorna o caminho para o local onde a entidade compactada foi salva
    }
    
    /**
     * Realiza a descompacta��o de uma entidade compactada localizada no endere�o recebido por par�metro.
     * @param caminhoEntrada localiza��o da entidade que ser� descompactada
     * @return endere�o no qual foi alocado o arquivo descompactado
     * @throws IntegridadeVioladaException caso a integridade do arquivo descompactado tenha sido violada
     * @throws FileNotFoundException caso o arquivo n�o seja encontrado
     * @throws IOException caso ocorra erro de entrada ou sa�da
     * @throws ClassNotFoundException caso alguma das classes dos dados salvos no arquivo compactado n�o seja encontrada em tempo de execu��o
     */
    public String descompactar(String caminhoEntrada) throws IntegridadeVioladaException, FileNotFoundException, IOException, ClassNotFoundException {
        DescompactadoPersistencia entidadeDescompactada; //entidade descompactada
        String textoDecodificado; //texto decodificado
        SaidaPersistencia entidadeSaida = null; //entidade que ser� salva ap�s o processo de descompacta��o
        
        try {
            entidadeDescompactada = Fachada.obterEntidadeDescompactacao(caminhoEntrada); //obt�m uma nova entidade para a realiza��o de descompacta��o
            algoritmoHuffman = new Huffman(entidadeDescompactada.obterArvore(), entidadeDescompactada.obterNumCaracteres()); //cria uma nova inst�ncia de algoritmo de Huffman, com base na �rvore e no n�mero de caracteres lidos do arquivo que ser�o descompactados
                        
            textoDecodificado = algoritmoHuffman.decodificar(entidadeDescompactada.obterTextoCodificado()); //realiza a decodifica��o
            
            entidadeDescompactada.verificarIntegridade(textoDecodificado); //verifica se a integridade do arquivo n�o foi violada
            
            entidadeSaida = Fachada.obterEntidadeSaida(entidadeDescompactada.obterNomeOriginal()); //obt�m uma nova inst�ncia de entidade de sa�da
            entidadeSaida.gravarTexto(textoDecodificado); //grava o texto decodificado na entidade de sa�da
        } catch (ClassNotFoundException ex) { //caso n�o seja encontrada alguma classe necess�ria em tempo de execu��o
            throw ex;
        } catch (FileNotFoundException ex) { //caso a entidade n�o seja encontrada no destino
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            throw ex;
        } catch (IntegridadeVioladaException ex) {
            throw ex;
        }
        
        return entidadeSaida.obterEndereco(); //retorna o endere�o no qual foi salvo o arquivo ap�s a descompacta��o
    }
    
    /**
     * Verifica se a extens�o da entrada condiz com os formatos que podem ser compactados e descompactados.
     * @param nomeEntrada nome da entidade de entrada
     * @param compactacao <code>true</code>, caso se deseje verificar a entrada para um processo de compacta��o; <code>false</code>, caso contr�rio.
     * @throws FormatoInvalidoException caso o formato de entrada seja inv�lido
     */
    public static void verificarEntrada(String nomeEntrada, boolean compactacao) throws FormatoInvalidoException {
        String extensao = nomeEntrada.substring(nomeEntrada.lastIndexOf(".")); //obt�m a extens�o da entrada
            
        if(compactacao) { //caso seja verifica��o para compacta��o
            if(!extensao.equals(".txt") && !extensao.equals(".cpp") && !extensao.equals(".c") && !extensao.equals(".html")) { //caso a entrada seja diferente de algum dos formatos que se espera
             throw new FormatoInvalidoException();
            }  
        } else { //caso seja verifica��o para descompacta��o
            if(!extensao.equals(".monster")) { //verifica se o formato � diferente daquele que pode ser descompactado pelo programa
                throw new FormatoInvalidoException();
            }
        }
    }
    


}
