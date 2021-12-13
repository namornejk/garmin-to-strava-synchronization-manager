package cz.uhk.garmintostravasynchronizationmanager.service;

import cz.uhk.garmintostravasynchronizationmanager.dao.ActivityFilterDao;
import cz.uhk.garmintostravasynchronizationmanager.dao.FilterDetailDao;
import cz.uhk.garmintostravasynchronizationmanager.model.filters.ActivityFilter;
import cz.uhk.garmintostravasynchronizationmanager.model.filters.FilterDetail;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilterService {

    private ActivityFilterDao activityFilterDao;
    private FilterDetailDao filterDetailDao;

    @Autowired
    public FilterService(ActivityFilterDao activityFilterDao, FilterDetailDao filterDetailDao){
        this.activityFilterDao = activityFilterDao;
        this.filterDetailDao = filterDetailDao;
    }

    public ActivityFilter createActivityFilter(ActivityFilter activityFilter){
        return activityFilterDao.save(activityFilter);
    }

    public FilterDetail createFilterDetail(FilterDetail filterDetail){
        return filterDetailDao.save(filterDetail);
    }

    public ActivityFilter getActivityFilter(Long id){
        return activityFilterDao.findById(id).get();
    }

    public FilterDetail getFilterDetail(FilterDetail filterDetail){
        return filterDetailDao.save(filterDetail);
    }

    public ActivityFilter updateActivityFilter(ActivityFilter activityFilter){
        return activityFilterDao.save(activityFilter);
    }

    public FilterDetail updateFilterDetail(FilterDetail filterDetail){
        return filterDetailDao.save(filterDetail);
    }

    public void deleteActivityFilter(Long id){
        activityFilterDao.deleteById(id);
    }

    public void deleteFilterDetail(Long id){
        filterDetailDao.deleteById(id);
    }
}
