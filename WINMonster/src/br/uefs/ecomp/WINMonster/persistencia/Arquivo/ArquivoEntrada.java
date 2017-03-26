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
package br.uefs.ecomp.WINMonster.persistencia.Arquivo;

import br.uefs.ecomp.WINMonster.persistencia.EntradaPersistencia;
import br.uefs.ecomp.WINMonster.exceptions.EntradaVaziaException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Classe representa um arquivo de entrada no programa.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class ArquivoEntrada extends Arquivo implements EntradaPersistencia {
    
    /**
     * Obt�m uma nova inst�ncia do arquivo de entrada
     * @param enderecoEntrada endere�o do arquivo de entrada
     */
    public ArquivoEntrada(String enderecoEntrada) {
        super(enderecoEntrada); //define o endere�o do arquivo
    }
    
    /**
     * Obt�m o texto original contido no arquivo de entrada.
     * @return texto original contido no arquivo de entrada 
     * @throws java.io.FileNotFoundException caso o arquivo n�o seja encontrado
     * @throws java.io.IOException caso ocorra erro de entrada do arquivo
     * @throws EntradaVaziaException caso a entrada esteja vazia
     */
    @Override
    public String obterTextoOriginal() throws FileNotFoundException, IOException, EntradaVaziaException {
        Scanner entradaArqTexto = null; //refer�ncia utilizada para leitura do arquivo
        StringBuffer textoOriginal = new StringBuffer(); //StringBuffer para concantenar o texto lido do arquivo
        
        try {
           entradaArqTexto = new Scanner(new FileReader(super.obterEndereco())); //tenta redirecionar o fluxo para uma entrada de arquivo de texto
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
            throw ex;
        }
        
        while(entradaArqTexto.hasNextLine()) { //enquanto n�o for atingido o fim do arquivo de texto
            textoOriginal.append(entradaArqTexto.nextLine()); //obt�m a pr�xima linha e concatena na StringBuffer
            textoOriginal.append("\n"); //adiciona uma quebra de linha
        }
        
        if(textoOriginal.toString().equals("")) { //caso o texto esteja vazio
            throw new EntradaVaziaException();
        }
        
        return textoOriginal.toString(); //retorna a String correspondente ao texto original
    }
    

     /**
     * Obt�m o caminho para o arquivo de entrada.
     * @return caminho do arquivo de entrada
     * @throws java.io.FileNotFoundException caso o arquivo n�o seja encontrado
     * @throws java.io.IOException caso ocorra erro de entrada
     */
    @Override
    public String obterCaminho() throws FileNotFoundException, IOException {
        try {
            return super.getArquivo().getCanonicalPath(); //obt�m o endere�o �nico do arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou sa�da
           throw ex;
        }
    }
    
    /**
     * Obt�m o nome original do arquivo de entrada, bem como a sua extens�o.
     * @return nome original do arquivo de entrada
     */
    @Override
    public String obterNome() {
        return super.getArquivo().getName(); //obt�m o nome do arquivo de entrada
    }
    
    
}
