package com.bunshock.ClinicaVeterinaria_IntelliJ.service;

import com.bunshock.ClinicaVeterinaria_IntelliJ.dto.MascotaPropDTO;
import com.bunshock.ClinicaVeterinaria_IntelliJ.model.Mascota;
import java.util.List;


public interface IMascotaService {

    void saveMascota(Mascota mascota);

    void deleteMascota(Long id);

    List<Mascota> getMascotas();

    Mascota getMascotaById(Long id);

    void editMascota(Long id_original, Long id_nuevo, String nombre_nuevo,
                            String especie_nuevo, String raza_nuevo, String color_nuevo);

    List<Mascota> getMascotasEspRaz(String especie, String raza);

    List<MascotaPropDTO> getMascotasProp();

}
