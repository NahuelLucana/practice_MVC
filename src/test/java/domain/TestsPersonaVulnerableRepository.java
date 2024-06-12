package domain;

import MVC_PersonaVulnerable_ABM.models.entities.Persona;
import MVC_PersonaVulnerable_ABM.models.entities.PersonaVulnerable;
import MVC_PersonaVulnerable_ABM.models.repositories.DAOs.interfaces.IPersonaVulnerableDAO;
import MVC_PersonaVulnerable_ABM.models.repositories.implementation.PersonasVulnerableRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class TestsPersonaVulnerableRepository {
    PersonasVulnerableRepository repository;
    PersonaVulnerable maria;
    PersonaVulnerable nayeon;
    Persona mateo;
    Persona diego;
    IPersonaVulnerableDAO personaVulnerableDAO;
    @BeforeEach
    public void init(){
        mateo = new Persona("Mateo", 12);
        diego = new Persona("Diego", 11);
        maria = new PersonaVulnerable("Maria", LocalDate.of(1996, 7, 21));
        maria.agregarMenorACargo(mateo);
        maria.agregarMenorACargo(diego);
        nayeon =  new PersonaVulnerable("Nayeon", LocalDate.of(1996, 4, 21));
        repository = new PersonasVulnerableRepository();
        personaVulnerableDAO = mock(IPersonaVulnerableDAO.class);
        repository.setRepositoryDAO(personaVulnerableDAO); //Ya se que esta instanciado en el constructor, eso fue decisión mia, pero ahora voy a setear
        // un MOCKEO del DAO, NO una implementación real.
    }

    @Test
    @DisplayName("Validar que el agregar/alta de una personavulnerable hacia el medio de persistencia se realizo.")
    void agregarPersonaVulnerable(){
        repository.guardar(maria);
        verify(personaVulnerableDAO).guardar(maria);
    }
    @Test
    @DisplayName("Validar Remover/eliminar una persona vulnerable del medio de persistencia se realizo")
    void removerPersonaVulnerable(){
        repository.guardar(maria);
        repository.eliminar(maria);
        verify(personaVulnerableDAO).eliminar(maria);
    }
    @Test
    @DisplayName("Validar Buscar todas las personas vulnerables del repositorio de personas vulnerables")
    void buscarTodasLasPersonasVulnerables(){
        repository.guardar(maria);  //No testeo la verificación de los guardados de maria y nayeon en el mockeo del DAO, porque ya lo hice en el primer test, por lo cual si no funciona, caeria en el primer test el error
        repository.guardar(nayeon);
        List<PersonaVulnerable> personasVulnerables = new ArrayList<>();
        personasVulnerables.add(maria);
        personasVulnerables.add(nayeon);
        when(personaVulnerableDAO.buscarTodos()).thenReturn(personasVulnerables);
        Assertions.assertEquals(personasVulnerables,repository.buscarTodos());
        verify(personaVulnerableDAO).buscarTodos();
    }
    @Test
    @DisplayName("Validar Buscar a una persona vulnerable especifica mediante el id en el repositorio de personas vulnerables")
    void buscarUnaPersonaVulnerableMedianteElID(){
        repository.guardar(nayeon);
        when(personaVulnerableDAO.buscar(1L)).thenReturn(Optional.of(nayeon)); //El id esta setea cuando se quiere guardar, mirar la implementación.
        Assertions.assertEquals(Optional.of(nayeon),repository.buscar(1L));
        verify(personaVulnerableDAO).buscar(1L);
    }
}
