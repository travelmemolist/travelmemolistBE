package com.example.travelmemolistbe.repository;

import com.example.travelmemolistbe.models.ImagesOfActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImageOfActivitiesRepository extends JpaRepository<ImagesOfActivities,Long> {

    @Query(value = "select id_image,is_deleted,url_images,activities_activity_id from images_of_activities where activities_activity_id = ?1",nativeQuery = true)
    List<ImagesOfActivities> findAllByActivityId(String activityId);

    @Query(value = "select id_image,url_images from images_of_activities inner join activities \n" +
            "on activities_activity_id = activity_id inner join day_activities \n" +
            "on day_activities_id_day_activities = id_day_activities\n" +
            "inner join schedules on schedules_id = schedules_id where schedules_id = ?1 and schedules.status = false",nativeQuery = true)
    List<ImagesOfActivities> findAllBySchedulesID(String schedules_id);
}
