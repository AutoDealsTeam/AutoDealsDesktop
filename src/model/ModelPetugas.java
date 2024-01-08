package model;

import javax.swing.Icon;
import swing.table.PetugasEventAction;
import swing.table.ModelAction;
import swing.table.ModelProfile;

public class ModelPetugas {

    /**
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the usernameAdmin
     */
    public String getUsernameAdmin() {
        return usernameAdmin;
    }

    /**
     * @param usernameAdmin the usernameAdmin to set
     */
    public void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

    public ModelPetugas(Icon icon, String username, String password, String name, String usernameAdmin) {
        this.icon = icon;
        this.username = username;
        this.password = password;
        this.name = name;
        this.usernameAdmin = usernameAdmin;
    }
    
    public ModelPetugas() {
    }

    private Icon icon;
    private String username;
    private String password;
    private String name;
    private String usernameAdmin;
    
    public Object[] toRowTable(PetugasEventAction event) {
        return new Object[] {
            new ModelProfile(icon, name), username, password, usernameAdmin,
            new ModelAction(this, event)
        };
    }
}
