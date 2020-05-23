package com.edu.dp.demo.repository;

import com.edu.dp.demo.entity.OrderInfo;
import com.edu.dp.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("delete from User t where t.schoolCardId in :ids")
    void deleteByIds(@Param("ids")List<Long> ids);

    @Modifying
    @Query("update User as c set c.email = ?2 where c.schoolCardId= ?1")
    @Transactional
    void updateEmailById(long id,String email);

    @Modifying
    @Query("update User as c set c.name = ?2 where c.schoolCardId= ?1")
    @Transactional
    void updateNameById(long id, String name);

    @Modifying
    @Query("update User as c set c.sex = ?2 where c.schoolCardId= ?1")
    @Transactional
    void updateSexById(long id, User.Sex sex);

    @Modifying
    @Query("update User as c set c.password = ?2 where c.schoolCardId= ?1")
    @Transactional
    void updatePasswordById(long id, String password);

    @Modifying
    @Query("update User as c set c.phone = ?2 where c.schoolCardId= ?1")
    @Transactional
    void updatePhoneById(long id, String phone);

    List<User> findByEmail(String email);

    List<User> findByName(String name);

    List<User> findBySchoolCardId(long schoolCardId);

    List<User> findBySex(User.Sex sex);

    List<User> findByPhone(String phone);
}
