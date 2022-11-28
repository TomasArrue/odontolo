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
@Table(name = "domicilios")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "provincia")
    private String provincia;

    @Column(name = "actual")
    private Boolean actual;

    public Domicilio(String calle, Integer numero, String localidad, String provincia, Boolean actual) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
        this.actual = actual;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", actual='" + actual + '\'' +
                '}';
    }
}
