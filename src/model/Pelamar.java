package model;

public class Pelamar extends Orang{
    private BerkasLamaran berkas;
    private int idPelamar;

	public Pelamar(String name, String tanggal, int idPelamar, BerkasLamaran bl){
            super(name, tanggal);
            this.idPelamar = idPelamar;
            berkas = bl;
	}
        
        public Pelamar(String name, String tanggal, int idPelamar){
            super(name, tanggal);
            this.idPelamar = idPelamar;
	}
                
	public void createBerkas(BerkasLamaran bl){
            berkas = bl;
	}
        
        public BerkasLamaran getBerkas()
	{
            return berkas;
	}
        
        public int getId()
        {
            return idPelamar;
        }
        
        public String DataPelamar(){
            return "Nama Pelamar: "+getName()+                 
                    "\nID Pelamar: "+getId()+
                    "\nTanggal Mendaftar: "+getTanggal()+
                    "\n"+getBerkas().toString();
        }
}
