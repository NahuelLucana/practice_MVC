package MVC_PersonaVulnerable_ABM.models.repositories;

import MVC_PersonaVulnerable_ABM.models.entities.PersonaVulnerable;
import MVC_PersonaVulnerable_ABM.models.repositories.interfaces.IPersonaVulnerableRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *  Este repositorio trabaja con persistencia en memoria
 */
public class PersonasVulnerableRepository implements IPersonaVulnerableRepository {
        private List<PersonaVulnerable> personasVulnerableEnMemoria;

    public PersonasVulnerableRepository() {
        this.personasVulnerableEnMemoria = new ArrayList<>();
    }

    @Override
    public Optional<PersonaVulnerable> buscar(Long id) {
        return this.personasVulnerableEnMemoria
                .stream()
                .filter(personaVulnerableABuscar -> personaVulnerableABuscar.getId().equals(id))
                .findFirst();
    }
    @Override
    public List<PersonaVulnerable> buscarTodos(){
        return this.personasVulnerableEnMemoria;
    }
    @Override
    public void guardar(PersonaVulnerable personaVulnerable){
        this.personasVulnerableEnMemoria.add(personaVulnerable);
    }
    public void modificar(PersonaVulnerable personaVulnerable){
        //Do nothing
    }
    public void eliminar(PersonaVulnerable personaVulnerable){
        this.personasVulnerableEnMemoria.remove(personaVulnerable);
    }

}