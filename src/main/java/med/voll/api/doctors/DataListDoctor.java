package med.voll.api.doctors;

import javax.print.Doc;

public record DataListDoctor(
        String name,
        String email,
        String crm,
        Specialties specialties
) {

    public DataListDoctor(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialties());
    }

}
