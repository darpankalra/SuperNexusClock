package com.flickcraft.supernexusclock;

import java.util.Calendar;
import java.util.Timer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;

public class ClockWidget extends AppWidgetProvider {
	int[] mAppWidgetIds;
	AppWidgetManager widgetManager;
	boolean showSecHand;
	boolean setAlarmOnClick;
	boolean showRimShadow;
//	int color;
	int rimcolor;
	int seccolor;
	int mincolor;
	int hourcolor;
	int shadowrimcolor;
	int shadowseccolor;
	int shadowmincolor;
	int shadowhourcolor;
	float shadowsecradius;
	float shadowminradius;
	float shadowhourradius;
	public static String WIDGET_UPDATE = "com.flickcraft.supernexusclock.WIDGET_UPDATE";
	public static String SET_ALARM = "com.flickcraft.supernexusclock.SET_ALARM";
	public static String CLOCKTICK_SERVICE = "com.flickcraft.supernexusclock.CLOCKTICK_SERVICE";
	SharedPreferences customsettings;
	Bitmap bmpCenterTemp;
	static Timer timer = null;
	
	public void onReceive(Context context, Intent intent)
	{
		super.onReceive(context, intent);
		
		customsettings = context.getSharedPreferences(ClockWidgetConfigActivity.PREFS_NAME, 0);
		
		ComponentName thisAppWidget = new ComponentName(context.getPackageName(), getClass().getName());
		widgetManager = AppWidgetManager.getInstance(context);
		mAppWidgetIds = widgetManager.getAppWidgetIds(thisAppWidget);
		
		if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
		{
			if(mAppWidgetIds.length>0)
			{
				AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(System.currentTimeMillis());
				calendar.add(Calendar.SECOND, 1);
				
				alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()+1000, 1000, createClockTickIntent(context));
			}
		}
		
		if(WIDGET_UPDATE.equals(intent.getAction()))
		{
			
			for(int appWidgetId : mAppWidgetIds)
			{
				showSecHand = customsettings.getBoolean(appWidgetId+"sec_hand", true);
				showRimShadow = customsettings.getBoolean(appWidgetId+"shadow_rim", false);
//		        color = customsettings.getInt(appWidgetId+"color", 0xffFFFFFF);
		        rimcolor = customsettings.getInt(appWidgetId+"rimcolor", 0xffFFFFFF);
		        seccolor = customsettings.getInt(appWidgetId+"seccolor", 0xffFFFFFF);
		        mincolor = customsettings.getInt(appWidgetId+"mincolor", 0xffFFFFFF);
		        hourcolor = customsettings.getInt(appWidgetId+"hourcolor", 0xffFFFFFF);
		        shadowrimcolor = customsettings.getInt(appWidgetId+"shadowrimcolor", 0xff888888);
		        shadowseccolor = customsettings.getInt(appWidgetId+"shadowseccolor", 0xff888888);
		        shadowmincolor = customsettings.getInt(appWidgetId+"shadowmincolor", 0xff777777);
		        shadowhourcolor = customsettings.getInt(appWidgetId+"shadowhourcolor", 0xff777777);
		        shadowsecradius = customsettings.getFloat(appWidgetId+"shadowsecradius", 5.0f);
		        shadowminradius = customsettings.getFloat(appWidgetId+"shadowminradius", 5.0f);
		        shadowhourradius = customsettings.getFloat(appWidgetId+"shadowhourradius", 5.0f);
				update(context, appWidgetId);
			}
		}
		else if(SET_ALARM.equals(intent.getAction()))
		{
			Intent AlarmClickIntent = new Intent("android.intent.action.MAIN");
		    AlarmClickIntent.setComponent(new ComponentName("com.android.alarmclock", "com.android.alarmclock.AlarmClock"));
		    AlarmClickIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    if (existsReceiver(context, AlarmClickIntent))
		    	context.startActivity(AlarmClickIntent);
		    else
		    {
		    	AlarmClickIntent.setComponent(new ComponentName("com.android.deskclock", "com.android.deskclock.AlarmClock"));
		    	if (existsReceiver(context, AlarmClickIntent))
			    	context.startActivity(AlarmClickIntent);
		    	else
		    	{
		    		AlarmClickIntent.setComponent(new ComponentName("com.google.android.deskclock", "com.android.deskclock.AlarmClock"));
		    		if (existsReceiver(context, AlarmClickIntent))
				    	context.startActivity(AlarmClickIntent);
		    		else
		    		{
		    			AlarmClickIntent.setComponent(new ComponentName("com.htc.android.worldclock", "com.htc.android.worldclock.WorldClockTabControl"));
		    			if (existsReceiver(context, AlarmClickIntent))
					    	context.startActivity(AlarmClickIntent);
		    			else
		    			{
		    				AlarmClickIntent.setComponent(new ComponentName("com.motorola.blur.alarmclock", "com.motorola.blur.alarmclock.AlarmClock"));
		    				if (existsReceiver(context, AlarmClickIntent))
						    	context.startActivity(AlarmClickIntent);
		    				else
		    				{
		    					AlarmClickIntent.setComponent(new ComponentName("com.sonyericsson.alarm", "com.sonyericsson.alarm.Alarm"));
		    					if (existsReceiver(context, AlarmClickIntent))
							    	context.startActivity(AlarmClickIntent);
		    					else
		    					{
		    						AlarmClickIntent.setComponent(new ComponentName("com.sec.android.app.clockpackage","com.sec.android.app.clockpackage.ClockPackage"));
		    						if (existsReceiver(context, AlarmClickIntent))
								    	context.startActivity(AlarmClickIntent);
		    					}
		    				}
		    			}
		    		}
		    	}
		    }
		}
	}
	
	private boolean existsReceiver(Context context, Intent intent)
	{
		boolean b;
		if (context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).size() > 0)
		{
			b = true;
		}
		else
		{
			b = false;
		}
		return b;
	}
	
	
	public void update(Context context, int appWidgetId)
	   {
//			Log.d("SuperNexusClock", ""+color);			
			RemoteViews views = drawClock2(context);
			
			if(customsettings.getBoolean(appWidgetId+"setalarm_onclick", true))
			{
				Intent intent = new Intent(SET_ALARM);
				PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
				views.setOnClickPendingIntent(R.id.widget_imageview, pendingIntent);
			}
			
			widgetManager.updateAppWidget(appWidgetId, views);

	   }
	
	public RemoteViews drawClock2(Context context)
	{
		RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget);
		Paint p = new Paint();
	    p.setAntiAlias(true);
	    p.setFilterBitmap(true);
	    p.setDither(true);
	    p.setColor(rimcolor);
	    p.setStrokeWidth(3.75f);
	    p.setStyle(Paint.Style.STROKE);
	    
	    Calendar rightNow = Calendar.getInstance();
	    
	    Bitmap bmpTemp=Bitmap.createBitmap(216, 216, Bitmap.Config.ARGB_8888);
	    Bitmap bmpMinTemp=Bitmap.createBitmap(216, 216, Bitmap.Config.ARGB_8888);
	    Bitmap bmpHourTemp=Bitmap.createBitmap(216, 216, Bitmap.Config.ARGB_8888);
	    Bitmap bmpSecTemp=Bitmap.createBitmap(216, 216, Bitmap.Config.ARGB_8888);
	    Canvas c = new Canvas(bmpTemp);
//	    p.setShadowLayer(5, 0, 0, Color.GRAY);
	    
	    p.setStrokeWidth(4.35f);
	    if(showRimShadow)
	    	p.setShadowLayer(5.0f, 0, 0, shadowrimcolor);
	    c.drawCircle(108, 108, 100, p);
	    p.clearShadowLayer();
	    p.setStrokeWidth(3.75f);
	    
	    Bitmap bmSecResult=null;
	    if(showSecHand)
		{
	    	p.setColor(seccolor);
			int secAngle = rightNow.get(Calendar.SECOND) * 360 / 60;
			bmSecResult = Bitmap.createBitmap(bmpSecTemp.getWidth(), bmpSecTemp.getHeight(), Config.ARGB_8888);
			Canvas tempCanvas = new Canvas(bmSecResult);
			tempCanvas.rotate(secAngle-90, bmpSecTemp.getWidth()/2, bmpSecTemp.getHeight()/2);
			p.setShadowLayer(shadowsecradius, 0, 0, shadowseccolor);
			p.setStrokeWidth(2.4f);
			tempCanvas.drawLine(97, 108, 195, 108, p);
			p.setStrokeWidth(3.75f);
			p.clearShadowLayer();
			tempCanvas.drawBitmap(bmpSecTemp, 0, 0, p);
		}
	    
	    p.setColor(mincolor);
	    int minAngle = rightNow.get(Calendar.MINUTE) * 360/60;
		Bitmap bmMinResult = Bitmap.createBitmap(bmpMinTemp.getWidth(), bmpMinTemp.getHeight(), Config.ARGB_8888);
		Canvas MinCanvas = new Canvas(bmMinResult);
		MinCanvas.rotate(minAngle-90, bmpMinTemp.getWidth()/2, bmpMinTemp.getHeight()/2);
		p.setShadowLayer(shadowminradius, 0, 0, shadowmincolor);
		MinCanvas.drawLine(97, 108, 196, 108, p);
		p.clearShadowLayer();
		MinCanvas.drawBitmap(bmpMinTemp, 0, 0, p);
		
		p.setColor(hourcolor);
		float hourAngle = rightNow.get(Calendar.HOUR)*30 + rightNow.get(Calendar.MINUTE) * 0.5f;
		Bitmap bmHourResult = Bitmap.createBitmap(bmpHourTemp.getWidth(), bmpHourTemp.getHeight(), Config.ARGB_8888);
		Canvas HourCanvas = new Canvas(bmHourResult);
		HourCanvas.rotate(hourAngle-90, 108, 108);
		p.setShadowLayer(shadowhourradius, 0, 0, shadowhourcolor);
		HourCanvas.drawLine(97, 108, 153, 108, p);
		p.clearShadowLayer();
		HourCanvas.drawBitmap(bmpHourTemp, 0, 0, p);
		
		Bitmap bmOverlay = Bitmap.createBitmap(216, 216, Config.ARGB_8888);
		
		Canvas canvas = new Canvas();
	    canvas.setBitmap(bmOverlay);
	    
	    canvas.drawBitmap(bmpTemp, new Matrix(), p);
	    canvas.drawBitmap(bmHourResult, new Matrix(), p);
	    canvas.drawBitmap(bmMinResult, new Matrix(), p);
	    
	    if(showSecHand)
		{
			canvas.drawBitmap(bmSecResult, new Matrix(), p);
		}
	    
		views.setImageViewBitmap(R.id.widget_imageview, bmOverlay);
		
	    return views;
	}
	
	public void onAppWidgetOptionsChanged (Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions)
	{
		Log.d("SuperNexusClock", "onAppWidgetOptionsChanged");
		int minwidth = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH);
		int maxwidth = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH);
		int minheight = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT);
		int maxheight = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT);
		Log.d("SuperNexusClock", "min width:"+minwidth);
		Log.d("SuperNexusClock", "max width:"+maxwidth);
		Log.d("SuperNexusClock", "min height:"+minheight);
		Log.d("SuperNexusClock", "max height:"+maxheight);
	}
	
	public void onUpdate(Context context,
	           AppWidgetManager appWidgetManager, int[] appWidgetIds)
	   {
	    // lets copy our stuff
	    mAppWidgetIds = new int[appWidgetIds.length];
	    for (int a = 0; a < appWidgetIds.length; a++)
	     mAppWidgetIds[a] = appWidgetIds[a];
	    widgetManager = appWidgetManager;
	    
	    RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget);
	    
		for(int appWidgetId : mAppWidgetIds)
		{
			widgetManager.updateAppWidget(appWidgetId, views);
		}
	   }
	
	private PendingIntent createClockTickIntent(Context context)
	{
		Intent intent = new Intent(WIDGET_UPDATE);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		return pendingIntent;
	}
	
	@Override
	public void onEnabled(final Context context)
	{
		super.onEnabled(context);
		
		AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.SECOND, 1);
		
		alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()+1000, 1000, createClockTickIntent(context));
	}
	
	@Override
	public void onDisabled(Context context)
	{
		super.onDisabled(context);
		AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		alarmManager.cancel(createClockTickIntent(context));
	}

}
