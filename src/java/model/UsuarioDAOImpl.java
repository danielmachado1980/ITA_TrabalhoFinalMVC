/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.UsuarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class UsuarioDAOImpl extends BaseDAO implements UsuarioDAO {
		
	@Override
	public void inserir(Usuario u) {
		String sql = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, u.getLogin());
			stm.setString(2, u.getEmail());
			stm.setString(3, u.getNome());
			stm.setString(4, u.getSenha());
			stm.setInt(5, u.getPontos());
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Usuario recuperar(String login) {
		String sql = "SELECT * FROM usuario WHERE login = ?";
		Usuario usuario = new Usuario();
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, login);
			ResultSet rs = stm.executeQuery();
			rs.next();
			usuario.setLogin(rs.getString("login"));
			usuario.setNome(rs.getString("nome"));
			usuario.setEmail(rs.getString("email"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setPontos(rs.getInt("pontos"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public void adicionarPontos(String login, int pontos) {
		String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, pontos);
			stm.setString(2, login);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Override
	public List<Usuario> ranking() {
		List<Usuario> lstUsuarios = new ArrayList<>();
		try {
			String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPontos(rs.getInt("pontos"));
				lstUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstUsuarios;
	}
	
}
