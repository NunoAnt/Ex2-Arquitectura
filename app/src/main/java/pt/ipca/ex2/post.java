package pt.ipca.ex2;

import org.json.JSONException;
import org.json.JSONObject;

/**
    Created by Nuno on 14/05/2018.
 */

public class post {

    public int userId;
    public int id;
    public String title;
    public String body;

    public post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public post(JSONObject job) throws JSONException {
            this.body = job.getString("body");
            this.title = job.getString("title");
            this.userId = job.getInt("userId");
            this.id = job.getInt("id");
    }
}
