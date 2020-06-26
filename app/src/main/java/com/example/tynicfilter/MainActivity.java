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
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayoutExisted;

    TextView textViewExact;
    TextView textViewTotalMatches;
    EditText editText1, editText2;
    Button buttonAdd1, buttonAdd2, buttonClear1, buttonClear2, buttonCompare, buttonBox;
    ListView listView1, listView2;
    ArrayList<String> arrayList1;
    ArrayList<String> arrayListCompare1;
    ArrayList<String> arrayList2;
    ArrayList<String> arrayListCompare2;
    ArrayList<String> arrayListCompareFinal1;
    ArrayList<String> arrayListCompareFinal2;
    ArrayAdapter<String> arrayAdapter1;
    ArrayAdapter<String> arrayAdapter2;
    ArrayAdapter<String> arrayAdapterCompareFinal1;
    ArrayAdapter<String> arrayAdapterCompareFinal2;


    ArrayList<Item> itemArrayList1;
    ArrayList<Item> itemArrayList2;
    Item mItem;


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

        itemArrayList1 = new ArrayList<>();
        itemArrayList2 = new ArrayList<>();
        arrayListCompareFinal1 = new ArrayList<>();
        arrayListCompareFinal2 = new ArrayList<>();
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
                            arrayListCompare1.add(trim);
                            mItem = new Item(index1, trim, false);
                            itemArrayList1.add(mItem);
                            arrayList1.add(index1 + ". " + trim);


                            index1++;
                        }

                        arrayAdapter1.notifyDataSetChanged();

                    } else if (newItem.contains("-")) {
                        String[] split = newItem.split("-");
                        for (String item : split) {
                            String trim = item.trim();
                            arrayListCompare1.add(trim);
                            mItem = new Item(index1, trim, false);
                            itemArrayList1.add(mItem);

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
                arrayListCompareFinal1.clear();
                arrayListCompareFinal2.clear();

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
                            mItem = new Item(index2, trim, false);

                            itemArrayList2.add(mItem);
                            arrayList2.add(index2 + ". " + trim);

                            index2++;
                        }
                        arrayAdapter2.notifyDataSetChanged();

                    } else if (newItem.contains("-")) {
                        String[] split = newItem.split("-");
                        for (String item : split) {
                            String trim = item.trim();
                            arrayListCompare2.add(trim);
                            mItem = new Item(index2, trim, false);
                            itemArrayList2.add(mItem);
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
                arrayListCompareFinal1.clear();
                arrayListCompareFinal2.clear();

                textViewExact.setVisibility(View.GONE);
                textViewTotalMatches.setVisibility(View.GONE);

            }
        });


        buttonClear1 = findViewById(R.id.btnClear1);
        buttonClear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList1.clear();


                arrayListCompareFinal1.clear();
                arrayListCompareFinal2.clear();
                textViewExact.setVisibility(View.GONE);
                textViewTotalMatches.setVisibility(View.GONE);

                arrayListCompare1.clear();
                arrayListCompareFinal1.clear();
                arrayListCompareFinal2.clear();
                index1 = 1;
                arrayAdapter1.notifyDataSetChanged();
                arrayAdapterCompareFinal1.notifyDataSetChanged();
                arrayAdapterCompareFinal2.notifyDataSetChanged();
            }
        });


        buttonClear2 = findViewById(R.id.btnClear2);
        buttonClear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList2.clear();

                arrayListCompareFinal1.clear();
                arrayListCompareFinal2.clear();
                textViewExact.setVisibility(View.GONE);
                textViewTotalMatches.setVisibility(View.GONE);

                arrayListCompare2.clear();
                arrayListCompareFinal1.clear();
                arrayListCompareFinal2.clear();
                index2 = 1;
                arrayAdapter2.notifyDataSetChanged();
                arrayAdapterCompareFinal1.notifyDataSetChanged();
                arrayAdapterCompareFinal2.notifyDataSetChanged();
            }
        });

        arrayAdapterCompareFinal1 = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtListItem, arrayListCompareFinal1);
        arrayAdapterCompareFinal2 = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtListItem, arrayListCompareFinal2);

        buttonCompare = findViewById(R.id.btnCompare);
        buttonCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int smallSize = 0;
                int largeSize = 0;
                if (itemArrayList1.size() > itemArrayList2.size()) {
                    smallSize = itemArrayList2.size();
                    largeSize = itemArrayList1.size();
                    if (!arrayList1.isEmpty() && !arrayList2.isEmpty()) {
                        for (int i = 0; i < smallSize; i++) {
                            for (int j = 0; j < largeSize; j++) {
                                if (itemArrayList2.get(i).getNumberText().equals(itemArrayList1.get(j).getNumberText()) &&
                                        String.valueOf(itemArrayList2.get(i).getIndex()).equals(String.valueOf(itemArrayList1.get(j).getIndex()))) {
                                    if (!itemArrayList1.get(j).isFound()) {

                                        arrayListCompareFinal1.add(itemArrayList1.get(j).getIndex() + ". " + itemArrayList1.get(j).getNumberText());
                                        arrayListCompareFinal2.add(itemArrayList2.get(i).getIndex() + ". " + itemArrayList2.get(i).getNumberText());

                                        itemArrayList1.get(j).setFound(true);
                                        break;

                                    }
                                }
                            }
                        }


                        textViewExact.setVisibility(View.VISIBLE);
                        textViewTotalMatches.setText(arrayListCompareFinal1.size() + " Total");
                        textViewTotalMatches.setVisibility(View.VISIBLE);

                        listView1.setAdapter(arrayAdapterCompareFinal1);
                        listView2.setAdapter(arrayAdapterCompareFinal2);

                        arrayAdapterCompareFinal1.notifyDataSetChanged();
                        arrayAdapterCompareFinal2.notifyDataSetChanged();


                    } else {
                        if (arrayList1.isEmpty()) {
                            Toast.makeText(MainActivity.this, "can't compare first listbox is empty", Toast.LENGTH_SHORT).show();
                        }
                        if (arrayList2.isEmpty()) {
                            Toast.makeText(MainActivity.this, "can't compare second list box is empty", Toast.LENGTH_SHORT).show();
                        }

                    }
                } else if (itemArrayList1.size() < itemArrayList2.size()) {
                    smallSize = itemArrayList1.size();
                    largeSize = itemArrayList2.size();
                    if (!arrayList1.isEmpty() && !arrayList2.isEmpty()) {
                        for (int i = 0; i < smallSize; i++) {
                            for (int j = 0; j < largeSize; j++) {
                                if (itemArrayList1.get(i).getNumberText().equals(itemArrayList2.get(j).getNumberText()) &&
                                        String.valueOf(itemArrayList1.get(i).getIndex()).equals(String.valueOf(itemArrayList2.get(j).getIndex()))) {
                                    if (!itemArrayList2.get(j).isFound()) {

                                        arrayListCompareFinal1.add(itemArrayList1.get(j).getIndex() + ". " + itemArrayList1.get(j).getNumberText());
                                        arrayListCompareFinal2.add(itemArrayList2.get(i).getIndex() + ". " + itemArrayList2.get(i).getNumberText());

                                        itemArrayList2.get(j).setFound(true);
                                        break;

                                    }
                                }
                            }
                        }


                        textViewExact.setVisibility(View.VISIBLE);
                        textViewTotalMatches.setText(arrayListCompareFinal1.size() + " Total");
                        textViewTotalMatches.setVisibility(View.VISIBLE);

                        listView1.setAdapter(arrayAdapterCompareFinal1);
                        listView2.setAdapter(arrayAdapterCompareFinal2);

                        arrayAdapterCompareFinal1.notifyDataSetChanged();
                        arrayAdapterCompareFinal2.notifyDataSetChanged();


                    } else {
                        if (arrayList1.isEmpty()) {
                            Toast.makeText(MainActivity.this, "can't compare first listbox is empty", Toast.LENGTH_SHORT).show();
                        }
                        if (arrayList2.isEmpty()) {
                            Toast.makeText(MainActivity.this, "can't compare second list box is empty", Toast.LENGTH_SHORT).show();
                        }

                    }

                } else if (itemArrayList1.size() == itemArrayList2.size()) {

                    if (!arrayList1.isEmpty() && !arrayList2.isEmpty()) {
                        for (int i = 0; i < itemArrayList1.size(); i++) {
                            for (int j = 0; j < itemArrayList2.size(); j++) {
                                if (itemArrayList1.get(i).getNumberText().equals(itemArrayList2.get(j).getNumberText()) &&
                                        String.valueOf(itemArrayList1.get(i).getIndex()).equals(String.valueOf(itemArrayList2.get(j).getIndex()))) {
                                    if (!itemArrayList2.get(j).isFound()) {

                                        arrayListCompareFinal1.add(itemArrayList1.get(j).getIndex() + ". " + itemArrayList1.get(j).getNumberText());
                                        arrayListCompareFinal2.add(itemArrayList2.get(i).getIndex() + ". " + itemArrayList2.get(i).getNumberText());

                                        itemArrayList2.get(j).setFound(true);
                                        break;

                                    }
                                }
                            }
                        }


                        textViewExact.setVisibility(View.VISIBLE);
                        textViewTotalMatches.setText(arrayListCompareFinal1.size() + " Total");
                        textViewTotalMatches.setVisibility(View.VISIBLE);

                        listView1.setAdapter(arrayAdapterCompareFinal1);
                        listView2.setAdapter(arrayAdapterCompareFinal2);

                        arrayAdapterCompareFinal1.notifyDataSetChanged();
                        arrayAdapterCompareFinal2.notifyDataSetChanged();


                    } else {
                        if (arrayList1.isEmpty()) {
                            Toast.makeText(MainActivity.this, "can't compare first listbox is empty", Toast.LENGTH_SHORT).show();
                        }
                        if (arrayList2.isEmpty()) {
                            Toast.makeText(MainActivity.this, "can't compare second list box is empty", Toast.LENGTH_SHORT).show();
                        }

                    }


                }

                arrayList1.clear();
                index1 = 1;
                arrayList2.clear();
                index2 = 1;
                arrayListCompare1.clear();
                arrayListCompare2.clear();
                indexComapare = 1;
                itemArrayList1.clear();
                itemArrayList2.clear();
            }
        });

        buttonBox = findViewById(R.id.btnBox);
        buttonBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int smallSize = 0;
                int largeSize = 0;
                if (itemArrayList1.size() > itemArrayList2.size()) {
                    smallSize = itemArrayList2.size();
                    largeSize = itemArrayList1.size();
                    if (!arrayList1.isEmpty() && !arrayList2.isEmpty()) {
                        for (int i = 0; i < smallSize; i++) {
                            for (int j = 0; j < largeSize; j++) {
//                                itemArrayList2.get(i).getNumberText().equals(itemArrayList1.get(j).getNumberText()) &&
                                if (String.valueOf(itemArrayList2.get(i).getIndex()).equals(String.valueOf(itemArrayList1.get(j).getIndex()))) {
                                    if (!itemArrayList1.get(j).isFound()) {
                                        if (sort(itemArrayList2.get(i).getNumberText()).equals(sort(itemArrayList1.get(j).getNumberText()))) {
                                            arrayListCompareFinal1.add(itemArrayList1.get(j).getIndex() + ". " + itemArrayList1.get(j).getNumberText());
                                            arrayListCompareFinal2.add(itemArrayList2.get(i).getIndex() + ". " + itemArrayList2.get(i).getNumberText());
                                            itemArrayList1.get(j).setFound(true);
                                            break;
                                        }


                                    }
                                }
                            }
                        }


                        textViewExact.setVisibility(View.VISIBLE);
                        textViewTotalMatches.setText(arrayListCompareFinal1.size() + " Total");
                        textViewTotalMatches.setVisibility(View.VISIBLE);

                        listView1.setAdapter(arrayAdapterCompareFinal1);
                        listView2.setAdapter(arrayAdapterCompareFinal2);

                        arrayAdapterCompareFinal1.notifyDataSetChanged();
                        arrayAdapterCompareFinal2.notifyDataSetChanged();


                    } else {
                        if (arrayList1.isEmpty()) {
                            Toast.makeText(MainActivity.this, "can't compare first listbox is empty", Toast.LENGTH_SHORT).show();
                        }
                        if (arrayList2.isEmpty()) {
                            Toast.makeText(MainActivity.this, "can't compare second list box is empty", Toast.LENGTH_SHORT).show();
                        }

                    }
                } else if (itemArrayList1.size() < itemArrayList2.size()) {
                    smallSize = itemArrayList1.size();
                    largeSize = itemArrayList2.size();
                    if (!arrayList1.isEmpty() && !arrayList2.isEmpty()) {
                        for (int i = 0; i < smallSize; i++) {
                            for (int j = 0; j < largeSize; j++) {
                                if (String.valueOf(itemArrayList1.get(i).getIndex()).equals(String.valueOf(itemArrayList2.get(j).getIndex()))) {
                                    if (!itemArrayList2.get(j).isFound()) {
//                                        sort(itemArrayList2.get(i).getNumberText()).equals(sort(itemArrayList1.get(j).getNumberText()))
                                        if (sort(itemArrayList1.get(i).getNumberText()).equals(sort(itemArrayList2.get(j).getNumberText()))) {
                                            arrayListCompareFinal1.add(itemArrayList1.get(j).getIndex() + ". " + itemArrayList1.get(j).getNumberText());
                                            arrayListCompareFinal2.add(itemArrayList2.get(i).getIndex() + ". " + itemArrayList2.get(i).getNumberText());
                                            itemArrayList2.get(j).setFound(true);
                                            break;
                                        }


                                    }
                                }
                            }
                        }


                        textViewExact.setVisibility(View.VISIBLE);
                        textViewTotalMatches.setText(arrayListCompareFinal1.size() + " Total");
                        textViewTotalMatches.setVisibility(View.VISIBLE);

                        listView1.setAdapter(arrayAdapterCompareFinal1);
                        listView2.setAdapter(arrayAdapterCompareFinal2);

                        arrayAdapterCompareFinal1.notifyDataSetChanged();
                        arrayAdapterCompareFinal2.notifyDataSetChanged();


                    } else {
                        if (arrayList1.isEmpty()) {
                            Toast.makeText(MainActivity.this, "can't compare first listbox is empty", Toast.LENGTH_SHORT).show();
                        }
                        if (arrayList2.isEmpty()) {
                            Toast.makeText(MainActivity.this, "can't compare second list box is empty", Toast.LENGTH_SHORT).show();
                        }

                    }

                } else if (itemArrayList1.size() == itemArrayList2.size()) {

                    if (!arrayList1.isEmpty() && !arrayList2.isEmpty()) {
                        for (int i = 0; i < itemArrayList1.size(); i++) {
                            for (int j = 0; j < itemArrayList2.size(); j++) {
                                if (String.valueOf(itemArrayList1.get(i).getIndex()).equals(String.valueOf(itemArrayList2.get(j).getIndex()))) {
                                    if (!itemArrayList2.get(j).isFound()) {
//                                        sort(itemArrayList2.get(i).getNumberText()).equals(sort(itemArrayList1.get(j).getNumberText()))
                                        if (sort(itemArrayList1.get(i).getNumberText()).equals(sort(itemArrayList2.get(j).getNumberText()))) {
                                            arrayListCompareFinal1.add(itemArrayList1.get(j).getIndex() + ". " + itemArrayList1.get(j).getNumberText());
                                            arrayListCompareFinal2.add(itemArrayList2.get(i).getIndex() + ". " + itemArrayList2.get(i).getNumberText());
                                            itemArrayList2.get(j).setFound(true);
                                            break;
                                        }


                                    }
                                }
                            }
                        }


                        textViewExact.setVisibility(View.VISIBLE);
                        textViewTotalMatches.setText(arrayListCompareFinal1.size() + " Total");
                        textViewTotalMatches.setVisibility(View.VISIBLE);

                        listView1.setAdapter(arrayAdapterCompareFinal1);
                        listView2.setAdapter(arrayAdapterCompareFinal2);

                        arrayAdapterCompareFinal1.notifyDataSetChanged();
                        arrayAdapterCompareFinal2.notifyDataSetChanged();


                    } else {
                        if (arrayList1.isEmpty()) {
                            Toast.makeText(MainActivity.this, "can't compare first listbox is empty", Toast.LENGTH_SHORT).show();
                        }
                        if (arrayList2.isEmpty()) {
                            Toast.makeText(MainActivity.this, "can't compare second list box is empty", Toast.LENGTH_SHORT).show();
                        }

                    }


                }

                arrayList1.clear();
                index1 = 1;
                arrayList2.clear();
                index2 = 1;
                arrayListCompare1.clear();
                arrayListCompare2.clear();
                indexComapare = 1;
                itemArrayList1.clear();
                itemArrayList2.clear();
            }
        });


    }


    public boolean isAlpha(String s) {
        return s != null && s.matches(".*[a-zA-Z]+.*");
    }


    public String sort(String str) {
        String res[] = new String[str.length()];
        String result = "";

        for (int i = 0; i < res.length; i++) {
            res[i] = String.valueOf(str.charAt(i));

        }

        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            result += res[i];
        }
        return result;
    }
}