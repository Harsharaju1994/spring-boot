package org.in60min.SpringbootDemo.service;

import org.in60min.SpringbootDemo.dto.TeacherDto;

import java.util.List;

public interface TeacherService
{

    TeacherDto addTeacher(TeacherDto teacherDto);
    TeacherDto getById(Long teacherId);
    List<TeacherDto> getAllTeacher();
    TeacherDto editById(Long teacherid,TeacherDto teacherDto);
    void deleteById(Long teacherId);
}
