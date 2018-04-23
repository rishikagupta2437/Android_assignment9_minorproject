package com.example.rishika.minorproject;


import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class home extends AppCompatActivity{

    public static final String CALCULATOR_PACKAGE ="com.android.calculator2";
    public static final String CALCULATOR_CLASS ="com.android.calculator2.Calculator";

       Button pbtn,calbtn,conbtn,exbtn, googbtn;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Toast.makeText(this,"HELLO RISHIKA",Toast.LENGTH_SHORT).show();

        pbtn=(Button) findViewById(R.id.uploadpicture);
        calbtn= (Button) findViewById(R.id.calcbtn);
        conbtn=(Button) findViewById(R.id.converbtn);
        exbtn=(Button) findViewById(R.id.extbtn);
        googbtn=(Button)findViewById(R.id.Googbtn);

        img=(ImageView)findViewById(R.id.imageView);

        pbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent takepictureintent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takepictureintent,101);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==101)
        {
            if (resultCode==RESULT_OK){
                Bundle extrabundle= data.getExtras();
                Bitmap imagebitmap=(Bitmap)extrabundle.get("data");
                img.setImageBitmap(imagebitmap);
            } else if (resultCode==RESULT_CANCELED){
                Toast.makeText(this,"User cancelled the operation",Toast.LENGTH_SHORT).show();
            }

        }
        calbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
                intent.setComponent(new ComponentName(
                        CALCULATOR_PACKAGE,
                        CALCULATOR_CLASS));

                home.this.startActivity(intent);



            }
        });

        conbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();

                 intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_CONTACTS);
                home.this.startActivity(intent);


            }
        });

        googbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent googleintent= new Intent(Intent.ACTION_VIEW);
                googleintent.setData(Uri.parse("http://google.com"));
                startActivity(googleintent);
            }

        });


        exbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}
