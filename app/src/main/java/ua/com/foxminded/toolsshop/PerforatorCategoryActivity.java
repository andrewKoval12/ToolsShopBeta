package ua.com.foxminded.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PerforatorCategoryActivity extends AppCompatActivity {

    private ListView listViewPerforator;
    private ArrayList<Instruments> perforator;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perforator_category);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        perforator = new ArrayList<>();
        perforator.add(new Instruments(getString(R.string.perforator_bosh_title), getString(R.string.perforator_bosh_info), R.drawable.perforatorbosh));
        perforator.add(new Instruments(getString(R.string.perforator_makita_title), getString(R.string.perforator_makita_info), R.drawable.perforatormakita));
        perforator.add(new Instruments(getString(R.string.perforator_dewalt_title), getString(R.string.perforator_dewalt_info), R.drawable.perfaratordewalt));
        listViewPerforator = findViewById(R.id.listViewPerforator);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.listview_color, perforator);
        listViewPerforator.setAdapter(adapter);
        listViewPerforator.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Instruments perforators = perforator.get(position);
                Intent intent = new Intent(getApplicationContext(), PerforatorDetailActivity.class);
                intent.putExtra("title", perforators.getTitle());
                intent.putExtra("info", perforators.getInfo());
                intent.putExtra("imgRes", perforators.getImageInfoId());
                startActivity(intent);
            }
        });


    }
}