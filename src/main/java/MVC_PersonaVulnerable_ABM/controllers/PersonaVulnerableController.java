package MVC_PersonaVulnerable_ABM.controllers;


import MVC_PersonaVulnerable_ABM.services.dtos.inputs.PersonaVulnerableInputDTO;
import MVC_PersonaVulnerable_ABM.services.interfaces.IPersonaVulnerableService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaVulnerableController {
    private IPersonaVulnerableService personaVulnerableService;
    public PersonaVulnerableController(IPersonaVulnerableService service){
        this.personaVulnerableService = service;
    }
    public Object crear(Object solicitud) {
        System.out.println("Ejecutando el crear() del controller.....");
        //En la sigueinte línea se debería hacer el mapeo real entre el verdadero input y el DTO
        PersonaVulnerableInputDTO dto = (PersonaVulnerableInputDTO) solicitud;
        return this.personaVulnerableService.crear(dto);
    }

}
