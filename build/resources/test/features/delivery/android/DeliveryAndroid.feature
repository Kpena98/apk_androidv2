@endtoend
Feature: Flujo  Delivery Android
  Como usuario quiero realizar un pedido delivery

  Background:
    Given Abrir Aplicacion en BrowserStack

  Scenario Outline: flujo de pedido delivery con usuario registrado
    And Seleccionar "<Pais>"
    And Presionar boton Next luego de elegir "<Pais>"
    When Dentro del mercado de "<Pais>" acceder a pedidos y hacer login con "<User>" y "<Pass>" registrada
    Then Iniciar orden tipo delivery indicar "<Direccion>" y seleccionar "<Producto>"
    @regresion
    Examples:
      | Pais                   | User                   | Pass          | Producto |
      |Argentina              | pruebaautoqa@gmail.com |  Pruebas_2022 |           |
      |Brasil                 | pruebaautoqabra@gmail.com |Pruebas_2022         |          |
      |Chile                  | pruebaautoqachi@gmail.com|Pruebas_2022          |          |
      |Colombia               | pruebaautoqacol@gmail.com|Pruebas_2022           |          |
      |Costa Rica             | pruebaautoqacos@gmail.com|Pruebas_2022          |          |
      |México                 | pruebaautoqamex@gmail.com|Pruebas_2022           |          |
      |Panamá                 | pruebaautoqapan@gmail.com|Pruebas_2022          |          |
      |Puerto Rico            | pruebaautoqapuer@gmail.com|Pruebas_2022           |          |
      |Uruguay                | pruebaautoqauru@gmail.com|Pruebas_2022             |          |
    @smokeTest
    Examples:
      | Pais       |     User               | Pass          | Direccion                     | Producto |
   #   |Brasil |  pruebaautoqabra@gmail.com | Pruebas_2022  |           |                   |
      |Chile | pruebaautoqachi@gmail.com | Pruebas_2022  |  Avenida camilo Henríquez 3060, Puente ALto|  McCombo Mediano Doble McFiesta con Queso    |



