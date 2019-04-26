package learn.kelayn.labw2.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import java.util.ArrayList;

import learn.kelayn.labw2.Data.Technology;
import learn.kelayn.labw2.R;

public class TechnologyRecyclerAdapter extends RecyclerView.Adapter<TechnologyRecyclerAdapter.RecyclerViewHolder> {

    ArrayList<Technology> mTechnologies;
    ClickListener mListener;
    Context mContext;

    public TechnologyRecyclerAdapter(ArrayList<Technology> technologies, ClickListener listener, Context context) {
        this.mTechnologies = technologies;
        this.mListener = listener;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.technology, viewGroup, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(mTechnologies.get(i).getName());
        myViewHolder.itemView.setOnClickListener(v -> {
            mListener.onItemClick(i);
        });

        GlideApp.with(mContext)
                .load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + mTechnologies.get(i).getGraphic())
                .override(300, 300)
                .transform(new CenterCrop())
                .error(R.mipmap.ic_launcher)
                .into(myViewHolder.pic);

    }

    @Override
    public int getItemCount() {
        return mTechnologies.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{

        ImageView pic;
        TextView name;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.tech_pic);
            name = itemView.findViewById(R.id.tech_name);
        }
    }
}
