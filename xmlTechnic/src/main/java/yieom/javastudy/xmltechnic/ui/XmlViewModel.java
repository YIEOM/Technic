package yieom.javastudy.xmltechnic.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import yieom.javastudy.xmltechnic.AppModule;
import yieom.javastudy.xmltechnic.R;
import yieom.javastudy.xmltechnic.platform.IXmlBuilder;
import yieom.javastudy.xmltechnic.platform.IXmlParser;
import yieom.javastudy.xmltechnic.platform.XmlBuilder;
import yieom.javastudy.xmltechnic.platform.XmlParser;
import yieom.javastudy.xmltechnic.utils.GeneralUtil;

public class XmlViewModel extends ViewModel {
    private String TAG = getClass().getName();

    VmHandler mVmHandler;
    public void init() {
        mVmHandler = new VmHandler(this);
        xmlBuildingBtn.set(GeneralUtil.getString(R.string.xml_build));
        xmlParsingBtn.set(GeneralUtil.getString(R.string.xml_parse));
    }

    public final ObservableField<String> xmlBuildingBtn = new ObservableField<>();
    public void onClickXmlBuildingBtn() {
        GeneralUtil.printLog(TAG,"onClickXmlBuildingBtn","click","");
        IXmlBuilder xmlBuilder = new XmlBuilder();
        xmlBuilder.buildXml();
    }

    public final ObservableField<String> xmlParsingBtn = new ObservableField<>();
    public void onClickXmlParsingBtn() {
        GeneralUtil.printLog(TAG,"onClickXmlParsingBtn","click","");
        IXmlParser xmlParser = new XmlParser();
        HashMap<String,String> map = xmlParser.parseXml();
        String msg = "root_txt : " + map.get("root_txt")
                + ",\nchild1_txt : " + map.get("child1_txt")
                + ",\nchild1-1_txt : " + map.get("child1-1_txt")
                + ",\nchild2_attr : " + map.get("child2_attr")
                + ",\nchild2_txt : " + map.get("child2_txt")
                + ",\nchild3_txt : " + map.get("child3_txt");
        sendMsgToHandler(msg);
    }

    public void showToast(String msg) {
        Toast.makeText(AppModule.provideContext(),msg,Toast.LENGTH_SHORT).show();
    }

    private void sendMsgToHandler(String msg) {
        Message message = new Message();
        message.what = 100000;
        message.obj = msg;
        mVmHandler.sendMessage(message);
    }

    private class VmHandler extends Handler {
        private WeakReference<XmlViewModel> mVm;
        public VmHandler(XmlViewModel vm) {
            mVm = new WeakReference<>(vm);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mVm.get().showToast((String)msg.obj);
        }
    }
}
