package com.edu.dp.demo.repository;


import com.edu.dp.demo.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo,Long> {
    @Modifying
    @Query("delete from OrderInfo t where t.orderId in :ids")
    @Transactional
    void deleteByIds(@Param("ids") List<Long> ids);

    @Modifying
    @Query("update OrderInfo as c set c.comment = ?1,c.stars = ?2 where c.orderId= ?3")
    @Transactional
    void updateCommentAndStarsById(String comment,int stars,long id);

    @Modifying
    @Query("update OrderInfo as c set c.deadline = ?2 where c.orderId= ?1")
    @Transactional
    void updateDeadlineById(long id,java.sql.Timestamp deadline);

    @Modifying
    @Query("update OrderInfo as c set c.description = ?2 where c.orderId= ?1")
    @Transactional
    void updateDescriptionById(long id,String description);

    @Modifying
    @Query("update OrderInfo as c set c.accepterId = ?2,c.status = ?3 where c.orderId= ?1")
    @Transactional
    void updateAccepterIdAndStatusById(long orderId, long id, OrderInfo.Status processing);

    @Modifying
    @Query("update OrderInfo as c set c.status = ?2 where c.orderId= ?1")
    @Transactional
    void updateStatusById(long id, OrderInfo.Status status);

    List<OrderInfo> findByDeadline(Timestamp deadline);

    List<OrderInfo> findByStars(int stars);

    List<OrderInfo> findByPublisherId(long publisherId);

    List<OrderInfo> findByOrderId(long orderId);

    List<OrderInfo> findByStatus(OrderInfo.Status status);
}
