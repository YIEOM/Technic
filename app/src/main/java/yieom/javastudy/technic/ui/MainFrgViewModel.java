package yieom.javastudy.technic.ui;

import android.content.Intent;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import yieom.javastudy.technic.App;
import yieom.javastudy.technic.R;
import yieom.javastudy.technic.utils.GeneralUtil;

public class MainFrgViewModel extends ViewModel {
    private String TAG = getClass().getName();

    public void init() {
        cntPrvBtn.set(GeneralUtil.getString(R.string.cnt_prv));
    }

    public final ObservableField<String> cntPrvBtn = new ObservableField<>();
    public void onClickCntPrvBtn() {
        GeneralUtil.printLog(TAG,"onClickCntPrvBtn","click","");
        Intent intent = new Intent();
        intent.setClassName("yieom.javastudy.technic","yieom.javastudy.contentprovidera.MainActivity");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        App.getContext().startActivity(intent);
    }
}
