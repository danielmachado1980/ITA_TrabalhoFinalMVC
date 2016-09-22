/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.UsuarioDAOImpl;

/**
 *
 * @author Daniel
 */
@WebServlet(urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();
        
        String senha = request.getParameter("senha");
        String login = request.getParameter("login");
                
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        usuario = usuarioDAO.recuperar(login);
        
        if(usuario.getSenha().equals(senha))
            response.sendRedirect(request.getContextPath() + "/Topicos");
        else
            response.sendRedirect(request.getContextPath() + "/");
    }
}
