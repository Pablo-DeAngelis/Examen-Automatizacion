Feature: Primer ejercicio
  Ingresar a la pagina de MercadoLibre y verificar las categorias y las subcategorias

  @PrimerEjercicio
  Scenario Outline: Verificar la categoria "<Categoria>" y a su subcategoria "<SubCategoria>"
    Given Ingresar a la Web de MercadoLibre
    When Ingresar a la "<Categoria>" y a su "<SubCategoria>"
    Then Se valida la "<SubCategoria>" y la cantidad de resultados

    Examples:
      | Categoria                | SubCategoria          |
      |Hogar y Electrodomésticos |Climatización          |
      |Tecnología                |Celulares y Smartphones|
      |Herramientas e Industrias |Industria Textil       |
      |Juguetes y Bebés          |Cuarto del Bebé        |


