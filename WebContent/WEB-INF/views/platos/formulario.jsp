<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="co.burguerzona.model.Plato" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<%
    Plato plato = (Plato) request.getAttribute("plato");
    boolean esEdicion = (plato != null);
%>

<h2><%= esEdicion ? "Editar Plato" : "Nuevo Plato" %></h2>
<br>

<div class="form-card">
    <form action="${pageContext.request.contextPath}/platos" method="post">

        <input type="hidden" name="accion" value="<%= esEdicion ? "actualizar" : "insertar" %>">

        <% if (esEdicion) { %>
            <input type="hidden" name="idPlato" value="<%= plato.getIdPlato() %>">
        <% } %>

        <div class="form-group">
            <label for="nombrePlato">Nombre del plato</label>
            <input type="text" id="nombrePlato" name="nombrePlato" required
                   value="<%= esEdicion ? plato.getNombrePlato() : "" %>">
        </div>

        <div class="form-group">
            <label for="precio">Precio</label>
            <input type="number" id="precio" name="precio" step="0.01" min="0" required
                   value="<%= esEdicion ? plato.getPrecio() : "" %>">
        </div>

        <div class="form-group">
            <label for="descripcion">Descripción</label>
            <textarea id="descripcion" name="descripcion" rows="3"><%= esEdicion ? plato.getDescripcion() : "" %></textarea>
        </div>

        <button type="submit" class="btn btn-primary">
            <%= esEdicion ? "Actualizar" : "Guardar" %>
        </button>
        <a href="${pageContext.request.contextPath}/platos" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<%@ include file="/WEB-INF/views/footer.jsp" %>
