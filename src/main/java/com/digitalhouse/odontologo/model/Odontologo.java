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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String matricula;

    private Integer personaId;
    private Integer usuarioId;

    public Odontologo(String matricula, Integer personaId, Integer usuarioId) {
        this.matricula = matricula;
        this.personaId = personaId;
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", persona=" + personaId +
                ", usuario=" + usuarioId +
                '}';
    }
}
