package model;

public class ModelLoginPegawai {

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public ModelLoginPegawai(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ModelLoginPegawai() {
    }
    private String username;
    private String password;
}
