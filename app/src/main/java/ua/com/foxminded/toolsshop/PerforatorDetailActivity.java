package ua.com.foxminded.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PerforatorDetailActivity extends AppCompatActivity {

    TextView textViewPerforatorTitle;
    TextView textViewPerforatorInfo;
    ImageView imageViewPerforatorImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perforator_detail);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        textViewPerforatorTitle = findViewById(R.id.textViewTitlePerforatorDetail);
        textViewPerforatorInfo = findViewById(R.id.textViewInfoPerforatorDetail);
        imageViewPerforatorImg = findViewById(R.id.imageViewPerforatorDetail);

        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("imgRes")){
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int imgRes = intent.getIntExtra("imgRes", -1);
            textViewPerforatorTitle.setText(title);
            textViewPerforatorInfo.setText(info);
            imageViewPerforatorImg.setImageResource(imgRes);
        } else {
            Intent backToCategory = new Intent(getApplicationContext(), PerforatorCategoryActivity.class);
            startActivity(backToCategory);
        }
    }
}