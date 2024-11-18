package com.designpattern.prototype.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentDTO {
    private Long idStudent;
    private String name;
    private String registry;
}
