package com.tv.springbootwork.service;

import com.tv.springbootwork.Exception.APIException;
import com.tv.springbootwork.controller.request.EmployeeRequestDelete;
import com.tv.springbootwork.controller.request.EmployeeRequestGet;
import com.tv.springbootwork.controller.request.EmployeeRequestPost;
import com.tv.springbootwork.controller.request.EmployeeRequestPut;
import com.tv.springbootwork.model.EmployeeDetailDTO;
import com.tv.springbootwork.model.EmployeeResultDTO;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeResultDTO> getEmployeeResult(EmployeeRequestGet EmployeeRequestGet) throws APIException;

    public EmployeeDetailDTO getEmployeeDetailByResult(EmployeeRequestGet EmployeeRequestGet) throws APIException;

    public boolean insertEmployeeResultAndResult(EmployeeRequestPost EmployeeRequestPost) throws APIException;

    public void deleteEmployeeResultByBatch(List<EmployeeRequestDelete> employeeRequestDelete);

    public void updateEmployeeResult(EmployeeRequestPut employeeRequestPut);
}
