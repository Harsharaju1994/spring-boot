package org.in60min.SpringbootDemo.mapper;

import org.in60min.SpringbootDemo.dto.TeacherDto;
import org.in60min.SpringbootDemo.entity.Teacher;

public class TeacherMapper
{
    public static TeacherDto maptoTeacherDto(Teacher teacher){
        return new TeacherDto(
                teacher.getId(),
                teacher.getName(),
                teacher.getEmail(),
                teacher.getLocation()
        );
    }
    public static Teacher mapToTeacher(TeacherDto teacherDto){
        return new Teacher(
                teacherDto.getId(),
                teacherDto.getName(),
                teacherDto.getEmail(),
                teacherDto.getLocation()
        );
    }
}
