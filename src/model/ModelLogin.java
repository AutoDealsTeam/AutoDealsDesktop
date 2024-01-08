package model;

public class ModelLogin {

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the jabatan
     */
    public String getJabatan() {
        return jabatan;
    }

    /**
     * @param jabatan the jabatan to set
     */
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public ModelLogin() {
    }

    public ModelLogin(String username, String jabatan) {
        this.username = username;
        this.jabatan = jabatan;
    }

    private String username;
    private String jabatan;
}
