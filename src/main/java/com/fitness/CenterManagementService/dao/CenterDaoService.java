package com.fitness.CenterManagementService.dao;

import com.fitness.CenterManagementService.entity.Center;
import com.fitness.CenterManagementService.respository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CenterDaoService {
    @Autowired
    private CenterRepository centerRepository;

    public Center saveCenter(final Center user) {
        return centerRepository.save(user);
    }

    public Center getCenter(final String centerId) {
        final Optional<Center> center = centerRepository.findById(centerId);
        return center.orElse(null);
    }

    public List<Center> listCenter() {
        return centerRepository.findAll();
    }

    public void updateCenter(final Center center) {
        centerRepository.save(center);
    }

    public void deleteCenter(final String centerId) {
        centerRepository.deleteById(centerId);
    }
}
