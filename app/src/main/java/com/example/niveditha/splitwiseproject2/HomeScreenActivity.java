	package com.example.niveditha.splitwiseproject2;

	import android.annotation.TargetApi;
	import android.app.Activity;
	import android.app.AlertDialog;
	import android.content.Intent;
	import android.support.v4.app.Fragment;
	import android.os.Build;
	import android.support.v4.app.FragmentActivity;
	import android.support.v4.app.FragmentManager;
	import android.support.v4.app.FragmentTransaction;
	import android.support.v4.view.ViewPager;
	import android.support.v7.app.ActionBar.Tab;
	import android.app.ActionBar;

	import android.os.Bundle;
	import android.app.Activity;
	import android.os.Bundle;
	import android.support.v7.app.ActionBarActivity;
	import android.util.Log;
	import android.view.Menu;
	import android.view.MenuItem;
	import android.view.Window;
	import android.widget.Toast;

	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;

	import static android.R.id.content;


	public class HomeScreenActivity extends ActionBarActivity implements android.support.v7.app.ActionBar.TabListener {

		private String[] tabs = { "Home Screen", "Owner" , "Treasurer", "MyGroups"};
		List<Fragment> fragList = new ArrayList<Fragment>();
		String userName = "";
	   // ActionBar actionBar;

		@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
		@Override
		protected void onCreate(Bundle savedInstanceState)
        {
		    super.onCreate(savedInstanceState);
		    Intent intent = getIntent();
			userName = (String) intent.getExtras().get("userName");
			setContentView(R.layout.activity_home_screen);
			ActionBar.Tab tab1, tab2, tab3;
			Fragment fragmentTab1 = new Fragment();

			android.support.v7.app.ActionBar actionBar = getSupportActionBar();
			actionBar.setHomeButtonEnabled(false);
		    actionBar.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS);

			for (String tab_name : tabs) {
			  actionBar.addTab(actionBar.newTab().setText(tab_name)
					  .setTabListener(this));
			}
		}


		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.menu_home_screen, menu);
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
			if( id == R.id.logout)
			{


			}
			return super.onOptionsItemSelected(item);
		}


		@Override
		public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {

			Log.e("MainActivity", "Wow in lisstener");
			//viewPager.setCurrentItem(tab.getPosition());
			Fragment f = null;
			Fragment tf = null;

			if (fragList.size() > tab.getPosition())
				fragList.get(tab.getPosition());

			if (f == null) {
				if(tab.getPosition() == 0) {
					tf = new HomeScreenFragment();
					Bundle data = new Bundle();
					data.putString("userName",userName);
					tf.setArguments(data);
				}
				else
					tf = new HomeScreenFragment();
				fragList.add(tf);
			}
			else
				tf = (HomeScreenFragment) f;

			fragmentTransaction.replace(android.R.id.content, tf);


		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {

		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {

		}
	}
