
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="co.burguerzona.model.Factura" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<div class="top-bar">
    <h2>&#x1F4C4; Gestión de Facturas</h2>
    <a href="${pageContext.request.contextPath}/facturas?accion=nuevo"
       class="btn btn-primary">+ Nueva Factura</a>
</div>

<% String error = (String) request.getAttribute("error");
   if (error != null) { %>
    <div class="error-msg"><%= error %></div>
<% } %>

<table>
    <thead>
        <tr>
            <th>ID</th><th>Pedido</th><th>Fecha</th><th>Total</th><th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Factura> facturas = (List<Factura>) request.getAttribute("facturas");
            if (facturas != null) {
                for (Factura f : facturas) {
        %>
        <tr>
            <td><%= f.getIdFactura() %></td>
            <td>Pedido #<%= f.getIdPedido() %></td>
            <td><%= f.getFechaFactura() %></td>
            <td>$<%= String.format("%,.2f", f.getTotal()) %></td>
            <td>
                <a href="${pageContext.request.contextPath}/facturas?accion=editar&id=<%= f.getIdFactura() %>"
                   class="btn btn-warning">Editar</a>
                <a href="${pageContext.request.contextPath}/facturas?accion=eliminar&id=<%= f.getIdFactura() %>"
                   class="btn btn-danger"
                   onclick="return confirm('¿Eliminar esta factura?')">Eliminar</a>
            </td>
        </tr>
        <%  }  }  %>
    </tbody>
</table>

<%@ include file="/WEB-INF/views/footer.jsp" %>
