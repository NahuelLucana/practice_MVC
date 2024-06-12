package MVC_PersonaVulnerable_ABM.services.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonaVulnerableOutputDTO {
    String nombre;
    LocalDate fechaNacimiento;
    LocalDate fechaDeRegistro;
}
