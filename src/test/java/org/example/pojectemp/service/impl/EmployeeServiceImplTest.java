package org.example.pojectemp.service.impl;

import org.example.pojectemp.dto.EmployeeDTO;
import org.example.pojectemp.model.Employee;
import org.example.pojectemp.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository repository;
    @InjectMocks
    private EmployeeServiceImpl service;
    private EmployeeDTO employeeDTO;
    private Employee employee;

    @BeforeEach
    void setup(){
        employee = Employee.builder().id(1).name("someName").position("admin").build();
        employeeDTO = EmployeeDTO.builder().id(1).name("someName").position("admin").build();
    }

    @Test
    void testShouldReturnGetAll(){
        List<Employee> expected = Arrays.asList(employee);

        when(repository.findAll()).thenReturn(expected);

        Collection<EmployeeDTO> actual = service.getAll();

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        verify(repository, times(1)).findAll();
    }
}