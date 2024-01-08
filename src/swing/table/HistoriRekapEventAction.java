package swing.table;

import model.ModelHistoriCicilan;
import model.ModelRekap;

/**
 *
 * @author wedaw
 */
public interface HistoriRekapEventAction {
    void delete(ModelRekap histori);
    void update(ModelRekap histori);
}
