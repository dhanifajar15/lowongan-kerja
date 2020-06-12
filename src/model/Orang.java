package model;

public class Orang {
    private String name;
    private String tanggal;

    public Orang(String name, String tanggal){
        setName(name);
        setTanggal(tanggal);
    }
    
    public String getName() {
        return name;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
}
