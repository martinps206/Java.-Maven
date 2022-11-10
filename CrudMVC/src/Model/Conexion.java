package Model;

//import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import java.sql.*;
public class Conexion {

    private final String base = "tienda";
    private final String user = "root";
    private final String password = "mysql";
    private final String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection con = null;

    public Connection getConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);

        }catch(SQLException e){
            System.out.println("error" + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

}
