package com.digitalhouse.odontologo.repository;

import com.digitalhouse.odontologo.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository <Paciente, Long> {
}
