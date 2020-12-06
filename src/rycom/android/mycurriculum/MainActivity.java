package rycom.android.mycurriculum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class MainActivity extends Activity {
	private AdView adView;
	private String lsData = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//loadAds();
		Button next = (Button) findViewById(R.id.buttonNextMain);
		next.setOnClickListener(new ChangeActivity());
	}


	private void loadAds() {
		// Crear la adView
		adView = new AdView(this, AdSize.BANNER, "a150ad02d4e0938");

		// Buscar el LinearLayout suponiendo que se le haya asignado
		// el atributo android:id="@+id/mainLayout"
		LinearLayout layout = (LinearLayout)findViewById(R.id.banner);

		// Añadirle la adView
		layout.addView(adView);

		// Iniciar una solicitud genérica para cargarla con un anuncio
		adView.loadAd(new AdRequest());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	  if (resultCode == RESULT_OK && requestCode == 0) {
	    if (data.hasExtra("Valor")) {
	    	lsData = data.getExtras().getString("Valor").toString();
	    	Log.i("INFORMACION", data.getExtras().getString("Valor").toString());
	    }
	  }
	} 
	
	class ChangeActivity implements View.OnClickListener {
		@Override
		public void onClick(View view) {
			 Intent myIntent = new Intent(view.getContext(), PersonalData.class);
			 myIntent.putExtra("Valor", lsData);
             startActivityForResult(myIntent, 0);
		}
	}
}
