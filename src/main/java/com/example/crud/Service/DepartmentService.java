package com.example.crud.Service;

import com.example.crud.Model.Department;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    Department findDepartmentById(Long departmentId);

    List<Department> findAllDepartments();

    Department updateDepartment(Department department, Long departmentId);

    void deleteDepartmentById(Long departmentId);
}
