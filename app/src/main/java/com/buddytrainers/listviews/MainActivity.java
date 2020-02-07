package com.buddytrainers.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView ListViewable;
    private String [] weeksDays={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    private ArrayAdapter<String> objectArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JavaViews();
    }

    private void JavaViews()
    {
        try
        {
            ListViewable =findViewById(R.id.list_view);
            objectArrayAdapter=new ArrayAdapter<>(
                    this, android.R.layout.simple_list_item_1, weeksDays
            );

            ListViewable.setAdapter(objectArrayAdapter);
            ListViewable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int listPosition, long l) {
                    Toast.makeText(MainActivity.this, "Position Clicked:" +listPosition, Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(this, "JavaViews" + ":"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void customizedLayoutArrayAdapter()
    {
        try
        {
            ListViewable =findViewById(R.id.list_view);
            objectArrayAdapter=new ArrayAdapter<>(
                    this, R.layout.single_row, R.id.singleListStyle, weeksDays
            );


            ListViewable.setAdapter(objectArrayAdapter);
            ListViewable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int listPosition, long l) {

                    TextView tempTV=view.findViewById(R.id.singleListStyle);
                    Toast.makeText(MainActivity.this, "Text is:" +tempTV.getText().toString() +" and position is:" +listPosition, Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(this, "customizedLayoutArrayAdapter" + ":"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
