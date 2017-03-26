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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Classe no topo da hierarquia de Arquivos no contexto do programa. Representa um arquivo geral, sem especifica��es.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class Arquivo {
    
    /** Empacotador do arquivo. */
    private File arquivo;
    
    /**
     * Obt�m uma nova inst�ncia de arquivo.
     * @param endereco endere�o no qual o arquivo est� armazenado
     */
    public Arquivo(String endereco) {
        arquivo = new File(endereco); //cria uma nova inst�ncia de File a partir do endere�o recebido
    }
    
    /**
     * Obt�m o endere�o no qual o arquivo est� salvo.
     * @return endere�o no qual o arquivo est� salvo
     * @throws FileNotFoundException caso o arquivo n�o seja encontrado
     * @throws IOException caso ocorra erro de entrada ou sa�da
     */
    public String obterEndereco() throws FileNotFoundException, IOException {
        try {
           return arquivo.getCanonicalPath(); //obt�m o endere�o �nico do arquivo
        } catch (FileNotFoundException e) { //caso o arquivo n�o seja encontrado
            throw e;
        } catch (IOException e) { //caso ocorra erro de entrada ou sa�da
            throw e;
        }
    }
    
    /**
     * Retorna o empacotador de arquivo contido na classe.
     * @return empacotador de arquivo
     */
    public File getArquivo() {
        return arquivo; //retorna a refer�ncia do atributo "arquivo"
    }
}
