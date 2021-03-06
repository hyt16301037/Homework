package com.example.clas.gym_club;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class TraineeFragment extends Fragment {


    public TraineeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.trainee_layout, container, false);
    }

    public void onStart(){
        super.onStart();

        ImageView button = (ImageView) getActivity().findViewById(R.id.search_trainee);
        final TextView textView=(TextView)getActivity().findViewById(R.id.search_trainee_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tem = textView.getText().toString();
                final Fragment fragment = new Coach_TraineeFragment(tem);
                Toast.makeText(getActivity(), tem, Toast.LENGTH_LONG).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.trainee_content, fragment).commit();
            }
        });
    }

}
