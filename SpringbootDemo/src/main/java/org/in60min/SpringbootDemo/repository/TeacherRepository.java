package org.in60min.SpringbootDemo.repository;

import org.in60min.SpringbootDemo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long>
{

}
