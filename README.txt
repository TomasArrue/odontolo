En la carpeta "imagenes documentacion" se encuantran el grafico que muesta la relacion
de las tablas de la base de datos, y los cambios de estado en turnos.

Cambios y adiciones:

Persona: dado que Pacientes y Odontologos compartian nombre y apellido. Se decicdio combinarlo en una tabla-entidad.
por cuestion de escalabilidad se vinculo el domicilo a persona en lugar de paciente. Tambien se le adiciono campo telefono y dni.
Cada Paciente, Odontologo y Administrador posee un Usuario.

Usuario: el usuario representa la unformacion de login a nuestra aplicacion. Cada Paciente, Odontologo y Administrador posee un Usuario.

Administrativo: Mientras Paciente puede pedir turno con cualquier odontologo, pero solo puede ver sus turnos. Y el Odontologo puede crear turnos
para culquier paciente con el y ver cualquier turno que el tenga. Los Administrativos carecen de esas limitaciones.

Estado Turno: Se 

-Disponible  indica que este turno no a sido solicitado por nadie; y esta libre para ser solicitado.

-Bloqueado   impide que otras personas puedan acceder a este turno, mientras la misma persona confinrma que lo tomara.

-Ocupado     indica que este turno no esta disponible.

-Pendiente   espara la confirmacion de su asistencia a la persona apartir de las 48hs previas al turno.

-Confirmado  indica que el usuario confirmo en las 48hs previas al turno que asistira al mismo.

-En Sala     indica que el usuario se presento al establecimiento; y espea ser atendido.

-Finalizado  indica que la persona fue atendido.

-Vencido     indica que la persona no se presento al turno.

la logica no esta implementada y no estoy seguro de como establecer la relacion entre turno y ATurnoState.

- ATurnoState es abstracta. ¿puedo definirla como entidad? ¿como deveria guardar los estados?
turno tiene un atributo persona y ATurnoState tmb podria solo dejarlo en turno. 


Principal problema: las relaciones entre las entidades. no estoy seguro de cuando hacerlo unidireccional-bidireccional; no tengo definido ningun JoinColum JoinColums.
desde donde me veo mejor parado es desde la capa de logica de negocio. Me esta costando extrapolarlo a la base de datos.



Las Capas Service y Controller no estan completas