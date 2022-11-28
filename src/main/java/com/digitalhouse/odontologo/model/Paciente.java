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
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Integer usuarioID;
    private Integer personaID;
    private Integer domicilioID;
    private String fechaAlta;

    public Paciente(Integer usuarioID, Integer personaID, Integer domicilioID, String fechaAlta) {
        this.usuarioID = usuarioID;
        this.personaID = personaID;
        this.domicilioID = domicilioID;
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", usuario=" + usuarioID +
                ", persona=" + personaID +
                ", domicilio='" + domicilioID + '\'' +
                ", fechaAlta='" + fechaAlta + '\'' +
                '}';
    }
}
