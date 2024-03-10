package com.example.travelmemolistbe.repository;

import com.example.travelmemolistbe.models.Schedules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface ISchedulesRepository extends JpaRepository<Schedules, Integer> {
    @Query(value = "SELECT schedules_id, title, address, end_day, start_day, description, is_deleted, user_user_id " +
            "FROM Schedules " +
            "WHERE user_user_id = ?1 AND is_deleted = false AND title LIKE %?2%", nativeQuery = true)
    Page<Schedules> selectAllSchedules(Pageable pageable, String id, String titleSchedules);

       @Modifying
       @Transactional
        @Query(value = "insert into Schedules(title,description,address,start_day,end_day,user_user_id,is_deleted) values (:title,:description,:address,:startDay,:endDay,:userId,false)",nativeQuery = true)
        void createSchedule(@Param("title") String title, @Param("description") String description,@Param("address") String address,@Param("startDay") Date startDay,@Param("endDay") Date endDay,@Param("userId") Long userId);
}
