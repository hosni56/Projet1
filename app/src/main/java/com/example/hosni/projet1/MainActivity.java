package com.example.hosni.projet1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public  void busave (View View){

        EditText txtname=(EditText)findViewById(R.id.editText);
        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.InsertRowAdmin(txtname.getText().toString());

        ArrayList<String> arrlist =db.getAllrecord();
        ls.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, arrlist));
        txtname.setText("");
    }
    public  void budelete (View View){

        EditText txtname=(EditText)findViewById(R.id.editText);
        EditText txtid=(EditText)findViewById(R.id.editText2);

        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.deleteR(Integer.parseInt(txtid.getText().toString()));

        ArrayList<String> arrlist =db.getAllrecord();
        ls.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1 , arrlist));
        txtname.setText("");
    }
    public  void buupdate (View View){

        EditText txtname=(EditText)findViewById(R.id.editText);
        EditText txtid=(EditText)findViewById(R.id.editText2);

        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.updateR(txtname.getText().toString(), Integer.parseInt(txtid.getText().toString()));

        ArrayList<String> arrlist =db.getAllrecord();
        ls.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1 , arrlist));
        txtname.setText("");
    }
/*
    public  void buaddproduct (View View){

        EditText txtnameprod=(EditText)findViewById(R.id.editText3);
        EditText txtid=(EditText)findViewById(R.id.editText2);
       // EditText txtprod=(EditText)findViewById(R.id.editText3);

        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);

        db.InsertRowprocut(txtnameprod.getText().toString(),Integer.parseInt(txtid.getText().toString()));

        ArrayList<String> arrlist =db.getAllrecord();
        ls.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1 , arrlist));
        txtnameprod.setText("");
        txtid.setText("");
    }
    */

    public void buafficher (View View){


        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);


        ArrayList<String> arrlist =db.getAllrecord();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));

    }
}
