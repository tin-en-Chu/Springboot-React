package com.tv.springbootwork.controller.request;

import lombok.Data;

@Data
public class EmployeeRequestPut {
    /**
     * 員工id
     */
    private String employeeId;
    /**
     * 員工名稱(可能會有)
     */
    private String employeeName;
    /**
     * 信箱
     */
    private String email;
    /**
     * 員工狀態
     */
    private String status;
    /**
     * 部門id(下拉選單)
     */
    private String departmentId;
    /**
     * 手機號碼
     */
    private String phone;
    /**
     * 姓別
     */
    private String gender;
    /**
     * 修改人(id)
     */
    private String modifyBy;
    /**
     * 修改日期
     */
    private String modifyDate;
}
