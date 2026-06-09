package co.burguerzona.servlet;

import co.burguerzona.dao.impl.UsuarioDaoImpl;
import co.burguerzona.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet que gestiona el CRUD de Usuarios mediante HTTP GET y POST.
 *
 * @author Equipo BurguerZona
 * @version 1.0
 */
public class UsuarioServlet extends HttpServlet {

    private final UsuarioDaoImpl dao = new UsuarioDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");

        if ("nuevo".equals(accion)) {
            req.getRequestDispatcher("/WEB-INF/views/usuarios/formulario.jsp")
               .forward(req, resp);
            return;
        }

        if ("editar".equals(accion)) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                req.setAttribute("usuario", dao.consultarPorId(id));
            } catch (SQLException e) {
                req.setAttribute("error", "Error al cargar usuario: " + e.getMessage());
            }
            req.getRequestDispatcher("/WEB-INF/views/usuarios/formulario.jsp")
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
            List<Usuario> usuarios = dao.consultarTodos();
            req.setAttribute("usuarios", usuarios);
        } catch (SQLException e) {
            req.setAttribute("error", "Error al consultar usuarios: " + e.getMessage());
        }

        req.getRequestDispatcher("/WEB-INF/views/usuarios/lista.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String accion        = req.getParameter("accion");
        String nombre        = req.getParameter("nombre");
        String apellidos     = req.getParameter("apellidos");
        String tipoDoc       = req.getParameter("tipoDocumento");
        String documento     = req.getParameter("documento");
        String telefono      = req.getParameter("telefono");
        String email         = req.getParameter("email");
        String fechaRegistro = req.getParameter("fechaRegistro");
        int    idCargo       = Integer.parseInt(req.getParameter("idCargo"));
        int    idGenero      = Integer.parseInt(req.getParameter("idGenero"));

        try {
            if ("insertar".equals(accion)) {
                dao.insertar(new Usuario(0, nombre, apellidos, tipoDoc, documento,
                                         telefono, email, fechaRegistro, idCargo, idGenero));
            } else if ("actualizar".equals(accion)) {
                int id = Integer.parseInt(req.getParameter("idUser"));
                dao.actualizar(new Usuario(id, nombre, apellidos, tipoDoc, documento,
                                           telefono, email, fechaRegistro, idCargo, idGenero));
            }
        } catch (SQLException e) {
            req.setAttribute("error", "Error al guardar usuario: " + e.getMessage());
        }

        resp.sendRedirect(req.getContextPath() + "/usuarios");
    }
}
