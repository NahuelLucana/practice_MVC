package domain;

import MVC_PersonaVulnerable_ABM.models.entities.Persona;
import MVC_PersonaVulnerable_ABM.models.entities.PersonaVulnerable;
import MVC_PersonaVulnerable_ABM.models.repositories.DAOs.interfaces.IPersonaVulnerableDAO;
import MVC_PersonaVulnerable_ABM.models.repositories.DAOs.persistencePlaces.DAOMemory;
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

public class TestDAOsPersonaVulnerable {
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
        personaVulnerableDAO = mock(DAOMemory.class);
        repository.setRepositoryDAO(personaVulnerableDAO); //Ya se que esta instanciado en el constructor, eso fue decisión mia, pero en
        //realidad puede no estar por default en el constructor y ahora para algunos testeos necesito conocer que medio de persistencia usara, en este caso memoria
    }

    @Test
    @DisplayName("Validar que el agregar/alta de una personavulnerable hacia el medio de persistencia se realizo.")
    void agregarPersonaVulnerable(){
        personaVulnerableDAO.guardar(maria);
        verify(personaVulnerableDAO).guardar(maria);
    }
    @Test
    @DisplayName("Validar Remover/eliminar una persona vulnerable del medio de persistencia se realizo")
    void removerPersonaVulnerable(){
        personaVulnerableDAO.guardar(maria); //Ya esta testeado por lo cual se asume que funciona el guardado, y no tengo que testear en este test
        personaVulnerableDAO.eliminar(maria);
        verify(personaVulnerableDAO).eliminar(maria);
    }
    @Test
    @DisplayName("Validar Buscar todas las personas vulnerables del repositorio de personas vulnerables")
    void buscarTodasLasPersonasVulnerables(){
        personaVulnerableDAO.guardar(maria);
        personaVulnerableDAO.guardar(nayeon);
        List<PersonaVulnerable> personasVulnerables = new ArrayList<>();
        personasVulnerables.add(maria);
        personasVulnerables.add(nayeon);
        verify(personaVulnerableDAO).guardar(maria);
        verify(personaVulnerableDAO).guardar(nayeon);
        when(personaVulnerableDAO.buscarTodos()).thenReturn(personasVulnerables);
        Assertions.assertEquals(personasVulnerables,personaVulnerableDAO.buscarTodos());
        verify(personaVulnerableDAO).buscarTodos();
    }
    @Test
    @DisplayName("Validar Buscar a una persona vulnerable especifica mediante el id en el repositorio de personas vulnerables")
    void buscarUnaPersonaVulnerableMedianteElID(){
        personaVulnerableDAO.guardar(nayeon);
        when(personaVulnerableDAO.buscar(1L)).thenReturn(Optional.of(nayeon)); //El id esta setea cuando se quiere guardar, mirar la implementación.
        verify(personaVulnerableDAO).guardar(nayeon);
        Assertions.assertEquals(Optional.of(nayeon),personaVulnerableDAO.buscar(1L));
        verify(personaVulnerableDAO).buscar(1L);
    }
}
