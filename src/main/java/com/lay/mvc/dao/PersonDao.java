package com.lay.mvc.dao;

import com.lay.mvc.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 0:35 2018/11/11
 * @Modified By:IntelliJ IDEA
 */
@Mapper
@Repository
public interface PersonDao {

    //获取单个用户
    public Person getPerson(Long id);

    //新增用户
    public int insertPerson(Person person);

    //更新用户
    public int updatePerson(Person person);

    //获取全部用户
    public List<Person> getAllPersons();

    //查询用户
    public List<Person> findPersons(@Param("personName") String personName, @Param("note") String note);

    //删除用户
    public int deletePerson(Long id);

}
