package data;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.raslan.jwadtaskmanager.R;

public class TasksAdapter extends ArrayAdapter<Mytask> {

    public TasksAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public TasksAdapter(Context context) {
        super(context,R.layout.taskitem);
    }

    @NonNull
    @Override



    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        final View vitem= LayoutInflater.from(getContext()).inflate(R.layout.taskitem,parent,false);
        final TextView tvTitle=vitem.findViewById(R.id.itmTvSubject);
        final TextView tvsubject=vitem.findViewById(R.id.itmTvSubject);
        ImageView tvimage=vitem.findViewById(R.id.itmImdInfo);
        final CheckBox tvcheckbox=vitem.findViewById(R.id.itmChbxIsCompleted);
        final RatingBar tvratingbar=vitem.findViewById(R.id.itmRatingPrio);

        final Mytask mytask=getItem(position);

        //todo  tepol baero3 m7eka
        tvcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)

                FirebaseUtils.getRefernce().child(mytask.getKey()).removeValue(new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                        if (databaseError==null)
                        {
                            Toast.makeText(getContext(),"deleted",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getContext(),"notdeleted"+databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }

        });


                tvTitle.setText(mytask.getTitle());
        tvsubject.setText(mytask.getSubject());
       tvratingbar.setRating(mytask.getImportant());
       tvcheckbox.setChecked(false);

       return vitem;




    }
}
