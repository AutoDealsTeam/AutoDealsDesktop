
package model;

import swing.table.HistoriCicilanEventAction;
import swing.table.ModelAction;

/**
 *
 * @author wedaw
 */
public class ModelHistoriCicilan {

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
     * @return the idKonfirmasi
     */
    public String getIdKonfirmasi() {
        return idKonfirmasi;
    }

    /**
     * @param idKonfirmasi the idKonfirmasi to set
     */
    public void setIdKonfirmasi(String idKonfirmasi) {
        this.idKonfirmasi = idKonfirmasi;
    }

    /**
     * @return the dpCicilan
     */
    public String getDpCicilan() {
        return dpCicilan;
    }

    /**
     * @param dpCicilan the dpCicilan to set
     */
    public void setDpCicilan(String dpCicilan) {
        this.dpCicilan = dpCicilan;
    }

    /**
     * @return the sisa
     */
    public String getSisa() {
        return sisa;
    }

    /**
     * @param sisa the sisa to set
     */
    public void setSisa(String sisa) {
        this.sisa = sisa;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the lamaCicilan
     */
    public String getLamaCicilan() {
        return lamaCicilan;
    }

    /**
     * @param lamaCicilan the lamaCicilan to set
     */
    public void setLamaCicilan(String lamaCicilan) {
        this.lamaCicilan = lamaCicilan;
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

    public ModelHistoriCicilan() {
    }

    public ModelHistoriCicilan(String idKonfirmasi, String dpCicilan, String sisa, String status, String total, String lamaCicilan, String harga, String idPembelian) {
        this.idKonfirmasi = idKonfirmasi;
        this.dpCicilan = dpCicilan;
        this.sisa = sisa;
        this.status = status;
        this.total = total;
        this.lamaCicilan = lamaCicilan;
        this.idPembelian = idPembelian;
        this.harga = harga;
    }
    
    private String idKonfirmasi;
    private String dpCicilan;
    private String sisa;
    private String status;
    private String total;
    private String lamaCicilan;
    private String idPembelian;
    private String harga;
    
    public Object[] toRowTable(HistoriCicilanEventAction event) {
        return new Object[]{
            idKonfirmasi, dpCicilan, sisa, status, total, lamaCicilan,harga, idPembelian,
            new ModelAction(this, event)
        };
    }
    
}
