package com.digitalhouse.odontologo.service;

import com.digitalhouse.odontologo.repository.dao.IDao;
import com.digitalhouse.odontologo.model.Turno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurnoService {
    private IDao<Turno> turnoDao;

    public Turno cargar(Turno turno) {
        return turnoDao.guardar(turno);
    }

    public Turno buscar(Integer id) {
        return turnoDao.buscar(id);
    }

    public void eliminar(Integer id) {
        turnoDao.eliminar(id);
    }

    public List<Turno> buscartodos() {
        return turnoDao.buscartodos();
    }

    public  void borrarTabla(){
        turnoDao.eliminarTabla();
    }

    public  void crearTabla(){
        turnoDao.crearTabla();
    }

}
