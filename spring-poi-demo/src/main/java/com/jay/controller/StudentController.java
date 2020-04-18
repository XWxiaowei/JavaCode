package com.jay.controller;

import com.jay.service.StudentService;
import com.jay.util.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xiang.wei
 * @date 2020/4/18 1:45 PM
 */
@Controller
@Api(tags = {"批量导入学生信息"})
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "通过EasyPoi的方式批量导入学生信息-1", httpMethod = "POST", notes = "批量导入业主信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件流对象,接收数组格式", required = true, dataType = "MultipartFile")
    })
    @RequestMapping(value = "/batchUploadStudent_easyPOI.do", method = RequestMethod.POST)
    @ResponseBody
    public String batchUploadOwner_easyPOI(@RequestParam(value = "file") MultipartFile file) throws Exception {
        studentService.batchUploadStudent_easyPOI(file);
        return "success";
    }

    @ApiOperation(value = "通过forkjoin的方式批量导入学生信息-2", httpMethod = "POST", notes = "批量导入业主信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件流对象,接收数组格式", required = true, dataType = "MultipartFile")
    })
    @RequestMapping(value = "/batchUploadStudent_forkjoin.do", method = RequestMethod.POST)
    @ResponseBody
    public String batchUploadOwner(@RequestParam(value = "file") MultipartFile file) throws Exception {
        Workbook workbook = ExcelUtil.getWorkbook(file.getInputStream());
        studentService.batchUploadStudent_forkjoin(workbook);
        return "success";
    }
}

