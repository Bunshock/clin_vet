package com.bunshock.ClinicaVeterinaria_IntelliJ.repository;

import com.bunshock.ClinicaVeterinaria_IntelliJ.model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPropietarioRepository extends JpaRepository <Propietario, Long> {

}
