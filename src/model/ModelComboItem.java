package model;

public class ModelComboItem {

    /**
     * @return the item
     */
    public String toString() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }

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

    public ModelComboItem(String item, String id) {
        this.item = item;
        this.id = id;
    }
    
    private String item;
    private String id;
}
