package domain;

import MVC_PersonaVulnerable_ABM.models.repositories.interfaces.IPersonaVulnerableRepository;
import MVC_PersonaVulnerable_ABM.services.dtos.inputs.PersonaVulnerableInputDTO;
import MVC_PersonaVulnerable_ABM.services.dtos.outputs.PersonaVulnerableOutputDTO;
import MVC_PersonaVulnerable_ABM.services.implementations.PersonaVulnerableService;
import MVC_PersonaVulnerable_ABM.services.interfaces.IPersonaVulnerableService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class TestPersonaVulnerableService {
    private IPersonaVulnerableService service;
    private IPersonaVulnerableRepository repository;
    private PersonaVulnerableInputDTO inputDTO;
    private PersonaVulnerableOutputDTO outputDTO;
    @BeforeEach
    public void init(){
        repository = mock(IPersonaVulnerableRepository.class);
        service = new PersonaVulnerableService(repository); //Pude mockaer repository debido a que utilize inyección de dependencia

    }
    @Test
    @DisplayName("Validar que con un inputDTO se generé un outputDTO acorde")
    void validarOutputDTOCrear(){
        //Escenario
        inputDTO = new PersonaVulnerableInputDTO();
        inputDTO.setNombre("Nayeon");
        inputDTO.setNacimiento(LocalDate.of(1997,5,27));
        outputDTO = new PersonaVulnerableOutputDTO();
        outputDTO.setNombre("Nayeon");
        outputDTO.setFechaNacimiento(LocalDate.of(1997,5,27));

        //Acciones
        service.crear(inputDTO);

        //Validaciones
        Assertions.assertEquals(outputDTO.getNombre(),service.crear(inputDTO).getNombre());
        Assertions.assertEquals(outputDTO.getFechaNacimiento(),service.crear(inputDTO).getFechaNacimiento());
    }

}
