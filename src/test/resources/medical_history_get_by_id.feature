Feature: Obtener un registro de historial médico por ID

  Scenario: El usuario solicita un registro de historial médico por su ID
    Given el usuario proporciona un ID válido de un registro de historial médico
    When la solicitud se procesa correctamente
    Then se devuelve el registro de historial médico correspondiente
    And la respuesta contiene los detalles del registro de historial médico
    And la respuesta tiene el código de estado 200
