package com.raslan.jwadtaskmanager.ui.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raslan.jwadtaskmanager.R;

import data.Mytask;
import data.TasksAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllTasksFragment extends Fragment {
    private TasksAdapter tasksAdapter;
    private ListView lvTasks;


    public AllTasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasksAdapter=new TasksAdapter(getContext());
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_all_tasks, container, false);
       lvTasks=view.findViewById(R.id.lstvTasks);
       lvTasks.setAdapter(tasksAdapter);// rbtna list view bl adapter
       return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        readTasksFromFirebase();
    }

    public void readTasksFromFirebase()
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        FirebaseAuth auth=FirebaseAuth.getInstance();
        String uid= auth.getUid();
        DatabaseReference reference = database.getReference();

        reference.child("tasks").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                tasksAdapter.clear();
                for (DataSnapshot d: dataSnapshot.getChildren())   //data snapshot ns5a 3n jme3 almo3teat almojoda t7t uid
                {
                    Mytask t=d.getValue(Mytask.class);
                    Log.d("Mytask",t.toString());
                    tasksAdapter.add(t);

                }
            }
            //data snapshot ns5a 3n jme3 almo3teat almojoda t7t uid

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
