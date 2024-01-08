/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import swing.table.PembeliEventAction;
import swing.table.ModelAction;

/**
 *
 * @author wedaw
 */
public class ModelPembeli {

    public String getNik() {
        return nik;
    }
    public void setNik(String nik) {
        this.nik = nik;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNamaIbu() {
        return namaIbu;
    }
    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }
    public String getTlpPembeli() {
        return tlpPembeli;
    }
    public void setTlpPembeli(String tlpPembeli) {
        this.tlpPembeli = tlpPembeli;
    }
    public String getTglLahir() {
        return tglLahir;
    }
    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }
    public String getAlamatPembeli() {
        return alamatPembeli;
    }
    public void setAlamatPembeli(String alamatPembeli) {
        this.alamatPembeli = alamatPembeli;
    }

    public ModelPembeli() {
    }

    public ModelPembeli(String nik, String nama, String namaIbu, String tlpPembeli, String tglLahir, String alamatPembeli) {
        this.nik = nik;
        this.nama = nama;
        this.namaIbu = namaIbu;
        this.tlpPembeli = tlpPembeli;
        this.tglLahir = tglLahir;
        this.alamatPembeli = alamatPembeli;
    }
    
    private String nik;
    private String nama;
    private String namaIbu;
    private String tlpPembeli;
    private String tglLahir;
    private String alamatPembeli;
    
    public Object[] toRowTable(PembeliEventAction event) {
        return new Object[]{
            nik, nama, namaIbu, tlpPembeli, tglLahir, alamatPembeli,
            new ModelAction(this, event)
        };
    }
    
}
