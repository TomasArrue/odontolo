package com.digitalhouse.odontologo.service.impl;

import com.digitalhouse.odontologo.model.Domicilio;
import com.digitalhouse.odontologo.repository.IDomicilioRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Getter
@Setter
@AllArgsConstructor
public class DomicilioServiceImpl implements IDomicilioService{
    private final IDomicilioRepository domicilioRepositori;

    @Override
    public List<Domicilio> findAllDomicilios() {
        return domicilioRepositori.findAll();
    }

    @Override
    public Optional<Domicilio> findDomicilioById(Long id) {
        return domicilioRepositori.findById(id);
    }

    @Override
    public Domicilio saveStudient(Domicilio domicilio) {
        if (domicilio != null){
            return domicilioRepositori.save(domicilio);
        }
        return new Domicilio();
    }

    @Override
    public String deleteDomicilio(Long id) {
        if (domicilioRepositori.findById(id).isPresent()) {
            domicilioRepositori.deleteById(id);
            return "Domicilio con id: " + id + " eliminado.";
        }
        return "Domicilio con id: " + id + " no existe.";
    }

    @Override
    public String updateDomicilio(Domicilio domicilioNuevo) {
        return null;
    }
}
