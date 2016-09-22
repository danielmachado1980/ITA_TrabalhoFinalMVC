package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.UsuarioDAOImpl;

/**
 *
 * @author daniel
 */
@WebServlet(urlPatterns = {"/Ranking"})
public class RankingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        request.setAttribute("usuarios", usuarioDAO.ranking());
        request.getRequestDispatcher("/WEB-INF/view/ranking.jsp").forward(request, response);
    }
}
