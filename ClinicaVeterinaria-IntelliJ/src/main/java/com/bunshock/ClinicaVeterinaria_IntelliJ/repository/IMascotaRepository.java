package com.bunshock.ClinicaVeterinaria_IntelliJ.repository;

import com.bunshock.ClinicaVeterinaria_IntelliJ.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IMascotaRepository extends JpaRepository <Mascota, Long> {

}
