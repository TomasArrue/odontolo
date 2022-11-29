package com.digitalhouse.odontologo.repository.dao.impl;

import com.digitalhouse.odontologo.repository.dao.IDao;
import com.digitalhouse.odontologo.model.Turno;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurnoDaoH2 implements IDao<Turno> {
    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:./database/myDataBase";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";
    /*
    private IDao<Paciente> pacienteDaoH2 = new PacienteDaoH2();
    private IDao<Odontologo> odontologoDaoH2 = new OdontologoDaoH2();
    */
    public Connection getConection()throws Exception{
        Class.forName(DB_JDBC_DRIVER).newInstance();
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    @Override
    public Turno guardar(Turno turno) {
        /*

        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("INSERT INTO turno VALUES(?,?,?,?,?);");
            p.setInt(1,turno.getId());
            p.setInt(2,turno.getPacienteId());
            p.setInt(3,turno.getOdontologoId());
            p.setString(4,turno.getFecha());
            p.setBoolean(5,turno.isConfirmacion());
            p.execute();
            p.close();
            logger.info("El turno fue guardado exitosamente");
        } catch (Exception e){
            logger.error("No se pudo guardar el turno correctamente debido a: " + e);
        }

         */
        return null;
    }

    @Override
    public Turno buscar(Integer id) {
        /*
        Turno turno = new Turno();
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("SELECT * FROM turno WHERE id = ?;");
            p.setInt(1,id);
            ResultSet result = p.executeQuery();

            logger.info("Busqueda finalizada");
            while (result.next()){
                turno.setId(result.getInt("id"));
                turno.setPacienteId(result.getInt("pacienteId"));
                turno.setOdontologoId(result.getInt("odontologoId"));
                turno.setFecha(result.getString("fecha"));
                turno.setConfirmacion(result.getBoolean("confirmacion"));
            }
            p.close();
            logger.info("Busqueda finalizada");
        }
        catch (Exception e){
            logger.error("No se pudo encontrar el turno debido a: " + e);
        }

         */
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("DELETE FROM turno WHERE id = ?;");
            p.setInt(1, id);
            p.executeUpdate();
            p.close();
            logger.info("El turno fue eliminado");
        } catch (Exception e){
            logger.error("No se pudo eliminar correctamente debido a : " + e);
        }
    }

    @Override
    public Turno modificar(Integer id, Object valorAModificar, String campoAModificar) {
        return null;
    }

    @Override
    public List<Turno> buscartodos() {
        /*
        List<Turno> turnos = new ArrayList<>();
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("SELECT * FROM turno;");
            ResultSet result = p.executeQuery();
            while (result.next()) {
                Turno turno = new Turno();
                turno.setId(result.getInt("id"));
                turno.setPacienteId(result.getInt("pacienteId"));
                turno.setOdontologoId(result.getInt("odontologoId"));
                turno.setFecha(result.getString("fecha"));
                turno.setConfirmacion(result.getBoolean("confirmacion"));
                turnos.add(turno);
            }
            p.close();
            logger.info("Busqueda finalizada");
        } catch (Exception e){
            logger.error("No se pudieron mostrar todos lo turnos debido a: " + e);
        }

         */
        return null;
    }

    @Override
    public void crearTabla() {
        try{
            Statement s = getConection().createStatement();
            String script = "CREATE TABLE turno(" +
                    "id int primary key," +
                    "pacienteId int," +
                    "odontologoId int," +
                    "fecha varchar (255)," +
                    "confirmacion boolean ," +
                    "CONSTRAINT FK_odontologoId FOREIGN KEY (odontologoId) REFERENCES odontologo(id)," +
                    "CONSTRAINT FK_pacienteId FOREIGN KEY (pacienteId) REFERENCES paciente(id)" +
                    ");";
            s.execute(script);
            s.close();
            logger.info("Tabla turno creada");
        } catch (Exception e){
            logger.error("no se pudo crear la tabla correctamnte debido a: " + e);
        }
    }

    @Override
    public void eliminarTabla() {
        try{
            Statement s = getConection().createStatement();
            String script = "DROP TABLE IF EXISTS turno;";
            s.execute(script);
            s.close();
            logger.info("Tabla turno borrada");
        } catch (Exception e){
            logger.error("no se pudo borrar la tabla correctamnte debido a: " + e);
        }
    }
}
