package com.example.niveditha.splitwiseproject2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Niveditha on 4/19/2015.
 */
public class FriendListAdapter extends ArrayAdapter<Friend> {

    private final Activity context;
    private final List<Friend> friends;
    FriendListAdapter(Activity context,List<Friend> friendList){
        super(context,R.layout.friend_choose,friendList);
        this.context = context;
        this.friends = friendList;
    }
    static class ViewHolder {
        protected TextView text;
        protected CheckBox checkbox;
        protected RadioButton radioButton;
        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            convertView = inflator.inflate(R.layout.friend_choose, null,true);

            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) convertView.findViewById(R.id.friendName);
            viewHolder.checkbox = (CheckBox) convertView.findViewById(R.id.isFriend);
            viewHolder.radioButton = (RadioButton) convertView.findViewById(R.id.istreasurer);
            viewHolder.checkbox.setTag(position);
            viewHolder.radioButton.setTag(position);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.text.setText(friends.get(position).getName());
        viewHolder.checkbox.setChecked(friends.get(position).isMember());
        viewHolder.checkbox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CheckBox checkbox = (CheckBox) v;
                int getPosition = (Integer) checkbox.getTag();
                friends.get(getPosition).setMember(checkbox.isChecked());
            }
        });

        viewHolder.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                RadioButton radioButton = (RadioButton) buttonView;
                int getPosition = (Integer) radioButton.getTag();
                friends.get(getPosition).setTreasurer(radioButton.isSelected());
            }
        });

        return convertView;
    }
}
