package cz.uhk.garmintostravasynchronizationmanager.dao;

import cz.uhk.garmintostravasynchronizationmanager.model.filters.ActivityFilter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityFilterDao extends JpaRepository<ActivityFilter, Long>  {
}
