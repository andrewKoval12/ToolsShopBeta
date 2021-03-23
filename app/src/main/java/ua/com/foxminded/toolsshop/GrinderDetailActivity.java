package ua.com.foxminded.toolsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GrinderDetailActivity extends AppCompatActivity {

    private ImageView imageViewGrinder;
    private TextView textViewGrinderTitle;
    private TextView textViewGrinderInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grinder_detail);

        imageViewGrinder = findViewById(R.id.imageViewGrinderDetail);
        textViewGrinderTitle = findViewById(R.id.textViewGrinderTitle);
        textViewGrinderInfo = findViewById(R.id.textViewGrinderInfo);
        Intent intent = getIntent();
        if(intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("imgRes")){
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int imgRes = intent.getIntExtra("imgRes", -1);
            textViewGrinderTitle.setText(title);
            textViewGrinderInfo.setText(info);
            imageViewGrinder.setImageResource(imgRes);
        }else {
            Intent intentBackToCategory = new Intent(getApplicationContext(), GrinderCategoryActivity.class);
            startActivity(intentBackToCategory);
        }
    }
}