package com.tv.springbootwork.controller.request;

import lombok.Data;

@Data
public class EmployeeRequestGet {
    /**
     * 員工id
     */
    private String employeeId;
    /**
     * 員工名稱(可能會有)
     */
    private String employeeName;
    /**
     * 搜尋開始時間
     */
    private String startDate;
    /**
     * 搜尋結束時間
     */
    private String endDate;
    /**
     * 員工狀態
     */
    private String status;
    /**
     * 部門id
     */
    private String departmentId;
}
