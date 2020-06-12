package model;

import java.util.ArrayList;

public class Perusahaan extends Orang{
	private ArrayList<Lowongan> daftarLowongan = new ArrayList<Lowongan>();
        private int idPerusahaan;
	private String namep;
	private int nLowongan=0;
	
	public Perusahaan(String namep, String name, String tanggal, int id)
	{
            super(name, tanggal);
            this.namep=namep;
            idPerusahaan=id;
	}
	
	public void createLowongan(Lowongan l)
	{
            daftarLowongan.add(l);
            nLowongan++;
	}
	
	public Lowongan getLowonganidx(int idx)
	{
            return daftarLowongan.get(idx);
	}
	
	public Lowongan getLowonganid(int id)
	{
            Lowongan l = null;
            for (int i=0;i<jumlahLowongan();i++){
                if (id==daftarLowongan.get(i).getId()){
                    l=daftarLowongan.get(i);
                }
            }
                return l;
	}
	
	public void removeLowongan(int id)
	{
            for (int i=0;i<jumlahLowongan();i++){
                if (id==daftarLowongan.get(i).getId()){
                    daftarLowongan.remove(i);
                }
            }
	}	
	
/* public void ketLamaran(int indexLowongan,int idberkas)
	{
		daftarLowongan[indexLowongan]
	}
*/	
	public int jmlPelamarMasuk(int id)
	{
		return daftarLowongan.get(id).jmlBerkasM();
	}
	
	public int jmlPelamarDiterima(int id)
	{
		return daftarLowongan.get(id).jmlBerkasD();
	}
	
/*	public void lihatPelamar
	{
		System.out.println()
	} */
        
        public int getId()
        {
            return idPerusahaan;
        }
        
        public String getNameP()
        {
            return namep;
        }
        
        public String getName()
        {
            return super.getName();
        }
        
        public int jumlahLowongan()
        {
            return nLowongan;
        }
        
        public ArrayList<Lowongan> getLowongan(){
            return daftarLowongan;
        }
        
        public void Shout()
        {
            System.out.println("");
        }
        public String DataPerusahaan(){
            return "Nama Perusahaan   : "+getNameP()+
                 "\nNama HR           : "+getName()+
                 "\nID Perusahaan     : "+getId()+
                 "\nTanggal Terdaftar : "+getTanggal();
        }
        
        public String IDPerusahaan(){
            return "ID Perusahaan: "+getId();
        }
}
