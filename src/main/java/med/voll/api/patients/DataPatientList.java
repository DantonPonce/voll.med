package med.voll.api.patients;

public record DataPatientList(
        Long id,
        String name,
        String email,
        String phoneNumber,
        String cpf
) {

    public DataPatientList(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhoneNumber(), patient.getCpf());
    }

}
