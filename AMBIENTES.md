\# BurguerZona - Documentación de Ambientes

\*\*Evidencia GA8-220501096-AA1-EV01\*\*



\---



\## Ambiente de Desarrollo



\### Herramientas y Versiones

| Herramienta | Versión |

|-------------|---------|

| Java JDK | 17.0.12 |

| Spring Boot | 3.2.5 |

| Maven | 3.x |

| Node.js | 18.x |

| React | 18.x |

| SQL Server | 2019 |

| Git | 2.x |



\### Configuración del Backend

\- \*\*Framework:\*\* Spring Boot 3.2.5

\- \*\*Puerto:\*\* 8080

\- \*\*Base de datos:\*\* SQL Server en localhost:1433

\- \*\*Nombre BD:\*\* BurguerZona

\- \*\*Usuario BD:\*\* sa



\### Configuración del Frontend

\- \*\*Framework:\*\* React 18

\- \*\*Puerto:\*\* 3000

\- \*\*URL Backend:\*\* http://localhost:8080



\---



\## Ambiente de Pruebas



\### Pruebas realizadas

| Módulo | Endpoint | Método | Resultado |

|--------|----------|--------|-----------|

| Platos | /api/platos | GET | ✅ OK |

| Platos | /api/platos | POST | ✅ OK |

| Platos | /api/platos/{id} | DELETE | ✅ OK |

| Usuarios | /api/usuarios | GET | ✅ OK |

| Usuarios | /api/usuarios | POST | ✅ OK |

| Pedidos | /api/pedidos | GET | ✅ OK |

| Pedidos | /api/pedidos | POST | ✅ OK |

| Facturas | /api/facturas | GET | ✅ OK |

| Facturas | /api/facturas | POST | ✅ OK |



\### Pasos para ejecutar el proyecto

1\. Iniciar SQL Server: `net start MSSQLSERVER`

2\. Iniciar backend: `cd burguerzona-spring \&\& mvn spring-boot:run`

3\. Iniciar frontend: `cd burguerzona-react \&\& npm start`

4\. Abrir navegador en: http://localhost:3000



\---



\## Repositorio

URL: https://github.com/levelguardamo/burguerzona-web

