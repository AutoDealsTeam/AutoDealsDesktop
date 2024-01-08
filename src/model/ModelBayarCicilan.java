
package model;

import swing.table.ModelAction;
import swing.table.HistoriBayarCicilanEventAction;

/**
 *
 * @author wedaw
 */
public class ModelBayarCicilan {

    /**
     * @return the idKonfirmasi
     */
    public int getIdKonfirmasi() {
        return idKonfirmasi;
    }

    /**
     * @param idKonfirmasi the idKonfirmasi to set
     */
    public void setIdKonfirmasi(int idKonfirmasi) {
        this.idKonfirmasi = idKonfirmasi;
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
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the bulan
     */
    public String getBulan() {
        return bulan;
    }

    /**
     * @param bulan the bulan to set
     */
    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    /**
     * @return the aBunga
     */
    public String getaBunga() {
        return aBunga;
    }

    /**
     * @param aBunga the aBunga to set
     */
    public void setaBunga(String aBunga) {
        this.aBunga = aBunga;
    }

    /**
     * @return the aPokok
     */
    public String getaPokok() {
        return aPokok;
    }

    /**
     * @param aPokok the aPokok to set
     */
    public void setaPokok(String aPokok) {
        this.aPokok = aPokok;
    }

    /**
     * @return the aTotal
     */
    public String getaTotal() {
        return aTotal;
    }

    /**
     * @param aTotal the aTotal to set
     */
    public void setaTotal(String aTotal) {
        this.aTotal = aTotal;
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

    public ModelBayarCicilan() {
    }

    public ModelBayarCicilan(int id, String bulan, String aBunga, String aPokok, String aTotal, String sisa, String status, int idKonfirmasi) {
        this.id = id;
        this.bulan = bulan;
        this.aBunga = aBunga;
        this.aPokok = aPokok;
        this.aTotal = aTotal;
        this.sisa = sisa;
        this.status = status;
        this.idKonfirmasi = idKonfirmasi;
    }


    private int id;
    private String bulan;
    private String aBunga;
    private String aPokok;
    private String aTotal;
    private String sisa;
    private String status;
    private int idKonfirmasi;
    
    
    public Object[] toRowTable(HistoriBayarCicilanEventAction event) {
        return new Object[]{
            id, bulan, aBunga, aPokok, aTotal, sisa, status, idKonfirmasi,
            new ModelAction(this, event)
        };
    }
    
}
