package com.fitness.CenterManagementService.service;

import com.fitness.CenterManagementService.dao.SlotDaoService;
import com.fitness.CenterManagementService.entity.Slot;
import com.fitness.CenterManagementService.entity.SlotStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotManagementService {
    @Autowired
    SlotDaoService slotDaoService;

    public String addSlot(final String centerId, final String activityId, final Slot slot) {
        slot.setActivityId(activityId);
        return slotDaoService.saveSlot(slot).getSlotId();
    }

    public Slot getSlot(final String slotId) {
        final Slot slot = slotDaoService.getSlot(slotId);
        if (slot.getSlotStatus() == SlotStatus.ACTIVE) {
            return slot;
        } else {
            return null;
        }
    }

    public List<Slot> listSlotForActivity(final String activityId) {
        return slotDaoService.listSlotForActivity(activityId).stream()
                .filter(it -> it.getSlotStatus() == SlotStatus.ACTIVE).toList();
    }

    public void removeSlot(final String slotId) {
        final Slot slot = slotDaoService.getSlot(slotId);
        if(slot.getSlotStatus() == SlotStatus.ACTIVE) {
            slot.setSlotStatus(SlotStatus.CANCELLED);
            slotDaoService.updateSlot(slot);
        }
    }
}
