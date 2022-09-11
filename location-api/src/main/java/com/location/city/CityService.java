package com.location.city;

import com.location.common.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    public CityDTO findById(Long id) {
        if (null == id) {
            throw new ObjectNotFoundException("City", "id=null");
        }

        CityEnum city = CityEnum.getById(id);
        return new CityDTO(city.getId(), city.getName(), city.getState());
    }

}
