package unillanos.petcity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.petcity.constants.PictureConstants;
import unillanos.petcity.dto.PictureDTO;
import unillanos.petcity.exceptions.PetCityException;
import unillanos.petcity.interfaces.IPictureService;
import unillanos.petcity.model.Image;
import unillanos.petcity.repository.PictureRepository;
import unillanos.petcity.util.MapperUtil;

@Service
public class PictureService implements IPictureService {

    @Autowired
    PictureRepository pictureRepository;

    @Override
    public PictureDTO findById(int id) throws PetCityException {
        PictureDTO pictureDTO = new PictureDTO();
        try {
            Image picture = pictureRepository.findById(id).orElse(null);
            if (picture != null) {
                pictureDTO = MapperUtil.entityToDtoPicture(picture);
            }
        } catch (Exception exception) {
            throw new PetCityException(PictureConstants.ERROR_GETTING, exception);
        }
        return pictureDTO;
    }
}
