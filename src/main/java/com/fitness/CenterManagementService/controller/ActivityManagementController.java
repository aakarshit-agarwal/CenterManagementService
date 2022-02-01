package com.fitness.CenterManagementService.controller;

import com.fitness.CenterManagementService.entity.Activity;
import com.fitness.CenterManagementService.service.ActivityManagementService;
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
@RequestMapping("/you-fit/v1/centers/{centerId}/activities")
public class ActivityManagementController {
    @Autowired
    private ActivityManagementService activityManagementService;

    @PostMapping("/")
    public String addActivity(@PathVariable final String centerId, @RequestBody final Activity activity) {
        return activityManagementService.addActivity(centerId, activity);
    }

    @GetMapping("/{activityId}")
    public Activity getActivity(@PathVariable final String centerId, @PathVariable final String activityId) {
        return activityManagementService.getActivity(centerId, activityId);
    }

    @GetMapping("/")
    public List<Activity> listActivity(@PathVariable final String centerId) {
        return activityManagementService.listActivity(centerId);
    }

    @DeleteMapping("/{activityId}")
    public void removeActivity(@PathVariable final String centerId, @PathVariable final String activityId) {
        activityManagementService.removeActivity(centerId, activityId);
    }
}
