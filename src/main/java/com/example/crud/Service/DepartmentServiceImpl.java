package com.example.crud.Service;

import com.example.crud.Model.Department;
import com.example.crud.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentById(Long departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isPresent()) {
            if (department.get().isDeleted()) {
                throw new NoSuchElementException("Department for id " + departmentId + " not found");
            }
            return department.get();
        } else {
            throw new NoSuchElementException("Department for id " + departmentId + " not found");
        }
    }

    @Override
    public List<Department> findAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<Department> result = new ArrayList<>();
        for (Department department : departments) {
            if (!department.isDeleted()) {
                result.add(department);
            }
        }
        return result;
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
        if (departmentOptional.isPresent()) {
            Department department1 = departmentOptional.get();
            department1.setName(department.getName());
            department1.setCode(department.getCode());
            department1.setAddress(department.getAddress());
            return departmentRepository.save(department1);
        } else {
            throw new NoSuchElementException("Department for id " + departmentId + " not found");
        }

    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            department.setIsDeleted("true");
            departmentRepository.save(department);
        } else {
            throw new NoSuchElementException("Department for id " + departmentId + " not found");
        }
    }
}
