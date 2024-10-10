package med.voll.api.doctors;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.DataAddress;

public record DataUpdateDoctors(

        @NotNull
        Long id,

        String name,
        String phoneNumber,
        DataAddress address
) {
}
