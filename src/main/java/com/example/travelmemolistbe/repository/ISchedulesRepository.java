package com.example.travelmemolistbe.repository;

import com.example.travelmemolistbe.models.Schedules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ISchedulesRepository extends JpaRepository<Schedules, Long> {

//    @Query(value = "SELECT schedules_id, address,status, description, end_day, is_deleted, start_day, title, user_user_id FROM Schedules WHERE user_user_id = :userId AND is_deleted = 0 AND title LIKE %:title%", nativeQuery = true)
//    Page<Schedules> selectAllSchedules(Pageable pageable, @Param("userId") String userId, @Param("title") String titleSchedules);


    @Query(value = "update Schedules set status = true where schedules_id = ?1 and Schedules.status = false", nativeQuery = true)
    void updateStatusSchedules(String schedules_id);

    @Query(value = "SELECT s FROM Schedules s WHERE s.user.userId = :userId AND s.isDeleted = false AND s.status = false AND s.title LIKE %:title%")
    Page<Schedules> selectAllSchedules(@Param("userId") Long userId, @Param("title") String title, Pageable pageable);
    @Query(value = "SELECT s FROM Schedules s WHERE s.user.userId = :userId AND s.isDeleted = false AND s.status = true AND s.title LIKE %:title%")
    Page<Schedules> selectAllCompletedSchedules(@Param("userId") Long userId, @Param("title") String title, Pageable pageable);

}
