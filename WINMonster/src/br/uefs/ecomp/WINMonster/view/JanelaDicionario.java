package br.uefs.ecomp.WINMonster.view;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Janela respons�vel pela exibi��o do dicion�rio utilizado na codifica��o/decodifica��o.
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
     * Cria uma nova inst�ncia da janela com o dicion�rio.
     * @param dicionario dicion�rio que ser� exibido
     */
    public JanelaDicionario(String[][] dicionario){
        super("Dicionario"); //define o r�tulo da janela
        String[] tituloTabela = {"Caractere", "Bin�rio"}; //define o nome das colunas da tabela

        JPanel painelFundo = new JPanel(); //cria o painel que conter� o dicion�rio
        painelFundo.setLayout(new GridLayout(1, 1)); //define o layout do painel
        JTable tabela = new JTable(converterDicionario(dicionario), tituloTabela); //cria uma nova JTable a partir do dicion�rio
        tabela.setEnabled(false); //desativa a edi��o
        JScrollPane barraRolagem = new JScrollPane(tabela); //cria uma nova barra de rolagem com a tabela criada
        painelFundo.add(barraRolagem); //adiciona a barra ao painel
        getContentPane().add(painelFundo); //adiciona o painel ao frame principal
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//encerra o programa quando a janela � fechada
        setSize(300,150);//tamanho padr�o da janela
        setResizable(true);
        setLocationRelativeTo(null);//localiza a janela no centro do monitor
        setVisible(true);//torna a janela visivel
        setResizable(false);//trava o redimensionamento da janela
    }
    
    /**
     * Converte o dicion�rio para ser representado, as linhas do antigo dicion�rio ser�o as colunas do novo e as colunas do antigo ser�o as linhas do novo.
     * @param dicionarioOriginal dicion�rio original
     * @return dicion�rio ap�s convers�o
     */
    private String[][] converterDicionario(String[][] dicionarioOriginal) {
        String[][] novoDicionario = new String[dicionarioOriginal[1].length][2]; //cria uma nova matriz para o novo dicion�rio
        
        for(int i=0; i<dicionarioOriginal[1].length; i++){ //percorre o dicion�rio original
            if(dicionarioOriginal[0][i].equals("\n")) { //caso seja encontrada uma quebra de linha no dicion�rio
                novoDicionario[i][0] = "Quebra de linha";
            } else if(dicionarioOriginal[0][i].equals(" ")) { //caso seja encontrado um espa�o no dicion�rio
                novoDicionario[i][0] = "Espa�o";
            } else { 
                novoDicionario[i][0] = dicionarioOriginal[0][i]; //transfere a informa��o da linha do dicion�rio original para a coluna do novo
            }
            
            novoDicionario[i][1] = dicionarioOriginal[1][i]; //transfere a informa��o da coluna do dicion�rio original para a linha do novo
        }
        
        return novoDicionario;
    }
}