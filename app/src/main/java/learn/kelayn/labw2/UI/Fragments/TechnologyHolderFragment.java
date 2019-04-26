package learn.kelayn.labw2.UI.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import learn.kelayn.labw2.Adapters.ViewPagerAdapter;
import learn.kelayn.labw2.Data.Technology;
import learn.kelayn.labw2.R;

public class TechnologyHolderFragment  extends Fragment {

    View mFragmentView;
    ArrayList<Technology> mTechnologies;

    public TechnologyHolderFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mFragmentView = inflater.inflate(R.layout.fragment_technology_holder, container, false);
        mTechnologies = (ArrayList<Technology>) getArguments().getSerializable("data");

        ViewPager viewPager = mFragmentView.findViewById(R.id.fragmentHolder);
        ViewPagerAdapter adapter = new ViewPagerAdapter(mTechnologies, getChildFragmentManager());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(getArguments().getInt("item_number"));

        return mFragmentView;
    }
}
