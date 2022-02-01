package com.fitness.CenterManagementService.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "activity")
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(generator = "ActivityIdGenerator")
    @GenericGenerator(
            name = "ActivityIdGenerator",
            strategy = "com.fitness.CenterManagementService.helper.ActivityIdGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    String activityId;

    @Column(name = "name")
    String activityName;

    @Column(name = "center_id", updatable = false, nullable = false)
    String centerId;

    @Enumerated(EnumType.STRING)
    ActivityStatus activityStatus;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public ActivityStatus getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(ActivityStatus activityStatus) {
        this.activityStatus = activityStatus;
    }

    @Override
    public String toString() {
        return "Activity( " + "ID: " + this.activityId + ", NAME: " + this.activityName + ", CENTER_ID: " +
                this.centerId + ", STATUS: " + this.activityStatus + " )";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Activity activity = (Activity) o;
        return activityId != null && Objects.equals(activityId, activity.activityId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
