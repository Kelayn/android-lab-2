package learn.kelayn.labw2.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import learn.kelayn.labw2.Data.Technology;
import learn.kelayn.labw2.UI.Fragments.TechnologyFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Technology> mTechnologies;

    public ViewPagerAdapter(ArrayList<Technology> technologies, FragmentManager fragmentManager){
        super(fragmentManager);
        this.mTechnologies = technologies;
    }

    @Override
    public Fragment getItem(int i) {
        TechnologyFragment fragment = new TechnologyFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", mTechnologies.get(i));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return  mTechnologies.size();
    }
}
