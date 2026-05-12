<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="co.burguerzona.model.Plato" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<div class="top-bar">
    <h2>&#x1F354; Gestión de Platos</h2>
    <a href="${pageContext.request.contextPath}/WEB-INF/views/platos/formulario.jsp"
       class="btn btn-primary">+ Nuevo Plato</a>
</div>

<%-- Mensaje de error si ocurre uno --%>
<% String error = (String) request.getAttribute("error");
   if (error != null) { %>
    <div class="error-msg"><%= error %></div>
<% } %>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Descripción</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Plato> platos = (List<Plato>) request.getAttribute("platos");
            if (platos != null) {
                for (Plato p : platos) {
        %>
        <tr>
            <td><%= p.getIdPlato() %></td>
            <td><%= p.getNombrePlato() %></td>
            <td>$<%= String.format("%,.0f", p.getPrecio()) %></td>
            <td><%= p.getDescripcion() %></td>
            <td>
                <a href="${pageContext.request.contextPath}/platos?accion=editar&id=<%= p.getIdPlato() %>"
                   class="btn btn-warning">Editar</a>
                <a href="${pageContext.request.contextPath}/platos?accion=eliminar&id=<%= p.getIdPlato() %>"
                   class="btn btn-danger"
                   onclick="return confirm('¿Eliminar este plato?')">Eliminar</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </tbody>
</table>

<%@ include file="/WEB-INF/views/footer.jsp" %>
