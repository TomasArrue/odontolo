package com.digitalhouse.odontologo.repository.dao.impl;

import com.digitalhouse.odontologo.repository.dao.IDao;
import com.digitalhouse.odontologo.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {
    /**
     * @deprecated
     */
    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:./database/myDataBase";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    public Connection getConection()throws Exception{
        Class.forName(DB_JDBC_DRIVER).newInstance();
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    @Override
    public Paciente guardar(Paciente paciente) {
        /*
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("INSERT INTO paciente VALUES(?,?,?,?,?);");
            p.setInt(1,paciente.getId());
            p.setInt(2,paciente.getUsuarioID());
            p.setInt(3,paciente.getPersonaID());
            p.setInt(4,paciente.getDomicilioID());
            p.setString(5,paciente.getFechaAlta());

            p.execute();
            p.close();
            logger.info("El paciente fue guardado exitosamente");
        } catch (Exception e){
            logger.error("No se pudo guardar el paciente correctamente debido a: " + e);
        }

         */
        return null;
    }

    @Override
    public Paciente buscar(Integer id) {
        /*
        Paciente paciente = new Paciente();
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("SELECT * FROM paciente WHERE id = ?;");
            p.setInt(1,id);
            ResultSet result = p.executeQuery();
            logger.info("Busqueda finalizada");
            while (result.next()){
                paciente.setId(result.getInt("id"));
                paciente.setUsuarioID(result.getInt("usuarioID"));
                paciente.setPersonaID(result.getInt("personaID"));
                paciente.setDomicilioID(result.getInt("domicilioID"));
                paciente.setFechaAlta(result.getString("fechaAlta"));
            }
            p.close();
        }
        catch (Exception e){
            logger.error("No se pudo encontrar debido a: " + e);
        }

         */
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("DELETE FROM paciente WHERE id = ?;");
            p.setInt(1, id);
            p.executeUpdate();
            p.close();
            logger.info("El paciente fue eliminado");
        } catch (Exception e){
            logger.error("No se pudo eliminar el paciente correctamente debido a : " + e);
        }
    }

    @Override
    public Paciente modificar(Integer id, Object valorAModificar, String campoAModificar) {
        return null;
    }

    @Override
    public List<Paciente> buscartodos() {
        /*
        List<Paciente> pacientes = new ArrayList<>();
        try {
            Connection con = getConection();
            PreparedStatement p = con.prepareStatement("SELECT * FROM paciente;");
            ResultSet result = p.executeQuery();
            while (result.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(result.getInt("id"));
                paciente.setUsuarioID(result.getInt("usuarioID"));
                paciente.setPersonaID(result.getInt("personaID"));
                paciente.setDomicilioID(result.getInt("domicilioID"));
                paciente.setFechaAlta(result.getString("fechaAlta"));

                pacientes.add(paciente);
            }
            p.close();
            logger.info("Busqueda finalizada");
        } catch (Exception e){
            logger.error("No se pudieron mostrar todos lo pacientes debido a: " + e);
        }

         */
        return null;
    }

    @Override
    public void crearTabla() {
        try{
            Connection con = getConection();
            Statement s = getConection().createStatement();
            String script = "CREATE TABLE paciente(id int primary key," +
                    "usuarioId int," +
                    "personaId int," +
                    "domicilioId int," +
                    "fechaAlta varchar (255));";
            s.execute(script);
            s.close();
            logger.info("Tabla paciente creada");
        } catch (Exception e){
            logger.error("No se pudo crear la tabla paciente correctamnte debido a: " + e);
        }
    }

    @Override
    public void eliminarTabla() {
        try{
            Connection con = getConection();
            Statement s = getConection().createStatement();
            String script = "DROP TABLE IF EXISTS paciente;";
            s.execute(script);
            s.close();
            logger.info("Tabla paciente borrada");
        } catch (Exception e){
            logger.error("No se pudo borrar la tabla paciente correctamnte debido a: " + e);
        }
    }
}

