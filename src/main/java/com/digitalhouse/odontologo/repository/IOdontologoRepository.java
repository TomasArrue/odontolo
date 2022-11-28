package com.digitalhouse.odontologo.repository;

import com.digitalhouse.odontologo.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOdontologoRepository extends JpaRepository <Odontologo, Long> {
}
