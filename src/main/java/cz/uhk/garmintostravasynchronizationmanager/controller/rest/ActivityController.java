package cz.uhk.garmintostravasynchronizationmanager.controller.rest;

import cz.uhk.garmintostravasynchronizationmanager.model.Activity;
import cz.uhk.garmintostravasynchronizationmanager.model.Dto;
import cz.uhk.garmintostravasynchronizationmanager.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActivityController {

    private ActivityService activityService;

    @Autowired
    public void setActivityService(ActivityService activityService){
        this.activityService = activityService;
    }

    @GetMapping("/getActivity")
    public Dto getActivity(@RequestParam(name="id", required = false) Long id, Model model){
        List<String> errors = new ArrayList<>();
        Activity activity = null;

        if(id == null)
            errors.add("Activity ID parameter is empty.");
        else
            activity = activityService.getActivity(id);

        Dto dto = new Dto(activity, errors);
        return dto;
    }
}
