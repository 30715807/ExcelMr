package test.report;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;

import unit.db.DbHelper;
import unit.excel.*;


public class TestTableWrite {
	
	
	DbHelper dbHelper = new DbHelper();	
	
	public static void main(String[] args) {
		
		TestTableWrite test = new TestTableWrite();
		try {
			String filename=System.getProperty("user.dir")+"\\conf\\export\\TestTableWrite.xls";
			
			//����EXCEL
			test.writeExcle(test.getReport(),filename);

		} catch (Exception e) {
			e.printStackTrace();
		}
		test.dbHelper.CloseDatabase();
	}

	
	//��ȡ���ݿ���esb_msg����
	private ResultSet getReport(){
		try{
			ResultSet rs=dbHelper.executeQuery("select * from esb_msg order by msgcd");
		    return rs;
		    
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	private void writeExcle(ResultSet rs,String FilePath) throws Exception
	{
		Writer writer = new Writer(FilePath);
		writer.createSheet("esbmsg");
		ResultSetMetaData rsmd = rs.getMetaData();
		writer.setTableHeader(rsmd,"esbmsg");//��EXcel���ñ�������ı����ݵ�
		writer.setTableData(rs,"esbmsg");//��EXcel���ñ�������ı����ݵ�
		writer.write();
		writer.closeBook();
		System.out.println(this.getClass().getName()+"/" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}