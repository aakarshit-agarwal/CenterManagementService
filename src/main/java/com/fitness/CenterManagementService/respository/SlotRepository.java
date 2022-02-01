package com.fitness.CenterManagementService.respository;

import com.fitness.CenterManagementService.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot, String> {
}
