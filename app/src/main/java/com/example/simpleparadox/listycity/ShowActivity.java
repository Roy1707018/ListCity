package com.example.simpleparadox.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showactivity);
        textView = findViewById(R.id.citytextarea);
        button = findViewById(R.id.backbutton);
        Bundle bundle = getIntent().getExtras();
        textView.setText(bundle.getString("key_city"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowActivity.this.finish();
            }
        });

    }
}