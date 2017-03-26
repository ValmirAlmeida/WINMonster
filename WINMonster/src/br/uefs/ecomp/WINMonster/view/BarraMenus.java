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

import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Classe responsável por criar a barra de menu a ser exibida na janela principal.
 * @author Iago Almeida
 * @author Valmir Vinicius
 * @see javax.swing.JMenuBar
 * @see java.awt.event.ActionEvent
 * @see javax.swing.JMenuItem
 * @see javax.swing.JOptionPane
 */
public class BarraMenus extends JMenuBar {
    /** Menu de ajuda contido na barra. */
    private JMenu menuAjuda;
    
    /** Menu arquivo contido na barra. */
    private JMenu menuArquivo;
    
    /** Item sobre de um dos menus da barra. */
    private JMenuItem itemMenuSobre;
    
    /** Item autores de um dos menus da barra. */
    private JMenuItem itemMenuAutores;
    
    /** Item sair de um dos menus da barra. */
    private JMenuItem itemMenuSair;
    
    /**
     * Obtém uma nova instância da barra de menus. 
     */
    public BarraMenus() {
        criarMenus(); //cria os menus necessários
    }
    
    
    private void criarMenus() {
        //inicializa menus
        menuAjuda = new JMenu("Ajuda");
        menuArquivo = new JMenu("Arquivo");
        
        //inicializa itens de menu
        itemMenuSobre = new JMenuItem("Sobre");
        itemMenuAutores = new JMenuItem("Autores");
        itemMenuSair = new JMenuItem("Sair");
        
        //adiciona itens aos menus
        menuAjuda.add(itemMenuSobre);
        menuAjuda.add(itemMenuAutores);
        menuArquivo.add(itemMenuSair);
        
        
        //adiciona menus a barra de menus
        super.add(menuArquivo);
        super.add(menuAjuda);
        
        //adiciona ações aos Itens de menu
        itemMenuSobre.addActionListener((ActionEvent ae) -> {
            actionPerformed(ae);
        });
        itemMenuAutores.addActionListener((ActionEvent ae) -> {
            actionPerformed(ae);
        });
        itemMenuSair.addActionListener((ActionEvent ae) -> {
            actionPerformed(ae);
        });
        
    }
    
    /**
     * Adiciona ações aos eventos gerados pelo clique em opções do menu.
     * @param ae evento gerado pelo clique em uma das opções do menu
     */
    private void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == itemMenuAutores) { //caso ocorra um clique no item autores do menu
            JOptionPane.showMessageDialog(null, "Sistema Desenvolvido por:\nIago Almeida e Valmir Vinicius");
        } else if(ae.getSource() == itemMenuSobre) { //caso ocorra um clique no sobre do menu
            JOptionPane.showMessageDialog(null, "Sistema compactador de arquivos WINMonster\n O sistema compacta arquivos das seguintes extensÃµes:\n .c, .cpp, .txt e .html");
        } else { //caso contrário
            if(JOptionPane.showConfirmDialog(null, "Deseja encerra o programa?") <=0){
                JOptionPane.showMessageDialog(null, "Obrigado por utilizar WINMonster");
                System.exit(0);//encerra o sistema
            }
        }
    }
    
    
    
}
