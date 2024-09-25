package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {
    // Declaração dos componentes da interface
    JToolBar ferramentas;
    JButton aluno, prof, turma, exi;
    JPopupMenu opt;
    JMenuBar bars;
    JMenu sobre, Forms, sair;
    JMenuItem Aluno, Prof, Turma, exit, sob, exitPopup, sobPopup;

    SobrePag SobJanela;
    Forms_Aluno PriJanela;
    Forms_Prof SegJanela;
    Forms_Turma TercJanela;

    public Menu() {
        super("Menu");
        setLayout(new BorderLayout());

        // Criação dos botões de navegação sem texto
        aluno = new JButton();
        prof = new JButton();
        turma = new JButton();
        exi = new JButton(); // O botão "Sair" inicialmente sem texto

        // Adicionando ícones aos botões (opcional)
        aluno.setIcon(new ImageIcon("path/to/aluno/icon.png")); // Adicionar ícone do aluno
        prof.setIcon(new ImageIcon("path/to/prof/icon.png"));   // Adicionar ícone do professor
        turma.setIcon(new ImageIcon("path/to/turma/icon.png")); // Adicionar ícone da turma
        exi.setIcon(new ImageIcon("path/to/sair/icon.png"));    // Adicionar ícone de sair

        // Configurações dos botões
        aluno.setToolTipText("Aluno");
        prof.setToolTipText("Professor");
        turma.setToolTipText("Turma");
        exi.setToolTipText("Sair");

        // Criação da barra de ferramentas
        ferramentas = new JToolBar("Barra de Ferramentas");
        ferramentas.setRollover(true); // Permite que os botões "deslizem"
        ferramentas.add(aluno);
        ferramentas.add(prof);
        ferramentas.add(turma);
        ferramentas.add(exi);

        // Centralizar a barra de ferramentas
        JPanel toolbarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centraliza a barra
        toolbarPanel.add(ferramentas);
        add(toolbarPanel, BorderLayout.NORTH); // Adiciona a barra de ferramentas centralizada

        // Configuração da barra de menus
        bars = new JMenuBar();
        setJMenuBar(bars);

        Forms = new JMenu("Formulários");
        sobre = new JMenu("Sobre");
        sair = new JMenu("Sair");

        bars.add(Forms);
        bars.add(sobre);
        bars.add(sair);

        Aluno = new JMenuItem("Aluno");
        Prof = new JMenuItem("Prof");
        Turma = new JMenuItem("Turma");
        exit = new JMenuItem("Sair");
        sob = new JMenuItem("Sobre");

        sobre.add(sob);
        sair.add(exit);
        Forms.add(Aluno);
        Forms.add(Prof);
        Forms.add(Turma);

        // Configuração do menu popup
        opt = new JPopupMenu();
        exitPopup = new JMenuItem(exit.getText());
        sobPopup = new JMenuItem(sob.getText());
        opt.add(exitPopup);
        opt.add(sobPopup);

        // Evento para exibir o menu popup
        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    opt.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        // Ação para abrir o formulário "Aluno"
        aluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PriJanela = new Forms_Aluno(null, "Aluno", true);
                PriJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                PriJanela.setVisible(true);
            }
        });

        // Ação para abrir o formulário "Professor"
        Prof.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SegJanela = new Forms_Prof(null, "Professor", true);
                SegJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                SegJanela.setVisible(true);
            }
        });

        // Ação para abrir o formulário "Turma"
        turma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TercJanela = new Forms_Turma(null, "Turma", true);
                TercJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                TercJanela.setVisible(true);
            }
        });

        // Ação para fechar a aplicação ao clicar no botão "Sair"
        exi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pergunta = JOptionPane.showConfirmDialog(null, "Deseja fechar a janela?", "Mensagem saída", JOptionPane.YES_NO_OPTION);
                if (pergunta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Ação para fechar a aplicação ao clicar no menu "Sair"
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pergunta = JOptionPane.showConfirmDialog(null, "Deseja fechar a janela?", "Mensagem saída", JOptionPane.YES_NO_OPTION);
                if (pergunta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Ação para abrir a janela "Sobre" no menu popup
        sobPopup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SobJanela = new SobrePag(null, "Janela Sobre", true);
                SobJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                SobJanela.setVisible(true);
            }
        });

        // Ação para abrir a janela "Sobre" no menu
        sob.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SobJanela = new SobrePag(null, "Janela Sobre", true);
                SobJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                SobJanela.setVisible(true);
            }
        });

        // Configuração da janela principal
        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    public static void main(String[] args) {
        Menu app = new Menu(); 
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
