package unit.excel.mode.controller;

import unit.excel.model.CellVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import jxl.Sheet;


public class CellContorller {   
   //��ȡ�ǽṹ��������
   public  List<CellVo>  getUnstructList(List<CellVo> Cells,Sheet BookSheet){
	   if(Cells == null || Cells.size()==0)
		   return null;
	   String cellData;
	   for(int i=0 ;i< Cells.size(); i++){
		   //con.excel.*.xml�� cell x,y�����1��ʼ,ʵ������-1
		   int x = Cells.get(i).getX()-1;
		   int y = Cells.get(i).getY()-1;
		   cellData = BookSheet.getCell(y,x).getContents();
		   if(cellData == null)
			  Cells.get(i).setValue("");
		   else
		      Cells.get(i).setValue(cellData); 
	   }
	   return Cells;
   }
   
   //��ȡ�ǽữ�����ݣ�map����
   public Map<String, CellVo> getUnstructMap(List<CellVo> Cells,Sheet BookSheet){
	   Map<String, CellVo> unstructMap = new HashMap<String, CellVo>();
	   
	   if(Cells == null || Cells.size()==0)
		   return null;
	   String cellData;
	   for(int i=0 ;i< Cells.size(); i++){
		   //con.excel.*.xml�� cell x,y�����1��ʼ,ʵ������-1
		   int x = Cells.get(i).getX()-1;
		   int y = Cells.get(i).getY()-1;
		   cellData = BookSheet.getCell(y,x).getContents();
		   Cells.get(i).setValue(cellData);
		   unstructMap.put(Cells.get(i).getKey(),Cells.get(i));
	   }
	   return unstructMap;
   }
   

//��ȡ�ṹ��������
@SuppressWarnings({ "rawtypes", "unchecked" })
public ArrayList getTableData(List<CellVo> Cells,Sheet BookSheet){
	   
	   if(Cells == null || Cells.size()==0)
	   {
		   System.out.println("cells is null");
		   return null;
	   }
		   
	   ArrayList dataList = new ArrayList();//������ݼ�

	   CellVo cellVo = new CellVo();
	
	   //��ȡTABLE ����ʼ����XY(ͨ��0,0���궨λ)
	   cellVo = Cells.get(0);
	   int tagblePointX = cellVo.getX()-1;
	   int tagblePointY = cellVo.getY()-1; 
       	   
	   try{
		    System.out.println("Cells.size()"+Cells.size());
		    String cellTxt;
		    
			for (int rowi=tagblePointX; rowi<BookSheet.getRows(); rowi++)
			{
				String[] dataRow = new String[Cells.size()] ;
				int x=0;
				for (int colj=tagblePointY; colj<BookSheet.getColumns(); colj++)
				{
					cellTxt = BookSheet.getCell(colj, rowi).getContents();
					dataRow[x] = cellTxt;
					x++;
				}
				dataList.add(dataRow);
			}
			
			return 	dataList;	
		}catch(Exception ex){
		   System.out.println(this.getClass().getName()+" Exception\n"+ex.getStackTrace());
		   return null;
		}
   }
}
