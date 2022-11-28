package com.digitalhouse.odontologo.model.TurnoState;

import com.digitalhouse.odontologo.model.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ATurnoState implements ITurnoState{
    /**
     * @param persona representa al usuario que que opera el turno.
     */
    private Persona persona;


}
