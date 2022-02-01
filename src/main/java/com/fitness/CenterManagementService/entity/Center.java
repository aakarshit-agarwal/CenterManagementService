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
@Table(name = "center")
@NoArgsConstructor
@AllArgsConstructor
public class Center {
    @Id
    @GeneratedValue(generator = "CenterIdGenerator")
    @GenericGenerator(
            name = "CenterIdGenerator",
            strategy = "com.fitness.CenterManagementService.helper.CenterIdGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    String centerId;

    @Column(name = "name")
    String centerName;

    @Enumerated(EnumType.STRING)
    CenterStatus centerStatus;

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public CenterStatus getCenterStatus() {
        return centerStatus;
    }

    public void setCenterStatus(CenterStatus centerStatus) {
        this.centerStatus = centerStatus;
    }

    @Override
    public String toString() {
        return "Center( " + "ID: " + this.centerId + ", NAME: " + this.centerName + ", STATUS: " +
                this.centerStatus + " )";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Center center = (Center) o;
        return centerId != null && Objects.equals(centerId, center.centerId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
