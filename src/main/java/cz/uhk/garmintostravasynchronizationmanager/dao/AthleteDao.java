package cz.uhk.garmintostravasynchronizationmanager.dao;

import cz.uhk.garmintostravasynchronizationmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AthleteDao extends JpaRepository<User, Long> { }
