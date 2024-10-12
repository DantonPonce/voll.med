package med.voll.api.patients;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;

@Table(name = "patients")
@Entity(name = "patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Embedded
    private Address address;

    private boolean active;

    public Patient(DataCreatePatients data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.phoneNumber = data.phoneNumber();
        this.address = new Address(data.address());
    }

    public void updateDataPatient(DataPatientUpdate data) {
        if(data.name() != null){
            this.name = data.name();
        }

        if(data.phoneNumber() != null){
            this.phoneNumber = data.phoneNumber();
        }

        if(data.address() != null){
            this.address.updateDataAddress(data.address());
        }
    }

    public void delete() {
        this.active = false;
    }
}
