package com.digitalhouse.odontologo.model.TurnoState;

import com.digitalhouse.odontologo.model.Persona;

public class TurnoStateBloqueado extends ATurnoState{
    /**
     * El estado bloqueado impide que otras personas puedan acceder a este turno,
     *  mientras la persona confinrma que lo tomara.
     */

    @Override
    public void cambiarEstado(Persona persona) {

    }

    @Override
    public void confirmarEstado(Persona persona) {

    }

    @Override
    public void cancelarEstado(Persona persona) {

    }

}
