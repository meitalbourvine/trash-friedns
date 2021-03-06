package com.example.trashfriends;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class SendMessageActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_message);

		Intent intent = getIntent();
		ArrayList<String> evil_friends = intent.getStringArrayListExtra(MainActivity.EVIL_FRIENDS_LIST);
		
		String evil_friends_str = "Messages were sent to: ";
		
		for (String s : evil_friends) {
			evil_friends_str += s;
			evil_friends_str += ", ";
		}
		
		// Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText(evil_friends_str);

	    // Set the text view as the activity layout
	    setContentView(textView);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.send_message, menu);
		return true;
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	
    	// Handle presses on the action bar items
        switch (item.getItemId()) {
        case R.id.action_search:
    		openSearch();
        return true;
        case R.id.action_test:
            openTest();
            return true;
        case R.id.action_settings:
            openSettings();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }

	}
	
	public void openSearch() {
		// Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText("Search");
	
	    // Set the text view as the activity layout
	    setContentView(textView);
	}
    
    public void openTest() {
    	// Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText("Test");

	    // Set the text view as the activity layout
	    setContentView(textView);
    }
    
    public void openSettings(){
    	// Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText("Settings");

	    // Set the text view as the activity layout
	    setContentView(textView);
    }


	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_send_message,
					container, false);
			return rootView;
		}
	}

}
