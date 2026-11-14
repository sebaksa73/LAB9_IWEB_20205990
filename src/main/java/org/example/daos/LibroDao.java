package org.example.daos;

import org.example.beans.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LibroDao extends BaseDao{
    public ArrayList<Libro> listar() throws SQLException{
        ArrayList<Libro> lista = new ArrayList<>();
        String sql = "SELECT idLibro, titulo, autor, anio_publicacion FROM libro ORDER BY titulo";

        try(Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()){
            while(rs.next()){
                Libro libro = new Libro();
                libro.setIdLibro(rs.getInt("id_libro"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnioPublicacion(rs.getInt("anio_publicacion"));
                lista.add(libro);
            }
        }
        return lista;
    }
}
