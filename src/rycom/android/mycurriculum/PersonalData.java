package rycom.android.mycurriculum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonalData extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_data);
		Bundle extras = getIntent().getExtras();
	    if (extras == null) {
	      return;
	    }	
	    String value1 = extras.getString("Valor");
	    if (value1 != null) {
	      EditText text1 = (EditText) findViewById(R.id.editText1);
	      text1.setText(value1);
	    }
		// Show the Up button in the action bar.
		//getActionBar().setDisplayHomeAsUpEnabled(true);
		Button next = (Button) findViewById(R.id.PersonalDataNext);
		next.setOnClickListener(new ChangeActivityNext());
		Button prev = (Button) findViewById(R.id.PersonalDataPrev);
		prev.setOnClickListener(new ChangeActivityPrev());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_personal_data, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	class ChangeActivityNext implements View.OnClickListener {
		@Override
		public void onClick(View view) {
			 Intent myIntent = new Intent(view.getContext(), PersonalData.class);
			// myIntent.putExtra("Valor", lsData);
             startActivityForResult(myIntent, 0);
		}
	}
	class ChangeActivityPrev implements View.OnClickListener {
		@Override
		public void onClick(View view) {
			 Intent myIntent = new Intent(view.getContext(), MainActivity.class);
			 EditText letAux = (EditText)  findViewById(R.id.editText1);
			 myIntent.putExtra("Valor", letAux.getText().toString());
			 Log.i("LogInfo", letAux.getText().toString());
			 setResult(RESULT_OK, myIntent);
			 finish();
		}
	}

}
