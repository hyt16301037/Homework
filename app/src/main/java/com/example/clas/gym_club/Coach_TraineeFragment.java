package com.example.clas.gym_club;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class Coach_TraineeFragment extends ListFragment {
    //Searching String , when == 'ALL' list all
    String searchingString = "ALL";

    String[] trainee = {"Han yutong", "zzHyt", "toto", "Yoann", "Lu V"};
    String[] profile = {
            "Running is my life! Wanna be stronger!!",
            "A little bit stupid? Nothing!",
            "It never too late to learn.",
            "Read the f**king manual.",
            "Software doesn't change live, People do.",
    };
    int[] images = {R.drawable.trainee1, R.drawable.trainee2, R.drawable.trainee3, R.drawable.trainee4, R.drawable.trainee5};

    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;

    public Coach_TraineeFragment() {
        // Required empty public constructor
        Log.e("e_myPlanFra_cons","#1");
    }

    public Coach_TraineeFragment(String searchingString){
        this.searchingString = searchingString;
        Log.e("e_myPlanFra_cons", "#1");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //MAP
        HashMap<String, String> map = new HashMap<String, String>();

        //FILL
        Log.e("e_Plan_ALL ","searchingString#"+searchingString+"#"+searchingString.length());
        if("ALL".equals(searchingString))
        {
            Log.e("e_Plan_ALL ","#1"+searchingString);
            for (int i = 0; i < trainee.length; i++) {
                map = new HashMap<String, String>();
                map.put("Trainee", trainee[i]);
                map.put("Profile",profile[i]);
                map.put("Image", Integer.toString(images[i]));

                data.add(map);
            }
        }
        else {
            Log.e("e_Plan_ALL ","#2"+searchingString);
            for (int i = 0; i < trainee.length; i++) {
                map = new HashMap<String, String>();
                map.put("Trainee", trainee[i]);
                map.put("Profile", profile[i]);
                map.put("Image", Integer.toString(images[i]));
                if (trainee[i] .equals( searchingString)) {
                    Log.e("e_Plan_searching ","Found#"+ trainee[i]);
                    data.add(map);
                    break;
                }
            }
        }

        //KEYS IN MAP
        String[] from = {"Trainee","Profile","Image"};

        //IDS OF VIEWS
        int[] to = {R.id.nameTxt, R.id.infoTxt, R.id.imageView1};

        Log.e("e_create_plan_view","#1");

        //ADAPTER
        adapter = new SimpleAdapter(getActivity().getBaseContext(), data, R.layout.trainee_item, from, to);
        Log.e("e_create_plan_view","#2");
        setListAdapter(adapter);
        Log.e("e_create_plan_view","#3");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}

