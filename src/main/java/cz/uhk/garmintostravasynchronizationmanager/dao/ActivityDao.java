package cz.uhk.garmintostravasynchronizationmanager.dao;

import cz.uhk.garmintostravasynchronizationmanager.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ActivityDao extends JpaRepository<Activity, Long> {
}
