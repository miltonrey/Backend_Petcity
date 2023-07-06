package unillanos.petcity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualificationDTO {

    private int idQualification;

    private double score;

    private String comment;

    private CustomerDTO customer;

}
