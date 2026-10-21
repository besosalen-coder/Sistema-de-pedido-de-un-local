  #   Sistema de pedido de un local
Sistema de Pedidos de un Local de Comidas. Sistema en Java que modela el flujo de pedidos de un local de comidas: productos del menú, planes de fidelidad de clientes y medios de pago, calculando el total de cada pedido y la facturación del día. Desarrollado con TDD (Test-Driven Development): cada clase surgió a partir de un test, sin anticipar diseño.  
  Que resuelve?
. Un pedido puede incluir distintos tipos de producto (platos, bebidas, combos) sin que el código pregunte de qué tipo es cada uno.
. El total se calcula en 3 pasos: suma de productos → descuento según el plan del cliente → ajuste del medio de pago.
. Un cliente puede cambiar de plan de fidelidad en cualquier momento, y eso afecta sus próximos pedidos. 
. El local puede calcular su facturación total sumando todos los pedidos del día. 

  Diseño 
. Por qué Producto como interfaz? 	Plato, Bebida y Combo no tienen relación "es un" entre sí, solo comparten el comportamiento de calcular precio
. PlatoDelDia extends ? Porque Plato	y platoDelDia tiene una relacion "es un" y estado compartido (precio base).
. Combo Familiar sin subclase propia porque	la única diferencia con Combo es el % de descuento → se resuelve con un parámetro, no con herencia.
. ModoPago y PlanFidelidad como interfaces	porque no tienen estado compartido, y se usan también fuera del contexto de un pedido. 

Sin un solo instanceof en el código de producción — el polimorfismo resuelve todo.

Tests  16 tests con JUnit 5, cubriendo cada tipo de producto, cada medio de pago, cambio de plan de fidelidad, actualización de precios en caliente, y facturación total.  

src/   → clases de producción test/  → suite de tests JUnit 5 

Cómo correrlo?
Clonar el repo Abrir como proyecto Java en Eclipse (o IDE de preferencia) Run → Run As → JUnit Test sobre la carpeta test Stack

Stack
 Java · JUnit 5 · TDD

Base de Datos y Consultas SQL:
 Diseño Relacional: Creación de tablas funcionales estructuradas para clientes, productos, combos, pedidos y detalles con claves foráneas e integridad referencial.
Validaciones y Reportes (QA): Consultas avanzadas utilizando `JOIN` para la integración de datos y generación de reportes de tickets de compra.
