package cz.uhk.garmintostravasynchronizationmanager.dao;

import cz.uhk.garmintostravasynchronizationmanager.model.Activity;
import org.springframework.stereotype.Component;

@Component
public class ActivityDao {

    public Activity findById(Long id){ return new Activity(1L, "Test Activity"); }
}
