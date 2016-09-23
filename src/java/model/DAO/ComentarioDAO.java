/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Comentario;
import model.Topico;
import model.Usuario;

/**
 *
 * @author daniel
 */
public class ComentarioDAO extends BaseDAO {
    
    public void inserir(Comentario comentario) throws Exception {
		String sql = "INSERT INTO comentario(comentario, login, id_topico) VALUES (?, ?, ?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, comentario.getComentario());
			stm.setString(2, comentario.getLogin());
			stm.setInt(3, comentario.getIdTopico());
			stm.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao tentar inserir comentário",e);
		}
	}

    public List<Comentario> listarPorTopico(int codigo) {
                List<Comentario> lstComentarios = new ArrayList<>();
                String sql = "SELECT * FROM comentario WHERE id_topico = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
                                UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
				Comentario comentario = new Comentario();
				comentario.setLogin(rs.getString("login"));
				comentario.setCodigo(rs.getInt("id_comentario"));
				comentario.setComentario(rs.getString("comentario"));
				comentario.setIdTopico(rs.getInt("id_topico"));
                                comentario.setUsuario(usuarioDAO.recuperar(comentario.getLogin()));
				lstComentarios.add(comentario);
			}
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return lstComentarios;
    }
}
