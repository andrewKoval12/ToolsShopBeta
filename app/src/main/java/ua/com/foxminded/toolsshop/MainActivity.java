package ua.com.foxminded.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    private ListView listViewTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        listViewTools = findViewById(R.id.listViewTools);
        listViewTools.setOnItemClickListener((parent, view, position, id) -> {
           switch (position){
               case 0:
                   Intent intentDrill = new Intent(getApplicationContext(), DrillCategoryActivity.class);
                   startActivity(intentDrill);
                   break;
               case 1:
                   Intent intentPerforator = new Intent(getApplicationContext(), PerforatorCategoryActivity.class);
                   startActivity(intentPerforator);
                   break;
               case 2:
                   Intent intentGrinder = new Intent(getApplicationContext(), GrinderCategoryActivity.class);
                   startActivity(intentGrinder);
                   break;
           }
        });

    }
}