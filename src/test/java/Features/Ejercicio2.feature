Feature: Segundo ejercicio
  Ingresar a la pagina de MercadoLibre y verificar datos de la publicacion

  @SegundoEjercicio
  Scenario Outline: Verificar datos de la publicacion
    Given Ingresar a la Web de MercadoLibre
    When Ingresar a la "<Categoria>" y a su "<SubCategoria>"
    And Se filtra por la ubicacion "<Ubicacion>"
    Then Se ingresa a una publicacion y se verifican los datos

    Examples:
      | Categoria               | SubCategoria|Ubicacion      |
      |Hogar y Electrodomésticos|Lámparas     |Capital Federal|