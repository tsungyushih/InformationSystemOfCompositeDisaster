package com.frandog.informationsystemofcompositedisaster;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Student on 2018/1/23.
 */

public class Main4_MyHandler extends DefaultHandler {
    StringBuilder linkSB = new StringBuilder();
    StringBuilder descSB = new StringBuilder();

    boolean isSiteName = false;
    boolean isStatus = false;     //抓出來的第一行Mobile01 本站新聞不是頭條，所以要避開他
    boolean isAQI = false;
    boolean isPM25 = false;

    public ArrayList<Main4Item> newsItems = new ArrayList<>();
    Main4Item item;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        switch(qName)
        {
            case "SiteName":
                isSiteName = true;
                break;
            case "Status":
                isStatus = true;
                item = new Main4Item();
                break;
            case "AQI":
                isAQI = true;
                break;
            case "PM25":
                isPM25 = true;

                descSB = new StringBuilder();

                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
//        因為寫多個if看起來很亂，所以改switch寫法
//        if(qName.equals("title"))
//        {
//            isTitle = false;
//        }
//        if (qName.equals("item"))
//        {
//            isItem = false;
//            newsItems.add(item);
//        }
//        if(qName.equals("link"))
//        {
//            isLink = false;
//            if(isItem)
//            {
//                //links.add(linkSB.toString());     新創Mobile01NewsItem，因此改成下行那樣
//                item.link = linkSB.toString();
//                linkSB = new StringBuilder();
        switch(qName)
        {
            case "SiteName":
                isSiteName = false;
                break;
            case "Status":
                isStatus = false;
                newsItems.add(item);
                break;
            case "AQI":
                isAQI = false;
                if (isStatus)
                {
                    item.AQI = linkSB.toString();
                    linkSB = new StringBuilder();
                }
                break;
            case "description":


                if (isStatus)
                {
                    String str = descSB.toString();
                    Pattern pattern = Pattern.compile("https.*jpg");
                    Matcher m = pattern.matcher(str);
                    String imgurl = "";
                    if (m.find())
                    {
                        imgurl = m.group(0);
                    }
                    str = str.replaceAll("<img.*/>", "");
                    item.PM25 = str;
                }

                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
//        if(isTitle && isItem)
//        {
//
//            item.title = new String(ch,start,length);
//        }
//        if(isLink && isItem)
//        {
//            Log.d("NET2",new String(ch,start,length));
//            linkSB.append(new String(ch,start,length));
//        }
//        if (isDescription && isItem)
//        {
//
//            descSB.append(new String(ch, start, length));
//        }
    }
}
