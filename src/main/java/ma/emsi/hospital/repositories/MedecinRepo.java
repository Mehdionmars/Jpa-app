package ma.emsi.hospital.repositories;

import ma.emsi.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepo extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
