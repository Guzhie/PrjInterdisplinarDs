/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Conexao.conexao;
import java.sql.*;
import java.sql.SQLException;

public class LoginPag extends JFrame{

    conexao con_escolaMusica;
    JLabel rUsuario, rSenha, rTitulo;
    JTextField tUsuario;
    JPasswordField tSenha;
    JButton bLogar;
    
    public LoginPag(){
        con_escolaMusica = new conexao();
        con_escolaMusica.conecta();

        setTitle("Login de Acesso");
        Container tela = getContentPane();
        setLayout(null);

        rTitulo = new JLabel("Acesso ao controle de turmas");
        rTitulo.setBounds(165, 35, 300, 50);

        rUsuario = new JLabel("Usuario: ");
        rUsuario.setBounds(150, 100, 100, 20);
        tUsuario = new JTextField(50);
        tUsuario.setBounds(210, 100, 150, 20);

        rSenha = new JLabel("Senha : ");
        rSenha.setBounds(150, 130, 100, 20);
        tSenha = new JPasswordField(50);
        tSenha.setBounds(210, 130, 150, 20);

        bLogar = new JButton("Login");
        bLogar.setBounds(215,180,100,20);
        bLogar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                try {
                    String pesquisa = "select * from acesso where usuario like '" + tUsuario.getText() + "' && senha  like '" + tSenha.getText() + "'";
                    con_escolaMusica.executaSQL(pesquisa);

                    if (con_escolaMusica.resultset.first()) {
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "\n Usuário não cadastrado!!!!","Mensagem do Programa" ,JOptionPane.INFORMATION_MESSAGE);
                        con_escolaMusica.desconecta();
                        System.exit(0);
                    }
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null,"\n Os dados digitados não foram localizados!! :\n "+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });


        tela.add(rTitulo);
        tela.add(rUsuario);
        tela.add(rSenha);
        tela.add(tUsuario);
        tela.add(tSenha);
        tela.add(bLogar);

        setSize(550, 400);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
} 
 
