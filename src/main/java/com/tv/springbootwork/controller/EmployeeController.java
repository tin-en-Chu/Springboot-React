package com.tv.springbootwork.controller;

import com.tv.springbootwork.Exception.APIException;
import com.tv.springbootwork.controller.request.EmployeeRequestDelete;
import com.tv.springbootwork.controller.request.EmployeeRequestGet;
import com.tv.springbootwork.controller.request.EmployeeRequestPost;
import com.tv.springbootwork.controller.request.EmployeeRequestPut;
import com.tv.springbootwork.model.EmployeeDetailDTO;
import com.tv.springbootwork.model.EmployeeResultDTO;
import com.tv.springbootwork.service.EmployeeService;
import com.tv.springbootwork.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getResult")
    public ResponseBean<List<EmployeeResultDTO>> getResult(EmployeeRequestGet EmployeeRequestGet) throws APIException {
        List<EmployeeResultDTO> employeeResult = employeeService.getEmployeeResult(EmployeeRequestGet);
        return  ResponseBean.Builder.success(Action.INQUIRE, Code.INQUIRE_SUCCESS, employeeResult);
    }

    @GetMapping("/getDetail")
    public ResponseBean<EmployeeDetailDTO> getDetailByResult(EmployeeRequestGet EmployeeRequestGet) throws APIException {
        EmployeeDetailDTO employeeDetail = employeeService.getEmployeeDetailByResult(EmployeeRequestGet);
        return ResponseBean.Builder.success(Action.INQUIRE, Code.INQUIRE_SUCCESS, employeeDetail);
    }

    @PostMapping("/insertResult")
    public ResponseBean insertResult(@RequestBody EmployeeRequestPost employeeRequestPost) throws APIException {
        //先只做未填pk的錯誤處理
        if(employeeRequestPost.getEmployeeId() == null){
            throw new APIException(ResponseBean.Builder.error(Action.INSERT,Code.NO_USER_CODE));
        }
        employeeService.insertEmployeeResultAndResult(employeeRequestPost);
//        if(log.isDebugEnabled()){
            log.info("insert req obj :{}" , employeeRequestPost.toString());
//        }
        return  ResponseBean.Builder.success(Action.INSERT, Code.INSERT_SUCCESS, null);
    }

    @DeleteMapping("/deleteResultByBatch")
    public ResponseBean deleteResultByBatch(@RequestBody List<EmployeeRequestDelete> employeeRequestDelete) {
        employeeService.deleteEmployeeResultByBatch(employeeRequestDelete);
        return ResponseBean.Builder.success(Action.DELETE, Code.DELETE_SUCCESS, null);
    }

    @PutMapping("/updateResult")
    public ResponseBean updateResult(@RequestBody EmployeeRequestPut employeeRequestPut) throws APIException {
        employeeService.updateEmployeeResult(employeeRequestPut);
        return ResponseBean.Builder.success(Action.UPDATE, Code.UPDATE_SUCCESS, null);
    }


}
