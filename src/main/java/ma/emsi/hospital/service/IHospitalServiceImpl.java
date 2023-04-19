package ma.emsi.hospital.service;

import jakarta.transaction.Transactional;
import ma.emsi.hospital.entities.Consultation;
import ma.emsi.hospital.entities.Medecin;
import ma.emsi.hospital.entities.Patient;
import ma.emsi.hospital.entities.RendezVous;
import ma.emsi.hospital.repositories.ConsultationRepo;
import ma.emsi.hospital.repositories.MedecinRepo;
import ma.emsi.hospital.repositories.PatientRepo;
import ma.emsi.hospital.repositories.RendezVousRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    private PatientRepo patientRepo;
    private MedecinRepo medecinRepo;
    private RendezVousRepo rendezVousRepo;
    private ConsultationRepo consultationRepo;

    public IHospitalServiceImpl(PatientRepo patientRepo, MedecinRepo medecinRepo, RendezVousRepo rendezVousRepo, ConsultationRepo consultationRepo) {
        this.patientRepo = patientRepo;
        this.medecinRepo = medecinRepo;
        this.rendezVousRepo = rendezVousRepo;
        this.consultationRepo = consultationRepo;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepo.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepo.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepo.save(consultation);
    }
}
