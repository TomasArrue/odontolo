package com.digitalhouse.odontologo.model;

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
@Table(name = "tuenos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Integer pacienteId;
    private Integer odontologoId;
    private String fecha;
    private boolean confirmacion;

    public Turno(Integer pacienteId, Integer odontologoId, String fecha, Boolean confirmacion) {
        this.pacienteId = pacienteId;
        this.odontologoId = odontologoId;
        this.fecha = fecha;
        this.confirmacion = confirmacion;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", paciente=" + pacienteId +
                ", odontologo=" + odontologoId +
                ", fecha='" + fecha + '\'' +
                ", confirmacion=" + confirmacion +
                '}';
    }
}
