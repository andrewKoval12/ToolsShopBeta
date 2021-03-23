package ua.com.foxminded.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DrillCategoryActivity extends AppCompatActivity {

    private ListView listViewDrills;
    private ArrayList<Instruments> drills;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        drills = new ArrayList<>();
        drills.add(new Instruments(getString(R.string.drill_dewalt_title), getString(R.string.drill_dewalt_info), R.drawable.dewalt ));
        drills.add(new Instruments(getString(R.string.drill_interskol_title), getString(R.string.drill_interskol_info), R.drawable.interskol ));
        drills.add(new Instruments(getString(R.string.drill_makito_title), getString(R.string.drill_makita_info), R.drawable.makita ));
        listViewDrills = findViewById(R.id.listViewDrill);
        ArrayAdapter<Instruments> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.listview_color, drills);
        listViewDrills.setAdapter(adapter);
        listViewDrills.setOnItemClickListener((parent, view, position, id) -> {
            Instruments drill = drills.get(position);
            Intent intent = new Intent(getApplicationContext(), DrillDetailActivity.class);
            intent.putExtra("title", drill.getTitle());
            intent.putExtra("info", drill.getInfo());
            intent.putExtra("ImgRes", drill.getImageInfoId());
            startActivity(intent);
        });

    }
}