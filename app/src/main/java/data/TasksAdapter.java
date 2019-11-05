package data;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.raslan.jwadtaskmanager.R;

public class TasksAdapter extends ArrayAdapter<Mytask> {

    public TasksAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override



    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.taskitem,parent,true);
        TextView tvTitle=vitem.findViewById(R.id.itmTvSubject);
        TextView tvsubject=vitem.findViewById(R.id.itmTvSubject);
        ImageView tvimage=vitem.findViewById(R.id.itmImdInfo);
        CheckBox tvcheckbox=vitem.findViewById(R.id.itmChbxIsCompleted);
        RatingBar tvratingbar=vitem.findViewById(R.id.itmRatingPrio);

        Mytask mytask=getItem(position);

        tvTitle.setText(mytask.getTitle());
        tvsubject.setText(mytask.getSubject());
       tvratingbar.setRating(mytask.getImportant());
       tvcheckbox.setChecked(false);

       return vitem;




    }
}
