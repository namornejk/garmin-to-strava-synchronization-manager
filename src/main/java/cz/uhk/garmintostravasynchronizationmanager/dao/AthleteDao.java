package cz.uhk.garmintostravasynchronizationmanager.dao;

import cz.uhk.garmintostravasynchronizationmanager.model.UserAthlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AthleteDao extends JpaRepository<UserAthlete, Long> {

    UserAthlete findByUserToken(String userToken);

}