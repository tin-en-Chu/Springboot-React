package com.tv.springbootwork;

import com.tv.springbootwork.Exception.APIException;
import com.tv.springbootwork.controller.request.EmployeeRequestDelete;
import com.tv.springbootwork.controller.request.EmployeeRequestGet;
import com.tv.springbootwork.controller.request.EmployeeRequestPost;
import com.tv.springbootwork.controller.request.EmployeeRequestPut;
import com.tv.springbootwork.mapper.EmployeeMapper;
import com.tv.springbootwork.model.EmployeeDetailDTO;
import com.tv.springbootwork.model.EmployeeResultDTO;
import com.tv.springbootwork.service.EmployeeService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Employee 整合測試")
@SpringBootTest
@Sql(scripts = "/data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class UserControllerTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper mapper;

    @Test
    @DisplayName("get result測試")
    public void testGetEmployeeResult_success() throws APIException {
        EmployeeRequestGet request = new EmployeeRequestGet();
        request.setDepartmentId("D001");
        request.setEmployeeId("E001");
        request.setStartDate("2024-01-10");
        request.setEndDate("2024-03-10");
        request.setStatus("Y");

        List<EmployeeResultDTO> result = employeeService.getEmployeeResult(request);

        Assertions.assertFalse(result.isEmpty(), "Result should not be empty");
        Assertions.assertEquals("E001", result.get(0).getEmployeeId());
    }

    @Test
    @DisplayName("get detail測試")
    public void testGetEmployeeDetail_success() throws APIException {
        EmployeeRequestGet request = new EmployeeRequestGet();
        request.setEmployeeId("E002");

        EmployeeDetailDTO result = employeeService.getEmployeeDetailByResult(request);

        Assertions.assertEquals("李俊明", result.getEmployeeName());
    }


    @Test
    @DisplayName("insert result測試")
    public void testInertEmployeeDetail_success() throws APIException {
        EmployeeRequestPost request = new EmployeeRequestPost();
        request.setEmployeeId("E0010");
        request.setEmployeeName("朱廷恩");
        request.setGender("M");
        request.setBirth("1998-01-10");
        request.setEmail("mei@example.com");
        request.setEmail("0987654321");
        request.setPhone("2023-01-10");
        request.setDepartmentId("D001");
        request.setStatus("Y");
        request.setModifyBy("ADMIN");

        boolean result = employeeService.insertEmployeeResultAndResult(request);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("delete result測試")
    public void testDeleteEmployeeDetail_success() throws APIException {
        List<EmployeeRequestDelete> request = new ArrayList<EmployeeRequestDelete>();
        request.add(new EmployeeRequestDelete("E001"));
        request.add(new EmployeeRequestDelete("E002"));
        request.add(new EmployeeRequestDelete("E003"));

        employeeService.deleteEmployeeResultByBatch(request);

        //檢查是否被刪除
        Assertions.assertNull(mapper.testGet("E001"));
        Assertions.assertNull(mapper.testGet("E002"));
        Assertions.assertNull(mapper.testGet("E003"));
    }

    @Test
    @DisplayName("update result測試")
    public void testUpdateEmployeeDetail_success() throws APIException {
        EmployeeRequestPut request = new EmployeeRequestPut();
        request.setEmployeeId("E001");
        request.setEmployeeName("kyle chu");
        request.setGender("M");
        request.setEmail("mei@example.com");
        request.setEmail("0987654321");
        request.setPhone("2023-01-10");
        request.setDepartmentId("D001");
        request.setStatus("Y");
        request.setModifyBy("ADMIN");

        employeeService.updateEmployeeResult(request);
        Assertions.assertEquals("kyle chu", mapper.testGet("E001").getEmployeeName());
    }
}
