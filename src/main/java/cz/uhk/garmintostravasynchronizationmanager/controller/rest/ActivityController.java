package cz.uhk.garmintostravasynchronizationmanager.controller.rest;

import cz.uhk.garmintostravasynchronizationmanager.model.Activity;
import cz.uhk.garmintostravasynchronizationmanager.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {

    private ActivityService activityService;

    @Autowired
    public void setActivityService(ActivityService activityService){
        this.activityService = activityService;
    }

    @GetMapping("/getActivity/{id}")
    public ResponseEntity<Activity> getActivity(@PathVariable(name="id", required = false) Long id, Model model){
        Activity activity = null;
        ResponseEntity<Activity> response;

        if(id == null)
            response = ResponseEntity.badRequest().header("error", "ID is empty.").build();
        else
            response = ResponseEntity.ok().body(activityService.getActivity(id));

        return response;
    }
}
