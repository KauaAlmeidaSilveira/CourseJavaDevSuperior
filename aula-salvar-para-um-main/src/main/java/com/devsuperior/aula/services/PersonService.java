package com.devsuperior.aula.services;

import com.devsuperior.aula.DTO.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public PersonDepartmentDTO insert(PersonDepartmentDTO personDepartmentDTO) {
        Person person = new Person();
        copyDtoToEntity(personDepartmentDTO, person);
        person = personRepository.save(person);
        return new PersonDepartmentDTO(person);
    }

    public void copyDtoToEntity(PersonDepartmentDTO personDepartmentDTO, Person person) {
        person.setId(personDepartmentDTO.getId());
        person.setName(personDepartmentDTO.getName());
        person.setSalary(personDepartmentDTO.getSalary());
        person.setDepartment(departmentRepository.getReferenceById(personDepartmentDTO.getDepartment().getId()));
    }
}
