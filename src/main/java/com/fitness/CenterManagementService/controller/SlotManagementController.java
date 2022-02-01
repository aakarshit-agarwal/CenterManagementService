package com.fitness.CenterManagementService.controller;

import com.fitness.CenterManagementService.entity.Slot;
import com.fitness.CenterManagementService.service.SlotManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/you-fit/v1/centers/{centerId}/activities/{activityId}/slots")
public class SlotManagementController {
    @Autowired
    private SlotManagementService slotManagementService;

    @PostMapping("/")
    public String addSlot(@PathVariable final String centerId, @PathVariable final String activityId,
                          @RequestBody final Slot slot) {
        return slotManagementService.addSlot(centerId, activityId, slot);
    }

    @GetMapping("/{slotId}")
    public Slot getSlot(@PathVariable final String slotId) {
        return slotManagementService.getSlot(slotId);
    }

    @GetMapping("/")
    public List<Slot> listSlotForActivity(final String activityId) {
        return slotManagementService.listSlotForActivity(activityId);
    }

    @DeleteMapping("/{slotId}")
    public void removeSlot(@PathVariable final String slotId) {
        slotManagementService.removeSlot(slotId);
    }
}
