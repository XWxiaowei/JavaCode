package com.jay.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xiang.wei
 * @date 2020/4/18 1:46 PM
 */
public interface StudentService {
    /**
     * 通过easyPOI读取数据
     * @param file
     * @return
     * @author xiagwei
     * @date 2020/4/18 4:09 PM
     */
    String batchUploadStudent_easyPOI(MultipartFile file) throws Exception;

    /**
     * 通过fork-join的方式读取数据
     * @param workbook
     * @return
     * @author xiagwei
     * @date 2020/4/18 4:10 PM
     */
    String batchUploadStudent_forkjoin(Workbook workbook);
}
