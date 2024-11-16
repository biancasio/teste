/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.AdminDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Admin;
import view.CadastroAdminFrame;

/**
 *
 * @author Aline Rocha
 */
public class CadastroController {
    private CadastroAdminFrame view;
    private Admin admin;

    public CadastroController(CadastroAdminFrame view, Admin admin) {
        this.view = view;
        this.admin = admin;
    }

    public CadastroController() {
    }
    
    public void salvarInvestidor(){
        String nome = view.getTxtNome().getText();
        String cpf = view.getTxtCPF().getText();
        String senha = view.getTxtSenha().getText();
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            AdminDAO dao = new AdminDAO(conn);
            dao.inserir(cpf, senha, nome, 0,0,0,0);
            JOptionPane.showMessageDialog(view, "Investidor Cadastrado",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Investidor Não Cadastrado",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
}
