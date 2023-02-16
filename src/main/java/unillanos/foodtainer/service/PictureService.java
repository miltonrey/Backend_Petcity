package unillanos.foodtainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.foodtainer.constants.PictureConstants;
import unillanos.foodtainer.dto.PictureDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.interfaces.IPictureService;
import unillanos.foodtainer.model.Picture;
import unillanos.foodtainer.repository.PictureRepository;
import unillanos.foodtainer.util.MapperUtil;

@Service
public class PictureService implements IPictureService {

    @Autowired
    PictureRepository pictureRepository;

    @Override
    public PictureDTO findById(int id) throws FoodTainerException {
        PictureDTO pictureDTO = new PictureDTO();
        try {
            Picture picture = pictureRepository.findById(id).orElse(null);
            if (picture != null) {
                pictureDTO = MapperUtil.entityToDtoPicture(picture);
            }
        } catch (Exception exception) {
            throw new FoodTainerException(PictureConstants.ERROR_GETTING, exception);
        }
        return pictureDTO;
    }
}
