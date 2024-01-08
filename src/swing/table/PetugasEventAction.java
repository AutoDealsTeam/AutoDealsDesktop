package swing.table;

import model.ModelPetugas;

public interface PetugasEventAction {
    void delete(ModelPetugas petugas);
    void update(ModelPetugas petugas);
}
