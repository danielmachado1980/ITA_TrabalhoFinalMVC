package controller;

import java.io.IOException;
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
public class RankingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        try {
            request.setAttribute("usuarios", usuarioDAO.ranking());
        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());
        }
        request.getRequestDispatcher("/WEB-INF/view/ranking.jsp").forward(request, response);
    }
}
