package sk.cassomedia.eldermonitor.children_info;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import sk.cassomedia.eldermonitor.R;

public class ChildrenList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_list);

        populateListView();
        registerClick();
    }

    private void populateListView(){
        String[] children = {"Babka", "Dedko", "Postih"};

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, R.layout.children_list_item, children);

        ListView list = (ListView) findViewById(R.id.lv_children);
        list.setAdapter(myAdapter);
    }

    private void registerClick(){
        ListView list = (ListView) findViewById(R.id.lv_children);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                StringBuilder sb = new StringBuilder();
                sb.append("You clicked #");
                sb.append(position);
                sb.append(", which is string: ");
                sb.append(textView.getText().toString());

                Log.d("ChildrenList", "fungujem");
                Toast.makeText(ChildrenList.this, sb.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
