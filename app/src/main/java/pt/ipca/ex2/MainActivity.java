package pt.ipca.ex2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.main_list);


        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                doRequest();
            }
        });
    }

    public void doRequest() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build();

        List<post> posts = null;
        try {
            Response response = client.newCall(request).execute();
            String body = response.body().string();

            Log.d("ADM", body);

            JSONArray array = new JSONArray(body);
            posts = new ArrayList<post>();

            for (int i = 0; i < array.length(); i++) {

                // Obter o objeto json do array na posição i
                JSONObject obj = array.getJSONObject(i);

                // Criar o objecto Post a partir do objecto JSON
                post p = new post(obj);

                // Adicionar este objecto POST à  nossa lista
                posts.add(p);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, posts);

        listView.setAdapter(adapter);
    }
}
