package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    dbhelper mydb;
    private EditText item;
    private Button btn;
    private ListView itemslist;


    private ArrayList<String>  items;
    private ArrayAdapter<String>  adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item =(EditText)findViewById(R.id.itemedittext);
        btn = (Button)findViewById(R.id.addbutton);
        itemslist = (ListView)findViewById(R.id.itemlist);


        items = filehelper.readdata(this);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        itemslist.setAdapter(adapter);


        btn.setOnClickListener(this);
        itemslist.setOnItemClickListener(this);
}
    @Override
    public void onClick(View view) {
            switch (view.getId()){
            case R.id.addbutton:
                String itementered =item.getText().toString();
                adapter.add(itementered);
                item.setText("");
                filehelper.writedata(items,this);
                Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show();

                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        items.remove(i);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Deleted",Toast.LENGTH_SHORT).show();
}
}