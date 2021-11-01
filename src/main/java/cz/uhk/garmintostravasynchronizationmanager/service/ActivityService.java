package cz.uhk.garmintostravasynchronizationmanager.service;

import cz.uhk.garmintostravasynchronizationmanager.dao.ActivityDao;
import cz.uhk.garmintostravasynchronizationmanager.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    private ActivityDao activityDao;

    @Autowired
    public void setActivityDao(ActivityDao activityDao){
        this.activityDao = activityDao;
    }

    public Activity getActivity(Long activityId){
        return activityDao.findById(activityId);
    }
}
