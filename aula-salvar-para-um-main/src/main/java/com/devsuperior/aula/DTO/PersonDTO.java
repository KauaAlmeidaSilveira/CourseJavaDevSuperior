package com.devsuperior.aula.DTO;

import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;

public class PersonDTO {

    private Long id;
    private String name;
    private Double salary;
    private DepartmentDTO departmentDTO;

    public PersonDTO(Long id, String name, Double salary, DepartmentDTO departmentDTO) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.departmentDTO = departmentDTO;
    }

    public PersonDTO(Person person) {
        id = person.getId();
        name = person.getName();
        salary = person.getSalary();
        departmentDTO = new DepartmentDTO(person.getDepartment());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public DepartmentDTO getDepartment() {
        return departmentDTO;
    }

}
