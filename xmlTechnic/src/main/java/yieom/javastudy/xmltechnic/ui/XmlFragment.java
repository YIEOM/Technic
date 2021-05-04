package yieom.javastudy.xmltechnic.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import yieom.javastudy.xmltechnic.R;
import yieom.javastudy.xmltechnic.databinding.XmlFragmentBinding;

public class XmlFragment extends Fragment {
    private XmlFragmentBinding binding;
    private XmlViewModel vm;

    public static XmlFragment newInstance() {
        return new XmlFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //Fragment Binding하여 root를 반환
        binding = DataBindingUtil.inflate(inflater, R.layout.xml_fragment,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = new ViewModelProvider(this).get(XmlViewModel.class);
        // TODO: Use the ViewModel
        binding.setVm(vm);
        vm.init();
    }
}
