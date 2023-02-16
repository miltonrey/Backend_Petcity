package unillanos.foodtainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.foodtainer.constants.QualificationConstants;
import unillanos.foodtainer.dto.QualificationDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.interfaces.IQualificationService;
import unillanos.foodtainer.model.Qualification;
import unillanos.foodtainer.repository.QualificationRepository;
import unillanos.foodtainer.util.MapperUtil;

import java.util.List;

@Service
public class QualificationService implements IQualificationService {


    @Autowired
    QualificationRepository qualificationRepository;

    @Override
    public List<QualificationDTO> findByIdRestaurant(int idRestaurant) throws FoodTainerException {
        List<QualificationDTO> response;
        try {
            List<Qualification> qualifications = qualificationRepository.findProductByRestaurant(idRestaurant);
            response = MapperUtil.entityToDtoQualificationList(qualifications);
        } catch (Exception exception) {
            throw new FoodTainerException(QualificationConstants.ERROR_GETTING_BY_RESTAURANT, exception);
        }
        return response;
    }


}
