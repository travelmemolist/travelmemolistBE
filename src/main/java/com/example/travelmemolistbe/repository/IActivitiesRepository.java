package com.example.travelmemolistbe.repository;

import com.example.travelmemolistbe.models.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IActivitiesRepository extends JpaRepository<Activities,Long> {
    @Query(value = "select activity_id,activity_name,description,end_time,start_time,is_deleted,day_activities_id_day_activities from activities where day_activities_id_day_activities = :idDayActivities and is_deleted = false", nativeQuery = true)
    List<Activities> findAllActivitiesByDayActivities(@Param(value = "idDayActivities") int idDayActivities);
    @Modifying
    @Transactional
    @Query(value = "insert into activities(activity_name,end_time,start_time,id_day_activities,is_deleted) values (:activity_name,:end_time,:start_time,:id,false)", nativeQuery = true)
    void createActivities(@Param("activity_name") String activity_name, @Param("end_time") String endTime, @Param("start_time") String startTime, @Param("id") Long id);
    @Modifying
    @Transactional
    @Query(value = "update activities set activity_name = ?1,description = ?2,end_time =?3 ,start_time = ?4 where activity_id = ?5",nativeQuery = true)
    void updateActivity(String activityName,String description,String endTime,String startTime,String activityId);
    @Modifying
    @Transactional
    @Query(value = "update activities set is_deleted = true where activity_id = ?1",nativeQuery = true)
    void deleteActivity(String id);


    Activities findActivitiesByActivityId(Long ActivityId);
}
