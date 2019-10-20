package com.shenny.components;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    String imgURL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);
        ActionBar actionBar = getSupportActionBar();

        assert actionBar != null;
        actionBar.setTitle("Detail Component");
        getIncomingIntent();

        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void getIncomingIntent(){
        if((getIntent().hasExtra("judul"))&&(getIntent().hasExtra("penjelasan"))&&(getIntent().hasExtra("url"))&&(getIntent().hasExtra("example"))){

            Intent mIntent = getIntent();

            String imgTitle = mIntent.getStringExtra("judul");
            String imgExplanation = mIntent.getStringExtra("penjelasan");
            String imgExample = mIntent.getStringExtra("example");
            imgURL = mIntent.getStringExtra("url");

            setImage(imgTitle, imgExplanation, imgExample);
        }
    }

    private void setImage( String imgTitle, String imgExplanation, String imgExample){
        TextView name = findViewById(R.id.tv_item_title);
        name.setText(imgTitle);

        TextView explanation = findViewById(R.id.tv_item_explanation);
        explanation.setText(imgExplanation);

        TextView example = findViewById(R.id.tv_example_code);
        example.setText(imgExample);

        TextView openLink = findViewById(R.id.tv_open_link);
        openLink.setText("\t\tBerikut ini adalah materi dari " + imgTitle + " : ");

        TextView openExample = findViewById(R.id.tv_open_example);
        openExample.setText("\t\tBerikut ini adalah contoh syntax dari implementasi " + imgTitle + " : ");

        Button btnLinkMateri = findViewById(R.id.btn_link_materi);
        btnLinkMateri.setOnClickListener(this);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu){return  true;}

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_link_materi){
            Intent linkMateriIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(imgURL));
            startActivity(linkMateriIntent);
        }
    }
}
