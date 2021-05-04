package yieom.javastudy.technic.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import yieom.javastudy.contentprovidera.ui.Page1Fragment;
import yieom.javastudy.contentproviderb.ui.Page2Fragment;
import yieom.javastudy.technic.R;
import yieom.javastudy.technic.databinding.MainActivityBinding;
import yieom.javastudy.technic.utils.GeneralUtil;

public class MainActivity extends AppCompatActivity {
    private MainViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.main));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.xml_technic));
        tabLayout.addTab(tabLayout.newTab().setText("Page2"));

        vm = new MainViewModel(
                getSupportFragmentManager(),
                new TabLayout.ViewPagerOnTabSelectedListener((ViewPager)findViewById(R.id.viewPager)),
                new TabLayout.TabLayoutOnPageChangeListener((TabLayout)findViewById(R.id.tabLayout)));
        binding.setVm(vm);
        vm.init();

        //        setContentView(R.layout.main_activity);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container,MainFragment.newInstance())
//                    .commitNow();
//        }
    }
}