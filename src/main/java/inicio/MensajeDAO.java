package inicio;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDAO {

    private static Conexion dbConection = new Conexion();

    public static void crearMensaje(Mensajes mensaje) {

        try (Connection conexion = dbConection.get_connection()) {
            PreparedStatement ps = null;
            String query = "INSERT INTO mensajes( `mensaje`, `autor_mensaje`) VALUES ( ?, ?)";
            ps = conexion.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAutor());
            ps.executeUpdate();
            System.out.println("mensaje actualizado");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void leerMensaje() {
        PreparedStatement psRead = null;
        ResultSet rs = null;
        try (Connection conexion = dbConection.get_connection()) {
            String query = "SELECT * FROM mensajes";
            psRead = conexion.prepareStatement(query);
            rs = psRead.executeQuery();

            while (rs.next()) {
                System.out.println("ID mensaje: " + rs.getInt("id_mensaje"));
                System.out.println("mensaje: " + rs.getString("Mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("                                                  ");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void borrarMensaje(int idMensaje) {

        try(Connection conexion = dbConection.get_connection()){
            PreparedStatement psDelete=null;
            String query="DELETE FROM mensajes WHERE id_mensaje = ?";
            psDelete=conexion.prepareStatement(query);
            psDelete.setInt(1,idMensaje);
            psDelete.executeUpdate();
            System.out.println("mensaje borrado con exito");

        }catch (SQLException exe){
            System.out.println(exe);
        }
    }
    public static void editarMensaje(Mensajes mensaje) {
    }
}
