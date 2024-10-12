package med.voll.api.controller;

import med.voll.api.patients.DataCreatePatients;
import med.voll.api.patients.DataPatientList;
import med.voll.api.patients.Patient;
import med.voll.api.patients.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    public void create(@RequestBody DataCreatePatients data){
        // System.out.println(data);
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<DataPatientList> list(@PageableDefault(size=10, sort={"name"}) Pageable pagination){
        return repository.findAll(pagination).map(DataPatientList::new);
    }

}
