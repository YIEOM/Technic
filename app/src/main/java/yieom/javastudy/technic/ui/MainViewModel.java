package yieom.javastudy.technic.ui;

import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModel;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import yieom.javastudy.contentproviderb.ui.Page2Fragment;
import yieom.javastudy.technic.BuildConfig;
import yieom.javastudy.technic.R;
import yieom.javastudy.technic.utils.GeneralUtil;
import yieom.javastudy.xmltechnic.ui.XmlFragment;

public class MainViewModel extends ViewModel {
    private String TAG = getClass().getName();

    private FragmentStatePagerAdapter viewPagerAdapter;
    private TabLayout.ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener;
    private TabLayout.TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener;

    public MainViewModel(FragmentManager fm,
                         TabLayout.ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener,
                         TabLayout.TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener) {

        this.viewPagerOnTabSelectedListener = viewPagerOnTabSelectedListener;
        this.tabLayoutOnPageChangeListener = tabLayoutOnPageChangeListener;

        // ViewPagerAdapter 생성
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(MainFragment.newInstance());
        fragments.add(XmlFragment.newInstance());
        fragments.add(new Page2Fragment());
        viewPagerAdapter = new ViewPagerAdapter(fm,fragments);
    }

    public void init() {
        String main =  "";
        if(BuildConfig.FLAVOR.equals("tempApi1")) {
            main = "api1 "+GeneralUtil.getString(R.string.main);
        } else if(BuildConfig.FLAVOR.equals("tempApi2")) {
            main = "api2 "+GeneralUtil.getString(R.string.main);
        }
        mainTxt.set(main);
    }

    public FragmentStatePagerAdapter getViewPagerAdapter() {
        return viewPagerAdapter;
    }

    public TabLayout.ViewPagerOnTabSelectedListener getViewPagerOnTabSelectedListener() {
        return viewPagerOnTabSelectedListener;
    }

    public TabLayout.TabLayoutOnPageChangeListener getTabLayoutOnPageChangeListener() {
        return tabLayoutOnPageChangeListener;
    }

    public final ObservableField<String> mainTxt = new ObservableField<>();
}
