
package com.klef.soa.exam.service;

import java.util.List;
import com.klef.soa.exam.entity.BeautySalon;

public interface BeautySalonService {

    BeautySalon add(BeautySalon salon);

    List<BeautySalon> displayAll();

    String delete(long id);

    
}
