package company.wjc.ab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_info;
    private Button btn_find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_info = (TextView) findViewById(R.id.tv_info);
        btn_find = (Button) findViewById(R.id.btn_find);
        btn_find.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        final String path = "http://118.244.212.82:9092/newsClient";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url=new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                 conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    //conn.setRequestProperty("content-Type","text/css");
                    String data="news_list?ver=0&subid=1&dir=1&nid=0&stamp=20140321&cnt=20";
                    if (conn.getResponseCode()==200){
                        InputStream in = conn.getInputStream();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
