package com.digitalhouse.odontologo.service;

import com.digitalhouse.odontologo.repository.dao.IDao;
import com.digitalhouse.odontologo.model.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteService {
    private IDao<Paciente> pacienteDao;

    public Paciente cargar(Paciente paciente) {
        return pacienteDao.guardar(paciente);
    }

    public Paciente buscar(Integer id) {
        return pacienteDao.buscar(id);
    }

    public void eliminar(Integer id) {
        pacienteDao.eliminar(id);
    }

    public List<Paciente> buscartodos() {
        return pacienteDao.buscartodos();
    }

    public  void borrarTabla(){
        pacienteDao.eliminarTabla();
    }

    public  void crearTabla(){
        pacienteDao.crearTabla();
    }
}
