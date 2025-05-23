package com.tv.springbootwork.model;

import com.tv.springbootwork.model.vo.BaseDTO;
import com.tv.springbootwork.model.vo.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeDetailDTO extends BaseDTO<Employee, EmployeeDetailDTO> {
    /**
     * 員工id
     */
    private String employeeId;
    /**
     * 員工姓名
     */
    private String employeeName;
    /**
     * 部門id
     */
    private String departmentId;
    /**
     * 姓別
     */
    private String gender;
    /**
     * 出生日期
     */
    private String birth;
    /**
     * 信箱
     */
    private String email;
    /**
     * 入職時間
     */
    private String startDate;
    /**
     * 手機號碼
     */
    private String phone;
    /**
     * 修改人(id)
     */
    private String modifyBy;
    /**
     * 修改日期
     */
    private String modifyDate;

    @Override
    public EmployeeDetailDTO convert(Employee employee) {
        EmployeeDetailDTO detail = new EmployeeDetailDTO();
        detail.setEmployeeId(employee.getEmployeeId());
        detail.setEmployeeName(employee.getEmployeeName());
        detail.setDepartmentId(employee.getDepartmentId());
        detail.setGender(employee.getGender());
        detail.setBirth(employee.getBirth());
        detail.setEmail(employee.getEmail());
        detail.setStartDate(employee.getStartDate());
        detail.setPhone(employee.getPhone());
        detail.setModifyBy(employee.getModifyBy());
        detail.setModifyDate(employee.getModifyDate());
        return detail;
    }

}
