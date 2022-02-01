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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="slot")
@NoArgsConstructor
@AllArgsConstructor
public class Slot {
    @Id
    @GeneratedValue(generator = "SlotIdGenerator")
    @GenericGenerator(
            name = "SlotIdGenerator",
            strategy = "com.fitness.CenterManagementService.helper.SlotIdGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    String slotId;

    @Temporal(value = TemporalType.TIMESTAMP)
    Date startTime;

    @Column(name = "duration")
    Long durationInMin;

    @Column(name = "capacity")
    Integer seatCapacity;

    @Column(name = "activity_id")
    String activityId;

    @Enumerated(EnumType.STRING)
    SlotStatus slotStatus;

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Long getDurationInMin() {
        return durationInMin;
    }

    public void setDurationInMin(Long durationInMin) {
        this.durationInMin = durationInMin;
    }

    public Integer getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Integer seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }

    @Override
    public String toString() {
        return "Slot( " + "ID: " + this.slotId + ", START_TIME: " + this.startTime + ", DURATION: " +
                this.durationInMin + ", CAPACITY: " + this.seatCapacity + ", ACTIVITY_ID: " + this.activityId + " )";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Slot slot = (Slot) o;
        return slotId != null && Objects.equals(slotId, slot.slotId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}