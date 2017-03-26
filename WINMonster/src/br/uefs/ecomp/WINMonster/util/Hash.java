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
package br.uefs.ecomp.WINMonster.util;


/**
 * Classe respons�vel por fornecer um m�todo est�tico para gera��o de valor de Hash.
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
     * Gera uma representação em inteiros única, utilizando uma função de Hash, para uma chave informada.
     * @param chave chave para a qual será gerada uma representação em inteiros
     * @return valor de hash gerado para a chave
     */
    public static long obterHash(String chave) {
        long valorHash = 0; //valor de hash
        
       for(int i = 0; i < chave.length(); i++) { //percorre a chave
            valorHash = (valorHash*i + chave.charAt(i)) % chave.length(); //express�o para gerar o valor de hash
        }
        
        return valorHash; //retorna o valor de hash
    }
    
}
