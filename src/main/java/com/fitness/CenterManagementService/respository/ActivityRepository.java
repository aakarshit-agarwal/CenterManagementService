package com.fitness.CenterManagementService.respository;

import com.fitness.CenterManagementService.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, String> {
}
