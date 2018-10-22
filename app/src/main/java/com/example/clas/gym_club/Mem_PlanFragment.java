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
public class Mem_PlanFragment extends ListFragment {
    //Searching String , when == 'ALL' list all
    String searchingString = "ALL";

    int[] mem_select = {1, 2, 5};// 模拟了一个用户的选择

    String[] players = {"Wang Mo", "Li Jian", "刘教练", "David Zhang", "赵武 教练", "Van Persie", "Oscar"};
    String[] learners={"Students(11)","Students(12)","Students(13)","Students(14)","Students(15)","Students(17)","Students(1000)"};
    String[] experience = {
            "Perfection is not attainable, but if we chase perfection we can catch excellence",
            "Health & Fitness Lifestyle Transformation.Gym doesn't change live, People do.",
            "If we chase perfection we can catch excellence",
            "Gym doesn't change live, People do.",
            "An accomplished fitness trainer with seven years of experience n hand",
            "Gym doesn't change live, People do.",
            "Gym doesn't change live, People do."
    };
    int[] images = {R.drawable.trainer1, R.drawable.trainer2, R.drawable.trainer3, R.drawable.trainer4, R.drawable.trainer5, R.drawable.trainer6, R.drawable.trainer7};

    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>(); // 用于显示
    SimpleAdapter adapter;

    public Mem_PlanFragment() {
        // Required empty public constructor
        Log.e("e_myPlanFra_cons","#1");
    }

    public Mem_PlanFragment(String searchingString){
        this();
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
            for (int i = 0; i < mem_select.length; i++) {
                map = new HashMap<String, String>();
                map.put("Player", players [mem_select[i]]);
                map.put("Info",experience[mem_select[i]]);
                map.put("learners",learners[mem_select[i]]);
                map.put("Image", Integer.toString(images[mem_select[i]]));

                data.add(map);
            }
        }
        else {
            Log.e("e_Plan_ALL ","#2"+searchingString);
            for (int i = 0; i < mem_select.length; i++) {
                map = new HashMap<String, String>();
                map.put("Player", players[mem_select[i]]);
                map.put("Info", experience[mem_select[i]]);
                map.put("learners", learners[mem_select[i]]);
                map.put("Image", Integer.toString(images[mem_select[i]]));
                if (players[mem_select[i]] .equals( searchingString)) {
                    Log.e("e_Plan_searching ","Found#"+players[mem_select[i]]);
                    data.add(map); // 如果符合条件就添加上去
                    break;
                }
            }
        }

        //KEYS IN MAP
        String[] from = {"Player","Info","learners","Image"};

        //IDS OF VIEWS
        int[] to = {R.id.nameTxt, R.id.infoTxt,R.id.lernerTxt, R.id.imageView1};

        Log.e("e_create_plan_view","#1");

        //ADAPTER
        adapter = new SimpleAdapter(getActivity().getBaseContext(), data, R.layout.trainer_item, from, to);
        Log.e("e_create_plan_view","#2");
        setListAdapter(adapter);
        Log.e("e_create_plan_view","#3");

        return super.onCreateView(inflater, container, savedInstanceState);
    }


   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), data.get(pos).get("Player"), Toast.LENGTH_SHORT).show();

            }
        });
    }*/
}

