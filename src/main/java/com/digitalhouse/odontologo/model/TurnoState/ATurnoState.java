package com.digitalhouse.odontologo.model.TurnoState;

import com.digitalhouse.odontologo.model.Persona;
import com.digitalhouse.odontologo.model.Turno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public abstract class ATurnoState implements ITurnoState{
    /**
     * @param persona representa al usuario que que opera el turno.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany
    private Persona persona;

    @OneToOne
    private Turno turno;

    public ATurnoState (Persona persona){
        this.persona = persona;
    }

}
