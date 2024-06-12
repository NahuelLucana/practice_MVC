package MVC_PersonaVulnerable_ABM.services.interfaces;

import MVC_PersonaVulnerable_ABM.services.dtos.inputs.PersonaVulnerableInputDTO;
import MVC_PersonaVulnerable_ABM.services.dtos.outputs.PersonaVulnerableOutputDTO;

public interface IPersonaVulnerableService {
    PersonaVulnerableOutputDTO crear(PersonaVulnerableInputDTO persona);
}
