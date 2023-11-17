package com.backend.clinica_odontologica.Repository;

import com.backend.clinica_odontologica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {

}
