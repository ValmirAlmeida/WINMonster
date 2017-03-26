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
package br.uefs.ecomp.WINMonster.view;


/**
 * Classe responsável por dar início ao programa.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 */
public class Principal {

    /**
     * Método principal.
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args)  {
        SplashScreen splashScreen = new SplashScreen(); //cria uma nova instância de SplashScreen e a exibe
        JanelaPrincipal janela = new JanelaPrincipal(); //cria uma nova instância da janela principal
        janela.criarJanelaPrincipal(); //exibe a janela principal
    }
    
}
