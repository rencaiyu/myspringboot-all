package com.rcy.springbooteasypoi.exportutil;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.rcy.springbooteasypoi.bean.StudentEntity;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 * @description:
 * @author: rencaiyu
 * @create: 2019年12月25日 11:11
 **/
public class Test {

    //本地测试的方法,建议拿到test里测试
    public static void main(String[] args) throws Exception {
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

        FileOutputStream fileOutputStream = new FileOutputStream("aaa");
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生", "学生"),
                StudentEntity.class, studentEntityList);
        workbook.write(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();

    }
}
