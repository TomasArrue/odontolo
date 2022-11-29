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
@Table(name = "personas")
public class Persona {
    /**
     * Representa la informacion personal del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private Integer dni;
    @Column(name = "telefono")
    private Long telefono;
    @OneToMany
    private Domicilio domicilio;


    public Persona(String nombre, String apellido, Integer dni, Domicilio domicilio, Long telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre= " + nombre + '\'' +
                ", apellido= " + apellido + '\'' +
                ", dni= " + dni + '\'' +
                ", telefono= " + telefono + '\'' +
                ", domicilio= " + domicilio +
                '}';
    }
}
