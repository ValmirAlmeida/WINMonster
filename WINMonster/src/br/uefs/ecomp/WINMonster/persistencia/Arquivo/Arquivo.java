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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Classe no topo da hierarquia de Arquivos no contexto do programa. Representa um arquivo geral, sem especificações.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class Arquivo {
    
    /** Empacotador do arquivo. */
    private File arquivo;
    
    /**
     * Obtém uma nova instância de arquivo.
     * @param endereco endereço no qual o arquivo está armazenado
     */
    public Arquivo(String endereco) {
        arquivo = new File(endereco); //cria uma nova instância de File a partir do endereço recebido
    }
    
    /**
     * Obtém o endereço no qual o arquivo está salvo.
     * @return endereço no qual o arquivo está salvo
     * @throws FileNotFoundException caso o arquivo não seja encontrado
     * @throws IOException caso ocorra erro de entrada ou saída
     */
    public String obterEndereco() throws FileNotFoundException, IOException {
        try {
           return arquivo.getCanonicalPath(); //obtém o endereço único do arquivo
        } catch (FileNotFoundException e) { //caso o arquivo não seja encontrado
            throw e;
        } catch (IOException e) { //caso ocorra erro de entrada ou saída
            throw e;
        }
    }
    
    /**
     * Retorna o empacotador de arquivo contido na classe.
     * @return empacotador de arquivo
     */
    public File getArquivo() {
        return arquivo; //retorna a referência do atributo "arquivo"
    }
}
