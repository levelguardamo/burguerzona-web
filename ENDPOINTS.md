\# BurguerZona - Documentación de Endpoints API REST

\*\*Evidencia GA7-220501096-AA5-EV03\*\*

\*\*Base URL:\*\* http://localhost:8080



\---



\## PLATOS `/api/platos`



| Método | Endpoint | Descripción |

|--------|----------|-------------|

| GET | /api/platos | Lista todos los platos |

| GET | /api/platos/{id} | Obtiene un plato por ID |

| POST | /api/platos | Crea un nuevo plato |

| DELETE | /api/platos/{id} | Elimina un plato por ID |



\*\*Ejemplo respuesta GET /api/platos:\*\*

```json

\[{"idPlato":1,"nombrePlato":"sorrentinos","precio":15000.0,"descripcion":"pasta rellena de carne"}]

```



\---



\## USUARIOS `/api/usuarios`



| Método | Endpoint | Descripción |

|--------|----------|-------------|

| GET | /api/usuarios | Lista todos los usuarios |

| GET | /api/usuarios/{id} | Obtiene un usuario por ID |

| POST | /api/usuarios | Crea un nuevo usuario |

| DELETE | /api/usuarios/{id} | Elimina un usuario por ID |



\*\*Ejemplo respuesta GET /api/usuarios:\*\*

```json

\[{"idUser":7,"nombre":"Juan","apellidos":"Perez","email":"juan@email.com"}]

```



\---



\## PEDIDOS `/api/pedidos`



| Método | Endpoint | Descripción |

|--------|----------|-------------|

| GET | /api/pedidos | Lista todos los pedidos |

| GET | /api/pedidos/{id} | Obtiene un pedido por ID |

| POST | /api/pedidos | Crea un nuevo pedido |

| DELETE | /api/pedidos/{id} | Elimina un pedido por ID |



\*\*Ejemplo respuesta GET /api/pedidos:\*\*

```json

\[{"idPedido":3,"idUser":7,"idPlato":1,"fechaPedido":"2026-05-13","cantidad":12}]

```



\---



\## FACTURAS `/api/facturas`



| Método | Endpoint | Descripción |

|--------|----------|-------------|

| GET | /api/facturas | Lista todas las facturas |

| GET | /api/facturas/{id} | Obtiene una factura por ID |

| POST | /api/facturas | Crea una nueva factura |

| DELETE | /api/facturas/{id} | Elimina una factura por ID |



\*\*Ejemplo respuesta GET /api/facturas:\*\*

```json

\[{"idFactura":2,"idPedido":3,"fechaFactura":"2026-05-13","total":12000.0}]

```

