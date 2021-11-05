package cz.uhk.garmintostravasynchronizationmanager.service;

import cz.uhk.garmintostravasynchronizationmanager.dao.IActivityDao;
import cz.uhk.garmintostravasynchronizationmanager.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    private IActivityDao activityDao;

    @Autowired
    public ActivityService(IActivityDao activityDao){
        this.activityDao = activityDao;
        activityDao.save(new Activity(1L, "Morning Run"));
    }

    public Activity getActivity(Long activityId){
        //TODO handle Optional
        return activityDao.findById(activityId).get();
    }
}
