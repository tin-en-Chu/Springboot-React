package com.tv.springbootwork.mapper;

import com.tv.springbootwork.controller.request.EmployeeRequestGet;
import com.tv.springbootwork.controller.request.EmployeeRequestPost;
import com.tv.springbootwork.controller.request.EmployeeRequestPut;
import com.tv.springbootwork.model.EmployeeDetailDTO;
import com.tv.springbootwork.model.EmployeeResultDTO;
import com.tv.springbootwork.model.vo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    List<Employee> getEmployeeResult(EmployeeRequestGet EmployeeRequestGet);

    int deleteEmployeeResultByBatch(String employeeCode);

    int insertEmployeeResult(EmployeeRequestPost employeeRequestPost);

    int updateEmployeeResult(EmployeeRequestPut employeeRequestPut);


    //測試用
    Employee testGet(String employeeId);

}
