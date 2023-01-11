package com.komponente.notification_service.service;

import com.komponente.notification_service.model.Param;
import org.springframework.stereotype.Component;


public interface ParamService {

    Param findByParam(Param param);
}
