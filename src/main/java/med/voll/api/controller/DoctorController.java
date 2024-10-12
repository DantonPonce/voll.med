package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.doctors.*;
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
    public void create(@RequestBody @Valid DataCreateDoctors data) {
        System.out.println("Doctor Data: " + data);
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<DataListDoctor> list(@PageableDefault(size=10, sort={"name"}) Pageable pagination){
        return repository.findAllByActiveTrue(pagination).map(DataListDoctor::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataDoctorUpdate data){
        var doctor = repository.getReferenceById(data.id());
        doctor.updateDataDoctor(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.delete();
    }
}
