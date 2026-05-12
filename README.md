# BurguerZona Web — Sistema de Gestión con Servlets y JSP

Aplicación web desarrollada en Java con Servlets, JSP y conexión a SQL Server mediante JDBC.
**Evidencia GA7-220501096-AA2-EV02** | SENA - Análisis y Desarrollo de Software 2025

---

## Tecnologías utilizadas

| Tecnología        | Descripción                          |
|-------------------|--------------------------------------|
| Java              | Lenguaje de programación             |
| Jakarta Servlets  | Controladores HTTP (GET y POST)      |
| JSP               | Vistas dinámicas con Java embebido   |
| JDBC              | Conexión con SQL Server              |
| Apache Tomcat 10  | Servidor de aplicaciones             |
| SQL Server        | Base de datos relacional             |

---

## Estructura del proyecto

```
DanielRestrepo_AA2_EV02/
├── src/co/burguerzona/
│   ├── connection/
│   │   └── ConexionDB.java
│   ├── model/
│   │   ├── Plato.java
│   │   ├── Usuario.java
│   │   ├── Pedido.java
│   │   └── Factura.java
│   ├── dao/
│   │   ├── IPlatoDao.java
│   │   ├── IUsuarioDao.java
│   │   ├── IPedidoDao.java
│   │   ├── IFacturaDao.java
│   │   └── impl/
│   │       ├── PlatoDaoImpl.java
│   │       ├── UsuarioDaoImpl.java
│   │       ├── PedidoDaoImpl.java
│   │       └── FacturaDaoImpl.java
│   └── servlet/
│       ├── PlatoServlet.java
│       ├── UsuarioServlet.java
│       ├── PedidoServlet.java
│       └── FacturaServlet.java
└── WebContent/
    ├── index.jsp
    └── WEB-INF/
        ├── web.xml
        └── views/
            ├── header.jsp
            ├── footer.jsp
            ├── platos/
            │   ├── lista.jsp
            │   └── formulario.jsp
            ├── usuarios/
            │   ├── lista.jsp
            │   └── formulario.jsp
            ├── pedidos/
            │   ├── lista.jsp
            │   └── formulario.jsp
            └── facturas/
                ├── lista.jsp
                └── formulario.jsp
```

---

## Módulos implementados

| Módulo    | GET (listar/editar) | POST (insertar/actualizar) | Eliminar |
|-----------|:-------------------:|:--------------------------:|:--------:|
| Platos    | ✅                  | ✅                         | ✅       |
| Usuarios  | ✅                  | ✅                         | ✅       |
| Pedidos   | ✅                  | ✅                         | ✅       |
| Facturas  | ✅                  | ✅                         | ✅       |

---

## Configuración rápida

Ver el archivo `INSTRUCCIONES_EJECUCION.txt` para el paso a paso completo.
