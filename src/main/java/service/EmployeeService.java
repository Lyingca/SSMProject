package service;

import com.github.pagehelper.PageInfo;
import domain.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeeByPage(Integer pageNo);
}
