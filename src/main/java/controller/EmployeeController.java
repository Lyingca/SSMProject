package controller;

import com.github.pagehelper.PageInfo;
import domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees",employees);
        return "list";
    }

    @RequestMapping(value = "/list/page/{pageNo}",method = RequestMethod.GET)
    public String getEmployeeByPage(Model model, @PathVariable("pageNo") Integer pageNo){
        PageInfo<Employee> pageInfo = employeeService.getEmployeeByPage(pageNo);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }
}
