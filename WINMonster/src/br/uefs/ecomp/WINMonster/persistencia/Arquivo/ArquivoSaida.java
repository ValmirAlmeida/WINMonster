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

import br.uefs.ecomp.WINMonster.persistencia.SaidaPersistencia;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe que representa um arquivo gerado ap�s a descompacta��o no contexto do programa.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class ArquivoSaida extends Arquivo implements SaidaPersistencia {
    
    /**
     * Obt�m uma nova inst�ncia de arquivo de saida.
     * @param nomeArquivo nome do arquivo de sa�da
     */
    public ArquivoSaida(String nomeArquivo)  {
        super(nomeArquivo); //define o endere�o do local onde o caminho ser� salvo
        /* Como a inten��o � salvar os arquivos descompactados na mesma pasta do projeto, ent�o basta o nome desejado. */
    }

     /**
     * Grava o texto decodificado no arquivo de sa�da.
     * @param textoDecodificado texto decodificado que ser� salvo no arquivo
     * @throws FileNotFoundException caso n�o seja encontrado o endere�o
     * @throws IOException caso ocorra erro de sa�da
     */
    @Override
    public void gravarTexto(String textoDecodificado) throws FileNotFoundException, IOException {
        BufferedWriter fluxoSaida; //fluxo para escrita no arquivo de sa�da
        StringBuffer auxiliar = new StringBuffer(); //StringBuffer auxiliar para realizar a concatena��o dos caracteres do texto codificado
        
        try {
            fluxoSaida = new BufferedWriter(new FileWriter(super.getArquivo())); //cria uma nova inst�ncia do fluxo de saida e o direciona para o caminho do arquivo
            for(int i = 0; i<textoDecodificado.length(); i++) { //percorre o texto decodificado
                if(textoDecodificado.charAt(i) != '\n') { //se n�o for um fim de linha
                    auxiliar.append(textoDecodificado.charAt(i)); //concatena o caractere na StringBuffer
                } else {
                    fluxoSaida.write(auxiliar.toString()); //escreve a String gerada at� o momento no arquivo
                    fluxoSaida.newLine(); //adiciona uma quebra de linha no arquivo
                    auxiliar = new StringBuffer(); //cria uma nova inst�ncia de StringBuffer
                }
                
            }
            
            fluxoSaida.close(); //fecha o fluxo de sa�da
        } catch (FileNotFoundException ex) {
            throw ex; //relan�a a exce��o caso o arquivo n�o seja encontrado
        } catch (IOException ex) {
            throw ex; //relan�a a exce��o caso ocorra erro durante o salvamento do arquivo
        }
    }
    
     /**
     * Obt�m o endere�o no qual o arquivo foi armazenado.
     * @return endere�o da arquivo de sa�da
     * @throws IOException caso ocorra erro de sa�da
     */
    @Override 
    public String obterEndereco() throws IOException {
        return super.obterEndereco(); //obt�m o endere�o na superclasse Arquivo
    }
    
}  

