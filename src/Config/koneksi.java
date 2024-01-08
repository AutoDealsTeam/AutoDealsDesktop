package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class koneksi {
    public static Connection conn;
    public static Statement stm;
    public static Connection koneksiSql(){
        try {
            String url ="jdbc:mysql://127.0.0.1:3306/db_autodeals2";
            String user="root";
            String pass="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =DriverManager.getConnection(url,user,pass);
            stm = conn.createStatement();
            System.out.println("koneksi berhasil;");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return conn;
    } 
}
