package swing.table;

import model.ModelMerk;
import model.ModelPetugas;
import model.ModelMobil;
import model.ModelBungaCicilan;
import model.ModelPembeli;
import model.ModelPembelian;
import model.ModelHistori;
import model.ModelHistoriCicilan;
import model.ModelBayarCicilan;


public class ModelAction {

    /**
     * @return the bayarCicilan
     */
    public ModelBayarCicilan getBayarCicilan() {
        return bayarCicilan;
    }

    /**
     * @param bayarCicilan the bayarCicilan to set
     */
    public void setBayarCicilan(ModelBayarCicilan bayarCicilan) {
        this.bayarCicilan = bayarCicilan;
    }

    /**
     * @return the bayarCicilanEvent
     */
    public HistoriBayarCicilanEventAction getBayarCicilanEvent() {
        return bayarCicilanEvent;
    }

    /**
     * @param bayarCicilanEvent the bayarCicilanEvent to set
     */
    public void setBayarCicilanEvent(HistoriBayarCicilanEventAction bayarCicilanEvent) {
        this.bayarCicilanEvent = bayarCicilanEvent;
    }

    /**
     * @return the historiCicilan
     */
    public ModelHistoriCicilan getHistoriCicilan() {
        return historiCicilan;
    }

    /**
     * @param historiCicilan the historiCicilan to set
     */
    public void setHistoriCicilan(ModelHistoriCicilan historiCicilan) {
        this.historiCicilan = historiCicilan;
    }

    /**
     * @return the historiCicilanEvent
     */
    public HistoriCicilanEventAction getHistoriCicilanEvent() {
        return historiCicilanEvent;
    }

    /**
     * @param historiCicilanEvent the historiCicilanEvent to set
     */
    public void setHistoriCicilanEvent(HistoriCicilanEventAction historiCicilanEvent) {
        this.historiCicilanEvent = historiCicilanEvent;
    }

    /**
     * @return the histori
     */
    public ModelHistori getHistori() {
        return histori;
    }

    /**
     * @param histori the histori to set
     */
    public void setHistori(ModelHistori histori) {
        this.histori = histori;
    }

    /**
     * @return the historiEvent
     */
    public HistoriEventAction getHistoriEvent() {
        return historiEvent;
    }

    /**
     * @param historiEvent the historiEvent to set
     */
    public void setHistoriEvent(HistoriEventAction historiEvent) {
        this.historiEvent = historiEvent;
    }

    /**
     * @return the beli
     */
    public ModelPembelian getBeli() {
        return beli;
    }

    /**
     * @param beli the beli to set
     */
    public void setBeli(ModelPembelian beli) {
        this.beli = beli;
    }

    /**
     * @return the pembelianEvent
     */
    public PembelianEventAction getPembelianEvent() {
        return pembelianEvent;
    }

    /**
     * @param pembelianEvent the pembelianEvent to set
     */
    public void setPembelianEvent(PembelianEventAction pembelianEvent) {
        this.pembelianEvent = pembelianEvent;
    }

    public ModelPembeli getPembeli() {
        return pembeli;
    }
    public void setPembeli(ModelPembeli pembeli) {
        this.pembeli = pembeli;
    }
    public PembeliEventAction getPembeliEvent() {
        return pembeliEvent;
    }
    public void setPembeliEvent(PembeliEventAction pembeliEvent) {
        this.pembeliEvent = pembeliEvent;
    }

    public ModelBungaCicilan getBunga() {
        return bunga;
    }
    public void setBunga(ModelBungaCicilan bunga) {
        this.bunga = bunga;
    }
    public BungaEventAction getBungaEvent() {
        return bungaEvent;
    }
    public void setBungaEvent(BungaEventAction bungaEvent) {
        this.bungaEvent = bungaEvent;
    }
    public ModelPetugas getPetugas() {
        return petugas;
    }
    public void setPetugas(ModelPetugas petugas) {
        this.petugas = petugas;
    }
    public PetugasEventAction getPetugasEvent() {
        return petugasEvent;
    }
    public void setPetugasEvent(PetugasEventAction petugasEvent) {
        this.petugasEvent = petugasEvent;
    }
    public ModelMobil getMobil() {
        return mobil;
    }
    public void setMobil(ModelMobil mobil) {
        this.mobil = mobil;
    }
    public MobilEventAction getMobilEvent() {
        return mobilEvent;
    }
    public void setMobilEvent(MobilEventAction mobilEvent) {
        this.mobilEvent = mobilEvent;
    }
    public ModelMerk getMekr() {
        return merk;
    }
    public void setMekr(ModelMerk merk) {
        this.merk = merk;
    }
    public MerkEventAction getMerkEvent() {
        return merkEvent;
    }
    public void setMerkEvent(MerkEventAction event) {
        this.merkEvent = event;
    }
   
    public ModelAction() {
    }
     
     
    public ModelAction(ModelMerk merk, MerkEventAction event) {
        this.merk = merk;
        this.merkEvent = event;
    }
    public ModelAction(ModelPetugas petugas, PetugasEventAction event) {
        this.petugas = petugas;
        this.petugasEvent = event;
    }
    public ModelAction(ModelMobil mobil, MobilEventAction event) {
        this.mobil = mobil;
        this.mobilEvent = event;
    }

    public ModelAction(ModelBungaCicilan bunga, BungaEventAction bungaEvent) {
        this.bunga = bunga;
        this.bungaEvent = bungaEvent;
    }

    public ModelAction(ModelPembeli pembeli, PembeliEventAction pembeliEvent) {
        this.pembeli = pembeli;
        this.pembeliEvent = pembeliEvent;
    }

    public ModelAction(ModelPembelian beli, PembelianEventAction pembelianEvent) {
        this.beli = beli;
        this.pembelianEvent = pembelianEvent;
    }

    public ModelAction(ModelHistori histori, HistoriEventAction historiEvent) {
        this.histori = histori;
        this.historiEvent = historiEvent;
    }

    public ModelAction(ModelHistoriCicilan historiCicilan, HistoriCicilanEventAction historiCicilanEvent) {
        this.historiCicilan = historiCicilan;
        this.historiCicilanEvent = historiCicilanEvent;
    }
    
    public ModelAction(ModelBayarCicilan bayarCicilan, HistoriBayarCicilanEventAction bayarCicilanEvent) {
        this.bayarCicilan = bayarCicilan;
        this.bayarCicilanEvent = bayarCicilanEvent;
    }
    
    
    private ModelPetugas petugas;
    private PetugasEventAction petugasEvent;
    
    private ModelMobil mobil;
    private MobilEventAction mobilEvent;
    
    private ModelMerk merk;
    private MerkEventAction merkEvent;
    
    private ModelBungaCicilan bunga;
    private BungaEventAction bungaEvent;
    
    private ModelPembeli pembeli;
    private PembeliEventAction pembeliEvent;
    
    private ModelPembelian beli;
    private PembelianEventAction pembelianEvent;
    
    private ModelHistori histori;
    private HistoriEventAction historiEvent;
    
    private ModelHistoriCicilan historiCicilan;
    private HistoriCicilanEventAction historiCicilanEvent;
    
    private ModelBayarCicilan bayarCicilan;
    private HistoriBayarCicilanEventAction bayarCicilanEvent;
}

