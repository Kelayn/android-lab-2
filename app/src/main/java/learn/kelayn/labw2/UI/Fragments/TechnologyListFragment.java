package learn.kelayn.labw2.UI.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import learn.kelayn.labw2.Adapters.TechnologyRecyclerAdapter;
import learn.kelayn.labw2.Data.Technology;
import learn.kelayn.labw2.R;
import learn.kelayn.labw2.UI.MainActivity;

public class TechnologyListFragment extends Fragment {
    View fragmentView;
    ArrayList<Technology> mTechnologies;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mTechnologies = (ArrayList<Technology>) getArguments().getSerializable("data");

        fragmentView = inflater.inflate(R.layout.fragment_technology_list, container, false);

        RecyclerView recycler = fragmentView.findViewById(R.id.technology_list_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new TechnologyRecyclerAdapter(mTechnologies, position -> {
            ((MainActivity) getActivity()).toggleDescriptionFragment(new TechnologyHolderFragment(), position);
        }, getContext()));

        return fragmentView;
    }
}
