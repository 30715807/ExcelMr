package unit.xml2class;

import unit.excel.model.CellVo;
import java.io.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class XMLConverter {
 
 
   
   public static Object XML2Class(String XMLFilePath,Object T){
	   try {
			   File file = new File(XMLFilePath);
			   
			   JAXBContext jaxbContext = JAXBContext.newInstance(T.getClass());//JAXBContext�࣬��Ӧ�õ���ڣ����ڹ���XML/Java����Ϣ��������������顢�������֤
			   Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();//Marshaller�ӿڣ���Java�������л�ΪXML���ݡ�
			   Object objInstance = jaxbUnmarshaller.unmarshal(file);//Unmarshaller�ӿڣ���XML���ݷ����л�ΪJava��������
			   return objInstance;
		  } catch (JAXBException e) {
			  e.printStackTrace();
			  return null;
		  }
   }   
   
   
   public static void Class2XML(String OutXMLPath,Object T){

		  try {
			  File file = new File(OutXMLPath);
			  JAXBContext jaxbContext = JAXBContext.newInstance(CellVo.class);
			  Marshaller jaxbMarshaller = jaxbContext.createMarshaller();//��������ģʽ���������κ�ȫ�� XML Ԫ�ؽ���Ϊʵ���ĵ��ĸ�

			  // output pretty printed
			  jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			  jaxbMarshaller.marshal(T, file);//��Java����ת����XML
			  //jaxbMarshaller.marshal(T, System.out);
	 
		  } catch (JAXBException e) {
			 e.printStackTrace();
		  }
	 
   }
   
}
