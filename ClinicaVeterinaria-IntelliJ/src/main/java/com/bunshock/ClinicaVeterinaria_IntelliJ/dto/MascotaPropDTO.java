package com.bunshock.ClinicaVeterinaria_IntelliJ.dto;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class MascotaPropDTO {

    // Datos de Mascota
    private String nombre_mascota;
    private String especie;
    private String raza;
    // Datos de Propietario
    private String nombre_prop;
    private String apellido_prop;

    public MascotaPropDTO() {
    }

    public MascotaPropDTO(String nombre_mascota, String especie, String raza,
                          String nombre_prop, String apellido_prop) {
        this.nombre_mascota = nombre_mascota;
        this.especie = especie;
        this.raza = raza;
        this.nombre_prop = nombre_prop;
        this.apellido_prop = apellido_prop;
    }

}
