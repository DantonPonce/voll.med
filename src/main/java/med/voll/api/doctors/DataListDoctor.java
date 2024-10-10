package med.voll.api.doctors;

import javax.print.Doc;

public record DataListDoctor(
        Long id,
        String name,
        String email,
        String crm,
        Specialties specialties
) {

    public DataListDoctor(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialties());
    }

}
