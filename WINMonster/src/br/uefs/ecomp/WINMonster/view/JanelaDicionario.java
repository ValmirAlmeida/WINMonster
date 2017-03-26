package br.uefs.ecomp.WINMonster.view;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Janela responsável pela exibição do dicionário utilizado na codificação/decodificação.
 * @author Iago Almeida
 * @author Valmir Vinicius
 * @see javax.swing.JFrame
 * @see java.awt.GridLayout
 * @see javax.swing.JPanel
 * @see javax.swing.JScrollPane
 * @see javax.swing.JTable
 */
public class JanelaDicionario extends JFrame {
    
    /**
     * Cria uma nova instância da janela com o dicionário.
     * @param dicionario dicionário que será exibido
     */
    public JanelaDicionario(String[][] dicionario){
        super("Dicionario"); //define o rótulo da janela
        String[] tituloTabela = {"Caractere", "Binário"}; //define o nome das colunas da tabela

        JPanel painelFundo = new JPanel(); //cria o painel que conterá o dicionário
        painelFundo.setLayout(new GridLayout(1, 1)); //define o layout do painel
        JTable tabela = new JTable(converterDicionario(dicionario), tituloTabela); //cria uma nova JTable a partir do dicionário
        tabela.setEnabled(false); //desativa a edição
        JScrollPane barraRolagem = new JScrollPane(tabela); //cria uma nova barra de rolagem com a tabela criada
        painelFundo.add(barraRolagem); //adiciona a barra ao painel
        getContentPane().add(painelFundo); //adiciona o painel ao frame principal
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//encerra o programa quando a janela é fechada
        setSize(300,150);//tamanho padrão da janela
        setResizable(true);
        setLocationRelativeTo(null);//localiza a janela no centro do monitor
        setVisible(true);//torna a janela visivel
        setResizable(false);//trava o redimensionamento da janela
    }
    
    /**
     * Converte o dicionário para ser representado, as linhas do antigo dicionário serão as colunas do novo e as colunas do antigo serão as linhas do novo.
     * @param dicionarioOriginal dicionário original
     * @return dicionário após conversão
     */
    private String[][] converterDicionario(String[][] dicionarioOriginal) {
        String[][] novoDicionario = new String[dicionarioOriginal[1].length][2]; //cria uma nova matriz para o novo dicionário
        
        for(int i=0; i<dicionarioOriginal[1].length; i++){ //percorre o dicionário original
            if(dicionarioOriginal[0][i].equals("\n")) { //caso seja encontrada uma quebra de linha no dicionário
                novoDicionario[i][0] = "Quebra de linha";
            } else if(dicionarioOriginal[0][i].equals(" ")) { //caso seja encontrado um espaço no dicionário
                novoDicionario[i][0] = "Espaço";
            } else { 
                novoDicionario[i][0] = dicionarioOriginal[0][i]; //transfere a informação da linha do dicionário original para a coluna do novo
            }
            
            novoDicionario[i][1] = dicionarioOriginal[1][i]; //transfere a informação da coluna do dicionário original para a linha do novo
        }
        
        return novoDicionario;
    }
}