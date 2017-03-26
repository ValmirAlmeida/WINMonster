/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.WINMonster.view;

import br.uefs.ecomp.WINMonster.controller.WINMonsterController;
import br.uefs.ecomp.WINMonster.exceptions.EntradaVaziaException;
import br.uefs.ecomp.WINMonster.exceptions.FormatoInvalidoException;
import br.uefs.ecomp.WINMonster.exceptions.IntegridadeVioladaException;
import br.uefs.ecomp.WINMonster.util.NoHuffman;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

/**
 * Classe respons�vel por construir a janela principal do programa.
 * 
 * @author Valmir Vinicius
 * @author Iago Almeida
 * @see javax.swing.JFrame
 * @see java.awt.Container
 * @see javax.swing.JTextArea
 * @see javax.swing.JLabel
 * @see javax.swing.JScrollPane
 * @see br.uefs.ecomp.WINMonster.controller.WINMonsterController
 */
public class JanelaPrincipal extends JFrame {
    /** Container de bot�es exibidos na tela. */
    private Container containerBotoes;
  
    /* Caixa de texto exibida na tela. */
    private JTextArea caixaTexto;
    
    /* Label para exibi��o de mensagem. */
    private JLabel label;
    
    /* Painel com barra de rolagem contendo a exibi��o da �rvore. */
    private JScrollPane painelArvore;
    
    /* Selecionador de arquivos. */
    private JFileChooser selecionadorArquivo;
    
    /* Controlador de neg�cios do software. */
    private WINMonsterController controller;


    /**
     * Cria uma nova instancia de JanelaPrincipal.
     */
    public JanelaPrincipal(){
        super("WINMonster - Compactador de Arquivos"); //define o r�tulo da janela principal
         selecionadorArquivo = new JFileChooser(); //obt�m uma nova inst�ncia do selecionador de arquivos
         containerBotoes = new Container(); //obt�m uma nova inst�ncia de container
         caixaTexto = new JTextArea(); //cria uma nova inst�ncia de caixa de texto
         label = new JLabel("Para uma experi�ncia personalizada, digite o seu nome abaixo:"); //cria uma nova label
         controller = new WINMonsterController(); //obt�m uma nova inst�ncia do controlador
    }
    
    /**
     * Cria o container principal da janela.
     * @return refer�ncia para a inst�ncia de container criada
     */
    private Container criarContainer() {
        Container container = new Container(); //obt�m uma nova inst�ncia de container
        container.setLayout(new BorderLayout()); //define o layout da janela
        container.setVisible(true); //torna a janela vis�vel
        
        criarCaixaTexto(); //cria a caixa de texto
        criarBotoes(); //cria os bot�es da janela
        
        container.add(BorderLayout.EAST, containerBotoes);// insere os bot�es ao oeste (canto direito)
        container.add(BorderLayout.NORTH, label); //adiciona label na parte superior
        container.add(BorderLayout.CENTER, caixaTexto); //adiciona a caixa de texto ao centro da janela 
        
        return container; //retorna a refer�ncia para a inst�ncia criada
    }
    
 
    /**
     * Define as especifica��es da janela.
     */
    public void criarJanelaPrincipal() {
        setContentPane(criarContainer()); //define o container do frame
        setJMenuBar(new BarraMenus());//adiciona a barra de menus ao JFrame principal
        setSize(new Dimension(500, 300)); //define o tamanho da tela
        setLocationRelativeTo(null);//localiza a janela no centro do monitor
        setResizable(true);//torna a tela redimension�vel
        setVisible(true);//torna a janela visivel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //encerra o programa quando a janela � fechada
    }
    
    /**
     * Define as especifica��es da caixa de texto.
     */
    private void criarCaixaTexto() {
        caixaTexto.setVisible(true); //torna a caixa de texto vis�vel
        caixaTexto.setEditable(true); //torna a caixa de texto edit�vel
    }
    
    /**
     * Cria os bot�es e define as suas especifica��es.
     */
    private void criarBotoes() {
        /* Cria os bot�es definindo os seus nomes. */
        JButton botaoCompactar = new JButton("Compactar"); 
        JButton botaoDescompactar = new JButton("Descompactar");
        
        botaoCompactar.setVisible(true);
        botaoDescompactar.setVisible(true);
        
        
        /* Adiciona cada um dos bot�es ao container. */
        containerBotoes.add(botaoCompactar); 
        containerBotoes.add(botaoDescompactar);
        
        containerBotoes.setLayout(new GridLayout(2,1)); //define o layout do container de bot�es
        containerBotoes.setVisible(true); //torna o container de bot�es vis�vel
        
        //atribui a��es aos bot�es
        botaoCompactar.addActionListener((ActionEvent ae) -> {
            atribuirAcoesAosBotoes(ae);
        });
        botaoDescompactar.addActionListener((ActionEvent ae) -> {
            atribuirAcoesAosBotoes(ae);
        });
        
    }
    
    /**
     * Define as a��es que v�o ocorrer a partir de um evento gerado pelo clique de um bot�o.
     * @param evento evento gerado pelo clique no bot�o
     */
    private void atribuirAcoesAosBotoes(ActionEvent evento) {
        if(evento.getSource() == containerBotoes.getComponent(0)) { //verifica se o evento recebido foi gerado pelo bot�o de compactar
            if(selecionadorArquivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //exibe a janela de compacta��o e verifica se foi selecionado um arquivo
                try {
                    
                    if(painelArvore != null) { //verifica se a �rvore j� foi criada anteriormente
                        painelArvore.setVisible(false); //torna a �rvore invis�vel
                    }
                    
                    WINMonsterController.verificarEntrada(selecionadorArquivo.getSelectedFile().getName(), true); //verifica se a extens�o do arquivo � v�lida

                    
                    label.setVisible(true); //torna o label vis�vel
                    caixaTexto.setVisible(true); //torna a caixa de texto vis�vel

                    if(caixaTexto.getText().isEmpty()) { //verifica se nada foi escrito na caixa de texto
                        JOptionPane.showMessageDialog(null, "O arquivo foi compactado e salvo no endere�o: " + controller.compactar(selecionadorArquivo.getSelectedFile().getCanonicalPath())); //compacta o arquivo e exibe uma mensagem ao usu�rio
                    } else {
                        JOptionPane.showMessageDialog(null, caixaTexto.getText() + ", o seu arquivo foi compactado e salvo no endere�o: " + controller.compactar(selecionadorArquivo.getSelectedFile().getCanonicalPath())); //compacta o arquivo e exibe uma mensagem personalizada ao usu�rio
                    }
                    
                    new JanelaDicionario(controller.getAlgoritmoHuffman().getDicionario()); //cria e exibe uma nova janela contendo o dicion�rio usado na codifica��o
                    exibirArvore(); //exibe a �rvore usada na codifica��o
                } catch (FileNotFoundException e) { //caso o arquivo n�o seja encontrado
                    JOptionPane.showMessageDialog(null, "Arquivo n�o encontrado!");
                } catch (IOException e) { //caso ocorra erro de entrada/sa�da
                    JOptionPane.showMessageDialog(null, "Erro durante a abertura do arquivo!");
                } catch (EntradaVaziaException ex) { //caso seja aberto um arquivo vazio
                    JOptionPane.showMessageDialog(null, "O arquivo aberto est� vazio");
                } catch (FormatoInvalidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage()); //exibe uma mensagem de erro
                }
            }
        } else {
            if(selecionadorArquivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //exibe a janela de descompacta��o e verifica se o usu�rio escolheu um arquivo
                try {
                    
                    if(painelArvore != null) { //verifica se a �rvore j� foi criada anteriormente
                        painelArvore.setVisible(false); //torna a �rvore invis�vel
                    }
                    
                    WINMonsterController.verificarEntrada(selecionadorArquivo.getSelectedFile().getName(), false); //verifica se a extens�o do arquivo � v�lida
                    
                    if(caixaTexto.getText().isEmpty()) { //verifica se nada foi escrito na caixa de texto
                        JOptionPane.showMessageDialog(null, "O arquivo foi descompactado e armazenado no endere�o: " + controller.descompactar(selecionadorArquivo.getSelectedFile().getCanonicalPath())); //realiza a descompacta��o e exibe uma mensagem ao usu�rio
                    } else {
                        JOptionPane.showMessageDialog(null, caixaTexto.getText() + ", o seu arquivo foi descompactado e armazenado no endere�o: " + controller.descompactar(selecionadorArquivo.getSelectedFile().getCanonicalPath())); //realiza a descompacta��o e exibe uma mensagem personalizada ao usu�rio
                    }
                    
                    label.setVisible(true); //torna a label vis�vel
                    caixaTexto.setVisible(true); //torna a caixa de texto vis�vel

                    new JanelaDicionario(controller.getAlgoritmoHuffman().getDicionario()); //cria e exibe uma nova janela contendo o dicion�rio usando na decodifica��o
                    exibirArvore(); //exibe a �rvore usada na decodifica��o
                    
                } catch (IntegridadeVioladaException ex) { //caso a integridade do arquivo seja violada
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (FileNotFoundException ex) { //caso o arquivo n�o seja encontrado
                    JOptionPane.showMessageDialog(null, "Arquivo n�o encontrado!");
                } catch (IOException ex) { //caso ocorram erros de sa�da
                    JOptionPane.showMessageDialog(null, "Erro durante a abertura do arquivo");
                } catch (ClassNotFoundException ex) { //caso n�o seja encontrada uma classe durante a execu��o do programa
                    JOptionPane.showMessageDialog(null, "Erro fatal durante a execu��o do software!");
                    System.exit(1); //fecha o programa ap�s o erro fatal
                } catch (FormatoInvalidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage()); //exibe uma mensagem de erro
                }
            }
        }
    }
    
    /**
     * Exibe a �rvore de Huffman usada na codifica��o/decodifica��o.
     */
    private void exibirArvore(){
        painelArvore = new JScrollPane(); // cria um novo painel com barra de rolagem
        JTree arvore = new JTree(); // cria uma nova �rvore 
        DefaultMutableTreeNode primeiroNo = new DefaultMutableTreeNode("�rvore de Huffman"); //cria o primeiro n� da �rvre e define o seu nome

        /** Define o �cone contido nas c�lulas da �rvore. */
        arvore.setCellRenderer(new DefaultTreeCellRenderer() { 
            @Override
            public void setIcon(Icon icon) {
                super.setIcon(new ImageIcon("src/br/uefs/ecomp/WINMonster/resources/no.png"));//Altera os icones do JTree
            }

        });
        
        /* Torna o label e a caixa de texto invis�veis. */
        label.setVisible(false);
        caixaTexto.setVisible(false);
        
        montaArvore(controller.getAlgoritmoHuffman().getArvore().getRaiz(), primeiroNo, false); //monta a  exibi��o da �rvore
        arvore.setModel(new DefaultTreeModel(primeiroNo));// adiciona a raiz � arvore
        painelArvore.setViewportView(arvore);//coloca a arvore no JScrollPanel para exibir no JFrame
        add(BorderLayout.CENTER, painelArvore);//adiciona o painel ao JFrame
    }

    /**
     * Percorre a �rvore de Huffman recursivamente e realiza a montagem da sua respectiva representa��o gr�fica.
     * @param noHuffman n� de huffman utilizado na itera��o
     * @param noExibicao n� da �rvore de exibi��o utilizado na itera��o
     * @param direita indica se o n� da itera��o est� ou n�o � direita do seu pai
     */
    public void montaArvore(NoHuffman noHuffman, DefaultMutableTreeNode noExibicao, boolean direita) {
        if(noHuffman.isFolha()) { //caso o n� de huffman seja uma flha
            DefaultMutableTreeNode folha = new DefaultMutableTreeNode("Folha | Caractere: " + noHuffman.getConteudo().getCaractere().toString() + " | Frequ�ncia: " + noHuffman.getConteudo().getFrequencia()); //cria um novo n� da �rvore de exibi��o
            noExibicao.add(folha); //adiciona o n� ao seu pai na �rvore de exibi��o
            return; //encerra o caso da recurs�o
        } else {
            DefaultMutableTreeNode novo; //novo n� da �rvore de exibi��o
            
            if(noHuffman == controller.getAlgoritmoHuffman().getArvore().getRaiz()) { //caso o n� de huffman seja a ra�z
                novo = new DefaultMutableTreeNode("Raiz | Frequ�ncia total: " + noHuffman.getConteudo().getFrequencia()); //cria uma nova inst�ncia do n� da �rvore de exibi��o com os seus respectivos dados
            } else if(!direita) { //caso n�o seja um n� � direita do seu pai
                novo = new DefaultMutableTreeNode("Filho da esquerda | Frequ�ncia: " + noHuffman.getConteudo().getFrequencia()); //cria uma nova inst�ncia do n� da �rvore de exibi��o com os seus respectivos dados
            } else { //caso seja um n� � direita do seu pai
                novo = new DefaultMutableTreeNode("Filho da direita  | Frequ�ncia: " + noHuffman.getConteudo().getFrequencia()); //cria uma nova inst�ncia do n� da �rvore de exibi��o com os seus respectivos dados
            }
            
            noExibicao.add(novo); //adiciona o n� da arvore de exibi��o criado ao seu pai
            montaArvore(noHuffman.getFilhoEsquerda(), novo, false); //chama o pr�ximo caso de recurs�o passando o n� de huffman � esquerda
            montaArvore(noHuffman.getFilhoDireita(), novo, true); //chama o pr�ximo caso de recurs�o passando o n� de huffman � direita
            
        }
    }
}
