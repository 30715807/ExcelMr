package unit.excel.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  	//ָ���Ƿ���ֶλ����Խ���ϵ�л��� 
@XmlType(name = "", propOrder = {})  
@XmlRootElement(name = "block")  
public class BlockVo {
	
	@XmlAttribute//��Java���һ������ӳ�䵽������ͬ����һ��XML���ԡ�
    private String blockType;

    public String getBlockType(){return this.blockType;}
    
    public void setBlockType(String blockType){this.blockType=blockType;}
    
    protected List<CellVo> cell;
    
	public List<CellVo> getCells() {
        if (cell == null) {
        	cell = new ArrayList<CellVo>();
        }
        return this.cell;
    }
}
