package org.example;

import MVC_PersonaVulnerable_ABM.controllers.PersonaVulnerableController;
import MVC_PersonaVulnerable_ABM.models.repositories.implementation.PersonasVulnerableRepository;
import MVC_PersonaVulnerable_ABM.models.repositories.interfaces.IPersonaVulnerableRepository;
import MVC_PersonaVulnerable_ABM.services.dtos.inputs.PersonaVulnerableInputDTO;
import MVC_PersonaVulnerable_ABM.services.dtos.outputs.PersonaVulnerableOutputDTO;
import MVC_PersonaVulnerable_ABM.services.implementations.PersonaVulnerableService;
import MVC_PersonaVulnerable_ABM.services.interfaces.IPersonaVulnerableService;

import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private PersonaVulnerableOutputDTO outputDTO;
    public static void main(String[] args) {
        //Instanciaciones
        IPersonaVulnerableRepository repository = new PersonasVulnerableRepository(); //Por default tiene el medio de persistencia de memoria
        IPersonaVulnerableService service = new PersonaVulnerableService(repository);
        PersonaVulnerableController controller = new PersonaVulnerableController(service);
        PersonaVulnerableInputDTO solicitud = new PersonaVulnerableInputDTO();
        solicitud.setNombre("Nayeon");
        solicitud.setNacimiento(LocalDate.of(1996,5,27));
        System.out.println("Solicitud:");
        System.out.println(solicitud.getNombre());
        System.out.println(solicitud.getNacimiento());
        //Controller recibe solicitud(por ahora es un object)
        Object ouput = controller.crear(solicitud);
        PersonaVulnerableOutputDTO ouputDTO = (PersonaVulnerableOutputDTO) ouput;

        System.out.println("Output:");
        System.out.println(ouputDTO.getNombre());
        System.out.println(ouputDTO.getFechaNacimiento());
        System.out.println(ouputDTO.getFechaDeRegistro());
    }
}