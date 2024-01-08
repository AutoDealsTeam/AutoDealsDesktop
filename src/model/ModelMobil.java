package model;

import swing.table.MobilEventAction;
import swing.table.ModelAction;
import swing.table.ModelProfile;
import javax.swing.Icon;

public class ModelMobil {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getNamaMobil() {
        return name;
    }

    public void setNamaMobil(String name) {
        this.name = name;
    }

    public String getHargaMobil() {
        return harga;
    }

    public void setHargaMobil(String harga) {
        this.harga = harga;
    }

    public String getWarnaMobil() {
        return warna;
    }

    public void setWarnaMobil(String warna) {
        this.warna = warna;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getMerekMobil() {
        return merk;
    }

    public void setMerekMobil(String merk) {
        this.merk = merk;
    }

    public String getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin;
    }

    public ModelMobil(Icon icon, String name, String id, String harga, String tahun, String warna, String merk, String userAdmin) {
        this.icon = icon;
        this.id = id;
        this.name = name;
        this.harga = harga;
        this.warna = warna;
        this.tahun = tahun;
        this.merk = merk;
        this.userAdmin = userAdmin;
    }

    public ModelMobil() {
    }
    
    private Icon icon;
    private String id;
    private String name;
    private String harga;
    private String warna;
    private String tahun;
    private String merk;
    private String userAdmin;
    
    public Object[] toRowTable(MobilEventAction event) {
        return new Object[]{
            new ModelProfile(icon, name), id, harga, tahun, warna, merk, userAdmin, 
            new ModelAction(this, event)
        };
    }
}
