package pt.ipca.ex2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
  Created by Nuno on 14/05/2018.
 */

public class MySimpleArrayAdapter extends ArrayAdapter {

    public Context mContext;
    public List<post> mPost;

    public MySimpleArrayAdapter (Context context, List<post> post) {
        super(context, R.layout.list_view_row);
        this.mContext = context;
        this.mPost = post;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_view_row, parent, false);
        }

        post posts = mPost.get(position);

        TextView labelID = convertView.findViewById(R.id.id);
        TextView labelUserID = convertView.findViewById(R.id.userID);
        TextView labelTitle = convertView.findViewById(R.id.title);
        TextView labelBody = convertView.findViewById(R.id.body);

        labelID.setText(posts.id);
        labelUserID.setText(posts.userId);
        labelTitle.setText(posts.title);
        labelBody.setText(posts.body);

        return convertView;
    }
}
