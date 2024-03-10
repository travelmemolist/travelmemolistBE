package com.example.travelmemolistbe.repository;

import com.example.travelmemolistbe.models.DayActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface IDayActiviesRepository extends JpaRepository<DayActivities,Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into day_activities(current_day,day,name_of_day_activities,schedule_schedules_id,is_deleted) values (?1,?2,?3,?4,false)",nativeQuery = true)
    void createDayAtivities(Date current_day, String day, String name_of_day_activities, Long schedules_id);
        @Modifying
        @Transactional
        @Query(value = "update day_activities set name_of_day_activities = :nameOfActivities where id_day_activities = :idDayActivies and is_deleted = false",nativeQuery = true)
        void updateNameOfDayActivities(@Param("nameOfActivities") String nameOfActivities,@Param("idDayActivies")String idDayActivies);
     @Query(value = "select id_day_activities,current_day,day,name_of_day_activities,is_deleted,schedule_schedules_id from day_activities where schedule_schedules_id = ?1",nativeQuery = true)
    List<DayActivities> listActivities(String schedulesId);
}
