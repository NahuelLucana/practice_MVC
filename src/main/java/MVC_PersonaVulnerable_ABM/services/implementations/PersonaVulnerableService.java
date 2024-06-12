package MVC_PersonaVulnerable_ABM.services.implementations;

import MVC_PersonaVulnerable_ABM.models.entities.PersonaVulnerable;
import MVC_PersonaVulnerable_ABM.models.repositories.interfaces.IPersonaVulnerableRepository;
import MVC_PersonaVulnerable_ABM.services.dtos.inputs.PersonaVulnerableInputDTO;
import MVC_PersonaVulnerable_ABM.services.dtos.outputs.PersonaVulnerableOutputDTO;
import MVC_PersonaVulnerable_ABM.services.interfaces.IPersonaVulnerableService;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class PersonaVulnerableService implements IPersonaVulnerableService {
    private IPersonaVulnerableRepository personaVulnerableRepository;

    public PersonaVulnerableService(IPersonaVulnerableRepository repositorioAGuardar){
        this.personaVulnerableRepository = repositorioAGuardar;
    }
    @Override
    public PersonaVulnerableOutputDTO crear(PersonaVulnerableInputDTO persona){
        System.out.println("Ejecutando el crear() del service...");

        //Se puede hacer validaciones de usuario, de la persona, etc.

        ////Guardado hacia el repositorio

        //Creo la instancia de personaVulnerable
        System.out.println("Instanciando la persona vulnerable para ser guardado en su respectivo repositorio...");
        LocalDate fechaDeRegistro = LocalDate.now();
        PersonaVulnerable personaVulnerableAGuardar = new PersonaVulnerable(persona.getNombre(),persona.getNacimiento());
        personaVulnerableAGuardar.setFechaRegitrado(fechaDeRegistro);
        System.out.println("Finaliza la instanciación.");
        //Guardo la instancia de persona vulnerable hacia el repositorio
        System.out.println("Ejecutando la llamada al guardar() del repositorio desde el service para el guardado de: " + personaVulnerableAGuardar.getNombre()+ " ..." );
        personaVulnerableRepository.guardar(personaVulnerableAGuardar); //Ya esta testeado asi que si quiero testear este service puedo mockear el repositorio.
        System.out.println("Finaliza la llamada guardar() al repositorio desde el service.");
        //OutputDTO
        System.out.println("Inicio de instanciación y configuración de outputDTO");
        PersonaVulnerableOutputDTO outputDTO = new PersonaVulnerableOutputDTO();
        outputDTO.setNombre(persona.getNombre());
        outputDTO.setFechaNacimiento(persona.getNacimiento());
        outputDTO.setFechaDeRegistro(fechaDeRegistro);
        System.out.println("Finaliza instanciación y se procede a retornar el outputDTO");
        return outputDTO;
    }
}
