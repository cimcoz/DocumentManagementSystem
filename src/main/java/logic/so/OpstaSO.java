/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import db.DbCommunication;
import db.DbCommunicationHibernateImpl;
import db.DbComumunicationInterface;

/**
 *
 * @author User
 */
public abstract class OpstaSO {
  protected DbComumunicationInterface db = new DbCommunication();
  //  protected DbComumunicationInterface db = new DbCommunicationHibernateImpl();
    
    private void ucitajDrajver()throws Exception{
        db.loadDriver();
    }
    
    private void uspostaviKonekciju() throws Exception{
        db.openConnection();
    }
    
    private void potvrdiTrasakciju() throws Exception{
        db.commitTransaction();
    }
    
    private void ponistiTransakciju() throws Exception{
        db.rollbackTransaction();
    }
    
    private void raskiniKonekciju() throws Exception{
        db.closeConnection();
    }
    
    abstract protected void izvrsiOperaciju() throws Exception;
    
    public void opsteIzvrsenje() throws Exception{
        // db=new DbCommunication();
        try{
            ucitajDrajver();
            uspostaviKonekciju();
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        try{
            izvrsiOperaciju();
            potvrdiTrasakciju();
            System.out.println("Transakcija commit-ovana");
        }catch(Exception e){
            ponistiTransakciju();
            e.printStackTrace();
            throw e;
        }finally{
            raskiniKonekciju();
        }
    }
    
    
}
