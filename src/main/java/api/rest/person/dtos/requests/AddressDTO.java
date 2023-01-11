package api.rest.person.dtos.requests;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDTO {

    private Long id;

    private String logradouro;

    private String cep;

    private String numero;

    private String cidade;

    private boolean mainAddress;

}
