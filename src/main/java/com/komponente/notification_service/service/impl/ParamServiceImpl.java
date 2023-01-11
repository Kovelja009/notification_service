package com.komponente.notification_service.service.impl;

import com.komponente.notification_service.model.Param;
import com.komponente.notification_service.repositories.ParamsRepo;
import com.komponente.notification_service.service.ParamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ParamServiceImpl implements ParamService {
    ParamsRepo paramsRepo;
    @Override
    public Param findByParam(Param param) {
        if( paramsRepo.findByFirstNameAndLastNameAndCompanyAndUsernameAndModelAndLink(param.getFirstName(),param.getLastName(), param.getCompany(), param.getUsername(),param.getModel(),param.getLink()).isPresent())
            return paramsRepo.findByFirstNameAndLastNameAndCompanyAndUsernameAndModelAndLink(param.getFirstName(),param.getLastName(), param.getCompany(), param.getUsername(),param.getModel(),param.getLink()).get();
        else
            return null;
    }
}
