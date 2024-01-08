/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import swing.table.MerkEventAction;
import swing.table.ModelAction;

/**
 *
 * @author wedaw
 */
public class ModelMerk {

    public String getKodeMerk() {
        return kodeMerk;
    }

    public void setKodeMerk(String kodeMerk) {
        this.kodeMerk = kodeMerk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ModelMerk() {
    }

    public ModelMerk(String kodeMerk, String nama) {
        this.kodeMerk = kodeMerk;
        this.nama = nama;
    }
    
    private String kodeMerk;
    private String nama;
    
    public Object[] toRowTable(MerkEventAction event) {
        return new Object[]{
            kodeMerk, nama, 
            new ModelAction(this, event)
        };
    }
    
}
