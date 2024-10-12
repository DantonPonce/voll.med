package med.voll.api.patients;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.DataAddress;

public record DataPatientUpdate(
        @NotNull
        Long id,
        String name,
        String phoneNumber,
        DataAddress address
) {
}
