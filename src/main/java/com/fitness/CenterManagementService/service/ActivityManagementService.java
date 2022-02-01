package com.fitness.CenterManagementService.service;

import com.fitness.CenterManagementService.dao.ActivityDaoService;
import com.fitness.CenterManagementService.entity.Activity;
import com.fitness.CenterManagementService.entity.ActivityStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityManagementService {
    @Autowired
    ActivityDaoService activityDaoService;

    public String addActivity(final String centerId, final Activity activity) {
        activity.setCenterId(centerId);
        return activityDaoService.saveActivity(activity).getActivityId();
    }

    public Activity getActivity(final String centerId, final String activityId) {
        final Activity activity = activityDaoService.getActivity(activityId);
        if (activity.getActivityStatus() == ActivityStatus.ACTIVE) {
            return activity;
        } else {
            return null;
        }
    }

    public List<Activity> listActivity(final String centerId) {
        return activityDaoService.listActivityForCenter(centerId).stream()
                .filter(it -> it.getActivityStatus() == ActivityStatus.ACTIVE).toList();
    }

    public void removeActivity(final String centerId, final String activityId) {
        Activity activity = activityDaoService.getActivity(activityId);
        if (activity.getActivityStatus() == ActivityStatus.ACTIVE) {
            activity.setActivityStatus(ActivityStatus.INACTIVE);
            activityDaoService.updateActivity(activity);
        }
    }
}
