package med.voll.api.doctors;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.address.Address;

@Table(name = "doctors")
@Entity(name = "doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Specialties specialties;

    @Embedded
    private Address address;

    public Doctor(DataDoctors data) {
        this.name = data.name();
        this.email = data.email();
        this.crm = data.crm();
        this.phoneNumber = data.phoneNumber();
        this.specialties = data.specialties();
        this.address = new Address(data.address());
    }
}
