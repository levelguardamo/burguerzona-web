<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="co.burguerzona.model.Usuario" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<div class="top-bar">
    <h2>&#x1F464; Gestión de Usuarios</h2>
    <a href="${pageContext.request.contextPath}/WEB-INF/views/usuarios/formulario.jsp"
       class="btn btn-primary">+ Nuevo Usuario</a>
</div>

<% String error = (String) request.getAttribute("error");
   if (error != null) { %>
    <div class="error-msg"><%= error %></div>
<% } %>

<table>
    <thead>
        <tr>
            <th>ID</th><th>Nombre</th><th>Apellidos</th>
            <th>Documento</th><th>Email</th><th>Teléfono</th><th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            if (usuarios != null) {
                for (Usuario u : usuarios) {
        %>
        <tr>
            <td><%= u.getIdUser() %></td>
            <td><%= u.getNombre() %></td>
            <td><%= u.getApellidos() %></td>
            <td><%= u.getTipoDocumento() %> <%= u.getDocumento() %></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getTelefono() %></td>
            <td>
                <a href="${pageContext.request.contextPath}/usuarios?accion=editar&id=<%= u.getIdUser() %>"
                   class="btn btn-warning">Editar</a>
                <a href="${pageContext.request.contextPath}/usuarios?accion=eliminar&id=<%= u.getIdUser() %>"
                   class="btn btn-danger"
                   onclick="return confirm('¿Eliminar este usuario?')">Eliminar</a>
            </td>
        </tr>
        <%  }  }  %>
    </tbody>
</table>

<%@ include file="/WEB-INF/views/footer.jsp" %>
