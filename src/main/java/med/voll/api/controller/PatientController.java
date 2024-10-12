package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.patients.*;
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

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataPatientUpdate data){
        var patient = repository.getReferenceById(data.id());
        patient.updateDataPatient(data);
    }

}
