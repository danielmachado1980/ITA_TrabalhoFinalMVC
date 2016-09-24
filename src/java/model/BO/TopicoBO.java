/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.TopicoDAO;
import model.DAO.UsuarioDAOImpl;
import model.Topico;

/**
 *
 * @author Daniel
 */
public class TopicoBO {

    public static void inserir(Topico topico) throws Exception {
        TopicoDAO dao = new TopicoDAO();
        try {
            dao.getConnection().setAutoCommit(false);
            dao.inserir(topico);
            UsuarioDAOImpl usuDAO = new UsuarioDAOImpl();
            usuDAO.setConnection(dao.getConnection());
            usuDAO.adicionarPontos(topico.getLogin(), 10);
            dao.getConnection().commit();
        } catch (Exception ex) {
            dao.getConnection().rollback();
            throw new Exception(ex.getMessage(),ex);
        }
    }
}
