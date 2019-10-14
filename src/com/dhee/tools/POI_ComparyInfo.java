package com.dhee.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;

import com.dhee.vo.ComparyInfo;
import com.dhee.vo.StudentInfo;

public class POI_ComparyInfo {
	
	public HSSFWorkbook getExcel(List<ComparyInfo> list) {
		ComparyInfo si;
		// 获得excel模板的路径
		String sourceFilePath = ServletActionContext.getServletContext().getRealPath("/EXL")+"\\StudentInfo.xls";
		// 文件链接器
		POIFSFileSystem fs;
		// exl工作bo
		HSSFWorkbook wb=null;
		try {
			fs = new POIFSFileSystem(new FileInputStream(sourceFilePath));
			wb = new HSSFWorkbook(fs);
			// 获得exl表
			HSSFSheet sheet = wb.getSheetAt(1);
			// 根据记录的数量插入行
			// 添加空行
			HSSFRow sourceRow = null;
			HSSFRow targetRow = null;
			HSSFCell sourceCell = null;
			HSSFCell targetCell = null;
			int num = list.size() - 2;// 表中留有两个空行，只需插入list.size()-2个空行就行
			if (num > 0) {
				for (int j = 1; j <= num; j++) {
					sheet.shiftRows(2 + j, 20 + j, 1, true, false); // 底部数据向下移动一行
					sourceRow = sheet.getRow(1 + j); // 源行
					targetRow = sheet.getRow(2 + j); // 新加入的行
					for (int i = sourceRow.getFirstCellNum(); i < sourceRow.getLastCellNum(); i++) {
						sourceCell = sourceRow.getCell(i);
						targetCell = targetRow.createCell(i);
						targetCell.setCellStyle(sourceCell.getCellStyle());
						targetCell.setCellType(sourceCell.getCellType());
					}
				}
			}

			for (int i = 0; i < list.size(); i++) {
				si = (ComparyInfo) list.get(i);
				// 设置序号的值
				HSSFRow row = sheet.getRow(2 + i);
				HSSFCell cell = row.getCell(0);
				cell.setCellValue(i + 1);

				// 设置班级的值
				row = sheet.getRow(2 + i);
				cell = row.getCell(1);
				cell.setCellValue(si.getComName());

				// 设置姓名的值
				row = sheet.getRow(2 + i);
				cell = row.getCell(2);
				cell.setCellValue(si.getComMan());

				// 设置就业情况的值
				row = sheet.getRow(2 + i);
				cell = row.getCell(3);
				cell.setCellValue(si.getZhiWu());
				
				// 设置出生年月日的值
				row = sheet.getRow(2 + i);
				cell = row.getCell(4);
				cell.setCellValue(si.getZuoJi());

				// 设置毕业时间的值
				row = sheet.getRow(2 + i);
				cell = row.getCell(5);
				cell.setCellValue(si.getShouJi());
				
				// 设置所在院校的值
				row = sheet.getRow(2 + i);
				cell = row.getCell(6);
				cell.setCellValue(si.getQq());
				
				// 设置专业的值
				row = sheet.getRow(2 + i);
				cell = row.getCell(7);
				cell.setCellValue(si.getWeiXin());
				
				// 设置学历的值
				row = sheet.getRow(2 + i);
				cell = row.getCell(8);
				cell.setCellValue(si.getEmail());
				// 设置外语语种的值
				row = sheet.getRow(2 + i);
				cell = row.getCell(9);
				cell.setCellValue(si.getDiZhi());
				// 设置级别的值
				row = sheet.getRow(2 + i);
				cell = row.getCell(10);
				cell.setCellValue(si.getFaPiao());
				// 设置分数的值
				row = sheet.getRow(2 + i);
				cell = row.getCell(11);
				cell.setCellValue(si.getBeiZhu());
				
				row.setHeightInPoints(20.00f);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return wb;
	}

}
