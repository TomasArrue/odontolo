package com.digitalhouse.odontologo.model.TurnoState;

import com.digitalhouse.odontologo.model.Persona;

public class TurnoStateDisponible extends ATurnoState{
    /**
     * El estado disponible indica que este turno no a sido solicitado por nadie; y esta libre para ser solicitado.
     */
    @Override
    public void cambiarEstado(Persona persona) {
        getTurno().setTurnoState(new TurnoStateBloqueado());
    }

    @Override
    public void confirmarEstado(Persona persona) {

    }

    @Override
    public void cancelarEstado(Persona persona) {

    }

}
