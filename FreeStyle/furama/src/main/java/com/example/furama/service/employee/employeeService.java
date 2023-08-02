package com.example.furama.service.employee;

import com.example.furama.model.employee.Division;
import com.example.furama.model.employee.EducationDegree;
import com.example.furama.model.employee.Employee;
import com.example.furama.model.employee.Position;
import com.example.furama.repository.employee.IDivisionRepository;
import com.example.furama.repository.employee.IEducationRepository;
import com.example.furama.repository.employee.IEmployeeRepository;
import com.example.furama.repository.employee.IPositionRepository;
import com.example.furama.service.employee.itf.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class employeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Autowired
    private IPositionRepository iPositionRepository;

    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Autowired
    private IEducationRepository iEducationRepository;

    @Override
    public boolean add(Employee employee) {
        try {
            iEmployeeRepository.save(employee);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        try {
            iEmployeeRepository.save(employee);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Long id) {
        try {
            iEmployeeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<EducationDegree> findEducation() {
        return iEducationRepository.findAll();
    }

    @Override
    public List<Position> findPosition() {
        return iPositionRepository.findAll();
    }

    @Override
    public List<Division> findDivision() {
        return iDivisionRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> searchByName(Pageable pageable, String name) {
        return iEmployeeRepository.searchByName(pageable, "%" + name + "%");
    }

    @Override
    public List<Employee> getEmployee() {
        return iEmployeeRepository.findAll();
    }


}
