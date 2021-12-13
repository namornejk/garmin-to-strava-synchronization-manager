package cz.uhk.garmintostravasynchronizationmanager.model.filters;

import cz.uhk.garmintostravasynchronizationmanager.model.UserAthlete;
import cz.uhk.garmintostravasynchronizationmanager.model.enums.ActivityType;
import cz.uhk.garmintostravasynchronizationmanager.model.enums.LogicalOperator;

import javax.persistence.*;
import java.util.List;

@Entity
public class ActivityFilter {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserAthlete user;

    @OneToMany(mappedBy="activityFilter")
    private List<FilterDetail> detailedFilters;

    private ActivityType type;
    private LogicalOperator logicalOperator;

}
