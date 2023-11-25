Feature: Filtrado en el Historial Médico

Scenario: El usuario filtra su historial médico por categorías
Given el servicio de historial médico está disponible
And el usuario ha iniciado sesión en su cuenta
And el usuario tiene consultas médicas registradas en diferentes categorías (por ejemplo, exámenes, tratamientos, seguimientos)
When el usuario filtra su historial médico por una categoría específica
Then se muestran solo las consultas médicas que pertenecen a la categoría seleccionada
And la respuesta tiene el código de estado 200