package com.affixu.andy.letmedesign;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private TextView textView1;
    private Resources resource;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resource = this.getResources();
        button1 = (Button) findViewById(R.id.button1);
        textView1 = (TextView) findViewById(R.id.textview1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DESIGN ", " BUTTON CLICK :: " + textView1.getText().toString());
                Log.i("DESIGN ", " BUTTON CLICK :: " + textView1.getText().toString());
                Log.e("DESIGN ", " BUTTON CLICK :: " + textView1.getText().toString());
                Log.w("DESIGN ", " BUTTON CLICK :: " + textView1.getText().toString());


                try {
                    InputStream rawResource = resource.openRawResource(R.raw.config);
                    Properties properties = new Properties();
                    properties.load(rawResource);
                    Log.i("DESIGN " , "The properties are now loaded");
                    Log.i("DESIGN " , "properties: " + properties);
                } catch (IOException e) {
                    System.err.println("Failed to open microlog property file");
                }

                Log.i("DESIGN :: ", resource.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
