package learn.kelayn.labw2.UI.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import learn.kelayn.labw2.Adapters.GlideApp;
import learn.kelayn.labw2.Data.Technology;
import learn.kelayn.labw2.R;

public class TechnologyFragment extends Fragment {

    View mFragmentView;
    public TechnologyFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.fragment_technology, container, false);

        TextView description = mFragmentView.findViewById(R.id.tech_desc);
        ImageView pic = mFragmentView.findViewById(R.id.tech_pic_big);
        Technology technology = (Technology) getArguments().getSerializable("data");
        if (technology.getHelptext() != null) description.setText(technology.getHelptext());

        GlideApp.with(getContext())
                .load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + technology.getGraphic())
                .override(300, 300)
                .transform(new CenterCrop())
                .error(R.mipmap.ic_launcher)
                .into(pic);

        return mFragmentView;
    }
}
