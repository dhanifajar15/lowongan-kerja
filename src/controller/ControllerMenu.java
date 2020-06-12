/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Aplikasi;
import view.MenuUtama;

/** 
 *
 * @author ventodeco
 */
public class ControllerMenu implements ActionListener{
    MenuUtama mu;
    Aplikasi app = new Aplikasi();

    public ControllerMenu(Aplikasi a){
        mu = new MenuUtama();
        mu.setVisible(true);
        mu.addListener(this);
        this.app = a;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        
        if(x.equals(mu.getbtnPrshn())){
            ControllerPerusahaan cpr = new ControllerPerusahaan(app);   
            mu.dispose();
        } else if(x.equals(mu.getbtnPelamar())){
            ControllerPelamar cpl = new ControllerPelamar(app);
            mu.dispose();
        } else if(x.equals(mu.getbtnout())){
            mu.dispose();
        }
    }
    
}
