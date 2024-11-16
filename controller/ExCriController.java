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
import javax.swing.JOptionPane;
import model.Admin;
import view.ExCriAdminFrame;

/**
 *
 * @author Aline Rocha
 */
public class ExCriController {
    private ExCriAdminFrame view;
    private Admin admin;

    public ExCriController(ExCriAdminFrame view, Admin admin) {
        this.view = view;
        this.admin = admin;
    }

    public ExCriController() {
    }
    
    public String consultarCriptomoeda(){
       String verificaNome = view.getTxtNome().getText();
       
           Conexao conexao = new Conexao();
           
           try{
                Connection conn = conexao.getConnection();
                AdminDAO dao = new AdminDAO(conn);
                ResultSet res = dao.consultarCripto(verificaNome);
                if(res.next()){
                    String Nome = res.getString("nome");
                    double Cotacao = res.getDouble("cotacao");
                    double TaxaComp = res.getDouble("taxacomp");
                    double TaxaVend = res.getDouble("taxavend");
                   
                    return "Nome: " + Nome + 
                            "\nCotação:" + Cotacao + 
                            "\n\nTaxa de Compra: " + TaxaComp +
                            "\nTaxa de Venda: " + TaxaVend;               
                }else{
                    JOptionPane.showMessageDialog(view, "Erro ao Consultar Criptomoedas",
                            "Erro",JOptionPane.ERROR_MESSAGE);
                }
            } catch(SQLException e){
                JOptionPane.showMessageDialog(view, "Erro de conexao",
                            "Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
           
        return null;    
    }
    
     public void excluir(){
       String verificaNome = view.getTxtNome().getText();
       int opcao = JOptionPane.showConfirmDialog(view,"Deseja Realmente Excluir?",
               "Aviso", JOptionPane.YES_NO_OPTION);
       if (opcao != 1){
           Conexao conexao = new Conexao();
           
           try{
               Connection conn = conexao.getConnection();
               AdminDAO dao = new AdminDAO(conn);
               dao.excluirCripto(verificaNome);
               JOptionPane.showMessageDialog(view,"Criptomoeda Excluida!",
               "Aviso", JOptionPane.INFORMATION_MESSAGE);
           } catch(SQLException e){
               JOptionPane.showMessageDialog(view,"Criptomoeda não Excluida!",
               "erro", JOptionPane.ERROR_MESSAGE);
               System.out.println(e);
           }
       }
       
   } 
    
}
