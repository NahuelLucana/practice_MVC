package MVC_PersonaVulnerable_ABM.models.entities;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Persona {
    private String nombre;
    private Integer edad;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
