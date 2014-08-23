package com.aaa;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {
Spinner place;
Spinner theme;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        place = (Spinner)findViewById(R.id.place);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.place, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(
android.R.layout.simple_spinner_dropdown_item);
        place.setAdapter(adapter1);
        
        theme = (Spinner)findViewById(R.id.theme);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.theme, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(
android.R.layout.simple_spinner_dropdown_item);
        place.setAdapter(adapter2);
    }


 
    
}
