Feature: Realizar filtrado en la página Fravega
    como usuario quiero poder filtrar correctamente articulos y poder verificar 3 puntos
    que se muestre el titulo correctamente
    que la cantidad de elementos corresponda a lo mostrado
    que el elemento breadcrumbItem contenga el texto 'Heladeras con Frezzer'

  Scenario: Realizar busqueda de articulo aplicando filtros
    Given el usuario se encuentra en la página home de Fravega
    And el usuario realiza una busqueda del articulo 'Heladeras'
    And el usuario aplica filtro 'Heladera'
    When el usuario aplica filtro 'Samsung'
    Then Se debe verificar 'Samsung' en su title
    Then Se debe verificar la cantidad de elementos mostrados
    Then Se debe verificar que breadcrumbItem contenga el texto 'Heladeras con Frezzer'
