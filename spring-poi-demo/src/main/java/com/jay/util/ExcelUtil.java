package com.jay.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.util.PoiCellUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author xiang.wei
 */
@Slf4j
public class ExcelUtil {
    /**
     * 非数字的处理
     */
    private static final String DECIMAL_FORMAT = "0";

    private static ThreadLocal<DecimalFormat> DECIMAL_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new DecimalFormat(DECIMAL_FORMAT));

    /**
     * 获取日解析的类
     * @return
     */
    public static DecimalFormat getDecimalFormat() {
        return DECIMAL_FORMAT_THREAD_LOCAL.get();
    }

    /**
     * Excel文档结构分为整个文档（Workbook）、
     * 分页（Sheet）、行（Row）、单元格（Cell）四个类来描述
     *
     * @param inputStream excel的文件流
     * @return
     * @throws Exception
     * @author xiang.wei
     */
    public static Workbook getWorkbook(InputStream inputStream) throws Exception {
        Workbook book = null;
        if (!(inputStream.markSupported())) {
            inputStream = new PushbackInputStream(inputStream, 8);
        }
        try {
            book = WorkbookFactory.create(inputStream);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return book;
    }

    /**
     * 获取列头的集合
     *
     * @param workbook
     * @param sheetIndex
     * @param rowIndex
     * @return
     */
    public static Map<Integer, String> getHeadMap(Workbook workbook, int sheetIndex, int rowIndex) {
        Map<Integer, String> headMap = null;
        //默认读取第一个sheet
        Sheet sheet = workbook.getSheetAt(sheetIndex);
//      获取第一行
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            return null;
        }
//      获取该行所有的单元格
        Iterator<Cell> headCells = row.cellIterator();
        if (headCells == null) {
            return null;
        }
        headMap = new HashMap<>();
        while (headCells.hasNext()) {
            Cell cell = headCells.next();
            String value = getKeyValue(cell);
            if (StringUtils.isNotBlank(value)) {
                value = StringUtils.replace(value, "\n", "");
                Integer i = cell.getColumnIndex();
                headMap.put(i, value);
            }
        }
        return headMap;
    }

    /**
     * 生成excel对象
     *
     * @param clzss
     * @param list
     * @param sheetName
     * @return workBook对象
     * @throws IOException
     */
    public Workbook getWorkbook(Class<T> clzss, List<T> list, String sheetName) {
        Workbook book = null;
        try {
            book = ExcelExportUtil.exportExcel(new ExportParams(null, sheetName, ExcelType.XSSF), clzss, list);
        } catch (Exception e) {
            log.info("生成excel模板对象出错={}", e);
        }
        return book;

    }

    /**
     * 非金额读取
     *
     * @param cell
     * @return
     */
    public static String getKeyValue(Cell cell) {
        try {
            String value = PoiCellUtil.getCellValue(cell);
            if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                return ExcelUtil.getDecimalFormat().format(cell.getNumericCellValue());
            }
            return StringUtils.isBlank(value) ? null : value.trim();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 金额读取
     *
     * @param cell
     * @return
     */
    public static String getMoney(Cell cell) {
        String value = PoiCellUtil.getCellValue(cell);
        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        }
        return StringUtils.isBlank(value) ? null : value.trim();
    }
}
