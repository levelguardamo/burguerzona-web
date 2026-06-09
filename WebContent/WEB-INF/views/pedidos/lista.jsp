<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="co.burguerzona.model.Pedido" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<div class="top-bar">
    <h2>&#x1F4CB; Gestión de Pedidos</h2>
    <a href="${pageContext.request.contextPath}/pedidos?accion=nuevo"
       class="btn btn-primary">+ Nuevo Pedido</a>
</div>

<% String error = (String) request.getAttribute("error");
   if (error != null) { %>
    <div class="error-msg"><%= error %></div>
<% } %>

<table>
    <thead>
        <tr>
            <th>ID</th><th>Usuario</th><th>Plato</th>
            <th>Fecha</th><th>Cantidad</th><th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
            if (pedidos != null) {
                for (Pedido p : pedidos) {
        %>
        <tr>
            <td><%= p.getIdPedido() %></td>
            <td>Usuario #<%= p.getIdUser() %></td>
            <td>Plato #<%= p.getIdPlato() %></td>
            <td><%= p.getFechaPedido() %></td>
            <td><%= p.getCantidad() %></td>
            <td>
                <a href="${pageContext.request.contextPath}/pedidos?accion=editar&id=<%= p.getIdPedido() %>"
                   class="btn btn-warning">Editar</a>
                <a href="${pageContext.request.contextPath}/pedidos?accion=eliminar&id=<%= p.getIdPedido() %>"
                   class="btn btn-danger"
                   onclick="return confirm('¿Eliminar este pedido?')">Eliminar</a>
            </td>
        </tr>
        <%  }  }  %>
    </tbody>
</table>

<%@ include file="/WEB-INF/views/footer.jsp" %>
