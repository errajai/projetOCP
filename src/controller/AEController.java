/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ConnectDB;
import view.Application;

/**
 *
 * @author holako
 */
public class AEController {
    
    private final ConnectDB con = new ConnectDB();
    public void addAE(String nAE,String montant,String dateAE,String nCredit){
        
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = null;
            java.sql.Date sqlDate = null;
            try {
                date = formatter.parse(dateAE);
                sqlDate = new java.sql.Date(date.getTime());
                con.addAE(Integer.parseInt(nAE),Float.parseFloat(montant),sqlDate,Integer.parseInt(nCredit));
                
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public ResultSet getAllAE () throws SQLException{
        
        return con.getAllAE();
        
    }
    public boolean isInAE(int num){
        return con.isInAE(num);
    }
    public void updateAE(String nAE,String montant,String dateAE,String nCredit) throws SQLException{
        
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = null;
            java.sql.Date sqlDate = null;
            try {
                date = formatter.parse(dateAE);
                sqlDate = new java.sql.Date(date.getTime());
                con.updateAE(Integer.parseInt(nAE),Float.parseFloat(montant),sqlDate,Integer.parseInt(nCredit));
                
            } catch (ParseException ex) {
                Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void deleteAE(String nAE) throws SQLException{
        con.deleteAE(Integer.parseInt(nAE));
    }
    
}
