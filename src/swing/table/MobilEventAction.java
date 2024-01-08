package swing.table;

import model.ModelMobil;

public interface MobilEventAction {
    void delete(ModelMobil mobil);
    void update(ModelMobil mobil);
}
