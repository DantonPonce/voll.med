package med.voll.api.doctors;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.DataAddress;

public record DataDoctorUpdate(

        @NotNull
        Long id,
        String name,
        String phoneNumber,
        DataAddress address
) {
}
