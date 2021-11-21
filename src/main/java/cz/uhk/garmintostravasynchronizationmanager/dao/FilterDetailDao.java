package cz.uhk.garmintostravasynchronizationmanager.dao;

import cz.uhk.garmintostravasynchronizationmanager.model.filters.FilterDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilterDetailDao extends JpaRepository<FilterDetail, Long> {

}
