package com.digitalhouse.odontologo.repository;

import com.digitalhouse.odontologo.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository <Turno, Long> {
}
