package com.neuman.PratyushAssignment.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.SearchView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.neuman.PratyushAssignment.ItemClass;
import com.neuman.PratyushAssignment.R;
import com.neuman.PratyushAssignment.itemAdapter;
import com.neuman.PratyushAssignment.utils.Globals;

import java.util.ArrayList;
import java.util.Collections;

public class HomeFragment extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener {

    private View view;
    private ArrayList<ItemClass> arrayList = new ArrayList<>();
    private ArrayAdapter<String> spinneradapter;
    private Spinner droplist;
    private String [] items = {"price", "rank", "date", "status"};
    private RecyclerView recyclerView;
    private RecyclerView.Adapter madapter;
    private RecyclerView.LayoutManager layoutManager;
    int choice;
    ArrayList<ItemClass> data = new ArrayList<>();


    Globals g;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recycler);
        droplist = view.findViewById(R.id.spinner);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        arrayList = getItemClass();
        madapter = new itemAdapter(arrayList);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(madapter);



       // recyclerView.setAdapter(new ArrayAdapter<>(getActivity(),R.layout.item_recycler_layout,getItemClass()));
        Toolbar toolbar = view.findViewById(R.id.toolbar);

        ArrayAdapter<String> ad = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,items);
        ad.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        droplist.setAdapter(ad);

        droplist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ((TextView)adapterView.getChildAt(0)).setTextSize(20);
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.BLACK);

                if(i>=0 && i< items.length){
                    choice = droplist.getSelectedItemPosition();
                    Toast.makeText(getActivity(), Integer.toString(choice), Toast.LENGTH_SHORT).show();
                    getSelectedItem(choice);
                }
                else {
                    Toast.makeText(getActivity(), "select valid option", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



       // toolbar.setTitle("Sort/Filter By");

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");

        setHasOptionsMenu(true);


        return view;

    }

    public void getSelectedItem(int pos){

        switch(pos){
            case 0: sortByPrice();
                    break;
            case 1: sortByRank();
                    break;
            case 2: sortByDate();
                    break;
            case 3: sortByStatus();
                    break;
        }
    }

    public void sortByPrice(){

        Collections.sort(data, (itemClass, t1) -> itemClass.getPrice().compareTo(t1.getPrice()));
        madapter = new itemAdapter(data);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(madapter);


        /*for(ItemClass itemClass :getItemClass()){

        }*/
    }

    public void sortByRank(){
        Collections.sort(data, (itemClass, t1) -> itemClass.getRank().compareTo(t1.getRank()));
        madapter = new itemAdapter(data);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(madapter);
    }

    public void sortByDate(){
        Collections.sort(data, (itemClass, t1) -> itemClass.getDate().compareTo(t1.getDate()));
        madapter = new itemAdapter(data);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(madapter);
    }

    public void sortByStatus(){
        Collections.sort(data, (itemClass, t1) -> itemClass.getStatus().compareTo(t1.getStatus()));
        madapter = new itemAdapter(data);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(madapter);
    }

    private ArrayList<ItemClass> getItemClass(){


        data.add(new ItemClass("A","28","4","12-12-2020","not working"));
        data.add(new ItemClass("b","08","4","15-08-2020","not working"));
        data.add(new ItemClass("c","08","4","17-08-1920","working"));
        data.add(new ItemClass("d","87","4","22-10-2020","working"));
        data.add(new ItemClass("e","04","4","06-08-2020","not working"));
        data.add(new ItemClass("f","88","4","14-09-2020","working"));
        data.add(new ItemClass("g","18","4","02-08-2020","not working"));
        data.add(new ItemClass("h","20","4","06-08-2020","working"));
        data.add(new ItemClass("i","77","4","06-09-2020","not working"));
        data.add(new ItemClass("j","06","4","08-10-2020","working"));
        data.add(new ItemClass("k","09","4","23-08-2020","working"));
        data.add(new ItemClass("l","34","4","12-08-2020","not working"));


       // Collections.sort(data, (itemClass, t1) -> (itemClass.getName()).compareTo(t1.getName()));
        return data;



    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_search_setting, menu);

        SearchView searchView = (SearchView)menu.findItem(R.id.action_search).getActionView();
/*
        Button datebtn = (Button)menu.findItem(R.id.filterByDate).getActionView();
        Button pricebtn = (Button)menu.findItem(R.id.filterByPrice).getActionView();
        Button statusbtn = (Button)menu.findItem(R.id.filterByStatus).getActionView();*/
        super.onCreateOptionsMenu(menu, inflater);



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_search){
            return true;
        }

        if(id==R.id.filterByDate){

            Toast.makeText(getActivity(), "u screwed", Toast.LENGTH_SHORT).show();
            FragmentTransaction fr = getChildFragmentManager().beginTransaction();

            fr.replace(R.id.dateContainer, new PickDate() );
            fr.commit();
            return false;
        }

        if(id==R.id.filterByPrice){

            Toast.makeText(getActivity(), "u screwed", Toast.LENGTH_SHORT).show();
            FragmentTransaction fr = getChildFragmentManager().beginTransaction();

            fr.replace(R.id.dateContainer, new PickRange() );
            fr.commit();
            return false;
        }

        if(id==R.id.filterByStatus){

            Toast.makeText(getActivity(), "u screwed", Toast.LENGTH_SHORT).show();
            FragmentTransaction fr = getChildFragmentManager().beginTransaction();

            fr.replace(R.id.dateContainer, new PickStatus() );
            fr.commit();
            return false;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
