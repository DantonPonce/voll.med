package med.voll.api.patients;

import med.voll.api.address.DataAddress;

public record DataCreatePatients(
        String name,
        String email,
        String phoneNumber,
        String cpf,
        DataAddress address) {
}
