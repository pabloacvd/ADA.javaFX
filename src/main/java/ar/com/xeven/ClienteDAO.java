package ar.com.xeven;

import ar.com.xeven.entities.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ClienteDAO {

    public static List<Cliente> getClientes() {
        String dbURL = "jdbc:mysql://localhost/CRMVentas";
        Connection conexion = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conexion = DriverManager.getConnection(dbURL,"root","unafacil");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clientes");
            if(rs!=null)
                while (rs.next())
                    clientes.add(new Cliente(
                            rs.getInt("idCliente"),
                            rs.getString("nombre"),
                            rs.getString("cargo"),
                            rs.getString("empresa")
                    ));
            if(st!=null) st.close();
            if(conexion!=null) conexion.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clientes;
    }


}
