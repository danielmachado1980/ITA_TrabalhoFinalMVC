/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Usuario;

/**
 *
 * @author daniel
 */
public interface UsuarioDAO {

    public void inserir(Usuario u);

    public Usuario recuperar(String login);

    public void adicionarPontos(String login, int pontos);

    public List<Usuario> ranking();
}
