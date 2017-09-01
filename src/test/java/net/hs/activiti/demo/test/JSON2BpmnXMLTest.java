package net.hs.activiti.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.hs.activiti.demo.entity.JsPlumbConnEntity;
import net.hs.activiti.demo.entity.JsPlumbNodeEntity;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.List;

/**
 * Project ： net.hs.activiti.demo
 * PackageName ： net.hs.activiti.demo.test
 * Author ： caijl
 * Date ： 2017/8/3
 * Time ： 14:07
 * Description :
 * 系统版本 ： 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JSON2BpmnXMLTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String XML_HEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:tns=\"http://www.activiti.org/test\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" expressionLanguage=\"http://www.w3.org/1999/XPath\" id=\"m1501399310132\" name=\"\" targetNamespace=\"http://www.activiti.org/test\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\">";
    public static final String XML_FOOTER = "</definitions>";

    public static  final String JSONSTRING = "{" +
            "\"nodes\":[" +
            "    {" +
            "      \"id\": \"node_1500882698434\"," +
            "      \"type\": \"start\"," +
            "      \"text\": \"开始\"," +
            "      \"left\": 337," +
            "      \"top\": 50," +
            "      \"resourceId\": \"sid-B321D128-7104-4028-B206-F570908C2E3E\"," +
            "      \"data\": {}" +
            "    }," +
            "    {" +
            "      \"id\": \"node_1500882710076\"," +
            "      \"type\": \"addtag\"," +
            "      \"text\": \"添加标签\"," +
            "      \"left\": 340," +
            "      \"top\": 210," +
            "      \"resourceId\": \"sid-CF7F9655-3B2D-46D8-9134-BE9CC969F101\"," +
            "      \"data\": {}" +
            "    }," +
            "    {" +
            "      \"id\": \"node_1500882719775\"," +
            "      \"type\": \"end\"," +
            "      \"text\": \"结束\"," +
            "      \"left\": 553," +
            "      \"top\": 568," +
            "      \"resourceId\": \"sid-642060DD-DD8D-4FD0-BB85-755A92B06E17\"," +
            "      \"data\": {}" +
            "    }" +
            "  ]," +
            "  \"connectors\": [" +
            "    {" +
            "      \"source\": \"node_1500882710076BottomCenter\"," +
            "      \"target\": \"node_1500882719775TopCenter\"," +
            "      \"resourceId\": \"sid-A5FC0276-186A-4125-86D9-89D3F3EAC9E2\"," +
            "      \"sourceId\": \"sid-CF7F9655-3B2D-46D8-9134-BE9CC969F101\"," +
            "      \"targetId\": \"sid-642060DD-DD8D-4FD0-BB85-755A92B06E17\"" +
            "    }," +
            "    {" +
            "      \"source\": \"node_1500882698434BottomCenter\"," +
            "      \"target\": \"node_1500882710076TopCenter\"," +
            "      \"resourceId\": \"sid-18DE53D8-F0CC-4D88-8727-302F52EC865F\"," +
            "      \"sourceId\": \"sid-B321D128-7104-4028-B206-F570908C2E3E\"," +
            "      \"targetId\": \"sid-CF7F9655-3B2D-46D8-9134-BE9CC969F101\"" +
            "    }" +
            "  ]," +
            "  \"bounds\": {" +
            "    \"lowerRight\": {" +
            "      \"x\": 10000," +
            "      \"y\": 10000" +
            "    }," +
            "    \"upperLeft\": {" +
            "      \"x\": 0," +
            "      \"y\": 0" +
            "    }" +
            "  }" +
            "}";

    /**
     * JsPlumb
     */
    @Test
    public void json2XML() throws Exception{
        JSONObject jsonObject = JSON.parseObject(JSONSTRING);
        Object jsonNodesArray = jsonObject.get("nodes");
        Object jsonConnArray = jsonObject.get("connectors");
        logger.debug("JSON转化对象-Node节点：" + jsonNodesArray);
        List<JsPlumbNodeEntity> nodeEntityList = JSON.parseArray(jsonNodesArray+"", JsPlumbNodeEntity.class);
        for(JsPlumbNodeEntity jsPlumbNodeEntity : nodeEntityList){
            logger.debug("Node节点ID: " + jsPlumbNodeEntity.getId());
        }
        logger.debug("JSON转化对象-Conn节点：" + jsonConnArray);
        List<JsPlumbConnEntity> connEntityList = JSON.parseArray(jsonConnArray+"", JsPlumbConnEntity.class);
        for(JsPlumbConnEntity jsPlumbConnEntity : connEntityList){
            logger.debug("Conn节点ID: " + jsPlumbConnEntity.getResourceId());
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(XML_HEAD);
        stringBuffer.append("<process id=\"createTest\" isClosed=\"false\" isExecutable=\"true\" name=\"createTestProcess\" processType=\"None\">");
        if(null != nodeEntityList && nodeEntityList.size() != 0){
            for(JsPlumbNodeEntity jsPlumbNodeEntity : nodeEntityList){
                if("start".equals(jsPlumbNodeEntity.getType().trim())){
                    stringBuffer.append("<startEvent id=\"" + jsPlumbNodeEntity.getResourceId()+"\" name=\"StartEvent\"/>");
                }else if("end".equals(jsPlumbNodeEntity.getType().trim())){
                    stringBuffer.append("<endEvent id=\""+jsPlumbNodeEntity.getResourceId()+"\" name=\"EndEvent\"/>");
                }else{
                    stringBuffer.append("<userTask activiti:exclusive=\"true\" id=\""+jsPlumbNodeEntity.getResourceId()+"\" name=\""+jsPlumbNodeEntity.getText()+"\"/>");
                }
            }
        }
        if(null != connEntityList && connEntityList.size() != 0){
            for(JsPlumbConnEntity jsPlumbConnEntity : connEntityList){
                stringBuffer.append("<sequenceFlow id=\""+jsPlumbConnEntity.getResourceId()+"\" sourceRef=\""+jsPlumbConnEntity.getSourceId()+"\" targetRef=\""+jsPlumbConnEntity.getTargetId()+"\"/>");
            }
        }
        stringBuffer.append("</process>");
        stringBuffer.append(XML_FOOTER);
        logger.debug("格式化JsPlumb数据为XML：\n"+formatXML(stringBuffer.toString()));
        writeXMLFile(formatXML(stringBuffer.toString()));
        logger.debug("将文件写入到本地");
    }

    /**
     * 格式化XML文件格式
     * @param inputXML
     * @return
     * @throws Exception
     */
    public String formatXML(String inputXML) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new StringReader(inputXML));
        String requestXML = null;
        XMLWriter writer = null;
        if (document != null) {
            try {
                StringWriter stringWriter = new StringWriter();
                OutputFormat format = new OutputFormat(" ", true);
                writer = new XMLWriter(stringWriter, format);
                writer.write(document);
                writer.flush();
                requestXML = stringWriter.getBuffer().toString();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        logger.error("出错了");
                    }
                }
            }
        }
        return requestXML;
    }

    /**
     * 将XML文件写入到本地指定路径文件下
     */
    public void createXMLFile(String xmlString) throws Exception{
        File file =new File("E:/GIT/SPRING_CLOUD/SPRING_BOOT_ACTIVITI/SpringBoot-Activiti-Demo/src/main/resources/processes/hhh.bpmn");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);
            bw.write(xmlString + "\n");
            bw.newLine();
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                bw.close();
                fw.close();
            } catch (IOException e1) {
                logger.error("哦，好像出错了。");
            }
        }
    }

    public void writeXMLFile(String xmlString) throws Exception{
        SAXReader reader = new SAXReader();
        Document document = reader.read(new StringReader(xmlString));
        FileWriter fileWriter = new FileWriter("E:/GIT/SPRING_CLOUD/SPRING_BOOT_ACTIVITI/SpringBoot-Activiti-Demo/src/main/resources/processes/hhh111.bpmn");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(System.out, format);
        writer.setWriter(fileWriter);
        writer.write(document);
        writer.close();
    }

}
