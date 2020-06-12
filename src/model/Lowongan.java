package model;

import java.util.ArrayList;

public class Lowongan{
    private ArrayList<BerkasLamaran> berkasMasuk = new ArrayList<BerkasLamaran>();
    private ArrayList<BerkasLamaran> berkasDiterima = null; 
    private String jenisPekerjaan;
    private String requirement;
    private int nBerkasM=0;
    private int nBerkasD=0;
    private int idLowongan;
    private String approval;

    public Lowongan(String jenisPekerjaan, String requirement, int idLowongan) {
        this.jenisPekerjaan = jenisPekerjaan;
        this.requirement = requirement;
        this.idLowongan = idLowongan;
    }
    
    public String getJenis()
    {
        return jenisPekerjaan;
    }
    
    public String getReq()
    {
        return requirement;
    }

    public int getId() {
        return idLowongan;
    }
    
    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getApproval() {
        return approval;
    }
                
    public void addBerkas(BerkasLamaran bl)
    {
            berkasMasuk.add(bl);
    }

    public BerkasLamaran getBerkasMidx(int idx)
    {
            return berkasMasuk.get(idx);
    }

    public BerkasLamaran getBerkasMid(int id)
    {
        BerkasLamaran bl = null;
        for (int i=0;i<berkasMasuk.size();i++){
            if (id==berkasMasuk.get(i).getIdLamaran()){
                bl=berkasMasuk.get(i);
            }
        }
            return bl;
    }

    public void berkasDiterimaId(int id)
    {
        berkasDiterima.add(getBerkasMid(id));
        removeBerkasMasuk(id);
    }

    public int jmlBerkasM()
    {
        nBerkasM=this.berkasMasuk.size();
        return nBerkasM;
    }

    public int jmlBerkasD()
    {
        nBerkasD=this.berkasDiterima.size();
        return nBerkasD;
    }

    public void removeBerkasMasuk(int id)
    {
        for (int i=0;i<berkasMasuk.size();i++){
            if (id==berkasMasuk.get(i).getIdLamaran()){
                berkasMasuk.remove(i);
            }
        }
    }	

    public BerkasLamaran getBerkasDidx(int idx)
    {
            return berkasDiterima.get(idx);
    }

    public BerkasLamaran getBerkasDid(int id)
    {
        BerkasLamaran bl = null;
        for (int i=0;i<berkasDiterima.size();i++){
            if (id==berkasDiterima.get(i).getIdLamaran()){
                bl=berkasDiterima.get(i);
            }
        }
            return bl;
    }

    public ArrayList<BerkasLamaran> getBerkas(){
        return berkasMasuk;
    }

    public String DataLowongan(){
        return "ID Lowongan             : "+getId()+                 
             "\nJenis Lowongan        : "+getJenis()+
             "\nRequirement             : "+getReq();
    }
}
