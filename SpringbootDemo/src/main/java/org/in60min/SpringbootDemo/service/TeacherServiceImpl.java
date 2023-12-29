package org.in60min.SpringbootDemo.service;

import lombok.AllArgsConstructor;
import org.in60min.SpringbootDemo.dto.TeacherDto;
import org.in60min.SpringbootDemo.entity.Teacher;
import org.in60min.SpringbootDemo.exception.ResourceNotFoundException;
import org.in60min.SpringbootDemo.mapper.TeacherMapper;
import org.in60min.SpringbootDemo.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService
{

    private TeacherRepository teacherRepository;

    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto) {
        Teacher teacher = TeacherMapper.mapToTeacher(teacherDto);
        Teacher savedTeacher = teacherRepository.save(teacher);

        return TeacherMapper.maptoTeacherDto(savedTeacher);
    }

    @Override
    public TeacherDto getById(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Teacher does not exists with given id : " +teacherId));
        return TeacherMapper.maptoTeacherDto(teacher);
    }

    @Override
    public List<TeacherDto> getAllTeacher()
    {
        List<Teacher> teacher = teacherRepository.findAll();
        return teacher
                .stream()
                .map(
                        (teah)->TeacherMapper.maptoTeacherDto(teah))
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDto editById(Long teacherid, TeacherDto teacherDto)
    {
        Teacher teacher = teacherRepository.findById(teacherid)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Teacher does not exists with given id : " +teacherid)
                );
        teacher.setName(teacherDto.getName());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setLocation(teacherDto.getLocation());
        Teacher updatedTeacher = teacherRepository.save(teacher);

        return TeacherMapper.maptoTeacherDto(updatedTeacher);
    }

    @Override
    public void deleteById(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
                ()-> new ResourceNotFoundException("Teacher does not exists with given id : " +teacherId)
        );
        teacherRepository.deleteById(teacherId);

    }
}
