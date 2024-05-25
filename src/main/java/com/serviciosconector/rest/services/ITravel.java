package com.serviciosconector.rest.services;

import com.serviciosconector.rest.models.dto.TravelDto;
import com.serviciosconector.rest.models.entity.Travel;

public interface ITravel {

    Travel save(TravelDto travel);
    Travel findById(String id);
    void delet(Travel travel);
}
