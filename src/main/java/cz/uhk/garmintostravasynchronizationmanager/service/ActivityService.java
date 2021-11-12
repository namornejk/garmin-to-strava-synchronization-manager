package cz.uhk.garmintostravasynchronizationmanager.service;

import cz.uhk.garmintostravasynchronizationmanager.dao.ActivityDao;
import cz.uhk.garmintostravasynchronizationmanager.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    private ActivityDao activityDao;

    @Autowired
    public ActivityService(ActivityDao activityDao){
        this.activityDao = activityDao;
        activityDao.save(new Activity("Morning Run"));
    }

    public Activity getActivity(Long activityId){
        //TODO handle Optional
        return activityDao.findById(activityId).get();
    }
}
