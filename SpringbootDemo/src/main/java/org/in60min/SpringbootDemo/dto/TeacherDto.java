package org.in60min.SpringbootDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto
{

    private Long id;
    private String name;
    private String email;
    private String location;
}
