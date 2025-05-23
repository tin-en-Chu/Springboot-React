package com.tv.springbootwork.model.vo;

import lombok.Data;

/**
 * 員工VO，用來連接MABATIS MAPPER轉DTO用的
 */
@Data
public class Employee {
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
     * 部門名稱
     */
    private String departmentName;
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
     * 手機號碼
     */
    private String phone;
    /**
     * 入職時間
     */
    private String startDate;

    /**
     * 員工狀態
     */
    private String status;
    /**
     * 修改人(id)
     */
    private String modifyBy;
    /**
     * 修改日期
     */
    private String modifyDate;
}
