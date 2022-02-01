package com.fitness.CenterManagementService.respository;

import com.fitness.CenterManagementService.entity.Center;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository extends JpaRepository<Center, String> {
}
