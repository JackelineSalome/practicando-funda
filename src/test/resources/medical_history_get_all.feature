Feature: Obtener todos los registros de historial médico

  Scenario: El usuario solicita todos los registros de historial médico
    Given el usuario hace una solicitud para obtener todos los registros de historial médico
    When la solicitud se procesa correctamente
    Then se devuelven todos los registros de historial médico existentes
    And la respuesta tiene el código de estado 200
