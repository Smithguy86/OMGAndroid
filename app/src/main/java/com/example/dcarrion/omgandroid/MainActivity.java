package com.example.dcarrion.omgandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener,AdapterView.OnItemClickListener {

    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Access TextView in layout and sets it's text
        mainTextView = (TextView) findViewById(R.id.main_textview);
        mainTextView.setText("Set in Java");

        //Accesss the button defined in layout Xml and listen for it here
        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);

        //Access the EditText defined in Layout xml
        mainEditText = (EditText) findViewById(R.id.main_edittext);

        //Access the listView
        mainListView = (ListView) findViewById(R.id.main_listview);

        // Create an ArrayAdapter for the ListView
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);

        //Set the listview to use the arrayAdapter
        mainListView.setAdapter(mArrayAdapter);

        // Set this activity to react to the items being pressed
        mainListView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        //Test the button
        mainTextView.setText("Button Pressed");

        //Take what was typed in the Edit Text and use it in the TextView
        mainTextView.setText(mainEditText.getText().toString() + " is learning Android Dev");

        //Also add that value to the list shown in the listView
        mNameList.add(mainEditText.getText().toString());
        mArrayAdapter.notifyDataSetChanged();


    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p/>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //Log the item position and contents to the console in Debug
        Log.d("omg Android", position + ":" + mNameList.get(position));

    }
}
