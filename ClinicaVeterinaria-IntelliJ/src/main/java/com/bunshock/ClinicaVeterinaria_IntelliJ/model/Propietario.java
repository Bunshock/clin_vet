package com.bunshock.ClinicaVeterinaria_IntelliJ.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Propietario {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private String celular;
    @OneToMany(mappedBy="propietario")
    List<Mascota> listaMascotas;

    public Propietario() {
    }

    public Propietario(Long id, String dni, String nombre, String apellido,
                       String celular, List<Mascota> listaMascotas) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.listaMascotas = listaMascotas;
    }

}
