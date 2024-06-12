package MVC_PersonaVulnerable_ABM.models.repositories.DAOs.persistencePlaces;

import MVC_PersonaVulnerable_ABM.models.entities.PersonaVulnerable;
import MVC_PersonaVulnerable_ABM.models.repositories.DAOs.interfaces.IPersonaVulnerableDAO;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Getter

public class DAOMemory implements IPersonaVulnerableDAO {
    private List<PersonaVulnerable> personasVulnerables;
    public DAOMemory(){
        this.personasVulnerables = new ArrayList<>();
    }
    @Override
    public Optional<PersonaVulnerable> buscar(Long id){
        return this.personasVulnerables
                .stream()
                .filter(personaVulnerableABuscar -> personaVulnerableABuscar.getId().equals(id))
                .findFirst();
    }
    @Override
    public List<PersonaVulnerable> buscarTodos(){
        return this.personasVulnerables;
    }
    @Override
    public void guardar(PersonaVulnerable personaVulnerable){
        personaVulnerable.setId((long) (this.personasVulnerables.size() + 1)); //Aca un efecto de lado hacia la personaVulnerable donde se le setea el id;
        this.personasVulnerables.add(personaVulnerable);
    }
    @Override
    public void modificar(PersonaVulnerable personaVulnerable){

    }
    @Override
    public void eliminar(PersonaVulnerable personaVulnerable){
        this.personasVulnerables.remove(personaVulnerable);
    }

}
