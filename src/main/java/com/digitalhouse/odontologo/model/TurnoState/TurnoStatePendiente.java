package com.digitalhouse.odontologo.model.TurnoState;

import com.digitalhouse.odontologo.model.Persona;

public class TurnoStatePendiente extends ATurnoState{
    /**
     * El estado pendiente espara la confirmacion de su asistencia a la persona apartir de las 48hs previas al turno.
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
