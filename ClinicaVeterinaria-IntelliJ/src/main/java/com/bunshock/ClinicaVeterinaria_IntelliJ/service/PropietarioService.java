package com.bunshock.ClinicaVeterinaria_IntelliJ.service;

import com.bunshock.ClinicaVeterinaria_IntelliJ.model.Propietario;
import com.bunshock.ClinicaVeterinaria_IntelliJ.repository.IPropietarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PropietarioService implements IPropietarioService {

    @Autowired
    private IPropietarioRepository propRepository;

    @Override
    public void savePropietario(Propietario prop) {
        propRepository.save(prop);
    }

    @Override
    public void deletePropietario(Long id) {
        propRepository.deleteById(id);
    }

    @Override
    public List<Propietario> getPropietarios() {
        return propRepository.findAll();
    }

    @Override
    public Propietario getPropietarioById(Long id) {
        return propRepository.findById(id).orElse(null);
    }

    @Override
    public void editPropietario(Long id_original, Long id_nuevo, String dni_nuevo,
                                String nombre_nuevo, String apellido_nuevo, String celular_nuevo) {
        Propietario prop = this.getPropietarioById(id_original);

        if (prop == null) return;

        if (id_nuevo != null) prop.setId(id_nuevo);
        if (dni_nuevo != null) prop.setDni(dni_nuevo);
        if (nombre_nuevo != null) prop.setNombre(nombre_nuevo);
        if (apellido_nuevo != null) prop.setApellido(apellido_nuevo);
        if (celular_nuevo != null) prop.setCelular(celular_nuevo);

        propRepository.save(prop);
    }

}
