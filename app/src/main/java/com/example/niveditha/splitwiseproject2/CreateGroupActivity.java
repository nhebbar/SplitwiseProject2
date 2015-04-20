package com.example.niveditha.splitwiseproject2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class CreateGroupActivity extends ActionBarActivity implements View.OnClickListener{

    ListView listView;
    Button save;
    List<Friend> myfriendsList = new ArrayList<Friend>();
    FriendListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        getFriends();
        listView = (ListView) findViewById(R.id.friend_list);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View view) {
                count = listView.getAdapter().getCount();
                for (Friend m : myfriendsList) {
                    Log.i("Stack1", m.toString());
                }
            }
        });

        adapter = new FriendListAdapter(this, myfriendsList);
        listView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_group, menu);
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

    @Override
    public void onClick(View v) {

    }


    private void getFriends()
    {
        for(int i = 0 ; i< 5; i++)
        {
            Friend friend = new Friend();
            friend.setName("niveditha"+i);
            this.myfriendsList.add(friend);
        }
        return ;
    }
}
