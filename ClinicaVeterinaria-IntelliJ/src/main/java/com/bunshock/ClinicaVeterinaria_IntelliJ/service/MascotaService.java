package com.bunshock.ClinicaVeterinaria_IntelliJ.service;

import com.bunshock.ClinicaVeterinaria_IntelliJ.dto.MascotaPropDTO;
import com.bunshock.ClinicaVeterinaria_IntelliJ.model.Mascota;
import com.bunshock.ClinicaVeterinaria_IntelliJ.repository.IMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private IMascotaRepository mascotaRepository;

    @Override
    public void saveMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    @Override
    public void deleteMascota(Long id) {
        mascotaRepository.deleteById(id);
    }

    @Override
    public List<Mascota> getMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota getMascotaById(Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    @Override
    public void editMascota(Long id_original, Long id_nuevo, String nombre_nuevo,
                            String especie_nuevo, String raza_nuevo, String color_nuevo) {
        Mascota mascota = this.getMascotaById(id_original);

        if (mascota == null) return;

        if (id_nuevo != null) mascota.setId(id_nuevo);
        if (nombre_nuevo != null) mascota.setNombre(nombre_nuevo);
        if (especie_nuevo != null) mascota.setEspecie(especie_nuevo);
        if (raza_nuevo != null) mascota.setRaza(raza_nuevo);
        if (color_nuevo != null) mascota.setColor(color_nuevo);

        mascotaRepository.save(mascota);
    }

    @Override
    public List<Mascota> getMascotasEspRaz(String especie, String raza) {
        List<Mascota> listaMascotas = this.getMascotas();
        List<Mascota> mascotasFiltradas = new ArrayList<>();

        for (Mascota mascota : listaMascotas) {
            if (mascota.getEspecie().equals(especie) &&
                    mascota.getRaza().equals(raza)) {
                mascotasFiltradas.add(mascota);
            }
        }

        return mascotasFiltradas;
    }

    @Override
    public List<MascotaPropDTO> getMascotasProp() {
        // Obtenemos la lista de mascotas
        List<Mascota> listaMascotas = this.getMascotas();
        // Creamos una lista vacia de DTO y un DTO vacio
        List<MascotaPropDTO> listaMascProp = new ArrayList<>();
        MascotaPropDTO mascProp = new MascotaPropDTO();

        for (Mascota mascota : listaMascotas) {
            // Si la mascota no tiene propietario, saltearsela
            // NOTA: Aca deberiamos asumir que cada mascota registrada en la
            // clinica deberia tener un propietario siempre. Pero para fines
            // de testeo, vamos a agregar esta condicion.
            if (mascota.getPropietario() == null) continue;

            // Datos de Mascota
            mascProp.setNombre_mascota(mascota.getNombre());
            mascProp.setEspecie(mascota.getEspecie());
            mascProp.setRaza(mascota.getRaza());
            // Datos de Propietario
            mascProp.setNombre_prop(mascota.getPropietario().getNombre());
            mascProp.setApellido_prop(mascota.getPropietario().getApellido());

            listaMascProp.add(mascProp);
        }

        return listaMascProp;
    }

}
