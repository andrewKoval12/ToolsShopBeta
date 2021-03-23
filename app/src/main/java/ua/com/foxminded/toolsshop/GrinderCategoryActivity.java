package ua.com.foxminded.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class GrinderCategoryActivity extends AppCompatActivity {

    private ListView listViewGrinders;
    private ArrayList<Instruments> grinders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grinder_category);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        grinders = new ArrayList<>();
        grinders.add(new Instruments(getString(R.string.grinder_bosh_title), getString(R.string.grinder_bosh_info), R.drawable.grinderbosh));
        grinders.add(new Instruments(getString(R.string.grinder_makita_title), getString(R.string.grinder_makita_info), R.drawable.grindermakita));
        grinders.add(new Instruments(getString(R.string.grinder_dewalt_title), getString(R.string.grinder_dewalt_info), R.drawable.grinderdewalt));
        listViewGrinders = findViewById(R.id.listViewGrinder);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.listview_color, grinders);
        listViewGrinders.setAdapter(adapter);
        listViewGrinders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Instruments grinder = grinders.get(position);
                Intent intent = new Intent(getApplicationContext(), GrinderDetailActivity.class);
                intent.putExtra("title", grinder.getTitle());
                intent.putExtra("info", grinder.getInfo());
                intent.putExtra("imgRes", grinder.getImageInfoId());
                startActivity(intent);
            }
        });

    }
}