<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="co.burguerzona.model.Usuario" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
    boolean esEdicion = (usuario != null);
%>

<h2><%= esEdicion ? "Editar Usuario" : "Nuevo Usuario" %></h2>
<br>

<div class="form-card">
    <form action="${pageContext.request.contextPath}/usuarios" method="post">

        <input type="hidden" name="accion" value="<%= esEdicion ? "actualizar" : "insertar" %>">
        <% if (esEdicion) { %>
            <input type="hidden" name="idUser" value="<%= usuario.getIdUser() %>">
        <% } %>

        <div class="form-group">
            <label>Nombre</label>
            <input type="text" name="nombre" required
                   value="<%= esEdicion ? usuario.getNombre() : "" %>">
        </div>
        <div class="form-group">
            <label>Apellidos</label>
            <input type="text" name="apellidos" required
                   value="<%= esEdicion ? usuario.getApellidos() : "" %>">
        </div>
        <div class="form-group">
            <label>Tipo de documento</label>
            <select name="tipoDocumento">
                <option value="CC" <%= esEdicion && "CC".equals(usuario.getTipoDocumento()) ? "selected" : "" %>>Cédula de Ciudadanía</option>
                <option value="TI" <%= esEdicion && "TI".equals(usuario.getTipoDocumento()) ? "selected" : "" %>>Tarjeta de Identidad</option>
                <option value="CE" <%= esEdicion && "CE".equals(usuario.getTipoDocumento()) ? "selected" : "" %>>Cédula Extranjería</option>
            </select>
        </div>
        <div class="form-group">
            <label>Número de documento</label>
            <input type="text" name="documento" required
                   value="<%= esEdicion ? usuario.getDocumento() : "" %>">
        </div>
        <div class="form-group">
            <label>Teléfono</label>
            <input type="text" name="telefono"
                   value="<%= esEdicion ? usuario.getTelefono() : "" %>">
        </div>
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email"
                   value="<%= esEdicion ? usuario.getEmail() : "" %>">
        </div>
        <div class="form-group">
            <label>Fecha de registro</label>
            <input type="date" name="fechaRegistro"
                   value="<%= esEdicion ? usuario.getFechaRegistro() : "" %>">
        </div>
        <div class="form-group">
            <label>ID Cargo</label>
            <input type="number" name="idCargo" min="1" required
                   value="<%= esEdicion ? usuario.getIdCargo() : "1" %>">
        </div>
        <div class="form-group">
            <label>ID Género</label>
            <input type="number" name="idGenero" min="1" required
                   value="<%= esEdicion ? usuario.getIdGenero() : "1" %>">
        </div>

        <button type="submit" class="btn btn-primary">
            <%= esEdicion ? "Actualizar" : "Guardar" %>
        </button>
        <a href="${pageContext.request.contextPath}/usuarios" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<%@ include file="/WEB-INF/views/footer.jsp" %>
