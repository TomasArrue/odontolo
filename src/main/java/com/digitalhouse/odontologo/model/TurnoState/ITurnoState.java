package com.digitalhouse.odontologo.model.TurnoState;

import com.digitalhouse.odontologo.model.Persona;

public interface ITurnoState {

    void cambiarEstado(Persona persona);

    void confirmarEstado(Persona persona);

    void cancelarEstado(Persona persona);

}
