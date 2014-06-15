package com.example.trashfriends;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

public class MainActivity extends ActionBarActivity {

	public final static String EVIL_FRIENDS_LIST = "EVIL_FRIENDS_LIST";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    
    /** Called when the user clicks the Send button */
    public void sendMessageToAll(View view) {
    	
    	ArrayList<String> evil_friends = new ArrayList<String>();
        
    	Intent intent = new Intent(this, SendMessageActivity.class);
    	
    	
    	List<Integer> check_box_id_list = new ArrayList<Integer>();
    	
    	int check_box_id_1 = R.id.checkBox1;
    	check_box_id_list.add(check_box_id_1);
    	
    	int check_box_id_2 = R.id.checkBox2;
    	check_box_id_list.add(check_box_id_2);
    	
    	int check_box_id_3 = R.id.checkBox3;
    	check_box_id_list.add(check_box_id_3);
    	
    	int check_box_id_4 = R.id.checkBox4;
    	check_box_id_list.add(check_box_id_4);
    	
    	
    	Iterator<Integer> it = check_box_id_list.iterator();
    	while(it.hasNext()) {
        	CheckBox check_box = (CheckBox) findViewById(it.next());
        	Boolean is_checked = check_box.isChecked();
        	
        	if (is_checked) {
        		String evil_friend_name = check_box.getText().toString();
        		evil_friends.add(evil_friend_name);
        	}
    	}

    	
    	intent.putStringArrayListExtra(EVIL_FRIENDS_LIST, evil_friends);
    	startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
