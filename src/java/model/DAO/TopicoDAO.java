/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Topico;

/**
 *
 * @author daniel
 */
public class TopicoDAO extends BaseDAO {
    
	public void inserir(Topico topico) throws Exception {
		String sql = "INSERT INTO topico(titulo, conteudo, login) VALUES (?, ?, ?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, topico.getTitulo());
			stm.setString(2, topico.getConteudo());
			stm.setString(3, topico.getLogin());
			stm.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao tentar inserir tópico",e);
		}
	}
        
        public List<Topico> listar() throws Exception {
		String sql = "SELECT * FROM topico";
                List<Topico> lstTopicos = new ArrayList<>();
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				Topico topico = new Topico();
                                UsuarioDAOImpl dao = new UsuarioDAOImpl();
                                topico.setCodigo(rs.getInt("id_topico"));
				topico.setLogin(rs.getString("login"));
				topico.setTitulo(rs.getString("titulo"));
                                topico.setConteudo(rs.getString("conteudo"));
                                topico.setUsuario(dao.recuperar(topico.getLogin()));
				lstTopicos.add(topico);
			}
		} catch (Exception e) {
			throw new Exception("Erro ao tentar listar tópicos",e);
		}
                return lstTopicos;
	}
}
