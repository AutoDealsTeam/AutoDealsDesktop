
package model;

import swing.table.PembelianEventAction;
import swing.table.ModelAction;

/**
 *
 * @author wedaw
 */
public class ModelPembelian {

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the warna
     */
    public String getWarna() {
        return warna;
    }

    /**
     * @param warna the warna to set
     */
    public void setWarna(String warna) {
        this.warna = warna;
    }

    /**
     * @return the merk
     */
    public String getMerk() {
        return merk;
    }

    /**
     * @param merk the merk to set
     */
    public void setMerk(String merk) {
        this.merk = merk;
    }

    public ModelPembelian() {
    }

    public ModelPembelian(String id, String name, String harga, String warna, String merk) {
        this.id = id;
        this.name = name;
        this.harga = harga;
        this.warna = warna;
        this.merk = merk;
    }
    
    private String id;
    private String name;
    private String harga;
    private String warna;
    private String merk;
    public Object[] toRowTable(PembelianEventAction event) {
        return new Object[]{
            id, name, harga, warna, merk,
            new ModelAction(this, event)
        };
    }
    
}
