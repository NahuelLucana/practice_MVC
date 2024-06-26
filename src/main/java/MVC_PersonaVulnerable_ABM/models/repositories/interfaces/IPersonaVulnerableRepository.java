package MVC_PersonaVulnerable_ABM.models.repositories.interfaces;

import MVC_PersonaVulnerable_ABM.models.entities.PersonaVulnerable;

import java.util.List;
import java.util.Optional;

public interface IPersonaVulnerableRepository {
    Optional<PersonaVulnerable> buscar(Long id);
    List<PersonaVulnerable> buscarTodos();
    void guardar(PersonaVulnerable personaVulnerable);
    void modificar(PersonaVulnerable personaVulnerable);
    void eliminar(PersonaVulnerable personaVulnerable);
}
