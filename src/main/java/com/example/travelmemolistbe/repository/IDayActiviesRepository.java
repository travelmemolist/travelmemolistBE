package com.example.travelmemolistbe.repository;

import com.example.travelmemolistbe.models.DayActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface IDayActiviesRepository extends JpaRepository<DayActivities,Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into day_activities(current_day,day,name_of_day_activities,schedule_schedules_id) values (?1,?2,?3,?4)",nativeQuery = true)
    void createDayAtivities(Date current_day, String day, String name_of_day_activities, Integer schedules_id);
}
