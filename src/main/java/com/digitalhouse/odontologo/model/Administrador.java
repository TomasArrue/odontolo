package com.digitalhouse.odontologo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;






@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "administradores")
public class Administrador {
    /**
     * Tipo de usuario con total acceso a la consulta y creacion de turnos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Usuario usuario;
    @OneToOne
    private Persona persona;

    public Administrador(Usuario usuario, Persona persona){
        this.usuario = usuario;
        this.persona = persona;
    }
}
