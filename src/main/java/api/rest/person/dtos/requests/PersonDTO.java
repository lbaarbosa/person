package api.rest.person.dtos.requests;

import api.rest.person.entities.Address;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDTO {

    private Long id;

    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    private List<Address> addressList;

}
