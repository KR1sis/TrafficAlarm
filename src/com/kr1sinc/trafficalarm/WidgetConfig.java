package com.kr1sinc.trafficalarm;


import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RemoteViews;
import android.widget.TextView;

public class WidgetConfig extends Activity {
	
	private static final String TAG = "ExampleAppWidgetProvider";
	int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
	OnClickListener ok_listner = new OnClickListener() {
		@Override
		public void onClick(View v) {
			final Context context = WidgetConfig.this;
			TextView source_tv = (TextView)findViewById(R.id.widgetTextEdit);
			
			AppWidgetManager widgetManager = AppWidgetManager.getInstance(context);
			RemoteViews view = new RemoteViews(context.getPackageName(), R.layout.widgetlayout);
			view.setTextViewText(R.id.widgetText, source_tv.getText());
			widgetManager.updateAppWidget(mAppWidgetId, view);
			
            Intent resultValue = new Intent();
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
			setResult(RESULT_OK, resultValue);
            finish();
		}
	};
	
	OnClickListener ShowYandexMap_Click = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			final String action_name = "com.kr1sinc.intent.action.ShowYandexMap"; 
			Intent intent = new Intent(action_name);
			startActivity(intent);
		}
	};
	
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setResult(RESULT_CANCELED);
		
		Log.i(TAG, "We are in onCreate method");
		
		setContentView(R.layout.widgetconfiglayout);
		findViewById(R.id.button1).setOnClickListener(ok_listner);
		findViewById(R.id.btnShowYandexMap).setOnClickListener(ShowYandexMap_Click);
		
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		if (extras != null){
			mAppWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
		}
		
		if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID)
			finish();
	 }
	 
}
