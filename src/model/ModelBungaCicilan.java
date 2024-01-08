package model;

import swing.table.BungaEventAction;
import swing.table.ModelAction;

public class ModelBungaCicilan {

    /**
     * @return the idCicilan
     */
    public String getIdCicilan() {
        return idCicilan;
    }

    /**
     * @param idCicilan the idCicilan to set
     */
    public void setIdCicilan(String idCicilan) {
        this.idCicilan = idCicilan;
    }

    /**
     * @return the idPembayaran
     */
    public String getIdPembayaran() {
        return idPembayaran;
    }

    /**
     * @param idPembayaran the idPembayaran to set
     */
    public void setIdPembayaran(String idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    /**
     * @return the bungaPers
     */
    public String getBungaPers() {
        return bungaPers;
    }

    /**
     * @param bungaPers the bungaPers to set
     */
    public void setBungaPers(String bungaPers) {
        this.bungaPers = bungaPers;
    }
    public ModelBungaCicilan(String idCicilan, String bungaPers, String idPembayaran) {
        this.idCicilan = idCicilan;
        this.idPembayaran = idPembayaran;
        this.bungaPers = bungaPers;
    }
    public ModelBungaCicilan() {
    }
    private String idCicilan;
    private String idPembayaran;
    private String bungaPers;
    
    public Object[] toRowTable(BungaEventAction event) {
        return new Object[]{
            idCicilan, bungaPers, idPembayaran,
            new ModelAction(this, event)
        };
    }
}
