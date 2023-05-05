package com.hedima.persistencia;

import com.hedima.modelo.Consulta;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccesoConsulta extends Conexion{
    public List<Consulta> consultarTodos() throws SQLException, ClassNotFoundException {
      Statement st;
      ResultSet rs;
      List<Consulta> resultado= new ArrayList<>();
      String sql ="Select product_id, product_name, p.category_id, category_name from products p inner join categories c on p.category_id=c.category_id";
      abrirConexion();
      st = miConexion.createStatement();
      rs = st.executeQuery (sql);
      while(rs.next()){
          Consulta c1=new Consulta(
                  rs.getInt(1),
                  rs.getString(2),
                  rs.getInt(3),
                  rs.getString(4)
          );
          resultado.add(c1);

      }
      st.close();
      rs.close();
      cerrar();
      return resultado;



    }

    public List<Consulta> consultaUno(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement st;
        ResultSet rs;
        List<Consulta> resultado = new ArrayList<>();
        String sql="Select product_id, product_name, p.category_id, category_name from products p inner join categories c on p.category_id=c.category_id" +
                " where c.category_id= ?"; //el ? reemplaza al id de "ayer"
        abrirConexion();
        st = miConexion.prepareStatement(sql);
        st.setInt(1,id);
        rs = st.executeQuery();
        while(rs.next()){
            Consulta c1=new Consulta(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4)
            );
            resultado.add(c1);
        }
        rs.close();
        st.close();
        cerrar();
        return resultado;
    }
}
