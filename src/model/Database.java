/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ventodeco
 */
public class Database {
    
    private Connection con;
    
    public void connect(){
        try{
            String url ="jdbc:mysql://localhost:3306/tubes?useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username="root";
            String password="";
            con=(Connection) DriverManager.getConnection(url,username, password);
            System.out.println("Connected to database.");
        } catch(SQLException se){
            System.out.println("Connection error.");
        }
    }
    public void savePerusahaan(Perusahaan p){
        try{
            String query="INSERT INTO perusahaan values('"+p.getId()+"','"+p.getNameP()+"','"+p.getName()+"','"+p.getTanggal()+"');";
            Statement s =(Statement) con.createStatement();
            s.execute(query);
            System.out.println("Saving success.");
        } catch(SQLException se){
            System.out.println("Saving error.");
        }
    }
    public Perusahaan selectOnePerusahaanById(int id){
        try{
            String query="select * from perusahaan where id ='"+id+"'" ;
            Statement s=(Statement) con.createStatement();
            ResultSet rs;
            rs = s.executeQuery(query);
            Perusahaan p=null;
            while (rs.next()){
                String namep=rs.getString(2);
                String nama=rs.getString(3);
                String tanggal=rs.getString(4);
                p = new Perusahaan(namep, nama, tanggal, id);
            }
            
            return p;
        }catch(SQLException se){
            return null;
        }
    }
    
    public ArrayList<Perusahaan> selectAllPerusahaan(){
        try{
            ArrayList<Perusahaan> prshn=new ArrayList();
            String query="select * from perusahaan" ;
            Statement s= con.createStatement();
            ResultSet rs=s.executeQuery(query);
            Perusahaan p;
            while (rs.next()){
                int id=rs.getInt(1);
                String namep=rs.getString(2);
                String nama=rs.getString(3);
                String tanggal=rs.getString(4);
                int year=Integer.parseInt(rs.getString(4));
                double cost=Double.parseDouble(rs.getString(4));
                p = new Perusahaan(namep, nama, tanggal, id);
                prshn.add(p);
            }
            return prshn;
        }catch(SQLException se){
            return null;
        }
    }
    public Perusahaan selectLastPerusahaan(){
        try{
            String query="select * from perusahaan where id = (select max(id) from perusahaan)" ;
            Statement s= con.createStatement();
            ResultSet rs=s.executeQuery(query);
            Perusahaan p=null;
            while (rs.next()){
                int id=rs.getInt(1);
                String namep=rs.getString(2);
                String nama=rs.getString(3);
                String tanggal=rs.getString(4);
                p = new Perusahaan(namep, nama, tanggal, id);
            }
            return p;
        }catch(SQLException se){
            return null;
        }
    }
    public void removePerusahaan(Perusahaan p){
        try{
            String query="delete from perusahaan where id='"+p.getId()+"'" ;
            Statement s = (Statement) con.createStatement();
            s.executeUpdate(query);
            System.out.println("Delete success.");
        } catch(SQLException se){
            System.out.println("Delete error.");
        }
    }
    
    public void savePelamar(Pelamar p){
        try{
            String query="INSERT INTO pelamar values('"+p.getId()+"','"+p.getName()+"','"+p.getTanggal()+"','"+p.getBerkas().getIdLamaran()+"');";
            Statement s =(Statement) con.createStatement();
            s.execute(query);
            System.out.println("Saving success.");
        } catch(SQLException se){
            System.out.println("Saving error.");
        }
    }
    public Pelamar selectOnePelamarById(int id){
        try{
            String query="select * from Pelamar where id ='"+id+"'" ;
            Statement s=(Statement) con.createStatement();
            ResultSet rs;
            rs = s.executeQuery(query);
            Pelamar p=null;
            while (rs.next()){
                String name=rs.getString(2);
                String tanggal=rs.getString(3);
//                String bl=rs.getString(4);
                p = new Pelamar(name, tanggal, id);
            }
            
            return p;
        }catch(SQLException se){
            return null;
        }
    }
    
    public ArrayList<Pelamar> selectAllPelamar(){
        try{
            ArrayList<Pelamar> prshn=new ArrayList();
            String query="select * from Pelamar" ;
            Statement s= con.createStatement();
            ResultSet rs=s.executeQuery(query);
            Pelamar p;
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String tanggal=rs.getString(3);
                p = new Pelamar(name, tanggal, id);
                prshn.add(p);
            }
            return prshn;
        }catch(SQLException se){
            return null;
        }
    }
    public Pelamar selectLastPelamar(){
        try{
            String query="select * from Pelamar where id = (select max(id) from Pelamar)" ;
            Statement s= con.createStatement();
            ResultSet rs=s.executeQuery(query);
            Pelamar p=null;
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String tanggal=rs.getString(3);
                p = new Pelamar(name, tanggal, id);
            }
            return p;
        }catch(SQLException se){
            return null;
        }
    }
    public void removePelamar(Pelamar p){
        try{
            String query="delete from Pelamar where id='"+p.getId()+"'" ;
            Statement s = (Statement) con.createStatement();
            s.executeUpdate(query);
            System.out.println("Delete success.");
        } catch(SQLException se){
            System.out.println("Delete error.");
        }
    }
    
    
}
