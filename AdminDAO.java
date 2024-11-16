/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admin;

/**
 *
 * @author Aline Rocha
 */
public class AdminDAO {
    private Connection conn;

    public AdminDAO(Connection conn) {
        this.conn = conn;
    }
    
    
    public ResultSet consultar(Admin admin) throws SQLException{
        //Este Comando é vulneravel
//        String sql = "select * from aluno where usuario = '"
//                + aluno.getUsuario() + "' AND senha = '"
//                + aluno.getSenha() + "'";
        String sql = "select * from administrador where cpf = ? AND senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, admin.getCpf());
        statement.setString(2, admin.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public ResultSet consultarUsuario(String Cpf) throws SQLException{
        //Este Comando é vulneravel
//        String sql = "select * from aluno where usuario = '"
//                + aluno.getUsuario() + "' AND senha = '"
//                + aluno.getSenha() + "'";
        String sql = "select * from investidor where cpf = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, Cpf);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public ResultSet consultarExtrato(int id_investidor, int id_extrato) throws SQLException{
        //Este Comando é vulneravel
//        String sql = "select * from aluno where usuario = '"
//                + aluno.getUsuario() + "' AND senha = '"
//                + aluno.getSenha() + "'";
        String sql = "select * from extrato where id_investidor = ? AND id_extrato = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id_investidor);
        statement.setInt(2, id_extrato);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public ResultSet excluirUsuario(String Cpf) throws SQLException{
        //Este Comando é vulneravel
//        String sql = "select * from aluno where usuario = '"
//                + aluno.getUsuario() + "' AND senha = '"
//                + aluno.getSenha() + "'";
        String sql = "delete from investidor where cpf = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, Cpf);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public  void inserir(String cpf, 
                String senha, String nome, double saldo, double bitcoin, 
                double ripple, double ethereum) throws SQLException{
        String sql = "insert into investidor (cpf, senha, nome, saldo, bitcoin,"
                + " ripple, ethereum) values('"
                + cpf+ "', '" + senha + "', '"
                + nome + "', '"
                + saldo + "', '"
                + bitcoin + "', '"
                + ripple + "', '"
                + ethereum + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public ResultSet consultarCripto(String nome) throws SQLException{
        //Este Comando é vulneravel
//        String sql = "select * from aluno where usuario = '"
//                + aluno.getUsuario() + "' AND senha = '"
//                + aluno.getSenha() + "'";
        String sql = "select * from criptomoedas where nome = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nome);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public  void inserirCripto(String nome, double cotacao, double compra, 
                double venda) throws SQLException{
        String sql = "insert into criptomoedas (nome, cotacao, taxacomp, taxavend) values('"
                + nome+ "', '" + cotacao + "', '"
                + compra + "', '"
                + venda + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void atualizarCriptomoeda(String nome, double cotacao) throws SQLException{
        String sql = "update criptomoedas set cotacao = ? where nome = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, cotacao);
        statement.setString(2, nome);
        statement.execute();
        conn.close();
    }
    
    public ResultSet excluirCripto(String nome) throws SQLException{

        String sql = "delete from criptomoedas where nome = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nome);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    /*
    public void inserir(Admin admin) throws SQLException{
        String sql = "insert into extrato (id_extrato, id_investidor, data, hora, valor, cotacao, taxa) values('"
                //+ admin.getIdExtrato()+ "', '"
                //+ admin.getIdInvestidor()+ "', '"
                //+ admin.getData()+ "', '"
                //+ admin.getHora()+ "', '"
               // + admin.getValor()+ "', '"
               // + admin.getCotacao()+ "', '"
               // + admin.getTaxa()+ "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void atualizar(Admin admin) throws SQLException{
        String sql = "update extrato set valor = ? where id_extrato = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, admin.getValor());
        statement.setInt(2, admin.getIdExtrato());
        statement.execute();
        conn.close();
    }
    
    public void excluir(Admin admin) throws SQLException{
        String sql = "delete from extrato where id_extrato = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, admin.getIdExtrato());
        statement.execute();
        conn.close();
    } */
}
