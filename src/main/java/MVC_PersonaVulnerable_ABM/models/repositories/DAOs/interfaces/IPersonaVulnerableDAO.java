package MVC_PersonaVulnerable_ABM.models.repositories.DAOs.interfaces;

import MVC_PersonaVulnerable_ABM.models.entities.PersonaVulnerable;

import java.util.List;
import java.util.Optional;

public interface IPersonaVulnerableDAO {
    Optional<PersonaVulnerable> buscar(Long id);
    List<PersonaVulnerable> buscarTodos();
    void guardar(PersonaVulnerable personaVulnerable);
    void modificar(PersonaVulnerable personaVulnerable);
    void eliminar(PersonaVulnerable personaVulnerable);
}
