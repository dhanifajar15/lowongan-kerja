package model;


public class PartTime extends Lowongan{

    private String nama;
    
    public PartTime(String nama, String jenisPekerjaan, String requirement, int idLowongan) {
        super(jenisPekerjaan, requirement, idLowongan);
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    
    
    
}
