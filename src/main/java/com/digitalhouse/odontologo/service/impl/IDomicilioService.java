package com.digitalhouse.odontologo.service.impl;


import com.digitalhouse.odontologo.model.Domicilio;

import java.util.List;
import java.util.Optional;

public interface IDomicilioService {
    List<Domicilio> findAllDomicilios();

    Optional<Domicilio> findDomicilioById(Long id);

    Domicilio saveStudient(Domicilio domicilio);

    String deleteDomicilio(Long id);

    String updateDomicilio(Domicilio domicilioNuevo);

}
