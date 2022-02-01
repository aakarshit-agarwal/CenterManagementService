package com.fitness.CenterManagementService.dao;


import com.fitness.CenterManagementService.entity.Slot;
import com.fitness.CenterManagementService.respository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlotDaoService {
    @Autowired
    private SlotRepository slotRepository;

    public Slot saveSlot(final Slot slot) {
        return slotRepository.save(slot);
    }

    public Slot getSlot(final String slotId) {
        final Optional<Slot> slot = slotRepository.findById(slotId);
        return slot.orElse(null);
    }

    public List<Slot> listSlotForActivity(final String activityId) {
        //TODO: Code complete
        return List.of();
    }

    public void updateSlot(final Slot slot) {
        slotRepository.save(slot);
    }

    public void deleteSlot(final String slotId) {
        slotRepository.deleteById(slotId);
    }
}
