package co.burguerzona.servlet;

import co.burguerzona.dao.impl.FacturaDaoImpl;
import co.burguerzona.model.Factura;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet que gestiona el CRUD de Facturas mediante HTTP GET y POST.
 *
 * @author Equipo BurguerZona
 * @version 1.0
 */
public class FacturaServlet extends HttpServlet {

    private final FacturaDaoImpl dao = new FacturaDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");

        if ("nuevo".equals(accion)) {
            req.getRequestDispatcher("/WEB-INF/views/facturas/formulario.jsp")
               .forward(req, resp);
            return;
        }

        if ("editar".equals(accion)) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                req.setAttribute("factura", dao.consultarPorId(id));
            } catch (SQLException e) {
                req.setAttribute("error", "Error al cargar factura: " + e.getMessage());
            }
            req.getRequestDispatcher("/WEB-INF/views/facturas/formulario.jsp")
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
            List<Factura> facturas = dao.consultarTodos();
            req.setAttribute("facturas", facturas);
        } catch (SQLException e) {
            req.setAttribute("error", "Error al consultar facturas: " + e.getMessage());
        }

        req.getRequestDispatcher("/WEB-INF/views/facturas/lista.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String accion   = req.getParameter("accion");
        int    idPedido = Integer.parseInt(req.getParameter("idPedido"));
        String fecha    = req.getParameter("fechaFactura");
        double total    = Double.parseDouble(req.getParameter("total").replace(",", "."));

        try {
            if ("insertar".equals(accion)) {
                dao.insertar(new Factura(0, idPedido, fecha, total));
            } else if ("actualizar".equals(accion)) {
                int id = Integer.parseInt(req.getParameter("idFactura"));
                dao.actualizar(new Factura(id, idPedido, fecha, total));
            }
        } catch (SQLException e) {
            req.setAttribute("error", "Error al guardar factura: " + e.getMessage());
        }

        resp.sendRedirect(req.getContextPath() + "/facturas");
    }
}
