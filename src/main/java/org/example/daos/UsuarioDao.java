package org.example.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao extends BaseDao{
    public boolean existeCorreo(String email) throws SQLException{
        String sql = "SELECT id_usuario FROM usuario WHERE email = ?";
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement((sql))){
            pstmt.setString(1,email);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }
}
