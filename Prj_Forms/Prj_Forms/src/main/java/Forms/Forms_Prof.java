package Forms;

//Imports
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;//Para o Reconhecimento Da Jtable

import java.text.*;
import javax.swing.text.MaskFormatter; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Conexao.conexao;
import java.sql.*;

public class Forms_Prof extends JDialog{
    conexao con_bancosql;
    
    JLabel rtId, rtNm, rtCPF, rtDt, rtEmail, rtTell,  rtEnd, rtCEP, rtPsq;
    JTextField txId, txNm, txEmail,  txEnd, txPsq;
    JFormattedTextField CPF, Dt, Tell, CEP;
    MaskFormatter MkCPF, MkDt, MkTell, MkCEP;
    JButton BtPri,BtAnt,BtPro,BtUlt; //Botões De Posição
    JButton BtNvRg,BtGrv,BtAlt,BtExc,BtPsq, Btsair; //Botões De Ação

    JTable tblProf; //Datagrid
    JScrollPane scp_tabela;// Container Para o Datagrid
    
    public Forms_Prof(Frame owner, String title, boolean modal){
        super(owner, title, modal);
        setLayout(null);
        con_bancosql = new conexao(); //Inicialização Do Objeto
        con_bancosql.conecta(); //Chama o Método Que Conecta
        
        setTitle("Conexão com a Tabela do MySql");
        // Criação Dos Rótulos  
        rtId = new JLabel("ID:");
        rtNm = new JLabel("Nome:");
        rtCPF = new JLabel("CPF:");
        rtDt = new JLabel("Data:");
        rtEmail = new JLabel("Email:");
        rtTell = new JLabel("Telefone:");
        rtEnd = new JLabel("Endereço:");
        rtCEP = new JLabel("CEP:");
        
        rtPsq = new JLabel("Pesquisar:");
        
        //Crição Das Caixas De Texto
        txId = new JTextField();
        txNm = new JTextField();
        txEmail = new JTextField();
        txEnd = new JTextField();
        txPsq = new JTextField();// tentar colocar como legenda uma mensgaem dixendo q é pra ser sobre o nome do aluno a pesquisa
        //Criação Das Máscaras
    try {
        MkCPF = new MaskFormatter("#########/##");
        MkDt = new MaskFormatter("##/##/####");
        MkTell = new MaskFormatter("(##)#####-####");
        MkCEP = new MaskFormatter("#####-###");
        
        CPF = new JFormattedTextField(MkCPF);
        Dt = new JFormattedTextField(MkDt);
        Tell = new JFormattedTextField(MkTell);
        CEP = new JFormattedTextField(MkCEP);
    } catch (ParseException e) {}
    
    //Criação Dos Botões De Posicionamento
    BtPri = new JButton("Primeiro");
    BtAnt = new JButton("Anterior");
    BtPro = new JButton("Próximo");
    BtUlt = new JButton("Último");
    
    //Criação Dos Botôes Que Realizarão o CRUD
    BtNvRg = new JButton("Novo");
    BtGrv = new JButton("Gravar");
    BtAlt = new JButton("Alterar");
    BtExc = new JButton("Excluir");
    
    //Criação Do Botão De Pesquisa
    BtPsq = new JButton("Pesquisar");
    Btsair = new JButton("sair");
    
    // Posicionando Os Rótulos, AS Caixas De Texto, As Máscaras e Os Botões
    //Rótulos e Caixas De Texto
    rtId.setBounds(50, 30, 50, 25);
    txId.setBounds(160, 30, 50, 25);

    rtNm.setBounds(50, 70, 100, 25);
    txNm.setBounds(160, 70, 300, 25);
    
    rtCPF.setBounds(50,110,50,25);
    CPF.setBounds(160,110,50,25);
    
    rtDt.setBounds(50, 150, 150, 25);
    Dt.setBounds(160, 150, 100, 25);
    
    rtEmail.setBounds(700, 30, 100, 25);
    txEmail.setBounds(810, 30, 200, 25);
    
    rtTell.setBounds(700, 70, 100, 25);
    Tell.setBounds(810, 70, 150, 25);
    
    rtEnd.setBounds(700, 110, 100, 25);
    txEnd.setBounds(810, 110, 250, 25);
    
    rtCEP.setBounds(700, 150, 50, 25);
    CEP.setBounds(810, 150, 50, 25);
    
    //Botões
    rtPsq.setBounds(80,230,100,25);
    txPsq.setBounds(150,230,300,25);
    BtPsq.setBounds(460,230,100,25);
    
    BtPri.setBounds(700,310,100,20);
    BtAnt.setBounds(700,350,100,20);
    BtPro.setBounds(700,390,100,20);
    BtUlt.setBounds(700,430,100,20);
    
    BtNvRg.setBounds(860,310,100,20);
    BtGrv.setBounds(860,350,100,20);
    BtAlt.setBounds(860,390,100,20);
    BtExc.setBounds(860,430,100,20);

    // Adiciona os componentes ao Container
    Container Tella = getContentPane();
    Tella.add(rtId);
    Tella.add(txId);
    Tella.add(rtNm);
    Tella.add(txNm);
    Tella.add(rtCPF);
    Tella.add(CPF);
    Tella.add(rtDt);
    Tella.add(Dt);
    Tella.add(rtEmail);
    Tella.add(txEmail);
    Tella.add(rtTell);
    Tella.add(Tell);
    Tella.add(rtEnd);
    Tella.add(txEnd);
    Tella.add(rtCEP);
    Tella.add(CEP);
    Tella.add(rtPsq);
    Tella.add(txPsq);
    Tella.add(BtPsq);
    Tella.add(BtPri);
    Tella.add(BtAnt);
    Tella.add(BtPro);
    Tella.add(BtUlt);
    Tella.add(BtNvRg);
    Tella.add(BtGrv);
    Tella.add(BtAlt);
    Tella.add(BtExc);
    
    // Configurações Da Tabela Que Virá Do MySql
    tblProf = new javax.swing.JTable();
    scp_tabela = new javax.swing.JScrollPane();

    tblProf.setBounds(80, 290, 550, 200);
    scp_tabela.setBounds(80, 290, 550, 200);
    
    Tella.add(tblProf);
    Tella.add(scp_tabela);  // Adiciona apenas o JScrollPane ao Container

    tblProf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    tblProf.setFont(new java.awt.Font("Arial", 1, 12));
    
    tblProf.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][]{
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
        },
        new String[]{"ID", "Nome", "CPF", "Data","Email", "Telefone","Endereço", "CEP"}
    ) {
        boolean[] canEdit = new boolean[]{
            false, false, false, false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    });
    
    scp_tabela.setViewportView(tblProf);
    tblProf.setAutoCreateRowSorter(true); // Ativa A Classificação Ordenada Da Tabela
    
    //Configurações Da Janela
    setSize(1500, 900);
    setVisible(true);
    setLocationRelativeTo(null); 
    setResizable(false);
    
    con_bancosql.executaSQL("select * from professor order by Id_Prof");
    preencherTabela();
    posicionarRegistro();
    
    //Botão Primerio Registro
    BtPri.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
            try{
                con_bancosql.resultSet.first();
                mostrar_Dados();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro"+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            }
        }});
    
    //Botão Registro Anterior
    BtAnt.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
            try{
                con_bancosql.resultSet.previous();
                mostrar_Dados();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Não foi possível acessar o registro anterior"+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            }
        }});
    
    //Botão Do Próximo Registro
    BtPro.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
            try{
                con_bancosql.resultSet.next();
                mostrar_Dados();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Não foi possível acessar o Próximo registro"+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            }
        }});
    
    //Botão Do Último Registro
    BtUlt.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){
            try{
                con_bancosql.resultSet.last();
                mostrar_Dados();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Não foi possível acessar o último registro"+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            }
        }});
    }
    //FUNÇÕES......................
     public void preencherTabela(){
        tblProf.getColumnModel() .getColumn(0) .setPreferredWidth(4); //Id
        tblProf.getColumnModel() .getColumn(1) .setPreferredWidth(150);//Nome
        tblProf.getColumnModel() .getColumn(2) .setPreferredWidth(15);//CPF
        tblProf.getColumnModel() .getColumn(3) .setPreferredWidth(11);//Data
        tblProf.getColumnModel() .getColumn(4) .setPreferredWidth(150);//Email
        tblProf.getColumnModel() .getColumn(5) .setPreferredWidth(50);//Telefone
        tblProf.getColumnModel() .getColumn(6) .setPreferredWidth(150);//Endereço
        tblProf.getColumnModel() .getColumn(7) .setPreferredWidth(11);//CEP
        
        DefaultTableModel modelo=(DefaultTableModel) tblProf.getModel();
        modelo.setNumRows(0);
        
        try {
            con_bancosql.resultSet.beforeFirst();
            while(con_bancosql.resultSet.next()){
                modelo.addRow(new Object[]{
                    con_bancosql.resultSet.getString("Id_Prof"),con_bancosql.resultSet.getString("Nome_Prof"),con_bancosql.resultSet.getString("cpf_Prof"),con_bancosql.resultSet.getString("DataNasc_Prof"),con_bancosql.resultSet.getString("email_prof"),con_bancosql.resultSet.getString("telefone_Prof"),con_bancosql.resultSet.getString("endereco_prof"),con_bancosql.resultSet.getString("cep_prof")
                });   
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!:\n "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
     public void posicionarRegistro(){
          try {
              con_bancosql.resultSet.first();//Posiciona No 1° Registro Da Tabela
              mostrar_Dados();// Chama o Método Que Irá Buscar o Dado Da Tabela
          }catch(SQLException erro){
              JOptionPane.showMessageDialog(null, "Não foi possível posiiconar no primeiro registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
          }
      }
     public void mostrar_Dados(){
          try{
              txId.setText(con_bancosql.resultSet.getString("Id_Prof"));//Associa a Caixa De Texto Ao Campo Cod
              txNm.setText(con_bancosql.resultSet.getString("Nome_Prof"));//Associa a Caixa De Texto Ao Campo Nome
              CPF.setText(con_bancosql.resultSet.getString("cpf_Prof"));//Associa a Caixa De Texto Ao Campo cpf_Aluno
              Dt.setText(con_bancosql.resultSet.getString("DataNasc_Prof"));//Associa a Caixa De Texto Ao Campo dtNasc_Aluno
              txEmail.setText(con_bancosql.resultSet.getString("email_prof"));//Associa a Caixa De Texto Ao Campo email_Aluno
              Tell.setText(con_bancosql.resultSet.getString("telefone_Prof"));//Associa a Caixa De Texto Ao Campo Tel_Aluno
              txEnd.setText(con_bancosql.resultSet.getString("endereco_prof"));//Associa a Caixa De Texto Ao Campo endereco_Aluno
              CEP.setText(con_bancosql.resultSet.getString("cep_prof"));//Associa a Caixa De Texto Ao Campo cep_Aluno
          }catch(SQLException erro){
              JOptionPane.showMessageDialog(null, "Não localizou os dados : "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);

          }
      }
}