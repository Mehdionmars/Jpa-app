package ma.emsi.hospital.repositories;

import ma.emsi.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Long> {
    Patient findByNom(String name);
}
