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

}
