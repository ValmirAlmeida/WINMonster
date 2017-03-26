/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.WINMonster.view;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * Cria e exibe a Splash Screen exibida ao iniciar o software.
 * @author Iago Almeida
 * @author Valmir Vinicius
 * 
 * @see javax.swing.JFrame
 * @see java.awt.FlowLayout
 * @see java.io.IOException
 * @see javax.swing.ImageIcon
 * @see javax.swing.JLabel
 * @see javax.swing.JProgressBar
 */
public class SplashScreen extends JFrame {
    /** Barra de carregamento da Splash screen. */
    private JProgressBar barraDeCarregamento;
    
    
    /**
     * Cria e exibe a splash screen.
     */
    public SplashScreen() {
        barraDeCarregamento = new JProgressBar(); //obtém uma nova instância da barra de carregamento
        barraDeCarregamento.setSize(400,20); //define o tamanho da barra de carregamento
        barraDeCarregamento.setVisible(true); //torna a barra visível
        
        setContentPane(new JLabel(new ImageIcon("src/br/uefs/ecomp/WINMonster/resources/logo.png"))); //define a imagem exibida
        setLayout(new FlowLayout()); //define o layout
        setUndecorated(true);// retira a barra onde fica os botoes de maximizar, restaura e fechar
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//encerra o programa quando a janela eh fechada
        setSize(400,200);//tamanho padrÃ£o da janela
        setLocationRelativeTo(null);//localiza a janela no centro do monitor
        setVisible(true);//torna a janela visivel
        setResizable(true);//trava o redimensionamento da janela
        add(barraDeCarregamento); //adiciona a barra de carregamento à splash screen
        carregar(); //carrega a splash screen
        setVisible(false); //torna a splash screen não visível
    }
    
    /**
     * Carrega e atualiza a splash screen.
     */
    private void carregar() {
        for (int i = 0; i < 101; i++) { 
            try {
                barraDeCarregamento.setValue(i); //altera o valor carregado
                Thread.sleep(40); //suspende o thread atual por 40 segundos
            } catch (InterruptedException ex) { //caso algum processo interrompa a suspensão do thread
                Thread.currentThread().interrupt();
            }
        }
    }


}

