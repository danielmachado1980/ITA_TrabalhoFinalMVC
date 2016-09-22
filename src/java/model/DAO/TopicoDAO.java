/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Topico;
import model.Usuario;

/**
 *
 * @author daniel
 */
public class TopicoDAO extends BaseDAO {
    
	public void inserir(Topico topico) {
		String sql = "INSERT INTO topico(titulo, conteudo, login) VALUES (?, ?, ?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, topico.getTitulo());
			stm.setString(2, topico.getConteudo());
			stm.setString(3, topico.getLogin());
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
