package ma.emsi.hospital;

import ma.emsi.hospital.entities.*;
import ma.emsi.hospital.repositories.ConsultationRepo;
import ma.emsi.hospital.repositories.MedecinRepo;
import ma.emsi.hospital.repositories.PatientRepo;
import ma.emsi.hospital.repositories.RendezVousRepo;
import ma.emsi.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	CommandLineRunner start(IHospitalService hospitalService, PatientRepo patientRepo,RendezVousRepo rendezVousRepo,MedecinRepo medecinRepo){
			return args -> {
			Stream.of("Simo","Salim","Sara")
					.forEach(name->{
						Patient patient=new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						hospitalService.savePatient(patient);
					});
			Stream.of("Adam","Reda","Aya")
					.forEach(name->{
						Medecin medecin=new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						hospitalService.saveMedecin(medecin);
					});
			Patient patient=patientRepo.findById(1L).orElse(null);
			Patient patient1=patientRepo.findByNom("");

			Medecin medecin=medecinRepo.findByNom("");

			RendezVous rendezVous= new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			RendezVous saveRDV = rendezVousRepo.save(rendezVous);
			System.out.println(saveRDV.getId());

			RendezVous rendezVous1=rendezVousRepo.findAll().get(0);
			Consultation consultation=new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation ......");
			hospitalService.saveConsultation(consultation);
		};
	}
}


