package com.bunshock.ClinicaVeterinaria_IntelliJ.controller;

import com.bunshock.ClinicaVeterinaria_IntelliJ.model.Propietario;
import com.bunshock.ClinicaVeterinaria_IntelliJ.service.IPropietarioService;
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
@RequestMapping("/propietario")
public class PropietarioController {

    @Autowired
    private IPropietarioService propService;

    @PostMapping("/crear")
    public String crearPropietario(@RequestBody Propietario prop) {
        propService.savePropietario(prop);
        return "Propietario creado satisfactoriamente!";
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarPropietario(@PathVariable Long id) {
        propService.deletePropietario(id);
        return "El propietario con id " + id + " fue borrado exitosamente.";
    }

    @GetMapping("/traer")
    public List<Propietario> traerPropietarios() {
        return propService.getPropietarios();
    }

    @GetMapping("/traer/{id}")
    public Propietario traerPropietarioPorId(@PathVariable Long id) {
        return propService.getPropietarioById(id);
    }

    @PutMapping("/editar/{id_original}")
    public Propietario editarPropietario(@PathVariable Long id_original,
                                         @RequestParam(required=false, name="id") Long id_nuevo,
                                         @RequestParam(required=false, name="dni") String dni_nuevo,
                                         @RequestParam(required=false, name="nombre") String nombre_nuevo,
                                         @RequestParam(required=false, name="apellido") String apellido_nuevo,
                                         @RequestParam(required=false, name="celular") String celular_nuevo) {
        propService.editPropietario(id_original, id_nuevo, dni_nuevo,
                nombre_nuevo, apellido_nuevo, celular_nuevo);

        return propService.getPropietarioById(id_original);
    }

}
