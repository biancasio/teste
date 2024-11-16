/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Admin;
import view.SaldoAdminFrame;
import DAO.Conexao;
import DAO.AdminDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Admin;
import view.MenuAdminFrame;


/**
 *
 * @author Aline Rocha
 */
public class SaldoController {
    private SaldoAdminFrame view;
    private Admin admin;

    public SaldoController(SaldoAdminFrame view, Admin admin) {
        this.view = view;
        this.admin = admin;
    }

    public SaldoController() {
    }
    
    public String consultarSaldo(){
       String verificaCpf = view.getTxtCpf().getText();
       
           Conexao conexao = new Conexao();
           
           try{
                Connection conn = conexao.getConnection();
                AdminDAO dao = new AdminDAO(conn);
                ResultSet res = dao.consultarUsuario(verificaCpf);
                if(res.next()){
                    String CPF = res.getString("cpf");
                    String Nome = res.getString("nome");
                    double Valor = res.getDouble("saldo");
                    double Bitcoin = res.getDouble("bitcoin");
                    double Ethereum = res.getDouble("ethereum");
                    double Ripple = res.getDouble("ripple");
                   
                    return "Nome: " + Nome + 
                            "\nCPF:" + CPF + 
                            "\n\nReais: " + Valor +
                            "\nBitcoin: " + Bitcoin + 
                            "\nEthereum: " + Ethereum +
                            "\nRipple: " + Ripple;               
                }else{
                    JOptionPane.showMessageDialog(view, "Erro ao Consultar Saldo",
                            "Erro",JOptionPane.ERROR_MESSAGE);
                }
            } catch(SQLException e){
                JOptionPane.showMessageDialog(view, "Erro de conexao",
                            "Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
           
        return null;
           
    }
       
}
    

    
    
