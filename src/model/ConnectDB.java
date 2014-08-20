/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.sql.*;

/**
 *
 * @author holako
 */
public class ConnectDB {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public ConnectDB (){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBAE", "root", "1234");
            st =  con.createStatement();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            
        }
    
    }
    
    public ResultSet getAll() throws SQLException{
        try{
        rs = st.executeQuery("select * from Commande");
        return rs;
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public ResultSet getAllAE() throws SQLException{
        try{
        rs = st.executeQuery("select * from AE");
        return rs;
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }

    
    public void addAE(int nAE,float montantAE,Date date,int nCredit) throws SQLException{
        String insertSql = "insert into AE (NAE,MontantAE,Date,NCredit) values(?,?,?,?)";
        PreparedStatement insertStatement = con.prepareStatement(insertSql);
        insertStatement.setInt(1, nAE);
        insertStatement.setFloat(2, montantAE);
        insertStatement.setDate(3, date);
        insertStatement.setInt(4, nCredit);
        insertStatement.executeUpdate();
    }
    public void updateAE(int nAE,float montantAE,Date date,int nCredit) throws SQLException{
        String updateSql = "update AE set MontantAE = ?,Date = ?,NCredit = ? where NAE = ?";
        PreparedStatement insertStatement = con.prepareStatement(updateSql);
        insertStatement.setFloat(1, montantAE);
        insertStatement.setDate(2, date);
        insertStatement.setInt(3, nCredit);
        insertStatement.setInt(4, nAE);
        insertStatement.executeUpdate();
    }
    public void deleteAE(int nAE) throws SQLException{
        String deleteSql = "delete from AE where NAE = ?";
        PreparedStatement insertStatement = con.prepareStatement(deleteSql);
        insertStatement.setInt(1, nAE);
        insertStatement.executeUpdate();
        
    }
    
    public boolean isInAE(int num){
        try{
        rs = st.executeQuery("select * from AE where NAE = "+num);
        if(rs.next())
            return true;
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
    public void close() throws SQLException{
        con.close();
    }
}
