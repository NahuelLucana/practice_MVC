package domain;

import MVC_PersonaVulnerable_ABM.models.entities.Persona;
import MVC_PersonaVulnerable_ABM.models.entities.PersonaVulnerable;
import MVC_PersonaVulnerable_ABM.models.repositories.DAOs.persistencePlaces.DAOMemory;
import MVC_PersonaVulnerable_ABM.models.repositories.implementation.PersonasVulnerableRepository;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestRepositories {
    PersonasVulnerableRepository repository;
    PersonaVulnerable maria;
    PersonaVulnerable nayeon;
    Persona mateo;
    Persona diego;
    DAOMemory memoryDAOPersonaVulnerable;
    @BeforeEach
    public void init(){
        mateo = new Persona("Mateo", 12);
        diego = new Persona("Diego", 11);
        maria = new PersonaVulnerable("Maria", LocalDate.of(1996, 7, 21));
        maria.agregarMenorACargo(mateo);
        maria.agregarMenorACargo(diego);
        nayeon =  new PersonaVulnerable("Nayeon", LocalDate.of(1996, 4, 21));
        repository = new PersonasVulnerableRepository();
        memoryDAOPersonaVulnerable = new DAOMemory();
        repository.setRepositoryDAO(memoryDAOPersonaVulnerable); //Ya se que esta instanciado en el constructor, eso fue decisión mia, pero en
        //realidad puede no estar por default en el constructor y ahora para algunos testeos necesito conocer que medio de persistencia usara, en este caso memoria
    }

    @Test
    @DisplayName("Agregar/dar_alta/guardar una persona vulnerable hacia el repositorio de persona vulnerable")
    void agregarPersonaVulnerable(){
        repository.guardar(maria);
        Assertions.assertTrue(memoryDAOPersonaVulnerable.getPersonasVulnerables().contains(maria));
    }
    @Test
    @DisplayName("Remover/eliminar una persona vulnerable del repositorio de persona vulnerables")
    void removerPersonaVulnerable(){
        repository.guardar(maria); //Ya esta testeado por lo cual se asume que funciona el guardado, y no tengo que testear en este test
        repository.eliminar(maria);
        Assertions.assertFalse(memoryDAOPersonaVulnerable.getPersonasVulnerables().contains(maria));
    }
    @Test
    @DisplayName("Buscar todas las personas vulnerables del repositorio de personas vulnerables")
    void buscarTodasLasPersonasVulnerables(){
        repository.guardar(maria);
        repository.guardar(nayeon);
        List<PersonaVulnerable> expectedPersonasVulnerables = new ArrayList<>();
        expectedPersonasVulnerables.add(maria);
        expectedPersonasVulnerables.add(nayeon);
        Assertions.assertEquals(expectedPersonasVulnerables,repository.buscarTodos());
    }
    @Test
    @DisplayName("Buscar a una persona vulnerable especifica mediante el id en el repositorio de personas vulnerables")
    void buscarUnaPersonaVulnerableMedianteElID(){
        nayeon.setId(1L);//Agregue un ID a nayeon de 1, esto en teoria deberia ser parte del constructor pero por simplificar y no cambiar todos los test lo agrego con un set
        repository.guardar(nayeon);
        Assertions.assertEquals(Optional.of(nayeon),repository.buscar(1L));
    }
}
