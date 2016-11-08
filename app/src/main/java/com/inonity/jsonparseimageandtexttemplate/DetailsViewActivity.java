package com.inonity.jsonparseimageandtexttemplate;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.inonity.jsonparseimageandtexttemplate.app.AppController;
import com.inonity.jsonparseimageandtexttemplate.model.Movie;

public class DetailsViewActivity extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    TextView movieName,rating,genre,year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        movieName = (TextView) findViewById(R.id.textMovieName);
        rating = (TextView) findViewById(R.id.textRating);
        genre = (TextView) findViewById(R.id.textGenre);
        year = (TextView) findViewById(R.id.textYear);

       Movie movie = (Movie) getIntent().getExtras().getSerializable("object");

        movieName.setText(movie.getTitle());
        rating.setText(new StringBuilder().append(" ").append(movie.getRating()).toString());
        genre.setText(movie.getGenre().get(0)+","+movie.getGenre().get(1));
        year.setText(new StringBuilder().append(" ").append(movie.getYear()).toString());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
