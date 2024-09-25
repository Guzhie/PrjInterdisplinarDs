
package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SobrePag extends JDialog{
    JLabel Integrante1, Integrante2, Integrante3 ,sala;
    JButton fechar;

    public SobrePag(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        Container TelaS = getContentPane();
        TelaS.setLayout(null);

        Integrante1 = new JLabel("Nome: Jhonata Alves do Nascimento");
        Integrante2 = new JLabel("Nome: Gustavo Henrique Ribeiro da Silva");
        Integrante3 = new JLabel("Nome: Enzo Costa Paz");
        sala = new JLabel("Sala: 2°AMS grupo A");
        fechar = new JButton("Fechar");

        Integrante1.setBounds(40,40,300,20);
        Integrante2.setBounds(40,70,300,20);
        Integrante3.setBounds(40,100,300,20);

        sala.setBounds(40,140,200,20);
        fechar.setBounds(40,180,100,20);
        
        fechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        TelaS.add(Integrante1);
        TelaS.add(Integrante2);
        TelaS.add(Integrante3);
        TelaS.add(sala);
        TelaS.add(fechar);
        setSize(500, 300);
        setLocationRelativeTo(null);
        }
}
