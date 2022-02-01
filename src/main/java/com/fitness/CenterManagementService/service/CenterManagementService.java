package com.fitness.CenterManagementService.service;

import com.fitness.CenterManagementService.dao.CenterDaoService;
import com.fitness.CenterManagementService.entity.Center;
import com.fitness.CenterManagementService.entity.CenterStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterManagementService {
    @Autowired
    private CenterDaoService centerDaoService;

    public String createCenter(final Center center) {
        return centerDaoService.saveCenter(center).getCenterId();
    }

    public Center getCenter(final String centerId) {
        return centerDaoService.getCenter(centerId);
    }

    public List<Center> listCenter() {
        List<Center> centerList = centerDaoService.listCenter();
        return centerList.stream().filter(it -> it.getCenterStatus() == CenterStatus.ACTIVE).toList();
    }

    public void removeCenter(final String centerId) {
        final Center center = centerDaoService.getCenter(centerId);
        if (center != null && center.getCenterStatus() == CenterStatus.ACTIVE) {
            center.setCenterStatus(CenterStatus.INACTIVE);
            centerDaoService.updateCenter(center);
        }
    }
}
