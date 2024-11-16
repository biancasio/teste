/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.AdminDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Admin;
import view.LoginAdminFrame;
import view.MenuAdminFrame;

/**
 *
 * @author unifboliveira
 */
public class LoginController {
    private LoginAdminFrame view;
    
    public LoginController(LoginAdminFrame view) {
        this.view = view;
    }

    public LoginController() {
    }

    
    public void loginAdmin(){
        Admin admin = new Admin(null,view.getTxtCPF().getText(), view.getPwdLogin().getText());
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            AdminDAO dao = new AdminDAO(conn);
            ResultSet res = dao.consultar(admin);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login Efetuado",
                        "Aviso",JOptionPane.INFORMATION_MESSAGE);
                String CPF = res.getString("cpf");
                String Senha = res.getString("senha");
                String Nome = res.getString("nome");
                Admin admin1 = new Admin(Nome, CPF, Senha);
                MenuAdminFrame uf = new MenuAdminFrame(admin1);
                uf.setVisible(true);
                view.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(view, "Login Não Efetuado",
                        "Erro",JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao",
                        "Erro",JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
}
