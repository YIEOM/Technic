package yieom.javastudy.xmltechnic.platform;

import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Xml;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import yieom.javastudy.xmltechnic.AppModule;

public class XmlBuilder implements IXmlBuilder {
    private String TAG = getClass().getName();

    @Override
    public void buildXml() {
        File file = new File(AppModule.provideContext().getFilesDir(),"/test.xml");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fos = new FileOutputStream(file,false);

            XmlSerializer serial = Xml.newSerializer();
            serial.setOutput(fos, "UTF-8");
            serial.startDocument(null, null);

            serial.startTag(null, "root");

            serial.startTag(null, "child1");
            serial.startTag(null, "child1-1");
            serial.text("some text inside child1-1");
            serial.endTag(null, "child1-1");
            serial.endTag(null, "child1");

            serial.startTag(null, "child2");
            serial.attribute(null, "attribute", "value");
            serial.endTag(null, "child2");

            serial.startTag(null, "child3");
            serial.text("some text inside child3");
            serial.endTag(null, "child3");

            serial.endTag(null, "root");
            serial.endDocument();
            serial.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
