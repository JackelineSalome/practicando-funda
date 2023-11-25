Feature: Actualizar un registro de historial médico

  Scenario: El usuario actualiza un registro de historial médico existente
    Given el usuario proporciona un ID válido y los datos actualizados de un registro de historial médico
    When la solicitud se procesa correctamente
    Then se actualiza el registro de historial médico con los nuevos datos
    And la respuesta contiene los detalles del registro de historial médico actualizado
    And la respuesta tiene el código de estado 200

  Scenario: El usuario intenta actualizar un registro de historial médico con un ID incorrecto
    Given el usuario proporciona un ID válido pero incorrecto y los datos actualizados de un registro de historial médico
    When la solicitud se procesa
    Then la solicitud es rechazada
    And la respuesta tiene el código de estado 400
