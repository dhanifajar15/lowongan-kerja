package model;

public class FullTime extends Lowongan {
    private String nama;
    public FullTime(String nama, String jenisPekerjaan, String requirement, int idLowongan) {
        super(jenisPekerjaan, requirement, idLowongan);
        setNama(nama);
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }
    
}
