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
import view.CadCriAdminFrame;

/**
 *
 * @author Aline Rocha
 */
public class CadCriController {
    private CadCriAdminFrame view;
    private Admin admin;

    public CadCriController(CadCriAdminFrame view, Admin admin) {
        this.view = view;
        this.admin = admin;
    }

    public CadCriController() {
    }
    
    public void salvarCripto(){
        String nome = view.getTxtNome().getText();
        double cotacao = Double.parseDouble(view.getTxtCota().getText());
        double compra = Double.parseDouble(view.getTxtTaxaCompra().getText());
        double venda = Double.parseDouble(view.getTxtTaxaVenda().getText());
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            AdminDAO dao = new AdminDAO(conn);
            dao.inserirCripto(nome, cotacao, compra, venda);
            JOptionPane.showMessageDialog(view, "Criptomoeda Cadastrada",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Criptomoeda Não Cadastrada",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        
    }
}
