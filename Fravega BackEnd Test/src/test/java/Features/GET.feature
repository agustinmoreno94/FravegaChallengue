Feature: Realizar GET para verificacion de recurso '\breweries'

  Scenario: Realizar GET Breweries por name, state y realizar accerts
    Given Se ejecuta un metodo GET con la url "https://api.openbrewerydb.org/breweries/"
    And Se obtiene una lista de cervecerias con "lagunitas" en su key 'name' y se filtra de la lista a los registros con key 'name' "Lagunitas Brewing Co"
    Then Se filtra de la lista a los registros con key 'state' "California" y Se realiza assert de los keys 'id'="761" 'name'="Lagunitas Brewing Co" 'street'="1280 N McDowell Blvd" 'phone'="7077694495"
