package med.voll.api.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String neighborhood;
    private String city;
    private String uf;
    private String number;
    private String complement;

    @Column(name = "zip_code")
    private String zipCode;

    public Address(DataAddress data) {
        this.street = data.street();
        this.neighborhood = data.neighborhood();
        this.zipCode = data.zipCode();
        this.city = data.city();
        this.uf = data.uf();
        this.number = data.number();
        this.complement = data.complement();
    }

    public void updateDataAddress(DataAddress data) {
        if(data.street() != null){
            this.street = data.street();
        }

        if(data.neighborhood() != null){
            this.neighborhood = data.neighborhood();
        }

        if(data.zipCode() != null){
            this.zipCode = data.zipCode();
        }

        if(data.city() != null){
            this.city = data.city();
        }

        if(data.uf() != null){
            this.uf = data.uf();
        }

        if(data.number() != null){
            this.number = data.number();
        }

        if(data.complement() != null){
            this.complement = data.complement();
        }
    }
}
