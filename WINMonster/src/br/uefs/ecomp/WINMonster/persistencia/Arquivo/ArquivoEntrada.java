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
     * Obtém uma nova instância do arquivo de entrada
     * @param enderecoEntrada endereço do arquivo de entrada
     */
    public ArquivoEntrada(String enderecoEntrada) {
        super(enderecoEntrada); //define o endereço do arquivo
    }
    
    /**
     * Obtém o texto original contido no arquivo de entrada.
     * @return texto original contido no arquivo de entrada 
     * @throws java.io.FileNotFoundException caso o arquivo não seja encontrado
     * @throws java.io.IOException caso ocorra erro de entrada do arquivo
     * @throws EntradaVaziaException caso a entrada esteja vazia
     */
    @Override
    public String obterTextoOriginal() throws FileNotFoundException, IOException, EntradaVaziaException {
        Scanner entradaArqTexto = null; //referência utilizada para leitura do arquivo
        StringBuffer textoOriginal = new StringBuffer(); //StringBuffer para concantenar o texto lido do arquivo
        
        try {
           entradaArqTexto = new Scanner(new FileReader(super.obterEndereco())); //tenta redirecionar o fluxo para uma entrada de arquivo de texto
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
            throw ex;
        }
        
        while(entradaArqTexto.hasNextLine()) { //enquanto não for atingido o fim do arquivo de texto
            textoOriginal.append(entradaArqTexto.nextLine()); //obtém a próxima linha e concatena na StringBuffer
            textoOriginal.append("\n"); //adiciona uma quebra de linha
        }
        
        if(textoOriginal.toString().equals("")) { //caso o texto esteja vazio
            throw new EntradaVaziaException();
        }
        
        return textoOriginal.toString(); //retorna a String correspondente ao texto original
    }
    

     /**
     * Obtém o caminho para o arquivo de entrada.
     * @return caminho do arquivo de entrada
     * @throws java.io.FileNotFoundException caso o arquivo não seja encontrado
     * @throws java.io.IOException caso ocorra erro de entrada
     */
    @Override
    public String obterCaminho() throws FileNotFoundException, IOException {
        try {
            return super.getArquivo().getCanonicalPath(); //obtém o endereço único do arquivo
        } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
           throw ex;
        } catch (IOException ex) { //caso ocorra algum erro de entrada ou saída
           throw ex;
        }
    }
    
    /**
     * Obtém o nome original do arquivo de entrada, bem como a sua extensão.
     * @return nome original do arquivo de entrada
     */
    @Override
    public String obterNome() {
        return super.getArquivo().getName(); //obtém o nome do arquivo de entrada
    }
    
    
}
