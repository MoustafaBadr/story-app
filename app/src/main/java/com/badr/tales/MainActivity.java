package com.badr.tales;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         list=(ListView)findViewById(R.id.listView);

        String mylis[]=getResources().getStringArray(R.array.index);
        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,R.layout.raw_items,R.id.textitem,mylis);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(MainActivity.this,Webhtml.class);
                i.putExtra("page",position);
                startActivity(i);
            }
        });
    }

    public void onshar(View view) {
        String text_share="تطبيق حكايات السندباد";
        String sharelink="https://play.google.com/store/apps/details?id=com.badr.tales";

        Intent share=new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,text_share + "\n" + sharelink);

        startActivity(share);
    }

    public void onemail(View view) {
      try {
          String text = "السلام عليكم ورحة الله وبركاته\n اقتراحي هو ";
          Intent sendemail = new Intent(Intent.ACTION_SEND);
          sendemail.setData(Uri.parse("mailto:"));
          sendemail.setType("message/rfc822");
          sendemail.putExtra(Intent.EXTRA_EMAIL, "mostafabadr664@gmail.com");
          sendemail.putExtra(Intent.EXTRA_SUBJECT, "تطبيق حكايات السندباد ");
          sendemail.putExtra(Intent.EXTRA_TEXT, text);
          startActivity(sendemail);
      }catch (Exception c){
          Toast.makeText(this,"عفوا لا يوجد تطبيق بريد",Toast.LENGTH_LONG).show();
      }

      }

    public void onclose(View view) {
        finish();
    }



   /* public void onmore(View view) { / da 3shan y3rd googlestore acc lo 3ndk
        Intent more_app=new Intent(Intent.ACTION_SEND);
        more_app.setData(Uri.parse("https://play.google.com/store/apps/developer?idid pta3k f google"))
        startActivity(share);
    }*/


}
