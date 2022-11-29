package com.digitalhouse.odontologo.model;

import com.digitalhouse.odontologo.model.TurnoState.ATurnoState;
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
    @ManyToMany
    private Persona persona;
    @ManyToMany
    private Odontologo odontologo;
    private String fecha;

    @OneToOne
    private ATurnoState turnoState;

    public Turno(Persona persona, Odontologo odontologo, String fecha, ATurnoState turnoState) {
        this.persona = persona;
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.turnoState = turnoState;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", persona=" + persona + '\'' +
                ", odontologo=" + odontologo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", estado=" + turnoState +
                '}';
    }
}
