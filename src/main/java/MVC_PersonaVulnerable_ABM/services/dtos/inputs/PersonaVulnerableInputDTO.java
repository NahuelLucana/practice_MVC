package MVC_PersonaVulnerable_ABM.services.dtos.inputs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonaVulnerableInputDTO {
    String nombre;
    LocalDate nacimiento;
    Long id;
}
