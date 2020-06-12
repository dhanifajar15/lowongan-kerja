package model;

public class BerkasLamaran
{
    private String Pengalaman;
    private int idLamaran;
    private String edukasi;
    private String status;

    public BerkasLamaran(int idLamaran, String Pengalaman, String edukasi, String status) {
        this.idLamaran = idLamaran;
        this.Pengalaman = Pengalaman;            
        this.edukasi = edukasi;
        this.status = status;
    }		
        
    public int getIdLamaran()
    {
            return idLamaran;
    }

    public void setIdLamaran(int idLamaran)
    {
            this.idLamaran=idLamaran;
    }

    public void setEdukasi(String edukasi)
    {
            this.edukasi=edukasi;
    }

    @Override
    public String toString() {
        return "Pengalaman=" + Pengalaman + 
                "\nidLamaran : " + idLamaran + 
                "\nedukasi : " + edukasi + 
                "\nstatus : " + status;
    }

    public String getPengalaman()
    {
        return Pengalaman;
    }

    public void setPengalaman(String Pengalaman)
    {
        this.Pengalaman=Pengalaman;
         }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEdukasi() {
        return edukasi;
    }

    public String getStatus() {
        return status;
    }      

}