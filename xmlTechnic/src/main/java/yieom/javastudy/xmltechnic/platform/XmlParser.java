package yieom.javastudy.xmltechnic.platform;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import yieom.javastudy.xmltechnic.AppModule;

public class XmlParser implements IXmlParser {
    private String TAG = getClass().getName();

    static final int STEP_NONE = 0 ;
    static final int STEP_ROOT = 1 ;
    static final int STEP_CHILD1 = 2 ;
    static final int STEP_CHILD1_1 = 3 ;
    static final int STEP_CHILD2 = 4 ;
    static final int STEP_CHILD3 = 5 ;

    @Override
    public HashMap<String,String> parseXml() {
        HashMap<String,String> map = new HashMap<String,String>();

        File file = new File(AppModule.provideContext().getFilesDir(),"/test.xml");
        try {
            FileInputStream fis = new FileInputStream(file);

            XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
            //공백도 포함
            parserFactory.setNamespaceAware(true);
            XmlPullParser parser = parserFactory.newPullParser();

            parser.setInput(fis,"UTF-8");

            int eventType = parser.getEventType() ;
            int step = STEP_NONE ;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_DOCUMENT) {
                    // XML 데이터 시작
                } else if (eventType == XmlPullParser.START_TAG) {
                    String startTag = parser.getName() ;
                    if (startTag.equals("root")) {
                        step = STEP_ROOT ;
                    } else if (startTag.equals("child1")) {
                        step = STEP_CHILD1 ;
                    } else if (startTag.equals("child1-1")) {
                        step = STEP_CHILD1_1 ;
                    } else if (startTag.equals("child2")) {
                        step = STEP_CHILD2 ;
                        map.put("child2_attr",parser.getAttributeValue(0));
                    } else if (startTag.equals("child3")) {
                        step = STEP_CHILD3 ;
                    } else {
                        step = STEP_NONE ;
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    String endTag = parser.getName() ;
                    if ((endTag.equals("root") && step != STEP_ROOT) ||
                            (endTag.equals("child1") && step != STEP_CHILD1) ||
                            (endTag.equals("child1-1") && step != STEP_CHILD1_1) ||
                            (endTag.equals("child2") && step != STEP_CHILD2) ||
                            (endTag.equals("child3") && step != STEP_CHILD3)) {
                        // TODO : error
                    }
                    step = STEP_NONE ;
                } else if (eventType == XmlPullParser.TEXT) {
                    String text = parser.getText() ;
                    if (step == STEP_ROOT) {
                        map.put("root_txt",text);
                    } else if (step == STEP_CHILD1) {
                        map.put("child1_txt",text);
                    } else if (step == STEP_CHILD1_1) {
                        map.put("child1-1_txt",text);
                    } else if (step == STEP_CHILD2) {
                        map.put("child2_txt",text);
                    } else if (step == STEP_CHILD3) {
                        map.put("child3_txt",text);
                    }
                }
                eventType = parser.next();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}
