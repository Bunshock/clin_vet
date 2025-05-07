package com.bunshock.ClinicaVeterinaria_IntelliJ.service;

import com.bunshock.ClinicaVeterinaria_IntelliJ.model.Propietario;
import java.util.List;


public interface IPropietarioService {

    public void savePropietario(Propietario prop);

    public void deletePropietario(Long id);

    public List<Propietario> getPropietarios();

    public Propietario getPropietarioById(Long id);

    public void editPropietario(Long id_original, Long id_nuevo, String dni_nuevo,
                         String nombre_nuevo, String apellido_nuevo, String celular_nuevo);

}
