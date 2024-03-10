package com.example.travelmemolistbe.repository;

import com.example.travelmemolistbe.models.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActivitiesRepository extends JpaRepository<Activities,Long> {
    @Query(value = "select activity_id,activity_name,description,end_time,start_time,is_deleted,day_activities_id_day_activities from activities where day_activities_id_day_activities = :idDayActivities and is_deleted = false",nativeQuery = true)
    List<Activities> findAllActivitiesByDayActivities(@Param(value = "idDayActivities") int idDayActivities);
}
