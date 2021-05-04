package yieom.javastudy.technic.ui;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

import yieom.javastudy.technic.R;
import yieom.javastudy.technic.utils.GeneralUtil;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private String TAG = getClass().getName();
    private List<Fragment> fragments;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position < fragments.size())
            return fragments.get(position);
        return null;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
