<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<h2>Bienvenido al Sistema de Gestión</h2>
<p style="color:#666; margin-bottom:28px;">Selecciona un módulo para comenzar:</p>

<div style="display:flex; gap:20px; flex-wrap:wrap;">

    <a href="${pageContext.request.contextPath}/platos" style="text-decoration:none;">
        <div style="background:white; border-radius:8px; padding:28px 36px;
                    box-shadow:0 2px 8px rgba(0,0,0,0.08); text-align:center;
                    border-top:4px solid #b71c1c; min-width:200px; transition:transform 0.2s;"
             onmouseover="this.style.transform='translateY(-4px)'"
             onmouseout="this.style.transform='translateY(0)'">
            <div style="font-size:2.5rem;">&#x1F354;</div>
            <div style="font-weight:700; margin-top:10px; color:#b71c1c;">Platos</div>
            <div style="color:#888; font-size:0.85rem; margin-top:4px;">Gestión del menú</div>
        </div>
    </a>

    <a href="${pageContext.request.contextPath}/usuarios" style="text-decoration:none;">
        <div style="background:white; border-radius:8px; padding:28px 36px;
                    box-shadow:0 2px 8px rgba(0,0,0,0.08); text-align:center;
                    border-top:4px solid #1565c0; min-width:200px; transition:transform 0.2s;"
             onmouseover="this.style.transform='translateY(-4px)'"
             onmouseout="this.style.transform='translateY(0)'">
            <div style="font-size:2.5rem;">&#x1F464;</div>
            <div style="font-weight:700; margin-top:10px; color:#1565c0;">Usuarios</div>
            <div style="color:#888; font-size:0.85rem; margin-top:4px;">Clientes y empleados</div>
        </div>
    </a>

    <a href="${pageContext.request.contextPath}/pedidos" style="text-decoration:none;">
        <div style="background:white; border-radius:8px; padding:28px 36px;
                    box-shadow:0 2px 8px rgba(0,0,0,0.08); text-align:center;
                    border-top:4px solid #2e7d32; min-width:200px; transition:transform 0.2s;"
             onmouseover="this.style.transform='translateY(-4px)'"
             onmouseout="this.style.transform='translateY(0)'">
            <div style="font-size:2.5rem;">&#x1F4CB;</div>
            <div style="font-weight:700; margin-top:10px; color:#2e7d32;">Pedidos</div>
            <div style="color:#888; font-size:0.85rem; margin-top:4px;">Registro de pedidos</div>
        </div>
    </a>

    <a href="${pageContext.request.contextPath}/facturas" style="text-decoration:none;">
        <div style="background:white; border-radius:8px; padding:28px 36px;
                    box-shadow:0 2px 8px rgba(0,0,0,0.08); text-align:center;
                    border-top:4px solid #f57c00; min-width:200px; transition:transform 0.2s;"
             onmouseover="this.style.transform='translateY(-4px)'"
             onmouseout="this.style.transform='translateY(0)'">
            <div style="font-size:2.5rem;">&#x1F4C4;</div>
            <div style="font-weight:700; margin-top:10px; color:#f57c00;">Facturas</div>
            <div style="color:#888; font-size:0.85rem; margin-top:4px;">Facturación</div>
        </div>
    </a>

</div>

<%@ include file="/WEB-INF/views/footer.jsp" %>
