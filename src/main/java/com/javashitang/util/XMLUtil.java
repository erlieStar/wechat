package com.javashitang.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLUtil {

    public static Map<String, String> xml2Map(HttpServletRequest request) throws IOException, DocumentException {

        Map<String,String> map = new HashMap<>();
        SAXReader reader = new SAXReader();

        InputStream inputStream = request.getInputStream();
        Document doc = reader.read(inputStream);

        Element root = doc.getRootElement();

        List<Element> list = root.elements();

        for (Element e : list){
            map.put(e.getName(),e.getText());
        }

        inputStream.close();
        return map;
    }
}
