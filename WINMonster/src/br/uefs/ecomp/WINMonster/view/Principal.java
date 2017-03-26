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
package br.uefs.ecomp.WINMonster.view;


/**
 * Classe respons�vel por dar in�cio ao programa.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class Principal {

    /**
     * M�todo principal.
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args)  {
        SplashScreen splashScreen = new SplashScreen(); //cria uma nova inst�ncia de SplashScreen e a exibe
        JanelaPrincipal janela = new JanelaPrincipal(); //cria uma nova inst�ncia da janela principal
        janela.criarJanelaPrincipal(); //exibe a janela principal
    }
    
}
