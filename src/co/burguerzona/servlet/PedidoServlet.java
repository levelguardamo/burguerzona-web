package co.burguerzona.servlet;

import co.burguerzona.dao.impl.PedidoDaoImpl;
import co.burguerzona.model.Pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet que gestiona el CRUD de Pedidos mediante HTTP GET y POST.
 *
 * @author Equipo BurguerZona
 * @version 1.0
 */
public class PedidoServlet extends HttpServlet {

    private final PedidoDaoImpl dao = new PedidoDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");

        if ("nuevo".equals(accion)) {
            req.getRequestDispatcher("/WEB-INF/views/pedidos/formulario.jsp")
               .forward(req, resp);
            return;
        }

        if ("editar".equals(accion)) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                req.setAttribute("pedido", dao.consultarPorId(id));
            } catch (SQLException e) {
                req.setAttribute("error", "Error al cargar pedido: " + e.getMessage());
            }
            req.getRequestDispatcher("/WEB-INF/views/pedidos/formulario.jsp")
               .forward(req, resp);
            return;
        }

        if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                dao.eliminar(id);
            } catch (SQLException e) {
                req.setAttribute("error", "Error al eliminar: " + e.getMessage());
            }
        }

        try {
            List<Pedido> pedidos = dao.consultarTodos();
            req.setAttribute("pedidos", pedidos);
        } catch (SQLException e) {
            req.setAttribute("error", "Error al consultar pedidos: " + e.getMessage());
        }

        req.getRequestDispatcher("/WEB-INF/views/pedidos/lista.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String accion = req.getParameter("accion");
        int    idUser  = Integer.parseInt(req.getParameter("idUser"));
        int    idPlato = Integer.parseInt(req.getParameter("idPlato"));
        String fecha   = req.getParameter("fechaPedido");
        int    cant    = Integer.parseInt(req.getParameter("cantidad"));

        try {
            if ("insertar".equals(accion)) {
                dao.insertar(new Pedido(0, idUser, idPlato, fecha, cant));
            } else if ("actualizar".equals(accion)) {
                int id = Integer.parseInt(req.getParameter("idPedido"));
                dao.actualizar(new Pedido(id, idUser, idPlato, fecha, cant));
            }
        } catch (SQLException e) {
            req.setAttribute("error", "Error al guardar pedido: " + e.getMessage());
        }

        resp.sendRedirect(req.getContextPath() + "/pedidos");
    }
}
