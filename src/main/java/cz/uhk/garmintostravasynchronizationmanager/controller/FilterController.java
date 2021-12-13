package cz.uhk.garmintostravasynchronizationmanager.controller;

import cz.uhk.garmintostravasynchronizationmanager.model.filters.ActivityFilter;
import cz.uhk.garmintostravasynchronizationmanager.model.filters.FilterDetail;
import cz.uhk.garmintostravasynchronizationmanager.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilterController {

    private FilterService filterService;

    @Autowired
    public FilterController(FilterService filterService){
        this.filterService = filterService;
    }

    @PostMapping("/filter/createActivityFilter")
    public ActivityFilter createActivityFilter(ActivityFilter activityFilter){
        return filterService.createActivityFilter(activityFilter);
    }

    @PostMapping("/filter/createFilterDetail")
    public FilterDetail createFilterDetail(FilterDetail filterDetail){
        return filterService.createFilterDetail(filterDetail);
    }

    @GetMapping("/filter/getActivityFilter")
    public ActivityFilter getActivityFilter(Long id){
        return filterService.getActivityFilter(id);
    }

    @GetMapping("/filter/getFilterDetail")
    public FilterDetail getFilterDetail(FilterDetail filterDetail){
        return filterService.getFilterDetail(filterDetail);
    }

    @PostMapping("/filter/updateActivityFilter")
    public ActivityFilter updateActivityFilter(ActivityFilter activityFilter){
        return filterService.updateActivityFilter(activityFilter);
    }

    @PostMapping("/filter/updateFilterDetail")
    public FilterDetail updateFilterDetail(FilterDetail filterDetail){
        return filterService.updateFilterDetail(filterDetail);
    }

    @GetMapping("/filter/deleteActivityFilter")
    public void deleteActivityFilter(Long id){
        filterService.deleteActivityFilter(id);
    }

    @GetMapping("/filter/deleteFilterDetail")
    public void deleteFilterDetail(Long id){
        filterService.deleteFilterDetail(id);
    }

}
