package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.Getter;
import med.voll.api.doctors.DataDoctors;
import med.voll.api.doctors.DataListDoctor;
import med.voll.api.doctors.Doctor;
import med.voll.api.doctors.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataDoctors data) {
        System.out.println("Doctor Data: " + data);
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<DataListDoctor> listDoctors(@PageableDefault(size=10, sort={"name"}) Pageable pagination){
        return repository.findAll(pagination).map(DataListDoctor::new);
    }
}
