package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import domain.Employee;
import mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.EmployeeService;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeMapper.getAllEmployee();
        return employees;
    }

    @Override
    public PageInfo<Employee> getEmployeeByPage(Integer pageNo) {
        PageHelper.startPage(pageNo,4);
        List<Employee> employees = employeeMapper.getAllEmployee();
        PageInfo<Employee> pageInfo = new PageInfo<>(employees,5);
        return pageInfo;
    }
}
