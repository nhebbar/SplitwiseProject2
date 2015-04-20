        package com.example.niveditha.splitwiseproject2;

        import android.app.Activity;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.TextView;

        /**
         * author: Niveditha
         */
        public class HomeScreenFragment extends Fragment implements View.OnClickListener {

            String userName;
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState)
            {
                View view = inflater.inflate(R.layout.fragment_home_screen, container, false);
                Bundle data = getArguments();
                userName = data.getString("userName");
                Button createGroup = (Button) view.findViewById(R.id.createGrp);
                Button joinGroup = (Button) view.findViewById(R.id.joinGrp);
                createGroup.setOnClickListener(this);
                joinGroup.setOnClickListener(this);
                return view;
            }


            @Override
            public void onClick(View v)
            {
                switch (v.getId()) {
                    case R.id.createGrp:
                        Intent intent = new Intent(this.getActivity(),CreateGroupActivity.class );
                        intent.putExtra("username", userName);
                        startActivity(intent);
                        break;
                    case R.id.joinGrp:
                        break;
                    default:
                        break;
                }
            }
        }
