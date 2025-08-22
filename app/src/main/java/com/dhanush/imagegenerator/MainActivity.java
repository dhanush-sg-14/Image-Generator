package com.dhanush.imagegenerator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button generateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.randomImageView);
        generateBtn = findViewById(R.id.generateBtn);

        generateBtn.setOnClickListener(v -> fetchRandomImage());

        // Optionally load an image when app starts
        fetchRandomImage();
    }

    private void fetchRandomImage() {
        // Picsum Photos URL generates a new random image each time by appending current time
        String url = "https://picsum.photos/600/400?random=" + System.currentTimeMillis();

        Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_placeholder)  // your placeholder drawable
                .error(R.drawable.ic_error)              // your error drawable
                .into(imageView);
    }
}
