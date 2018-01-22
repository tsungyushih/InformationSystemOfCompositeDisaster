package com.frandog.informationsystemofcompositedisaster;

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Tsung on 2018/1/16.
 */

public class ReadXMLFromZIP {
    public  void main(String[] args) throws Exception {

        String zipfile_dir = "C:\\Users\\Tsung\\Desktop\\a";
        try {
            readZipFile(zipfile_dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readZipFile(String file) throws Exception {

        readZipFile(new File(file));
    }

    public void readZipFile(File file) throws Exception {

        ZipFile zf = new ZipFile(file, Charset.forName("GBK"));
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        ZipInputStream zis = new ZipInputStream(in);
        ZipEntry ze;
        while ((ze = zis.getNextEntry()) != null) {
            if (ze.isDirectory()) {
            } else {
                if (ze.getName().endsWith(".xml")) {
                    System.err.println("file - " + ze.getName() + " : " + ze.getSize() + " bytes");
                    Log.d("xxxxxxx","file - " + ze.getName() + " : " + ze.getSize() + " bytes");
                    if (ze.getSize() > 0) {
                        File new_xml_file = null;
                        BufferedReader br = new BufferedReader(new InputStreamReader(zf.getInputStream(ze), "GBK"));
                        if ((ze.getName().trim().lastIndexOf("/")) != -1) {
                            new_xml_file = new File(ze.getName().substring(ze.getName().trim().lastIndexOf("/")+1));
                            System.out.println(new_xml_file);
                        } else {
                            new_xml_file = new File(ze.getName());
                        }
                        FileOutputStream out = new FileOutputStream(new_xml_file);
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
                        String line;
                        while ((line = br.readLine()) != null) {
//                           System.out.println(line);
                            bw.write(line);
                        }
                        br.close();
                        bw.close();

                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder builder = factory.newDocumentBuilder();
                        Document document = builder.parse(new_xml_file);
                        Element root = document.getDocumentElement();
                        NodeList nodeList = root.getElementsByTagName("description");
                        for (int i = 0; i < nodeList.getLength(); i++) {
                            Element element = (Element) nodeList.item(i);
                            System.out.println("description:" + element.getTextContent());
                            Log.d("qqqqqqq","description:" + element.getTextContent());
                        }
                        new_xml_file.delete();
                    }
                }
            }
        }
        zis.closeEntry();
        zis.close();
        zf.close();
    }
}
