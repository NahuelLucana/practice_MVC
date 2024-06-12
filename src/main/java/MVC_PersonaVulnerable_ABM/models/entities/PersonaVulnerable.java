package MVC_PersonaVulnerable_ABM.models.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonaVulnerable {
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaRegitrado;
    private Ubicacion domicilio;
    private Integer documento;
    private List<Persona> menoresACargo;
    private Long id;

    public PersonaVulnerable(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.menoresACargo = new ArrayList<>();
    }

    public int cantidadDeMenoresACargo(){
        return this.getMenoresACargo().size();
    }
    public void agregarMenorACargo(Persona persona){
        this.menoresACargo.add(persona);
    }
}
