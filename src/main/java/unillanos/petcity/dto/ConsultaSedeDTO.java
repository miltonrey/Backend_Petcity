package unillanos.petcity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaSedeDTO {

    private HeadquarterDTO headquarter;

    private List<ProductDTO> products;

    private List<QualificationDTO> qualifications;

}
