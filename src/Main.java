import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/estudiantes1";
        String user = "root";
        String password = "123456";
        String sql = "select * from estudiantes1 limit 3";
        Connection conn = null;
        PreparedStatement ps = null;
        System.out.println("Hello and Welcome");

        //establecer Conexion
        /*try (Connection connection= DriverManager.getConnection(url,user,password)) {
            PreparedStatement Statement = connection.prepareStatement(sql);
            ResultSet resultSet = Statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }*/
        String cedula = "0031132615";
        String sql1 = "DELETE FROM estudiantes1  WHERE cedula = ?";

        try{
            conn= DriverManager.getConnection(url, user, password);
            // preparar la sentencia sql
            ps = conn.prepareStatement(sql1);
            //Seteamos los valores de la sentencia previa
            ps.setString(1, cedula);
            System.out.println(sql1);
            int n = ps.executeUpdate();
            System.out.println("Se modificaron: " + n + " Lineas");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            //Cerramos la conexion
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}