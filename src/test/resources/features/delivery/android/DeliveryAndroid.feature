@endtoend
Feature: Flujo  Delivery Android
  Como usuario quiero realizar un pedido delivery

  Background:
    Given Abrir Aplicacion en BrowserStack

  Scenario Outline: flujo de pedido delivery con usuario registrado
    And Seleccionar "<Pais>"
    And Presionar boton Next luego de elegir "<Pais>"
    When Dentro del mercado de "<Pais>" acceder a pedidos y hacer login con "<User>" y "<Pass>" registrada
 #   Then Iniciar orden tipo delivery y seleccionar "<Producto>"
    @regresion
    Examples:
      | Pais                   | User                   | Pass          | Producto |
      |Argentina              | pruebaautoqa@gmail.com |  Pruebas_2022 |           |
      |Brasil                 | pruebaautoqa@gmail.com |Pruebas_2022         |          |
      |Chile                  | pruebaautoqa@gmail.com|Pruebas_2022          |          |
      |Colombia               | pruebaautoqa@gmail.com|Pruebas_2022           |          |
      |Costa Rica             | pruebaautoqa@gmail.com|Pruebas_2022          |          |
      |México                 | pruebaautoqa@gmail.com|Pruebas_2022           |          |
      |Panamá                 | pruebaautoqa@gmail.com|Pruebas_2022          |          |
      |Puerto Rico            | pruebaautoqa@gmail.com|Pruebas_2022           |          |
      |Uruguay                | pruebaautoqa@gmail.com|Pruebas_2022             |          |
    @smokeTest
    Examples:
      | Pais       |     User               | Pass          | Producto |
      | Venezuela | pruebaautoqa@gmail.com | Pruebas_2022  |           |
      | Perú | pruebaautoqa@gmail.com | Pruebas_2022  ||
      | Colombia | pruebaautoqa@gmail.com | Pruebas_2022  ||
      | Panamá | pruebaautoqa@gmail.com | Pruebas_2022  |  |
      |Chile |  pruebaautoqa@gmail.com | Pruebas_2022  |   |
      |Argentina | pruebaautoqa@gmail.com | Pruebas_2022  ||




