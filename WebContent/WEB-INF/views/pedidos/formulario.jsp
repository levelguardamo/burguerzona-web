<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="co.burguerzona.model.Pedido" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<%
    Pedido pedido = (Pedido) request.getAttribute("pedido");
    boolean esEdicion = (pedido != null);
%>

<h2><%= esEdicion ? "Editar Pedido" : "Nuevo Pedido" %></h2>
<br>

<div class="form-card">
    <form action="${pageContext.request.contextPath}/pedidos" method="post">

        <input type="hidden" name="accion" value="<%= esEdicion ? "actualizar" : "insertar" %>">
        <% if (esEdicion) { %>
            <input type="hidden" name="idPedido" value="<%= pedido.getIdPedido() %>">
        <% } %>

        <div class="form-group">
            <label>ID del Usuario</label>
            <input type="number" name="idUser" min="1" required
                   value="<%= esEdicion ? pedido.getIdUser() : "" %>">
        </div>
        <div class="form-group">
            <label>ID del Plato</label>
            <input type="number" name="idPlato" min="1" required
                   value="<%= esEdicion ? pedido.getIdPlato() : "" %>">
        </div>
        <div class="form-group">
            <label>Fecha del Pedido</label>
            <input type="date" name="fechaPedido" required
                   value="<%= esEdicion ? pedido.getFechaPedido() : "" %>">
        </div>
        <div class="form-group">
            <label>Cantidad</label>
            <input type="number" name="cantidad" min="1" required
                   value="<%= esEdicion ? pedido.getCantidad() : "1" %>">
        </div>

        <button type="submit" class="btn btn-primary">
            <%= esEdicion ? "Actualizar" : "Guardar" %>
        </button>
        <a href="${pageContext.request.contextPath}/pedidos" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<%@ include file="/WEB-INF/views/footer.jsp" %>
