package com.tv.springbootwork.service.impl;

import com.tv.springbootwork.Exception.APIException;
import com.tv.springbootwork.controller.request.EmployeeRequestDelete;
import com.tv.springbootwork.controller.request.EmployeeRequestGet;
import com.tv.springbootwork.controller.request.EmployeeRequestPost;
import com.tv.springbootwork.controller.request.EmployeeRequestPut;
import com.tv.springbootwork.mapper.EmployeeMapper;
import com.tv.springbootwork.model.EmployeeDetailDTO;
import com.tv.springbootwork.model.EmployeeResultDTO;
import com.tv.springbootwork.model.vo.Employee;
import com.tv.springbootwork.service.EmployeeService;
import com.tv.springbootwork.util.Action;
import com.tv.springbootwork.util.BatchTool;
import com.tv.springbootwork.util.Code;
import com.tv.springbootwork.util.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    private BatchTool batchExecutor;

    @Override
    //查詢(主表)
    public List<EmployeeResultDTO> getEmployeeResult(EmployeeRequestGet employeeRequestGet) throws APIException {
        List<Employee> employeeList = mapper.getEmployeeResult(employeeRequestGet);
        if(employeeList.isEmpty()){
            throw new APIException(ResponseBean.Builder.error(Action.DELETE,Code.NO_DATA));
        }
        return new EmployeeResultDTO().convertList(employeeList);
    }

    @Override
    //查詢(明細)
    public EmployeeDetailDTO getEmployeeDetailByResult(EmployeeRequestGet employeeRequestGet) throws APIException{
        List<Employee> employeeList = mapper.getEmployeeResult(employeeRequestGet);
        if(employeeList.isEmpty()){
            throw new APIException(ResponseBean.Builder.error(Action.DELETE,Code.NO_DATA));
        }
        return new EmployeeDetailDTO().convert(employeeList.getFirst());
    }

    //    新增(主表 + 明細)
    public boolean insertEmployeeResultAndResult(EmployeeRequestPost EmployeeRequestPost) throws APIException{
        EmployeeRequestGet systemCode = new EmployeeRequestGet();
        systemCode.setEmployeeId(EmployeeRequestPost.getEmployeeId());
        //假設db有相同的系統代碼
        if(!(mapper.getEmployeeResult(systemCode).isEmpty())){
            throw new APIException(ResponseBean.Builder.error(Action.INSERT,Code.DUPLICATE_USER_CODE));
        }
        int resultCount = mapper.insertEmployeeResult(EmployeeRequestPost);

        return resultCount > 0;
    }

    @Override
    //批次刪除(主表 + 明細)
    public void deleteEmployeeResultByBatch(List<EmployeeRequestDelete> employeeRequestDelete){
        batchExecutor.executeBatch(EmployeeMapper.class, mapper -> {
            for (EmployeeRequestDelete SRD : employeeRequestDelete) {
                mapper.deleteEmployeeResultByBatch(SRD.getEmployeeId());
            }
        });
    }

    @Override
    //更新(主表 + 明細)
    public void updateEmployeeResult(EmployeeRequestPut employeeRequestPut){
        int resultCount = mapper.updateEmployeeResult(employeeRequestPut);
    }



}
