/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ventodeco
 */
public class Aplikasi {
    private ArrayList<Perusahaan> daftarPerusahaan;
    private ArrayList<Pelamar> daftarPelamar;
    private int nPerusahaan=0;
    private int nPelamar=0;
    Scanner in = new Scanner(System.in);
    Database db;
    int pil;

    public Aplikasi() {
        this.daftarPerusahaan = new ArrayList<>();
        this.daftarPelamar = new ArrayList<>();
        db=new Database();
        db.connect();
    }

    public void addPelamar(Pelamar p) {
        daftarPelamar.add(p);
        db.savePelamar(p);
        nPelamar++;
    }
    
    public int jumlahPelamar(){
        return nPelamar;
    }

    public Pelamar getPelamar(int idp) {
        for(int i=0; i<jumlahPelamar(); i++){
            if(idp == daftarPelamar.get(i).getId()){
                return daftarPelamar.get(i);    
            }
        }
        return null;
    }

    public int jumlahPerusahaan() {
        return nPerusahaan;
    }

    public Perusahaan getPerusahaanIdx(int i) {
        return daftarPerusahaan.get(i);
    }

    public void addPerusahaan(Perusahaan p) {
        daftarPerusahaan.add(p);
        db.savePerusahaan(p);
        nPerusahaan++;
    }

    public Perusahaan getPerusahaan(int i) {
        Perusahaan p = null;
        for(Perusahaan x : daftarPerusahaan){
                if(x.getId()==i){
                    p = x;
                }
            }
        return p;
    }

    public void deletePerusahaan(int cid) {
        for (int i=0;i<daftarPerusahaan.size();i++){
            if (cid==daftarPerusahaan.get(i).getId()){
                daftarPerusahaan.remove(i);
            }
        }   
    }
    
}
