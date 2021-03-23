package ua.com.foxminded.toolsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {
    ImageView imageViewDrill;
    TextView textViewDrillInfo;
    TextView textViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_deteil);
        imageViewDrill = findViewById(R.id.imageViewDrills  );
        textViewDrillInfo = findViewById(R.id.textViewDrillInfo);
        textViewTitle = findViewById(R.id.textViewTitle);
        Intent intent = getIntent();
        if(intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("ImgRes")){
            String info = intent.getStringExtra("info");
            String title = intent.getStringExtra("title");
            int imgRes = intent.getIntExtra("ImgRes", -1);
            textViewTitle.setText(title);
            textViewDrillInfo.setText(info);
            imageViewDrill.setImageResource(imgRes);
        }else {
            Intent backToCategory = new Intent(this, DrillCategoryActivity.class);
            startActivity(backToCategory);
        }
    }
}