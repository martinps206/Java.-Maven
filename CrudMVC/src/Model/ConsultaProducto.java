package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaProducto extends Conexion {

    public boolean registrar(Product product){
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO product (code, name, price, count) VALUES (?, ?, ?, ?)";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getCount());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error" + e);
            //throw new RuntimeException(e);
            return false;
        }finally {
            try{
                con.close();
            }catch (SQLException e){
                System.out.println("Error" + e);
                //throw new RuntimeException(e);
            }
        }
    }


    public boolean modificar(Product product){
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE product SET code=?, name=?, price=?, count=? WHERE id=?";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getCount());
            ps.setInt(5, product.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error" + e);
            //throw new RuntimeException(e);
            return false;
        }finally {
            try{
                con.close();
            }catch (SQLException e){
                System.out.println("Error" + e);
                //throw new RuntimeException(e);
            }
        }
    }


    public boolean eliminar(Product product){
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM product WHERE id=?";

        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, product.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error" + e);
            //throw new RuntimeException(e);
            return false;
        }finally {
            try{
                con.close();
            }catch (SQLException e){
                System.out.println("Error" + e);
                //throw new RuntimeException(e);
            }
        }
    }


    public boolean buscar(Product product){
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs= null;

        String sql = "SELECT * FROM product WHERE code=?";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getCode());
            rs = ps.executeQuery();

            if(rs.next()){
                product.setId(Integer.parseInt(rs.getString("id")));
                product.setCode(rs.getString("code"));
                product.setName(rs.getString("name"));
                product.setPrice(Double.parseDouble(rs.getString("price")));
                product.setCount(Integer.parseInt(rs.getString("count")));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Error" + e);
            //throw new RuntimeException(e);
            return false;
        }finally {
            try{
                con.close();
            }catch (SQLException e){
                System.out.println("Error" + e);
                //throw new RuntimeException(e);
            }
        }
    }

}
