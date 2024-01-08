
package model;

import swing.table.HistoriEventAction;
import swing.table.ModelAction;

/**
 *
 * @author wedaw
 */
public class ModelHistori {

    /**
     * @return the idHistori
     */
    public String getIdHistori() {
        return idHistori;
    }

    /**
     * @param idHistori the idHistori to set
     */
    public void setIdHistori(String idHistori) {
        this.idHistori = idHistori;
    }

    /**
     * @return the tglLunas
     */
    public String getTglLunas() {
        return tglLunas;
    }

    /**
     * @param tglLunas the tglLunas to set
     */
    public void setTglLunas(String tglLunas) {
        this.tglLunas = tglLunas;
    }

    /**
     * @return the mobil
     */
    public String getMobil() {
        return mobil;
    }

    /**
     * @param mobil the mobil to set
     */
    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    /**
     * @return the nik
     */
    public String getNik() {
        return nik;
    }

    /**
     * @param nik the nik to set
     */
    public void setNik(String nik) {
        this.nik = nik;
    }

    /**
     * @return the harga
     */
    public String getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(String harga) {
        this.harga = harga;
    }

    /**
     * @return the jumlahUang
     */
    public String getJumlahUang() {
        return jumlahUang;
    }

    /**
     * @param jumlahUang the jumlahUang to set
     */
    public void setJumlahUang(String jumlahUang) {
        this.jumlahUang = jumlahUang;
    }

    /**
     * @return the idPembelian
     */
    public String getIdPembelian() {
        return idPembelian;
    }

    /**
     * @param idPembelian the idPembelian to set
     */
    public void setIdPembelian(String idPembelian) {
        this.idPembelian = idPembelian;
    }

    public ModelHistori() {
    }

    public ModelHistori(String idHistori, String tglLunas, String mobil, String nik, String harga, String jumlahUang, String idPembelian) {
        this.idHistori = idHistori;
        this.tglLunas = tglLunas;
        this.mobil = mobil;
        this.nik = nik;
        this.harga = harga;
        this.jumlahUang = jumlahUang;
        this.idPembelian = idPembelian;
    }

    
    
    private String idHistori;
    private String tglLunas;
    private String mobil;
    private String nik;
    private String harga;
    private String jumlahUang;
    private String idPembelian;
    
    
    public Object[] toRowTable(HistoriEventAction event) {
        return new Object[]{
            idHistori, tglLunas, mobil, nik, harga, jumlahUang, idPembelian
//            new ModelAction(this, event)
        };
    }
    
}
