package com.fitness.CenterManagementService.controller;

import com.fitness.CenterManagementService.entity.Center;
import com.fitness.CenterManagementService.service.CenterManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/you-fit/v1/centers")
public class CenterManagementController {
    @Autowired
    private CenterManagementService centerManagementService;

    @PostMapping("/")
    public String createCenter(@RequestBody final Center center) {
        return centerManagementService.createCenter(center);
    }

    @GetMapping("/{centerId}")
    public Center getCenter(@PathVariable final String centerId) {
        return centerManagementService.getCenter(centerId);
    }

    @GetMapping("/")
    public List<Center> listCenter() {
        return centerManagementService.listCenter();
    }

    @DeleteMapping("/{centerId}")
    public void removeUser(@PathVariable final String centerId) {
        centerManagementService.removeCenter(centerId);
    }
}
