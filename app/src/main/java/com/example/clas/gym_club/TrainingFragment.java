package com.example.clas.gym_club;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrainingFragment extends Fragment {


    private int select = 0;

    public TrainingFragment() {
        // Required empty public constructor

    }

    public static TrainingFragment newInstance(int select) {
        TrainingFragment f = new TrainingFragment();
        Bundle b = new Bundle();
        b.putInt("select", select);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            select = args.getInt("select");
        }

        return inflater.inflate(R.layout.my_training_layout, container, false);
    }

    public void onStart() {
        super.onStart();

        ImageView button = (ImageView) getActivity().findViewById(R.id.search_trainer);
        final TextView textView=(TextView)getActivity().findViewById(R.id.search_trainer_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tem=textView.getText().toString();
                switch(select){
                    case 0:{ // 从导航进入My Training
                        final Fragment fragment = new MyPlanFragment(tem);
                        Toast.makeText(getActivity(), tem, Toast.LENGTH_LONG).show();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.trainer_content, fragment).commit();
                    }break;
                    case 1: { // 学员的My Training
                        final Fragment fragment = new Mem_PlanFragment(tem);
                        Toast.makeText(getActivity(), tem, Toast.LENGTH_LONG).show();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.trainer_content, fragment).commit();
                    }break;
                    case 2: { // 教练的My Training
                        final Fragment fragment = new Coach_PlanFragment(tem);
                        Toast.makeText(getActivity(), tem, Toast.LENGTH_LONG).show();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.trainer_content, fragment).commit();
                    }break;
                }

                //fragment.setArguments(bundle); //bundle set is null so no things will display

            }
        });
    }

}