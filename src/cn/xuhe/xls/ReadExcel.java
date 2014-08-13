package cn.xuhe.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import cn.xuhe.xls.SqlOperator;
import cn.xuhe.xls.MyThread;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {
//	private String filePath = "C:/Users/ҫ��/Desktop";
	private Workbook workbook;
	public Sheet sheet;
	private String fileName;

	public ReadExcel(File file) throws BiffException {
//		File file = new File(filePath + File.separator + fileName);
		if (!file.exists()) {
			System.out.println("文件不存在");
		} else {
			try {
				InputStream in = new FileInputStream(file);
				workbook = Workbook.getWorkbook(in);
				sheet = workbook.getSheet(0);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println(e.toString());
				e.printStackTrace();
			}

		}

	}

//	public boolean readFromExcel() {
//		int rowCounts = sheet.getRows();
//		int columnCounts = sheet.getColumns();
//		System.out.println("row: " + rowCounts + "\tcolumn: " + columnCounts);
//		for (int i = 0; i < rowCounts; i++) {
//			for (int j = 0; j < columnCounts; j++) {
//				Cell cell = sheet.getCell(j, i);// �����,�����.��i��j��
//
//				String cellContent = cell.getContents();
//				System.out.println("the data in cell is: " + cellContent
//						+ "\t����Ϊ: " + cell.getType());
//			}
//		}
//
//		return true;
//	}

//	public static void main(String[] args) throws InstantiationException,
//			IllegalAccessException, ClassNotFoundException, SQLException {
//		
//		ReadExcel readExcel = null;
//		try {
//			readExcel = new ReadExcel(fileName);
//			// ��ӡexcel�ļ�����
//			// readExcel.readFromExcel();
//
//		} catch (BiffException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// �����������߳�ִ����ݿ��Ľ�������ݲ��붯��
//		// for(int i=0;i<1000;i++){
//		MyThread myThread = new MyThread(ConstantValues.databaseName, readExcel.sheet);
//		new Thread(myThread).start();
//		// }
//	}
}
