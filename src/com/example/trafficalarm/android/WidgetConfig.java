package com.example.trafficalarm.android;

import com.example.trafficalarm.R;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class WidgetConfig extends AppWidgetProviderInfo {
	 public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		 Intent intent = new Intent(context, ConfigActivity.class);
		 PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
		 
		 RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widgetconfiglayout);
		 views.setOnClickPendingIntent(R.id.button1, pendingIntent);
		 appWidgetManager.updateAppWidget(appWidgetIds[0], views);
	 }
	 
}
