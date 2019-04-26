package learn.kelayn.labw2.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import learn.kelayn.labw2.Data.Technology;
import learn.kelayn.labw2.R;
import learn.kelayn.labw2.UI.Fragments.TechnologyHolderFragment;
import learn.kelayn.labw2.UI.Fragments.TechnologyListFragment;

public class  MainActivity extends AppCompatActivity {

    ArrayList<Technology> mTechnologyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTechnologyList = (ArrayList<Technology>) getIntent().getSerializableExtra("data");
        if (savedInstanceState == null) toggleListFragment(new TechnologyListFragment());
    }

    void toggleListFragment(TechnologyListFragment fragment){
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", mTechnologyList);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_activity, fragment, "list")
                .commit();
    }

    public void toggleDescriptionFragment(TechnologyHolderFragment fragment, int position){
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", mTechnologyList);
        bundle.putInt("item_number", position);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_activity, fragment, "description")
                .commit();
    }

    @Override
    public void onBackPressed(){
        if (getSupportFragmentManager().findFragmentByTag("description") != null){
            toggleListFragment(new TechnologyListFragment());
        }
        else{
            super.onBackPressed();
        }
    }
}
