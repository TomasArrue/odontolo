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
@Table(name = "odontologos")
public class Odontologo{
    /**
     * Tipo de usuario capas de crear turnos con cualquier persona siendo el odontologo.
     * Solo es capas de ver los turnos en los que el sea paciente o el sea odontologo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String matricula;
    @OneToOne
    private Usuario usuario;
    @OneToOne
    private Persona persona;

    public Odontologo(String matricula, Persona persona, Usuario usuario) {
        this.matricula = matricula;
        this.persona = persona;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", persona=" + usuario + '\'' +
                ", usuario=" + persona +
                '}';
    }
}
