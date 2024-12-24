package org.example.pojectemp.mapper;

import lombok.Builder;
import org.example.pojectemp.dto.EmployeeDTO;
import org.example.pojectemp.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDTO toEmpDto(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setPosition(employee.getPosition());
        return employeeDTO;
    }

    public  Employee toEmp(EmployeeDTO employee){
        Employee emp = new Employee();
        emp.setId(employee.getId());
        emp.setName(employee.getName());
        emp.setPosition(employee.getPosition());
        return emp;
    }
}
