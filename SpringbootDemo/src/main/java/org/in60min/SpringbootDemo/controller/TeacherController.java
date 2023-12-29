package org.in60min.SpringbootDemo.controller;

import lombok.AllArgsConstructor;
import org.in60min.SpringbootDemo.dto.TeacherDto;
import org.in60min.SpringbootDemo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
@AllArgsConstructor
public class TeacherController
{

    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDto> createTecher(@RequestBody TeacherDto teacherDto){
        TeacherDto savedTeacher = teacherService.addTeacher(teacherDto);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getById(@PathVariable("id") Long teacherId){
        TeacherDto teacher = teacherService.getById(teacherId);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAll(){
        List<TeacherDto> teachers = teacherService.getAllTeacher();
        return ResponseEntity.ok(teachers);
    }

    @PutMapping("{id}")
    public ResponseEntity<TeacherDto> update(@PathVariable("id") Long teacherid,
                                             @RequestBody TeacherDto teacherDto){
        TeacherDto teacherDto1 = teacherService.editById(teacherid,teacherDto);
        return ResponseEntity.ok(teacherDto1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") Long teacherId){
        teacherService.deleteById(teacherId);
        return ResponseEntity.ok(teacherId+" : deleted Successfully...!");
    }
}
