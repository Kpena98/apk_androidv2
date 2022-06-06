@endtoend
Feature: Flujo  Delivery Android
  Como usuario quiero realizar un pedido delivery

  Background:
    Given Abrir Aplicacion en BrowserStack

  Scenario Outline: flujo de pedido delivery con usuario registrado
    And Seleccionar "<Pais>"
    And Presionar boton Next luego de elegir "<Pais>"
    When Dentro del mercado acceder a pedidos y hacer login con "<User>" y "<Pass>" registrada
    Then Seleccionar "<Producto>"
    @regresion
    Examples:
      | Pais                   | User                   | Pass          | Producto |
      | Argentina              | pruebaautoqa@gmail.com | Pruebas_2022  |           |
      |Aruba en Curaçao       |                        |               |         |
      |Brasil                 |                        |               |          |
      |Chile                  |                        |               |          |
      |Colombia               |                        |               |          |
      |Costa Rica             |                        |               |          |
      |Curacao                |                        |               |          |
      |Ecuador                |                        |               |          |
      |Guyane Française       |                        |               |          |
      |Guadeloupe             |                        |               |          |
      |Guatemala              |                        |               |          |
      |Martinique             |                        |               |          |
      |México                 |                        |               |          |
      |Panamá                 |                        |               |          |
      |Perú                   |                        |               |          |
      |Puerto Rico            |                        |               |          |
      |Quality ES             |                        |               |          |
      |St.Croix & St.Thomas   |                        |               |          |
      |Trinidad and Tobago    |                        |               |          |
      |Uruguay                |                        |               |          |
      | Venezuela             |                        |               |          |
    @smokeTest
    Examples:
      | Pais       |     User               | Pass          | Producto |
      | Venezuela | pruebaautoqa@gmail.com | Pruebas_2022  |           |
      | Perú | pruebaautoqa@gmail.com | Pruebas_2022  ||
      | Colombia | pruebaautoqa@gmail.com | Pruebas_2022  ||
      | Panamá | pruebaautoqa@gmail.com | Pruebas_2022  |  |
      |Chile |  pruebaautoqa@gmail.com | Pruebas_2022  |   |
      |Argentina | pruebaautoqa@gmail.com | Pruebas_2022  ||




