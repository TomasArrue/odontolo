package com.digitalhouse.odontologo;

import com.digitalhouse.odontologo.repository.dao.impl.OdontologoDaoH2;
import com.digitalhouse.odontologo.repository.dao.impl.PacienteDaoH2;
import com.digitalhouse.odontologo.repository.dao.impl.TurnoDaoH2;
import com.digitalhouse.odontologo.service.OdontologoService;
import com.digitalhouse.odontologo.service.PacienteService;
import com.digitalhouse.odontologo.service.TurnoService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class OdontologoApplication {
	private static final Logger logger = Logger.getLogger(OdontologoApplication.class);
	public static void main(String[] args) {
		File log4jfile = new File("./log4j.properties");
		PropertyConfigurator.configure(log4jfile.getAbsolutePath());
		//SpringApplication.run(OdontologoApplication.class, args);

		PacienteService pacienteService = new PacienteService(new PacienteDaoH2());



		OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
		TurnoService turnoService = new TurnoService(new TurnoDaoH2());
		/*
		Paciente paciente = new Paciente(1,"tomas","arrue",12345,"casa","una fecha");

		Odontologo odontologo = new Odontologo(1,"Diego","vianchi",12345,"MP12345");

		Turno turno = new Turno(1,paciente,odontologo,"fechaaa", false);
		 */

		/*
		logger.info("crear tabla paciente");
		pacienteService.crearTabla();
		logger.info("cargar paciente: " + paciente);
		pacienteService.cargar(paciente);
		logger.info("buscar paciente");
		System.out.println(pacienteService.buscar(paciente.getId()));
		*/

		/*
		logger.info("crear tabla");
		odontologoService.crearTabla();
		logger.info("cargar odontologo: " + odontologo);
		odontologoService.cargar(odontologo);
		logger.info("buscar odontologo");
		System.out.println(odontologoService.buscar(odontologo.getId()));
		*/

		/*
		logger.info("crear tabla");
		turnoService.crearTabla();
		logger.info("cargar turno: " + turno);
		turnoService.cargar(turno);
		logger.info("buscar turno");
		System.out.println(turnoService.buscar(turno.getId()));
		*/






	}

}
