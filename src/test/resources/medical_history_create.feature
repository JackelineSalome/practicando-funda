Feature: Crear un nuevo registro de historial médico

  Scenario: El usuario crea un nuevo registro de historial médico
    Given el usuario proporciona los datos para crear un nuevo registro de historial médico
    When la solicitud se procesa correctamente
    Then se crea un nuevo registro de historial médico
    And la respuesta contiene los detalles del nuevo registro de historial médico
    And la respuesta tiene el código de estado 201
