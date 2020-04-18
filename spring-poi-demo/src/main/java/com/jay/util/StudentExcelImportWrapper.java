package com.jay.util;


import com.jay.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;


@Slf4j
@Component
public class StudentExcelImportWrapper {


    private static final ForkJoinPool forkJoinPool = new ForkJoinPool(4);


    public List<Student> importExcel(Workbook workbook) {
        ForkJoinPool forkJoinPool = StudentExcelImportWrapper.forkJoinPool;
        Sheet sheet = workbook.getSheetAt(0);
        JoinTask joinTask = new JoinTask(1, sheet.getLastRowNum(), sheet);
        List<Student> importVOList = forkJoinPool.invoke(joinTask);
        //excel内部去重
        List<Student> noRepeatImportVOList = importVOList.stream().filter(DistinctUtil.distinctByKey(Student::getStudentNo)).collect(Collectors.toList());
        return noRepeatImportVOList;
    }

    class JoinTask extends RecursiveTask<List<Student>> {
        private int start;
        private int end;
        private Sheet sheet;
        private int total;

        public JoinTask(int start, int end, Sheet sheet) {
            this.start = start;
            this.end = end;
            this.sheet = sheet;
            this.total = sheet.getLastRowNum();
        }

        @Override
        protected List<Student> compute() {
            if (start > end || total < end) {
                return new ArrayList<>(1);
            }
            if (end - start <= 200) {
                return getData(sheet, start, end).stream().filter(DistinctUtil.distinctByKey(Student::getStudentNo)).collect(Collectors.toList());
            } else {
                int mid = (start + end) / 2;
                JoinTask rightTask = new JoinTask(start, mid, sheet);
                JoinTask leftTask = new JoinTask(mid + 1, end, sheet);
                //写法一
                /*rightTask.fork();
                List<ExcelBo> leftList =  leftTask.compute();
                List<ExcelBo> rightList = rightTask.join();*/
                //写法二
                invokeAll(rightTask, leftTask);
                List<Student> leftList = leftTask.join();
                List<Student> rightList = rightTask.join();
                leftList.addAll(rightList);
                return leftList;
            }
        }
    }

    /**
     * 分页读取Excel中的数据
     *
     * @param sheet
     * @param start 开始页
     * @param end   结束页
     * @return
     * @author xiang.wei
     * @date 2020/4/15  11:00
     */
    private List<Student> getData(Sheet sheet, int start, int end) {
        List<Student> mapList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            Student Student = null;
            try {
                Row row = sheet.getRow(i);
                Student = new Student();
                Student.setClassName(ExcelUtil.getKeyValue(row.getCell(0)));
                Student.setStudentName(ExcelUtil.getKeyValue(row.getCell(1)));
                Student.setStudentMobile(ExcelUtil.getKeyValue(row.getCell(2)));
                Student.setIdCard(ExcelUtil.getKeyValue(row.getCell(3)));
                Student.setStudentNo(ExcelUtil.getKeyValue(row.getCell(4)));
                Student.setIdCard(ExcelUtil.getKeyValue(row.getCell(5)));
            } catch (Exception e) {
                log.info("***************税号={},文件名={},数据解析出现异常={}", e);
                continue;
            }
            mapList.add(Student);
        }
        return mapList;
    }

}
