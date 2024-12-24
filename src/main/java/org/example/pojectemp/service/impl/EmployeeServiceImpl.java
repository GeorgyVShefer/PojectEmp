package org.example.pojectemp.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pojectemp.dto.EmployeeDTO;
import org.example.pojectemp.mapper.EmployeeMapper;
import org.example.pojectemp.repository.EmployeeRepository;
import org.example.pojectemp.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService<EmployeeDTO> {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public Collection<EmployeeDTO> getAll() {
        log.debug("Запущен вызов метода getAll");
        return repository.findAll().stream()
                .map(mapper::toEmpDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getById(Integer id) {
        log.debug("Запущен вызов метода getById");
        return mapper.toEmpDto(repository.findById(id).orElseThrow());
    }

    @Override
    public void save(EmployeeDTO type) {
        log.debug("Запущен вызов метода save");

        repository.save(mapper.toEmp(type));
    }

    @Override
    public void update(EmployeeDTO type) {
        log.debug("Запущен вызов метода update");
        repository.save(mapper.toEmp(type));
    }

    @Override
    public void delete(Integer id) {
        log.debug("Запущен вызов метода delete");
        repository.deleteById(id);
    }
}
