package unillanos.petcity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.petcity.constants.QualificationConstants;
import unillanos.petcity.dto.QualificationDTO;
import unillanos.petcity.exceptions.PetCityException;
import unillanos.petcity.interfaces.IQualificationService;
import unillanos.petcity.model.Qualification;
import unillanos.petcity.repository.QualificationRepository;
import unillanos.petcity.util.MapperUtil;

import java.util.List;

@Service
public class QualificationService implements IQualificationService {


    @Autowired
    QualificationRepository qualificationRepository;

    @Override
    public List<QualificationDTO> findByIdRestaurant(int idRestaurant) throws PetCityException {
        List<QualificationDTO> response;
        try {
            List<Qualification> qualifications = qualificationRepository.findProductByRestaurant(idRestaurant);
            response = MapperUtil.entityToDtoQualificationList(qualifications);
        } catch (Exception exception) {
            throw new PetCityException(QualificationConstants.ERROR_GETTING_BY_RESTAURANT, exception);
        }
        return response;
    }


}
