# CRUD_Pedidos
## Resumen
Microservicio Pedidos que interactua con el microservicio productos, recoge un producto y realiza un pedido sobre el, actualiza el stock dependiendo
de la cantidad de unidades que pida. Además podemos ver una lista de los pedidos que hemos realizado. 
## Estructura
### Paquetes
* com.curso.inicio
  - Clase **Application.java**
* com.curso.model
  - Clase **Pedido.java**
    - idPedido: numero entero
    - codigoProducto: numero entero
    - unidades: numero entero
    - total: numero con decimales, precio del pedido
    - fecha: fecha con hora de la realizacion del pedido
  - Clase **Producto.java**
    - codigoProducto: numero entero
    - producto: nombre del producto
    - stock: numero entero
    - precioUnitario: numero con decimales, precio de cada unidad
* com.curso.dao
  - Clase **PedidosDao.java**
* com.curso.service
  - Interfaz **PedidosService.java**
  - Clase **PedidosServiceImpl.java** (Implementa la interfaz **PedidosService.java**)
* com.curso.controller
  - Clase **PedidosController.java**
  
  > GET: Recojo la lista de los pedidos
  
  > POST: Realizo un pedido

### Metodos
* verPedidos() -> Lista de pedidos almacenados
* realizarPedido(int idPedido,int codigoProducto, int unidades) -> Insertar/Realizar un pedido pasando el id, el codigo del producto y las unidades como parametros
## Autor
* Daniel Rodriguez
## Estado
🟢Terminado🟢
