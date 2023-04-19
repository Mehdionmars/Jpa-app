package ma.emsi.hospital.repositories;

import ma.emsi.hospital.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository<Consultation,Long> {

}