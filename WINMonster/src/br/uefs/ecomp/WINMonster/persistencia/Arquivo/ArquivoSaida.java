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

import br.uefs.ecomp.WINMonster.persistencia.SaidaPersistencia;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe que representa um arquivo gerado após a descompactação no contexto do programa.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class ArquivoSaida extends Arquivo implements SaidaPersistencia {
    
    /**
     * Obtém uma nova instância de arquivo de saida.
     * @param nomeArquivo nome do arquivo de saída
     */
    public ArquivoSaida(String nomeArquivo)  {
        super(nomeArquivo); //define o endereço do local onde o caminho será salvo
        /* Como a intenção é salvar os arquivos descompactados na mesma pasta do projeto, então basta o nome desejado. */
    }

     /**
     * Grava o texto decodificado no arquivo de saída.
     * @param textoDecodificado texto decodificado que será salvo no arquivo
     * @throws FileNotFoundException caso não seja encontrado o endereço
     * @throws IOException caso ocorra erro de saída
     */
    @Override
    public void gravarTexto(String textoDecodificado) throws FileNotFoundException, IOException {
        BufferedWriter fluxoSaida; //fluxo para escrita no arquivo de saída
        StringBuffer auxiliar = new StringBuffer(); //StringBuffer auxiliar para realizar a concatenação dos caracteres do texto codificado
        
        try {
            fluxoSaida = new BufferedWriter(new FileWriter(super.getArquivo())); //cria uma nova instância do fluxo de saida e o direciona para o caminho do arquivo
            for(int i = 0; i<textoDecodificado.length(); i++) { //percorre o texto decodificado
                if(textoDecodificado.charAt(i) != '\n') { //se não for um fim de linha
                    auxiliar.append(textoDecodificado.charAt(i)); //concatena o caractere na StringBuffer
                } else {
                    fluxoSaida.write(auxiliar.toString()); //escreve a String gerada até o momento no arquivo
                    fluxoSaida.newLine(); //adiciona uma quebra de linha no arquivo
                    auxiliar = new StringBuffer(); //cria uma nova instância de StringBuffer
                }
                
            }
            
            fluxoSaida.close(); //fecha o fluxo de saída
        } catch (FileNotFoundException ex) {
            throw ex; //relança a exceção caso o arquivo não seja encontrado
        } catch (IOException ex) {
            throw ex; //relança a exceção caso ocorra erro durante o salvamento do arquivo
        }
    }
    
     /**
     * Obtém o endereço no qual o arquivo foi armazenado.
     * @return endereço da arquivo de saída
     * @throws IOException caso ocorra erro de saída
     */
    @Override 
    public String obterEndereco() throws IOException {
        return super.obterEndereco(); //obtém o endereço na superclasse Arquivo
    }
    
}  

