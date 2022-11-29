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
    @OneToOne
    private Usuario usuario;
    @OneToOne
    private Persona persona;

    private String fechaAlta;

    public Paciente(Usuario usuario, Persona persona, String fechaAlta) {
        this.usuario = usuario;
        this.persona = persona;
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", usuario=" + usuario + '\'' +
                ", persona=" + persona + '\'' +
                ", fechaAlta='" + fechaAlta + '\'' +
                '}';
    }
}
