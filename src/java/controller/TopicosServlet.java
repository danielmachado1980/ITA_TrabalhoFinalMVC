/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.TopicoDAO;
import model.Topico;
import model.Usuario;

/**
 *
 * @author Daniel
 */
@WebServlet(urlPatterns = {"/Topicos",
                           "/Topicos/Inserir",
                           "/Topicos/Exibir"})
public class TopicosServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        if(userPath.contains("Inserir")){
            request.getRequestDispatcher("/WEB-INF/view/insereTopico.jsp").forward(request, response);
        }else if(userPath.contains("Exibir")){
            try {
                int topico = Integer.parseInt(request.getParameter("topico"));
                TopicoDAO dao = new TopicoDAO();
                request.setAttribute("topico", dao.recuperar(topico));
                request.getRequestDispatcher("/WEB-INF/view/exibeTopico.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(TopicosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            TopicoDAO dao = new TopicoDAO();
            try {
                request.setAttribute("topicos", dao.listar());
            } catch (Exception ex) {
                Logger.getLogger(TopicosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("/WEB-INF/view/topicos.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        if(userPath.contains("Inserir")){
            Topico topico = new Topico();
            
            String titulo = request.getParameter("titulo");
            String conteudo = request.getParameter("conteudo");
            topico.setTitulo(titulo);
            topico.setConteudo(conteudo);
            topico.setLogin(((Usuario) request.getSession().getAttribute("usuario")).getLogin());
            
            TopicoDAO dao = new TopicoDAO();
            try {
                dao.inserir(topico);
            } catch (Exception ex) {
                Logger.getLogger(TopicosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect(request.getContextPath() + "/Topicos");
        }else if(userPath.contains("Exibir")){
            request.getRequestDispatcher("/WEB-INF/view/exibeTopico.jsp").forward(request, response);
        }else
            request.getRequestDispatcher("/WEB-INF/view/topicos.jsp").forward(request, response);
    }

}
