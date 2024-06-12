package MVC_PersonaVulnerable_ABM.models.repositories.implementation;

import MVC_PersonaVulnerable_ABM.models.entities.PersonaVulnerable;
import MVC_PersonaVulnerable_ABM.models.repositories.DAOs.interfaces.IPersonaVulnerableDAO;
import MVC_PersonaVulnerable_ABM.models.repositories.DAOs.persistencePlaces.DAOMemory;
import MVC_PersonaVulnerable_ABM.models.repositories.interfaces.IPersonaVulnerableRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *  Este repositorio trabaja con persistencia en memoria, osea el lugar de persistencia es la memoria
 */
@Getter
@Setter
public class PersonasVulnerableRepository implements IPersonaVulnerableRepository {
    private IPersonaVulnerableDAO repositoryDAO;

    public PersonasVulnerableRepository() {
        this.repositoryDAO = new DAOMemory(); //El medio a persistir por default es la memoria en este caso, y eso lo declaro mediante el DAOMemory que tiene el accesso a memoria de las personas vulnerables
    }
    //En estos metodos se puede ver el caso de que el repositorio retorna DOM hacia el que llama a estos metodos
    @Override
    public Optional<PersonaVulnerable> buscar(Long id) {
        return repositoryDAO.buscar(id);

    }
    @Override
    public List<PersonaVulnerable> buscarTodos(){
        return repositoryDAO.buscarTodos();
    }
    //En estos metodos se puede ver el transpaso de los Domain Model Objects hacia el repositorio(parametro)
    @Override
    public void guardar(PersonaVulnerable personaVulnerable){
        repositoryDAO.guardar(personaVulnerable);
    }
    @Override
    public void modificar(PersonaVulnerable personaVulnerable){
        //Do nothing
    }
    @Override
    public void eliminar(PersonaVulnerable personaVulnerable){
        repositoryDAO.eliminar(personaVulnerable);
    }

}