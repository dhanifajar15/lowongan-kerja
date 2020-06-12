/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Aplikasi;
import model.BerkasLamaran;
import model.Perusahaan;
import model.Lowongan;
import model.Pelamar;
import view.MenuPelamar;
import view.MenuUtama;

/**
 *
 * @author ventodeco
 */
public class ControllerPelamar implements ActionListener{

    MenuUtama mu;
    MenuPelamar plm;
    Aplikasi app = new Aplikasi();
    Perusahaan p;
    Lowongan l;

    ControllerPelamar(Aplikasi apps) {
        plm = new MenuPelamar();
        plm.setVisible(true);
        plm.addListener(this);
        app = apps;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        
        if(x.equals(plm.getBtnDaftar())){
            int pid = plm.getTfIdPelamar();
            String pnama = plm.getTfNamaPel();
            String ptgl = plm.getTfTgl();
            int lid = plm.getTfIdLamaran();
            String pend = plm.getTfPendidikan();
            String pkrj = plm.getTfPekerjaan();
            
            BerkasLamaran bl = new BerkasLamaran(lid, pkrj, pend, "Melamar");
            Pelamar p = new Pelamar(pnama, ptgl, pid, bl);
            app.addPelamar(p);
            plm.Reset();
            
            JOptionPane.showMessageDialog(plm, "Pelamar Berhasil Mendaftar");
        
        } 
        
        else if(x.equals(plm.getBtnBack1())){
            ControllerMenu cm = new ControllerMenu(app);
            plm.dispose();
        }
        
        else if(x.equals(plm.getBtnBack2())){
            ControllerMenu cm = new ControllerMenu(app);
            plm.dispose();
        }
        
        else if(x.equals(plm.getBtnBack3())){
            ControllerMenu cm = new ControllerMenu(app);
            plm.dispose();
        }
        
        else if(x.equals(plm.getBtnBack4())){
            ControllerMenu cm = new ControllerMenu(app);
            plm.dispose();
        }
        
        else if (x.equals(plm.getBtnInfo())){
            int idp = plm.getTfCariLamaran();
            plm.setTxInfoPelamar(app.getPelamar(idp).getBerkas().getStatus());
        }
        
        else if (x.equals(plm.getBtnLihatLowongan())){
            String s = "";
            int it = 1;
            if(app.jumlahPerusahaan() == 0){
                s = "Tidak ada Lowongan tersedia";
            }
            for (int i=0;i<app.jumlahPerusahaan();i++)    
            {
                String k = "";
                for (int j=0;j<app.getPerusahaanIdx(i).jumlahLowongan();j++) 
                {
                    k = "\nLowongan ke-" + it + "\n";
                    s = s + k;
                    s = s + app.getPerusahaanIdx(i).getLowonganidx(j).DataLowongan();
                    s = s + "\nNama Perusahaan    : " + app.getPerusahaanIdx(i).getName();
                    s = s + "\n";
                    it++;
                }
            }
            plm.setTxLowongan(s);
        }
        else if (x.equals(plm.getBtnLihatPerusahaan())){
            String s = "";  
            String k = "";
            int it = 1;
            if(app.jumlahPerusahaan() == 0){
                s = "Tidak Ada Perusahaan yang Terdaftar";
            }
            for (int i=0;i<app.jumlahPerusahaan();i++)    
            {
              k = "\nPerusahaan ke-" + it + "\n";
              s = s + k;
              s = s + app.getPerusahaanIdx(i).DataPerusahaan();
              it++;
            }
            
            
            plm.setTxPerusahaan(s);
        }
    }
    
}
