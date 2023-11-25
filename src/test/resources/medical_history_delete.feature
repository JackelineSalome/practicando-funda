Feature: Eliminar un registro de historial médico por ID

  Scenario: El usuario elimina un registro de historial médico existente
    Given el usuario proporciona un ID válido de un registro de historial médico existente
    When la solicitud se procesa correctamente
    Then se elimina el registro de historial médico correspondiente
    And la respuesta tiene el código de estado 200

  Scenario: El usuario intenta eliminar un registro de historial médico con un ID incorrecto
    Given el usuario proporciona un ID válido pero incorrecto de un registro de historial médico
    When la solicitud se procesa
    Then la solicitud es rechazada
    And la respuesta tiene el código de estado 404
