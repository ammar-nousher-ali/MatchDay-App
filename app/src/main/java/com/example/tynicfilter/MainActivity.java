package com.example.tynicfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayoutExisted;

    TextView textViewExact;
    TextView textViewTotalMatches;
    EditText editText1, editText2;
    Button buttonAdd1, buttonAdd2, buttonClear1, buttonClear2, buttonCompare;
    ListView listView1, listView2;
    ArrayList<String> arrayList1;  //name should be meaningfull
    ArrayList<String> arrayListCompare1;
    ArrayList<String> arrayList2;
    ArrayList<String> arrayListCompare2;
    ArrayList<String> arrayListCompare;
    ArrayAdapter<String> arrayAdapter1;
    ArrayAdapter<String> arrayAdapter2;
    ArrayAdapter<String> arrayAdapterCompare;


    int index1 = 1;
    int index2 = 1;
    int indexComapare = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewExact = findViewById(R.id.txt_exactmatches);
        textViewTotalMatches = findViewById(R.id.txt_totalmatches);

        listView1 = findViewById(R.id.listview1);
        listView2 = findViewById(R.id.listview2);

        arrayListCompare = new ArrayList<>();
        arrayListCompare1 = new ArrayList<>();
        arrayListCompare2 = new ArrayList<>();
        arrayList1 = new ArrayList<>();
        arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtListItem, arrayList1);
        editText1 = findViewById(R.id.edittext1);
        buttonAdd1 = findViewById(R.id.btnAdd1);

        buttonAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView1.setAdapter(arrayAdapter1);

                String newItem = editText1.getText().toString();

                if (!isAlpha(newItem)) {

                    if (newItem.contains(",")) {
                        String[] split = newItem.split(",");
                        for (String item : split) {
                            String trim = item.trim();
                            arrayListCompare1.add(trim);//touseeq bhai wohi to mujh se ni hora tha m yahi kehra tha apko k masla hojye ga
                            arrayList1.add(index1 + ". " + trim);  //if client say need index exact you need to make model simple

                            index1++;
                        }

                        //me bta dun ga  learning nahi ho gi khud kro until yourlast breath
                        //hahaha i will //i never ask to senior untill my last try //so you never would be depend for anybody
                        //make a model class with fields index and numbertext then arrayslist of model simple
                        // if client say then i will work on what you said INSHAALLAH i ll do it

//                    for (int i = 0; i < split.length;i++) {
//                        String item = split[i].trim();
//
//
//                        arrayList1.add(index1 + " " + item);
//                        index1++;
//                    }
                        arrayAdapter1.notifyDataSetChanged();

                    } else if (newItem.contains("-")) {
                        String[] split = newItem.split("-");
                        for (String item : split) {
                            String trim = item.trim();
                            arrayListCompare1.add(trim);
                            arrayList1.add(index1 + ". " + trim);
                            index1++;
                        }
                        arrayAdapter1.notifyDataSetChanged();

                    } else {

                        Toast.makeText(MainActivity.this, "Input Number is Missing", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Wrong input , Enter Numbers Only", Toast.LENGTH_SHORT).show();
                }
                editText1.setText("");
                arrayListCompare.clear();

                textViewExact.setVisibility(View.GONE);
                textViewTotalMatches.setVisibility(View.GONE);

            }
        });

        arrayList2 = new ArrayList<>();
        arrayAdapter2 = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtListItem, arrayList2);
        editText2 = findViewById(R.id.edittext2);
        buttonAdd2 = findViewById(R.id.btnAdd2);

        buttonAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView2.setAdapter(arrayAdapter2);
                String newItem = editText2.getText().toString();
                if (!isAlpha(newItem)) {

                    if (newItem.contains(",")) {

                        String[] split = newItem.split(",");
                        for (String item : split) {
                            String trim = item.trim();
                            arrayListCompare2.add(trim);
                            arrayList2.add(index2 + ". " + trim);
//                        arrayList1.add(index + " " + item);
                            index2++;
                        }
                        arrayAdapter2.notifyDataSetChanged();

                    } else if (newItem.contains("-")) {
                        String[] split = newItem.split("-");
                        for (String item : split) {
                            String trim = item.trim();
                            arrayListCompare2.add(trim);
                            arrayList2.add(index2 + ". " + trim);
                            index2++;

                        }
                        arrayAdapter2.notifyDataSetChanged();

                    } else {

                        Toast.makeText(MainActivity.this, "Input Number is Missing", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Wrong input , Enter Numbers Only", Toast.LENGTH_SHORT).show();
                }
                editText2.setText("");
                arrayListCompare.clear();

                textViewExact.setVisibility(View.GONE);
                textViewTotalMatches.setVisibility(View.GONE);

            }
        });


        buttonClear1 = findViewById(R.id.btnClear1);
        buttonClear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList1.clear();

                textViewExact.setVisibility(View.GONE);
                textViewTotalMatches.setVisibility(View.GONE);

                arrayListCompare1.clear();
                arrayListCompare.clear();
                index1 = 1;
                arrayAdapter1.notifyDataSetChanged();
                arrayAdapterCompare.notifyDataSetChanged();
            }
        });


        buttonClear2 = findViewById(R.id.btnClear2);
        buttonClear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList2.clear();
                textViewExact.setVisibility(View.GONE);
                textViewTotalMatches.setVisibility(View.GONE);

                arrayListCompare2.clear();
                arrayListCompare.clear();
                index2 = 1;
                arrayAdapter2.notifyDataSetChanged();
                arrayAdapterCompare.notifyDataSetChanged();
            }
        });

        arrayAdapterCompare = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtListItem, arrayListCompare);

        buttonCompare = findViewById(R.id.btnCompare);
        buttonCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!arrayList1.isEmpty() && !arrayList2.isEmpty()) {
                    for (int i = 0; i < arrayListCompare1.size(); i++) {
                        for (int j = 0; j < arrayListCompare2.size(); j++) {
                            if (arrayListCompare1.get(i).equals(arrayListCompare2.get(j))) {
                                arrayListCompare.add(indexComapare + ". " + arrayListCompare1.get(i));
                                indexComapare++;
                            }
                        }
                    }


                    textViewExact.setVisibility(View.VISIBLE);
                    textViewTotalMatches.setText(arrayListCompare.size() + " Total");
                    textViewTotalMatches.setVisibility(View.VISIBLE);

                    listView1.setAdapter(arrayAdapterCompare);
                    listView2.setAdapter(arrayAdapterCompare);

                    arrayAdapterCompare.notifyDataSetChanged();


                } else {
                    if (arrayList1.isEmpty()) {
                        Toast.makeText(MainActivity.this, "can't compare first listbox is empty", Toast.LENGTH_SHORT).show();
                    }
                    if (arrayList2.isEmpty()) {
                        Toast.makeText(MainActivity.this, "can't compare second list box is empty", Toast.LENGTH_SHORT).show();
                    }

                }
                arrayList1.clear();
                index1 = 1;
                arrayList2.clear();
                index2 = 1;
                arrayListCompare1.clear();
                arrayListCompare2.clear();
                indexComapare = 1;
            }
        });

    }


    public boolean isAlpha(String s) {
        return s != null && s.matches(".*[a-zA-Z]+.*");
    }


}