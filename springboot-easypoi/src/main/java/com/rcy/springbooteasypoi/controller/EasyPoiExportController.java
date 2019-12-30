package com.rcy.springbooteasypoi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.rcy.springbooteasypoi.bean.StudentEntity;
import com.rcy.springbooteasypoi.bean.TreePO;
import com.rcy.springbooteasypoi.mapper.TreePOMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @description: 基于Easy POI的 web 导出
 * @author: rencaiyu
 * @create: 2019年12月25日 11:07
 **/
@Controller
@RequestMapping("/easyPOI")
public class EasyPoiExportController {

    @Autowired
    TreePOMapper treePOMapper;

    /**
     * @param request
     * @param response
     * @throws Exception
     * @description: 基于Easy POI的webd导出
     */
    @RequestMapping("/export")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<StudentEntity> studentEntityList = new ArrayList<>();
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId("1");
        studentEntity.setName("张三");
        studentEntity.setBirthday(new Date());

        StudentEntity studentEntityOne = new StudentEntity();
        studentEntityOne.setId("2");
        studentEntityOne.setName("李四");
        studentEntityOne.setBirthday(new Date());

        studentEntityList.add(studentEntity);
        studentEntityList.add(studentEntityOne);

        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("此Excel", "UTF-8") + ".xls");
        //编码
        response.setCharacterEncoding("UTF-8");
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("学生管理", "学生信息表", ExcelType.XSSF),
                StudentEntity.class, studentEntityList);
        workbook.write(response.getOutputStream());

    }

    /**
     * @param request
     * @param response
     * @throws Exception
     * @description: 基于Easy POI的webd导出   大数据量
     */
    @RequestMapping("/exportExcelBigData")
    public void exportExcelBigData(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<TreePO> treePoList = treePOMapper.selectAll();
        ExportParams params = new ExportParams("大数据测试", "测试");
        Workbook workbook = ExcelExportUtil.exportBigExcel(params, TreePO.class, treePoList);
        ExcelExportUtil.closeExportBigExcel();

        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("此Excel", "UTF-8") + ".xls");
        //编码
        response.setCharacterEncoding("UTF-8");
        workbook.write(response.getOutputStream());
    }


}
