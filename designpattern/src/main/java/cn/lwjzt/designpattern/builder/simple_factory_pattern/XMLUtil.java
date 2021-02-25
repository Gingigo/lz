package cn.lwjzt.designpattern.builder.simple_factory_pattern;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;

public class XMLUtil {
    //该方法用于从XML配置文件中提取图表类型，并返回类型名
    public static Integer getMachineType() {
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("designpattern/src/main/java/cn/lwjzt/designpattern/builder/simple_factory_pattern/config.xml"));
            //获取包含图表类型的文本节点
            NodeList nl = doc.getElementsByTagName("MachineType");
            Node classNode = nl.item(0).getFirstChild();
            String machineType = classNode.getNodeValue().trim();
            return Integer.parseInt(machineType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
