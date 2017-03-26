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
package br.uefs.ecomp.WINMonster.util;


/**
 * Classe responsável por fornecer um método estático para geração de valor de Hash.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class Hash {
    
    /**
     * Construtor privado e vazio. Impede o instanciamento da classe.
     */
    private Hash(){};
    
    /**
     * Gera uma representaÃ§Ã£o em inteiros Ãºnica, utilizando uma funÃ§Ã£o de Hash, para uma chave informada.
     * @param chave chave para a qual serÃ¡ gerada uma representaÃ§Ã£o em inteiros
     * @return valor de hash gerado para a chave
     */
    public static long obterHash(String chave) {
        long valorHash = 0; //valor de hash
        
       for(int i = 0; i < chave.length(); i++) { //percorre a chave
            valorHash = (valorHash*i + chave.charAt(i)) % chave.length(); //expressão para gerar o valor de hash
        }
        
        return valorHash; //retorna o valor de hash
    }
    
}
