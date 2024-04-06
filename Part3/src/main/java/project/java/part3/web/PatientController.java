package project.java.part3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.java.part3.repository.PatientRepository;
import project.java.part3.entities.Patient;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    // Endpoint pour afficher la liste des patients
    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
                        @RequestParam(name = "size", defaultValue = "4") int s,
                        @RequestParam(name = "keyword", defaultValue = "") String kw) {
        Page<Patient> patientPage = patientRepository.findByNomContains(kw,PageRequest.of(p, s));
        List<Patient> patientList = patientPage.getContent();
        model.addAttribute("listPatients", patientList);
        model.addAttribute("pages", new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage", p);
        model.addAttribute("keyword",kw);
        return "patient";
    }
    @GetMapping("/delete")
    public String  delete(Long id,String keyword,int page)
    {
     patientRepository.deleteById(id);
     return "redirect:/index?page="+page+"&keyword="+keyword;
    }




}
