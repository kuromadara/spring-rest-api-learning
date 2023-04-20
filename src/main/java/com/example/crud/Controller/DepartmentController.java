package com.example.crud.Controller;

import com.example.crud.Model.Department;
import com.example.crud.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(
            @Validated @RequestBody Department department
    ) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> findAllDepartments() {
        return departmentService.findAllDepartments();
    }

    @GetMapping("/department/{departmentId}")
    public Department findDepartmentById(@PathVariable Long departmentId) {
        return departmentService.findDepartmentById(departmentId);
    }

    @PutMapping("/department/{departmentId}")
    public Department updateDepartment(
            @Validated @RequestBody Department department,@PathVariable
            Long departmentId
    ) {
        return departmentService.updateDepartment(department, departmentId);
    }

    @DeleteMapping("/department/{departmentId}")
    public String deleteDepartmentById(@PathVariable Long departmentId) {
        // soft delete
        System.out.println("ok");
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

}
