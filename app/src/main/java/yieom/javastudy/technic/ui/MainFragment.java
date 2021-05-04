package yieom.javastudy.technic.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import yieom.javastudy.technic.R;
import yieom.javastudy.technic.databinding.MainFragmentBinding;

public class MainFragment extends Fragment {
    private MainFragmentBinding binding;
    private MainFrgViewModel vm;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //Fragment Binding하여 root를 반환
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = new ViewModelProvider(this).get(MainFrgViewModel.class);
        // TODO: Use the ViewModel
        binding.setVm(vm);
        vm.init();
    }
}