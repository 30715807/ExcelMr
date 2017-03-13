package unit.excel.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)   //�����ֶλ����Ե����л���
										//FIELD��ʾJAXB���Զ���Java���е�ÿ���Ǿ�̬�ģ�static������˲̬�ģ���@XmlTransient��ע���ֶε�XML��
										//XmlAccessType.PROPERTY��XmlAccessType.NONE��
@XmlType(name = "", propOrder = {}) //@XmlType����Java���ö������ӳ�䵽XMLģʽ����
@XmlRootElement(name = "cell") //��Java���ö������ӳ�䵽XMLԪ�ء�
public class CellVo {
	
	@XmlElement//��Java���һ������ӳ�䵽������ͬ����һ��XMLԪ�ء�
	int x;
	
	@XmlElement
	int y;
	
	@XmlElement
	String key;//��ǩ����key
	
	@XmlElement
	String value;//��ǩֵvalue
	
//	String fontName;
//	String fontSize;
//	Boolean fontWeight = false;
//	String fontAlign;
//	String fontVAlign;

	
	public CellVo(){}
	
	public void setX(int x){
		this.x=x;
	}
	
	public int getX(){
		return this.x;
	}
	
	
	public void setY(int y){
		this.y= y;
	}
	
	
	public int getY(){
		return this.y;
	}
	
	
	
	public void setKey(String key){
		this.key= key;
	}
	
	
	public String getKey(){
		return this.key;
	}
	
	
	public void setValue(String value){
   	   this.value = value;
	}
		
	public String getValue(){
		return this.value;
	}
}
