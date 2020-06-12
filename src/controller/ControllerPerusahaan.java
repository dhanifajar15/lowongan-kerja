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
import model.Lowongan;
import model.Pelamar;
import model.Perusahaan;
import view.MenuPerusahaan;
import view.MenuUtama;

/**
 *
 * @author ventodeco
 */
public class ControllerPerusahaan implements ActionListener {

    MenuUtama mu;
    MenuPerusahaan prs;
    Aplikasi app = new Aplikasi();
    
    ControllerPerusahaan(Aplikasi ap) {
        prs = new MenuPerusahaan();
        prs.setVisible(true);
        prs.addListener(this);
        app = ap;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        
        if(x.equals(prs.getBtnDaftar())){
            String namap = prs.getTfNamaPrshn();
            String name = prs.getTfNamaHR();
            String tgl = prs.getTfTgl();
            String idp = prs.getTfIdPrshn();
            
            if("".equals(namap)){
                JOptionPane.showMessageDialog(prs, "Company Name Empty");
                prs.Reset();
            } else if("".equals(name)){
                JOptionPane.showMessageDialog(prs, "HR Name Empty");
                prs.Reset();
            } else if("".equals(tgl)){
                JOptionPane.showMessageDialog(prs, "Date Empty");
                prs.Reset();
            } else if("".equals(idp)){
                JOptionPane.showMessageDialog(prs, "Company ID Empty");
                prs.Reset();
            } else{
                int x2 = Integer.parseInt(idp);
                Perusahaan p = new Perusahaan(namap, name, tgl, x2);
                app.addPerusahaan(p);
                prs.Reset();
                
                JOptionPane.showMessageDialog(prs, "Your Company Success to Register");
            }
            
        } else if (x.equals(prs.getBtnTerima())){
            int idP = Integer.parseInt(prs.getTfCariIDPelamar1());
            int idL = app.getPelamar(idP).getBerkas().getIdLamaran();
            for(int i=0; i<app.jumlahPerusahaan(); i++){
                for (int j=0;j<app.getPerusahaanIdx(i).jumlahLowongan();j++) { 
                    if (idL==app.getPerusahaanIdx(i).getLowonganidx(j).getBerkasMid(idL).getIdLamaran()){
                        app.getPerusahaan(i).getLowonganidx(j).berkasDiterimaId(idL);
                        app.getPerusahaan(i).getLowonganidx(j).removeBerkasMasuk(idL);
                        
                    }
                }
            }
            app.getPelamar(idP).getBerkas().setStatus("Diterima");
            prs.Reset();
            
            JOptionPane.showMessageDialog(prs, "Pelamar Diterima");
        }
        
        else if (x.equals(prs.getBtnHapus())){
            int cid = prs.getTfCariIDPerusahaan();
            app.deletePerusahaan(cid);
            prs.Reset();
            
            JOptionPane.showMessageDialog(prs, "Perusahaan terhapus");
        }
        
        else if (x.equals(prs.getBtnTolak())){
            int idP = Integer.parseInt(prs.getTfCariIDPelamar1());
            int idL = app.getPelamar(idP).getBerkas().getIdLamaran();
            for (int i=0;i<app.jumlahPerusahaan();i++)    
            {
                for (int j=0;j<app.getPerusahaanIdx(i).jumlahLowongan();j++)  
                    if (idL==app.getPerusahaanIdx(i).getLowonganidx(j).getBerkasMid(idL).getIdLamaran())
                    {
                        app.getPerusahaan(i).getLowonganidx(j).removeBerkasMasuk(idL);
                    }
            }
            app.getPelamar(idP).getBerkas().setStatus("Ditolak");
            prs.Reset();
            
            JOptionPane.showMessageDialog(prs, "Pelamar Ditolak");
        }
        
        else if (x.equals(prs.getBtnCari3())){
            String tempC3 = prs.getTfCariIDPelamar();
            String s = "";
            Pelamar pl;
            if(tempC3.equals("")){
                for(int i=0; i<app.jumlahPelamar(); i++){
                    s = s + app.getPelamar(i).DataPelamar();
                }
                prs.setTxPelamar(s);
            } else {
                int pel =Integer.parseInt(tempC3);
                pl = app.getPelamar(pel);
                prs.setTxPelamar(pl.DataPelamar());
            }
            
   
        }
        
        else if (x.equals(prs.getBtnCari4()))
        {
            int tempC4 = Integer.parseInt(prs.getTfCariIDPelamar1());
            Pelamar pl;
            pl = app.getPelamar(tempC4);
            prs.setTxPelamar2(pl.DataPelamar());
        }
        
        
        else if (x.equals(prs.getBtnCari1())){
            int tempC1 = prs.getTfCariIDPerusahaan();
            Perusahaan ps;
            ps = app.getPerusahaan(tempC1);
            prs.setTxPerusahaan(ps.DataPerusahaan());
        }
        
        else if (x.equals(prs.getBtnBack5())){
            ControllerMenu cm = new ControllerMenu(app);
            prs.dispose();
        }
        
        else if (x.equals(prs.getBtnBack6())){
            ControllerMenu cm = new ControllerMenu(app);
            prs.dispose();
        }
        
        else if (x.equals(prs.getBtnBack7())){
            ControllerMenu cm = new ControllerMenu(app);
            prs.dispose();
        }
        
        else if (x.equals(prs.getBtnBack8())){
            ControllerMenu cm = new ControllerMenu(app);
            prs.dispose();
        }
        
        else if (x.equals(prs.getBtnBack9())){
            ControllerMenu cm = new ControllerMenu(app);
            prs.dispose();
        }
        
        else if (x.equals(prs.getBtnBack10())){
            ControllerMenu cm = new ControllerMenu(app);
            prs.dispose();
        }
        
        else if (x.equals(prs.getBtnCari2())){
            int tempC3 = prs.getTfCariIDLowongan();
            for (int i=0;i<app.jumlahPerusahaan();i++)    
            {
                for (int j=0;j<app.getPerusahaanIdx(i).jumlahLowongan();j++)  
                    if (tempC3==app.getPerusahaanIdx(i).getLowonganidx(j).getId())
                    {
                        prs.setTxLowongan(app.getPerusahaanIdx(i).getLowonganidx(j).DataLowongan());
                    }
            }
         }
                
        else if (x.equals(prs.getBtnTambahLowongan())){
            int idp = prs.getTfIdPrshn1();
            int idl = prs.getTfIDLowongan();
            String jns = prs.getTfJenisLowongan();
            String req = prs.getTfRequirement();
            Lowongan l = new Lowongan(jns, req, idl); 
            app.getPerusahaan(idp).createLowongan(l);
            prs.Reset();
            
            JOptionPane.showMessageDialog(prs, "Lowongan Telah Terdaftar");
        }        
        
        else if (x.equals(prs.getBtnHapusLowongan())){
            int cid = prs.getTfCariIDLowongan();
            for (int i=0;i<app.jumlahPerusahaan();i++)
            {
                for (int j=0;j<app.getPerusahaanIdx(i).jumlahLowongan();j++)  
                {    if (cid==app.getPerusahaanIdx(i).getLowonganidx(j).getId())
                    {
                    app.getPerusahaanIdx(i).removeLowongan(cid);
                    }
                }
            }
            prs.Reset();

            JOptionPane.showMessageDialog(prs, "Lowongan terhapus");
        }
    }
    
}
