package unit.excel;

import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class Writer
{
	WritableWorkbook book = null;
	WritableSheet sheet = null;
    
	public Writer(){
		
	}

	//Ĭ��table
	public Writer(String filePath){
		createExcel(filePath);
	}
 
	 public WritableWorkbook createExcel(String filePath)
	 {
		  try
		  {
			  book = Workbook.createWorkbook(new File(filePath));
			  return book;
		  }
		  catch (IOException e)
		  {
			  e.printStackTrace();
			  return null;
		  }
		  
	 }

	 
	 //����ģ�崴���ļ�
	 public WritableWorkbook createExcel(String filePath,String TempletFilePath) 
	 {
		  try
		  {
			  Workbook TempletBook = Workbook.getWorkbook(new File(TempletFilePath)); 
			  book = Workbook.createWorkbook(new File(filePath),TempletBook);
			  return book;
		  }
		  catch (Exception e)
		  {
			  e.printStackTrace();
			  return null;
		  }
	 }
	 
	 
	 public WritableSheet createSheet(String SheetName){
		 sheet = book.createSheet(SheetName, 0);
		 return sheet;
	 }
	 
	 
	 //����table header��ͷ
	 public WritableSheet setTableHeader(ResultSetMetaData rsmd,String SheetName)
	 {
		  WritableFont font = new WritableFont(WritableFont.createFont("����"),10, WritableFont.BOLD, false);
		  WritableCellFormat cellFormat = new WritableCellFormat(font);

		  try
		  {
			   cellFormat.setWrap(true);//�Զ�����
			   cellFormat.setAlignment(Alignment.CENTRE);//ˮƽ����
			   cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);//��ֱ���뷽ʽ
				
			   //���������������еĿ��
				for(int i=1;i<rsmd.getColumnCount();i++){
				   sheet.setColumnView(i-1,20);//set column width size
                   sheet.addCell(new Label(i-1, 0, rsmd.getColumnLabel(i), cellFormat));
				}
		  }
		  catch (Exception e)
		  {
			  e.printStackTrace();
		  }
		  return sheet;
	 }


	 //����table ������
	 public void setTableData(ResultSet rs,String SheetName) throws Exception{
		 		 
		if(rs==null) return;

		WritableFont font = new WritableFont(WritableFont.createFont("����"),10, WritableFont.NO_BOLD, false);
		WritableCellFormat cellFormat = new WritableCellFormat(font);

		cellFormat.setWrap(true);//�Զ�����
		cellFormat.setAlignment(Alignment.LEFT);//ˮƽ����
		cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);//��ֱ���뷽ʽ
   
		int rowi=1;// ��������
		ResultSetMetaData rsmd=rs.getMetaData();

		while (rs.next())
		{
			for(int i=1;i<rsmd.getColumnCount();i++){
				sheet.addCell(new Label(i-1,rowi, rs.getString(i), cellFormat));
			}
			rowi++;
		}
	 }
 
	 
	 public void write() throws Exception{
	    this.book.write();	 
	 }
	 
	 
	 public void closeBook() throws WriteException, IOException{
		 this.book.close();
	 }
	 
	 
	 public void downLoad(String FilePath) throws Exception{
		   //super.getHttpServletResponse().setContentType("application/x-msdownload");
		   //String encodetittle = new String(excelName.getBytes("GBK"), "ISO-8859-1");
		   //super.getHttpServletResponse().addHeader("Content-Disposition","attachment;filename="+encodetittle+".xls");
		   FileInputStream finput = new FileInputStream(FilePath);
		   //OutputStream output = super.getHttpServletResponse().getOutputStream();
		   File fout = new File(FilePath);
		   OutputStream output = new FileOutputStream(fout);
		   BufferedInputStream buffin = new BufferedInputStream(finput);
		   BufferedOutputStream buffout = new BufferedOutputStream(output);
		   byte[] buffer = new byte[4096];
		   int count = 0;
		   while ((count = buffin.read(buffer, 0, buffer.length)) > 0) {
		   buffout.write(buffer, 0, count);
		   }
		   buffin.close();
		   buffout.close();
		   finput.close();
		   output.close();
	 }
	 
}