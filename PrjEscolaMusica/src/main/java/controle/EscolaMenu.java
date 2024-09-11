package controle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EscolaMenu extends JFrame {
    JToolBar ferramentas;
    JButton aluno, prof, turma, exi;
    ImageIcon formularios[];
    JPopupMenu opt;
    JMenuBar bars;
    JMenu sobre, Forms, sair;
    JMenuItem Aluno, Prof, Turma, exit, sob, exitPopup, sobPopup;

    SobrePag SobJanela;

    
    public EscolaMenu() {
        super("Menu");
        Container tela = getContentPane();
        tela.setLayout(null);

        // Inicializa a matriz de ImageIcons com imagens válidas
        formularios = new ImageIcon[4];
        // Aqui você deve definir imagens válidas. 
        // Exemplo de atribuição, você deve ter suas imagens no caminho correto.
        formularios[0] = new ImageIcon("caminho/para/imagem1.png");
        formularios[1] = new ImageIcon("caminho/para/imagem2.png");
        formularios[2] = new ImageIcon("caminho/para/imagem3.png");
        formularios[3] = new ImageIcon("caminho/para/imagem4.png");
        
        // Barra de Ferramentas
        aluno = new JButton(formularios[0]);
        prof = new JButton(formularios[1]);
        turma = new JButton(formularios[2]);
        exi = new JButton(formularios[3]);
        aluno.setToolTipText("Aluno");
        prof.setToolTipText("Professor");
        turma.setToolTipText("Turma");
        ferramentas = new JToolBar("Barra de Ferramentas");
        ferramentas.setRollover(true);
        ferramentas.add(aluno);
        ferramentas.add(prof);
        ferramentas.add(turma);
        ferramentas.add(exi);

        // MenuBar
        bars = new JMenuBar();
        setJMenuBar(bars);
        Forms = new JMenu("Formularios");
        bars.add(Forms);
        sobre = new JMenu("Sobre");
        sair = new JMenu("Sair");
        bars.add(sobre);
        bars.add(sair);

        Aluno = new JMenuItem("Aluno");
        Prof = new JMenuItem("Prof");
        Turma = new JMenuItem("Turma");
        exit = new JMenuItem("Sair");
        sob = new JMenuItem("Sobre");

        sobre.add(sob); // Adicionar o item de menu "Sobre" ao menu "Sobre"
        sair.add(exit); // Adicionar o item de menu "Sair" ao menu "Sair"

        ferramentas.setBounds(1, 1, 250, 50);

        // PopMenu
        opt = new JPopupMenu();
        exitPopup = new JMenuItem(exit.getText());
        sobPopup = new JMenuItem(sob.getText());
        opt.add(exitPopup);
        opt.add(sobPopup);

        Forms.add(Aluno);
        Forms.add(Prof);
        Forms.add(Turma);
        tela.add(ferramentas);
        tela.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    opt.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        exi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pergunta = JOptionPane.showConfirmDialog(null, "Deseja fechar a janela?", "Mensagem saida", JOptionPane.YES_NO_OPTION);
                if (pergunta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pergunta = JOptionPane.showConfirmDialog(null, "Deseja fechar a janela?", "Mensagem saida", JOptionPane.YES_NO_OPTION);
                if (pergunta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        sobPopup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SobJanela = new SobrePag(null, "Janela Sobre", true);
                SobJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                SobJanela.setVisible(true);
            }
        });

        sob.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SobJanela = new SobrePag(null, "Janela Sobre", true);
                SobJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                SobJanela.setVisible(true);
            }
        });


        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
