<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BurguerZona - Sistema de Gestión</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }

        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #f5f5f5;
            color: #333;
        }

        header {
            background: #b71c1c;
            color: white;
            padding: 16px 32px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        header h1 { font-size: 1.6rem; letter-spacing: 1px; }

        nav a {
            color: white;
            text-decoration: none;
            margin-left: 20px;
            font-weight: 500;
            padding: 6px 12px;
            border-radius: 4px;
            transition: background 0.2s;
        }

        nav a:hover { background: rgba(255,255,255,0.2); }

        .container {
            max-width: 1100px;
            margin: 30px auto;
            padding: 0 20px;
        }

        h2 { margin-bottom: 18px; color: #b71c1c; }

        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 8px rgba(0,0,0,0.08);
        }

        th {
            background: #b71c1c;
            color: white;
            padding: 12px 16px;
            text-align: left;
        }

        td { padding: 10px 16px; border-bottom: 1px solid #eee; }
        tr:last-child td { border-bottom: none; }
        tr:hover td { background: #ffeaea; }

        .btn {
            display: inline-block;
            padding: 8px 16px;
            border-radius: 4px;
            text-decoration: none;
            font-size: 0.85rem;
            font-weight: 600;
            cursor: pointer;
            border: none;
            transition: opacity 0.2s;
        }

        .btn:hover { opacity: 0.85; }
        .btn-primary  { background: #b71c1c; color: white; }
        .btn-warning  { background: #f57c00; color: white; }
        .btn-danger   { background: #c62828; color: white; }
        .btn-secondary{ background: #757575; color: white; }

        .form-card {
            background: white;
            padding: 28px 32px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.08);
            max-width: 580px;
        }

        .form-group { margin-bottom: 16px; }

        label {
            display: block;
            font-weight: 600;
            margin-bottom: 6px;
            color: #555;
        }

        input, select, textarea {
            width: 100%;
            padding: 9px 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 0.95rem;
        }

        input:focus, select:focus { outline: none; border-color: #b71c1c; }

        .error-msg {
            background: #ffebee;
            color: #c62828;
            padding: 12px 16px;
            border-radius: 4px;
            margin-bottom: 16px;
            border-left: 4px solid #c62828;
        }

        .top-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 18px;
        }
    </style>
</head>
<body>
<header>
    <h1>&#x1F354; BurguerZona</h1>
    <nav>
        <a href="${pageContext.request.contextPath}/platos">Platos</a>
        <a href="${pageContext.request.contextPath}/usuarios">Usuarios</a>
        <a href="${pageContext.request.contextPath}/pedidos">Pedidos</a>
        <a href="${pageContext.request.contextPath}/facturas">Facturas</a>
    </nav>
</header>
<div class="container">
