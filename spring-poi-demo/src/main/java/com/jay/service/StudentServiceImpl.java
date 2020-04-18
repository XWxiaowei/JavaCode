package com.jay.service;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.jay.model.Student;
import com.jay.util.StudentExcelImportWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author xiang.wei
 * @date 2020/4/18 1:46 PM
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentExcelImportWrapper studentExcelImportWrapper;

    @Override
    public String batchUploadStudent_easyPOI(MultipartFile file) throws Exception {
        long startTime = System.currentTimeMillis();
        List<Student> studentList = ExcelImportUtil.importExcel(file.getInputStream(), Student.class, new ImportParams());
        log.info("********通过EasyPOI读取文件总耗时是={},读取到的数据总条数是={}", (System.currentTimeMillis() - startTime) + "毫秒", studentList.size());
        return null;
    }

    @Override
    public String batchUploadStudent_forkjoin(Workbook workbook) {
        long startTime = System.currentTimeMillis();
        List<Student> studentList = studentExcelImportWrapper.importExcel(workbook);
        log.info("********通过Fork-Join的方式读取文件总耗时是={},读取到的数据条数是={}", (System.currentTimeMillis() - startTime) + "毫秒", studentList.size());
        return null;
    }
}
