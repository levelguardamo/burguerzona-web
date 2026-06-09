package co.burguerzona.servlet;

import co.burguerzona.dao.impl.PlatoDaoImpl;
import co.burguerzona.model.Plato;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet que gestiona el CRUD de Platos mediante HTTP GET y POST.
 * GET  → lista todos los platos / carga formulario de edición.
 * POST → inserta, actualiza o elimina según el parámetro "accion".
 *
 * @author Equipo BurguerZona
 * @version 1.0
 */
public class PlatoServlet extends HttpServlet {

    private final PlatoDaoImpl dao = new PlatoDaoImpl();

    /**
     * Maneja peticiones GET: muestra la lista de platos o el formulario de edición.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");

        if ("nuevo".equals(accion)) {
            req.getRequestDispatcher("/WEB-INF/views/platos/formulario.jsp")
               .forward(req, resp);
            return;
        }

        if ("editar".equals(accion)) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                Plato plato = dao.consultarPorId(id);
                req.setAttribute("plato", plato);
            } catch (SQLException e) {
                req.setAttribute("error", "Error al cargar el plato: " + e.getMessage());
            }
            req.getRequestDispatcher("/WEB-INF/views/platos/formulario.jsp")
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
            List<Plato> platos = dao.consultarTodos();
            req.setAttribute("platos", platos);
        } catch (SQLException e) {
            req.setAttribute("error", "Error al consultar platos: " + e.getMessage());
        }

        req.getRequestDispatcher("/WEB-INF/views/platos/lista.jsp").forward(req, resp);
    }

    /**
     * Maneja peticiones POST: inserta o actualiza un plato.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String accion      = req.getParameter("accion");
        String nombrePlato = req.getParameter("nombrePlato");
        double precio      = Double.parseDouble(req.getParameter("precio").replace(",", "."));
        String descripcion = req.getParameter("descripcion");

        try {
            if ("insertar".equals(accion)) {
                dao.insertar(new Plato(0, nombrePlato, precio, descripcion));
            } else if ("actualizar".equals(accion)) {
                int id = Integer.parseInt(req.getParameter("idPlato"));
                dao.actualizar(new Plato(id, nombrePlato, precio, descripcion));
            }
        } catch (SQLException e) {
            req.setAttribute("error", "Error al guardar: " + e.getMessage());
        }

        resp.sendRedirect(req.getContextPath() + "/platos");
    }
}
