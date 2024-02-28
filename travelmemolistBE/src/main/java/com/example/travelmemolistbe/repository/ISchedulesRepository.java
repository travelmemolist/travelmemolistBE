package com.example.travelmemolistbe.repository;

import com.example.travelmemolistbe.models.Schedules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISchedulesRepository extends JpaRepository<Schedules, Integer> {
        @Query(value = "select title,address,end_day,start_day,description from Schedules inner join User on user_user_id = user_id where user_id = ?1 and is_deleted = false and title like %?2%",nativeQuery = true)
        Page<Schedules> selectAllSchedules(Pageable pageable, String id,String titleSchedules);
}
