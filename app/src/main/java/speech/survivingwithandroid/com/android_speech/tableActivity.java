package speech.survivingwithandroid.com.android_speech;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class tableActivity extends Activity implements View.OnClickListener {

	//String[] Names = {"amit","samit","ravi","sunil","panda"};
		//List<String> names = new ArrayList<String>();
		List<Double> number = new ArrayList<>();


		TableLayout table;
		String TAG =  tableActivity.class.getSimpleName();
		TextView text;
		Button buttons;
		Button add;
		Button sort;
  	ImageView addImage;

		@Override protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_table);
			add = (Button) findViewById(R.id.addButton);
			add.setOnClickListener(this);
			sort = (Button) findViewById(R.id.sort);
			sort.setOnClickListener(this);
			addImage = (ImageView) findViewById(R.id.AddImage);
			addImage.setOnClickListener(this);
			prefill();
			//initUI();
			table = (TableLayout) findViewById(R.id.activity_tablelayout);

	}

	private void prefill() {

		for (int count = 0; count < 10; count++) {
			double ran = Math.random();
			number.add(ran);
		}
	}

	private void initUI() {
		Log.d(TAG, " initUI enter");
		table = (TableLayout) findViewById(R.id.activity_tablelayout);
		int size = table.getChildCount();
		Log.d(TAG, " size of table is :" + size);
		for (int i = 0; i < size; i++) {
			View v = table.getChildAt(i);
			text = (TextView) v.findViewById(R.id.textView);
			buttons = (Button) v.findViewById(R.id.button);
			if (buttons != null && text != null) {
				buttons.setOnClickListener(this);
				if (i < number.size()) {
					text.setText(String.valueOf(number.get(i)));
					//	names.add(Names[i]);
				} else {
					text.setText("0.0");
					number.add(0.0);
				}
			}
		}
	}

	@Override public void onClick(View v) {
		if(v.getId() == R.id.addButton || v.getId() == R.id.AddImage){
				addRow();
		}
		else if (v.getId() == R.id.sort){
			sortRows();
		}
		else {
			Log.d(TAG, " onClick enter:" + v.getId());
			View row = (View) v.getParent();

			Log.d(TAG, " onClick row:" + row.getId());
			ViewGroup container = (ViewGroup) row.getParent();
			Log.d(TAG, " onClick view group" + container.getId());
			int index = container.indexOfChild(row); // try set tag. TODO
			Log.d(TAG, " onClick index :" + index);
			number.remove(index);
			container.removeView(row);
			container.invalidate();
		}
	}

	private void addRow() {
		Log.d(TAG, " addRow enter:");
		TableRow row = new TableRow(this);
		View v = getLayoutInflater().inflate(R.layout.table_row,null);
		row.addView(v);
		table.addView(row);
	//	initUI(); //  this can be more  efficient  actually  TODO
		if(number.add(Math.random())){
		TextView t = (TextView) row.findViewById(R.id.textView);
		if (t != null) {
			t.setText(String.valueOf(number.get(number.size()-1)));
		}
			buttons = (Button) v.findViewById(R.id.button);
			buttons.setOnClickListener(this);
	}
	}

	private void sortRows(){
		// TODO sort all the row and display  sorted  rows in table
		Log.d(TAG, " sortRows enter:");
		//sort all the names  and apply to table  layout  boys
	//	Arrays.sort(number.toArray());
		Collections.sort(number);
		Collections.reverse(number);
		for(int i=0;i<number.size();i++){
			Log.d(TAG,"number in index"+i+" :"+number.get(i)+"\n");
		}
		updateUI();
	}

	private void updateUI() {
		Log.d(TAG, "lets update the UI with Sorted rows: child count" + table.getChildCount());
		//int count = 0;
		for (int i = 0, j = table.getChildCount(); i < j; i++) {
			View view = table.getChildAt(i);
			if (view instanceof TableRow) {
				// then, you can remove the the row you want...
				// for instance...
				TableRow row = (TableRow) view;
				Log.d(TAG, "child count in Table Row:" + row.getChildCount());
				TextView t = (TextView) row.findViewById(R.id.textView);
				if (t != null) {
					t.setText(String.valueOf(number.get(i)));
				}
				//	count++;
			}
		}
	}



}
