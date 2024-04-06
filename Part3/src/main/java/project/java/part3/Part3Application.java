package project.java.part3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import project.java.part3.entities.Patient;
import project.java.part3.repository.PatientRepository;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Part3Application implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(Part3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//        patientRepository.save(new Patient(null, "hamza", new Date(), false, 5));
//        patientRepository.save(new Patient(null, "hamza", new Date(), true, 73));
//        patientRepository.save(new Patient(null, "hamza", new Date(), true, 766));





		List<Patient> patients = patientRepository.findAll();
		patients.forEach(System.out::println);


		int page = 0;
		int size = 2;
		Page<Patient> patientPage = patientRepository.findAll(PageRequest.of(page, size));
		patientPage.forEach(System.out::println);


//		String searchNom = "hamza";
//		List<Patient> patientsByName = patientRepository.findByNomContainingIgnoreCase(searchNom);
//		patientsByName.forEach(System.out::println);


		List<Patient> allPatients = patientRepository.findAll();
//		if (!allPatients.isEmpty()) {
//			Patient patientToDelete = allPatients.get(0);
//			patientRepository.delete(patientToDelete);
//			System.out.println("Patient supprimé : " + patientToDelete);
//		}
	}
}
