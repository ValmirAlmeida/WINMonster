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
 * Classe responsável por construir a janela principal do programa.
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
    /** Container de botões exibidos na tela. */
    private Container containerBotoes;
  
    /* Caixa de texto exibida na tela. */
    private JTextArea caixaTexto;
    
    /* Label para exibição de mensagem. */
    private JLabel label;
    
    /* Painel com barra de rolagem contendo a exibição da árvore. */
    private JScrollPane painelArvore;
    
    /* Selecionador de arquivos. */
    private JFileChooser selecionadorArquivo;
    
    /* Controlador de negócios do software. */
    private WINMonsterController controller;


    /**
     * Cria uma nova instancia de JanelaPrincipal.
     */
    public JanelaPrincipal(){
        super("WINMonster - Compactador de Arquivos"); //define o rótulo da janela principal
         selecionadorArquivo = new JFileChooser(); //obtém uma nova instância do selecionador de arquivos
         containerBotoes = new Container(); //obtém uma nova instância de container
         caixaTexto = new JTextArea(); //cria uma nova instância de caixa de texto
         label = new JLabel("Para uma experiência personalizada, digite o seu nome abaixo:"); //cria uma nova label
         controller = new WINMonsterController(); //obtém uma nova instância do controlador
    }
    
    /**
     * Cria o container principal da janela.
     * @return referência para a instância de container criada
     */
    private Container criarContainer() {
        Container container = new Container(); //obtém uma nova instância de container
        container.setLayout(new BorderLayout()); //define o layout da janela
        container.setVisible(true); //torna a janela visível
        
        criarCaixaTexto(); //cria a caixa de texto
        criarBotoes(); //cria os botões da janela
        
        container.add(BorderLayout.EAST, containerBotoes);// insere os botões ao oeste (canto direito)
        container.add(BorderLayout.NORTH, label); //adiciona label na parte superior
        container.add(BorderLayout.CENTER, caixaTexto); //adiciona a caixa de texto ao centro da janela 
        
        return container; //retorna a referência para a instância criada
    }
    
 
    /**
     * Define as especificações da janela.
     */
    public void criarJanelaPrincipal() {
        setContentPane(criarContainer()); //define o container do frame
        setJMenuBar(new BarraMenus());//adiciona a barra de menus ao JFrame principal
        setSize(new Dimension(500, 300)); //define o tamanho da tela
        setLocationRelativeTo(null);//localiza a janela no centro do monitor
        setResizable(true);//torna a tela redimensionável
        setVisible(true);//torna a janela visivel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //encerra o programa quando a janela é fechada
    }
    
    /**
     * Define as especificações da caixa de texto.
     */
    private void criarCaixaTexto() {
        caixaTexto.setVisible(true); //torna a caixa de texto visível
        caixaTexto.setEditable(true); //torna a caixa de texto editável
    }
    
    /**
     * Cria os botões e define as suas especificações.
     */
    private void criarBotoes() {
        /* Cria os botões definindo os seus nomes. */
        JButton botaoCompactar = new JButton("Compactar"); 
        JButton botaoDescompactar = new JButton("Descompactar");
        
        botaoCompactar.setVisible(true);
        botaoDescompactar.setVisible(true);
        
        
        /* Adiciona cada um dos botões ao container. */
        containerBotoes.add(botaoCompactar); 
        containerBotoes.add(botaoDescompactar);
        
        containerBotoes.setLayout(new GridLayout(2,1)); //define o layout do container de botões
        containerBotoes.setVisible(true); //torna o container de botões visível
        
        //atribui ações aos botões
        botaoCompactar.addActionListener((ActionEvent ae) -> {
            atribuirAcoesAosBotoes(ae);
        });
        botaoDescompactar.addActionListener((ActionEvent ae) -> {
            atribuirAcoesAosBotoes(ae);
        });
        
    }
    
    /**
     * Define as ações que vão ocorrer a partir de um evento gerado pelo clique de um botão.
     * @param evento evento gerado pelo clique no botão
     */
    private void atribuirAcoesAosBotoes(ActionEvent evento) {
        if(evento.getSource() == containerBotoes.getComponent(0)) { //verifica se o evento recebido foi gerado pelo botão de compactar
            if(selecionadorArquivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //exibe a janela de compactação e verifica se foi selecionado um arquivo
                try {
                    
                    if(painelArvore != null) { //verifica se a árvore já foi criada anteriormente
                        painelArvore.setVisible(false); //torna a árvore invisível
                    }
                    
                    WINMonsterController.verificarEntrada(selecionadorArquivo.getSelectedFile().getName(), true); //verifica se a extensão do arquivo é válida

                    
                    label.setVisible(true); //torna o label visível
                    caixaTexto.setVisible(true); //torna a caixa de texto visível

                    if(caixaTexto.getText().isEmpty()) { //verifica se nada foi escrito na caixa de texto
                        JOptionPane.showMessageDialog(null, "O arquivo foi compactado e salvo no endereço: " + controller.compactar(selecionadorArquivo.getSelectedFile().getCanonicalPath())); //compacta o arquivo e exibe uma mensagem ao usuário
                    } else {
                        JOptionPane.showMessageDialog(null, caixaTexto.getText() + ", o seu arquivo foi compactado e salvo no endereço: " + controller.compactar(selecionadorArquivo.getSelectedFile().getCanonicalPath())); //compacta o arquivo e exibe uma mensagem personalizada ao usuário
                    }
                    
                    new JanelaDicionario(controller.getAlgoritmoHuffman().getDicionario()); //cria e exibe uma nova janela contendo o dicionário usado na codificação
                    exibirArvore(); //exibe a árvore usada na codificação
                } catch (FileNotFoundException e) { //caso o arquivo não seja encontrado
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado!");
                } catch (IOException e) { //caso ocorra erro de entrada/saída
                    JOptionPane.showMessageDialog(null, "Erro durante a abertura do arquivo!");
                } catch (EntradaVaziaException ex) { //caso seja aberto um arquivo vazio
                    JOptionPane.showMessageDialog(null, "O arquivo aberto está vazio");
                } catch (FormatoInvalidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage()); //exibe uma mensagem de erro
                }
            }
        } else {
            if(selecionadorArquivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //exibe a janela de descompactação e verifica se o usuário escolheu um arquivo
                try {
                    
                    if(painelArvore != null) { //verifica se a árvore já foi criada anteriormente
                        painelArvore.setVisible(false); //torna a árvore invisível
                    }
                    
                    WINMonsterController.verificarEntrada(selecionadorArquivo.getSelectedFile().getName(), false); //verifica se a extensão do arquivo é válida
                    
                    if(caixaTexto.getText().isEmpty()) { //verifica se nada foi escrito na caixa de texto
                        JOptionPane.showMessageDialog(null, "O arquivo foi descompactado e armazenado no endereço: " + controller.descompactar(selecionadorArquivo.getSelectedFile().getCanonicalPath())); //realiza a descompactação e exibe uma mensagem ao usuário
                    } else {
                        JOptionPane.showMessageDialog(null, caixaTexto.getText() + ", o seu arquivo foi descompactado e armazenado no endereço: " + controller.descompactar(selecionadorArquivo.getSelectedFile().getCanonicalPath())); //realiza a descompactação e exibe uma mensagem personalizada ao usuário
                    }
                    
                    label.setVisible(true); //torna a label visível
                    caixaTexto.setVisible(true); //torna a caixa de texto visível

                    new JanelaDicionario(controller.getAlgoritmoHuffman().getDicionario()); //cria e exibe uma nova janela contendo o dicionário usando na decodificação
                    exibirArvore(); //exibe a árvore usada na decodificação
                    
                } catch (IntegridadeVioladaException ex) { //caso a integridade do arquivo seja violada
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (FileNotFoundException ex) { //caso o arquivo não seja encontrado
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado!");
                } catch (IOException ex) { //caso ocorram erros de saída
                    JOptionPane.showMessageDialog(null, "Erro durante a abertura do arquivo");
                } catch (ClassNotFoundException ex) { //caso não seja encontrada uma classe durante a execução do programa
                    JOptionPane.showMessageDialog(null, "Erro fatal durante a execução do software!");
                    System.exit(1); //fecha o programa após o erro fatal
                } catch (FormatoInvalidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage()); //exibe uma mensagem de erro
                }
            }
        }
    }
    
    /**
     * Exibe a árvore de Huffman usada na codificação/decodificação.
     */
    private void exibirArvore(){
        painelArvore = new JScrollPane(); // cria um novo painel com barra de rolagem
        JTree arvore = new JTree(); // cria uma nova árvore 
        DefaultMutableTreeNode primeiroNo = new DefaultMutableTreeNode("Árvore de Huffman"); //cria o primeiro nó da árvre e define o seu nome

        /** Define o ícone contido nas células da árvore. */
        arvore.setCellRenderer(new DefaultTreeCellRenderer() { 
            @Override
            public void setIcon(Icon icon) {
                super.setIcon(new ImageIcon("src/br/uefs/ecomp/WINMonster/resources/no.png"));//Altera os icones do JTree
            }

        });
        
        /* Torna o label e a caixa de texto invisíveis. */
        label.setVisible(false);
        caixaTexto.setVisible(false);
        
        montaArvore(controller.getAlgoritmoHuffman().getArvore().getRaiz(), primeiroNo, false); //monta a  exibição da árvore
        arvore.setModel(new DefaultTreeModel(primeiroNo));// adiciona a raiz à arvore
        painelArvore.setViewportView(arvore);//coloca a arvore no JScrollPanel para exibir no JFrame
        add(BorderLayout.CENTER, painelArvore);//adiciona o painel ao JFrame
    }

    /**
     * Percorre a árvore de Huffman recursivamente e realiza a montagem da sua respectiva representação gráfica.
     * @param noHuffman nó de huffman utilizado na iteração
     * @param noExibicao nó da árvore de exibição utilizado na iteração
     * @param direita indica se o nó da iteração está ou não à direita do seu pai
     */
    public void montaArvore(NoHuffman noHuffman, DefaultMutableTreeNode noExibicao, boolean direita) {
        if(noHuffman.isFolha()) { //caso o nó de huffman seja uma flha
            DefaultMutableTreeNode folha = new DefaultMutableTreeNode("Folha | Caractere: " + noHuffman.getConteudo().getCaractere().toString() + " | Frequência: " + noHuffman.getConteudo().getFrequencia()); //cria um novo nó da árvore de exibição
            noExibicao.add(folha); //adiciona o nó ao seu pai na árvore de exibição
            return; //encerra o caso da recursão
        } else {
            DefaultMutableTreeNode novo; //novo nó da árvore de exibição
            
            if(noHuffman == controller.getAlgoritmoHuffman().getArvore().getRaiz()) { //caso o nó de huffman seja a raíz
                novo = new DefaultMutableTreeNode("Raiz | Frequência total: " + noHuffman.getConteudo().getFrequencia()); //cria uma nova instância do nó da árvore de exibição com os seus respectivos dados
            } else if(!direita) { //caso não seja um nó à direita do seu pai
                novo = new DefaultMutableTreeNode("Filho da esquerda | Frequência: " + noHuffman.getConteudo().getFrequencia()); //cria uma nova instância do nó da árvore de exibição com os seus respectivos dados
            } else { //caso seja um nó à direita do seu pai
                novo = new DefaultMutableTreeNode("Filho da direita  | Frequência: " + noHuffman.getConteudo().getFrequencia()); //cria uma nova instância do nó da árvore de exibição com os seus respectivos dados
            }
            
            noExibicao.add(novo); //adiciona o nó da arvore de exibição criado ao seu pai
            montaArvore(noHuffman.getFilhoEsquerda(), novo, false); //chama o próximo caso de recursão passando o nó de huffman à esquerda
            montaArvore(noHuffman.getFilhoDireita(), novo, true); //chama o próximo caso de recursão passando o nó de huffman à direita
            
        }
    }
}
