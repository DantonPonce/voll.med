package med.voll.api.doctors;

import med.voll.api.address.DataAddress;

public record DataDoctors(
        String name,
        String email,
        String crm,
        Specialties specialties,
        DataAddress address) {
}
