package speech.survivingwithandroid.com.android_speech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;

public class compositeTables extends AppCompatActivity {

	Button add;
	Button sorter;
	TableLayout tableLayout;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_composite_tables);
	}
}
