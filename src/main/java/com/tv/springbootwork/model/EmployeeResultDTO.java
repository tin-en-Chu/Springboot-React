package com.tv.springbootwork.model;

import com.tv.springbootwork.model.vo.BaseDTO;
import com.tv.springbootwork.model.vo.Employee;
import lombok.Data;

@Data
public class EmployeeResultDTO extends BaseDTO<Employee, EmployeeResultDTO> {
    /**
     * 員工id
     */
    private String employeeId;
    /**
     * 員工名稱
     */
    private String employeeName;
    /**
     * 員工入職時間
     */
    private String startDate;
    /**
     * 員工狀態
     */
    private String status;
    /**
     * 部門id
     */
    private String departmentId;

    @Override
    public EmployeeResultDTO convert(Employee employee) {
        EmployeeResultDTO result = new EmployeeResultDTO();
        result.setEmployeeId(employee.getEmployeeId());
        result.setEmployeeName(employee.getEmployeeName());
        result.setDepartmentId(employee.getDepartmentId());
        result.setStartDate(employee.getStartDate());
        result.setStatus(employee.getStatus());
        return result;
    }
}
