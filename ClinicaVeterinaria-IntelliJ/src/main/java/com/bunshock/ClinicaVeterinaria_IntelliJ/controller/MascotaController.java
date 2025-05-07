package com.bunshock.ClinicaVeterinaria_IntelliJ.controller;

import com.bunshock.ClinicaVeterinaria_IntelliJ.dto.MascotaPropDTO;
import com.bunshock.ClinicaVeterinaria_IntelliJ.model.Mascota;
import com.bunshock.ClinicaVeterinaria_IntelliJ.service.IMascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    private IMascotaService mascotaService;

    @PostMapping("/crear")
    public String crearMascota(@RequestBody Mascota mascota) {
        mascotaService.saveMascota(mascota);
        return "Mascota creada satisfactoriamente!";
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarMascota(@PathVariable Long id) {
        mascotaService.deleteMascota(id);
        return "La mascota con id " + id + " fue borrada exitosamente";
    }

    @GetMapping("/traer")
    public List<Mascota> traerMascotas() {
        return mascotaService.getMascotas();
    }

    @GetMapping("/traer/{id}")
    public Mascota traerMascotaPorId(@PathVariable Long id) {
        return mascotaService.getMascotaById(id);
    }

    @PutMapping("/editar/{id_original}")
    public Mascota editarMascota(@PathVariable Long id_original,
                                 @RequestParam(required=false, name="id") Long id_nuevo,
                                 @RequestParam(required=false, name="nombre") String nombre_nuevo,
                                 @RequestParam(required=false, name="especie") String especie_nuevo,
                                 @RequestParam(required=false, name="raza") String raza_nuevo,
                                 @RequestParam(required=false, name="color") String color_nuevo) {

        mascotaService.editMascota(id_original, id_nuevo, nombre_nuevo,
                especie_nuevo, raza_nuevo, color_nuevo);

        return mascotaService.getMascotaById(id_original);
    }

    @GetMapping("/traerfiltradas")
    public List<Mascota> traerMascotasFiltradas(@RequestParam String especie,
                                                @RequestParam String raza) {
        return mascotaService.getMascotasEspRaz(especie, raza);
    }

    @GetMapping("traerMascProp")
    public List<MascotaPropDTO> traerListaMascPropDTO() {
        return mascotaService.getMascotasProp();
    }

}
