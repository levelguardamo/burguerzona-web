<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="co.burguerzona.model.Factura" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<%
    Factura factura = (Factura) request.getAttribute("factura");
    boolean esEdicion = (factura != null);
%>

<h2><%= esEdicion ? "Editar Factura" : "Nueva Factura" %></h2>
<br>

<div class="form-card">
    <form action="${pageContext.request.contextPath}/facturas" method="post">

        <input type="hidden" name="accion" value="<%= esEdicion ? "actualizar" : "insertar" %>">
        <% if (esEdicion) { %>
            <input type="hidden" name="idFactura" value="<%= factura.getIdFactura() %>">
        <% } %>

        <div class="form-group">
            <label>ID del Pedido</label>
            <input type="number" name="idPedido" min="1" required
                   value="<%= esEdicion ? factura.getIdPedido() : "" %>">
        </div>
        <div class="form-group">
            <label>Fecha de Factura</label>
            <input type="date" name="fechaFactura" required
                   value="<%= esEdicion ? factura.getFechaFactura() : "" %>">
        </div>
        <div class="form-group">
            <label>Total</label>
            <input type="number" name="total" step="0.01" min="0" required
                   value="<%= esEdicion ? factura.getTotal() : "" %>">
        </div>

        <button type="submit" class="btn btn-primary">
            <%= esEdicion ? "Actualizar" : "Guardar" %>
        </button>
        <a href="${pageContext.request.contextPath}/facturas" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<%@ include file="/WEB-INF/views/footer.jsp" %>
