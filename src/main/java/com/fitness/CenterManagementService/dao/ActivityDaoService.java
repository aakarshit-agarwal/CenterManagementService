package com.fitness.CenterManagementService.dao;

import com.fitness.CenterManagementService.entity.Activity;
import com.fitness.CenterManagementService.entity.ActivityStatus;
import com.fitness.CenterManagementService.respository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityDaoService {
    @Autowired
    ActivityRepository activityRepository;

    public Activity saveActivity(final Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity getActivity(final String activityId) {
        Optional<Activity> activity = activityRepository.findById(activityId);
        if(activity.isPresent() && activity.get().getActivityStatus() == ActivityStatus.ACTIVE) {
            return activity.get();
        } else {
            return null;
        }
    }

    public List<Activity> listActivityForCenter(final String centerId) {
        //TODO: Code complete
        return List.of();
    }

    public void updateActivity(final Activity activity) {
        activityRepository.save(activity);
    }

    public void deleteActivity(final String activityId) {
        activityRepository.deleteById(activityId);
    }
}
