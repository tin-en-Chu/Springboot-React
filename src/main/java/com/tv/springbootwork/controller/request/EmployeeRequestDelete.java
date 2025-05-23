package com.tv.springbootwork.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Data
public class EmployeeRequestDelete {
    /**
     * 員工id
     */
    private String employeeId;
}
