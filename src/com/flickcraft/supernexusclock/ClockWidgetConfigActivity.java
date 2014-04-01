/*
 * Copyright (C) 2010 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//Darpan Kalra on behalf of Flickcraft has modified the Main.java file as given under the license

package com.flickcraft.supernexusclock;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

@SuppressLint("NewApi")
public class ClockWidgetConfigActivity extends PreferenceActivity implements
Preference.OnPreferenceClickListener {

	static int mAppWidgetId;
	public static final String PREFS_NAME = "MyPrefsFile";
	public Preference mActivityPreference;
/*	public Preference mShadowSecActivityPreference;
	public Preference mShadowMinActivityPreference;
	public Preference mShadowHourActivityPreference;
	public Preference mShadowSecDialogPreference;
	public Preference mShadowMinDialogPreference;
	public Preference mShadowHourDialogPreference;*/
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE = 1000;
/*	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE2 = 1001;
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE3 = 1002;
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE4 = 1003;*/
    @SuppressLint("NewApi")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if(currentapiVersion >= Build.VERSION_CODES.HONEYCOMB_MR1)
        {
//        	SettingsFragment sf = (SettingsFragment)find;
        	final SettingsFragment sf = new SettingsFragment();
        	final FragmentManager sfManager = getFragmentManager();
        	
//        	new Thread(new Runnable() {
//    	        public void run() {
    	        	
    	        	sfManager.beginTransaction()
    	            .replace(R.id.frag, sf)
    	            .commit();
//    	        }
//    	    }).start();
        	setContentView(R.layout.activity_main2);
        	new Thread(new Runnable() {
    	        public void run() {
    	        	PreferenceManager.setDefaultValues(ClockWidgetConfigActivity.this, R.xml.preferences, false);
 
    	        	SharedPreferences customsettings = getSharedPreferences(PREFS_NAME, 0);
    	    		SharedPreferences.Editor editor = customsettings.edit();
    	    		
    	    		String separate_colors = mAppWidgetId+"separate_colors";
    	    		editor.putBoolean(separate_colors,false);
    	    		editor.commit();
    	        }
    	    }).start();
        }
        else
        {
        	new Thread(new Runnable() {
    	        public void run() {
		        	addPreferencesFromResource(R.xml.preferences);
		        	mActivityPreference = findPreference("pref_coloractivity");
		        	/*mShadowSecActivityPreference = findPreference("pref_shadowseccoloractivity");
		        	mShadowMinActivityPreference = findPreference("pref_shadowmincoloractivity");
		        	mShadowHourActivityPreference = findPreference("pref_shadowhourcoloractivity");
		        	mShadowSecDialogPreference = findPreference("pref_shadowsecradius");
		        	mShadowMinDialogPreference = findPreference("pref_shadowminradius");
		        	mShadowHourDialogPreference = findPreference("pref_shadowhourradius");*/
		        	
		        	if(mActivityPreference!=null)
		    			mActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);
		        	
		        	/*if(mShadowSecActivityPreference!=null)
		    			mShadowSecActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);
		        	
		        	if(mShadowMinActivityPreference!=null)
		    			mShadowMinActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);
		        	
		        	if(mShadowHourActivityPreference!=null)
		    			mShadowHourActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);
		        	
		        	if(mShadowSecDialogPreference!=null)
		    			mShadowSecDialogPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);
		        	
		        	if(mShadowMinDialogPreference!=null)
		    			mShadowMinDialogPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);
		        	
		        	if(mShadowHourDialogPreference!=null)
		    			mShadowHourDialogPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);*/
    	        }
    	    }).start();
        	setContentView(R.layout.activity_main);
        	new Thread(new Runnable() {
    	        public void run() {
    	        	PreferenceManager.setDefaultValues(ClockWidgetConfigActivity.this, R.xml.preferences, false);
    	        	SharedPreferences customsettings = getSharedPreferences(PREFS_NAME, 0);
    	    		SharedPreferences.Editor editor = customsettings.edit();
    	    		
    	    		String separate_colors = mAppWidgetId+"separate_colors";
    	    		editor.putBoolean(separate_colors,false);
    	    		editor.commit();
    	        }
    	    }).start();
        }
        
/*        new Thread(new Runnable() {
	        public void run() {
	        	mActivityPreference = findPreference("pref_coloractivity");
	    		if(mActivityPreference!=null)
	    			mActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);
	    		
	    		mShadowSecActivityPreference = findPreference("pref_shadowseccoloractivity");
	    		if(mShadowSecActivityPreference!=null)
	    			mShadowSecActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);
	    		
	    		mShadowMinActivityPreference = findPreference("pref_shadowmincoloractivity");
	    		if(mShadowMinActivityPreference!=null)
	    			mShadowMinActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);
	    		
	    		mShadowHourActivityPreference = findPreference("pref_shadowhourcoloractivity");
	    		if(mShadowHourActivityPreference!=null)
	    			mShadowHourActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);
	    		
	    		mShadowSecDialogPreference = findPreference("pref_shadowsecradius");
	    		if(mShadowSecDialogPreference!=null)
	    			mShadowSecDialogPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);
	    		
	    		mShadowMinDialogPreference = findPreference("pref_shadowminradius");
	    		if(mShadowMinDialogPreference!=null)
	    			mShadowMinDialogPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);
	    		
	    		mShadowHourDialogPreference = findPreference("pref_shadowhourradius");
	    		if(mShadowHourDialogPreference!=null)
	    			mShadowHourDialogPreference.setOnPreferenceClickListener(ClockWidgetConfigActivity.this);
	        }
	    }).start();*/
//        Log.d("SuperNexusClock", "i am here");
//        setContentView(R.layout.activity_main);
        
/*        new Thread(new Runnable() {
	        public void run() {
	        	PreferenceManager.setDefaultValues(ClockWidgetConfigActivity.this, R.xml.preferences, false);
	        }
	    }).start();*/
//        Log.d("SuperNexusClock", "i am here2");
        
        Button ok=(Button)findViewById(R.id.okbutton);
        ok.setOnClickListener(mOnClickListener);
//        Log.d("SuperNexusClock", "i am here3");
        
        Button cancel=(Button)findViewById(R.id.cancelbutton);
        cancel.setOnClickListener(mOnClickListener2);
//        Log.d("SuperNexusClock", "i am here4");
        
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID, 
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }
//        Log.d("SuperNexusClock", "i am here5");
        
        if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
        }
        
 //       new Thread(new Runnable() {
//	        public void run() {
//	        }
//	    }).start();
        
//        Log.d("SuperNexusClock", "end of oncreate");
        
    }
    
    View.OnClickListener mOnClickListener = new View.OnClickListener() {
		
		public void onClick(View v) {
			
			final Context context = ClockWidgetConfigActivity.this;
			copyPreferences(context);	    	
	    	
			AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
	    	RemoteViews views = new RemoteViews(context.getPackageName(),
	    	R.layout.widget);
	    	appWidgetManager.updateAppWidget(mAppWidgetId, views);
	    	Intent resultValue = new Intent();
	    	resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
	    	setResult(RESULT_OK, resultValue);
			
	    	ClockWidgetConfigActivity.this.finish();
		}
	}; 
		View.OnClickListener mOnClickListener2 = new View.OnClickListener() {
		
		public void onClick(View v) {
	    	finish();
		}
	};
	public void copyPreferences(final Context context)
	{
		new Thread(new Runnable() {
	        public void run() {
	        	SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
	    		SharedPreferences customsettings = getSharedPreferences(PREFS_NAME, 0);
	    		SharedPreferences.Editor editor = customsettings.edit();
	    		
	    		String sec_hand = mAppWidgetId+"sec_hand";
	    		Boolean sec_hand_value = settings.getBoolean("sec_hand", true);
	    		editor.putBoolean(sec_hand, sec_hand_value);
	    		
	    		String setalarm_onclick = mAppWidgetId+"setalarm_onclick";
	    		Boolean setalarm_onclick_value = settings.getBoolean("setalarm_onclick", true);
	    		editor.putBoolean(setalarm_onclick, setalarm_onclick_value);
	    		
	    		if(setalarm_onclick_value)
	    		{
	    			RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
	    			Intent intent = new Intent(ClockWidget.SET_ALARM);
	    			PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
	    			views.setOnClickPendingIntent(R.id.widget_imageview, pendingIntent);
	    		}
	    		
	    		String separate_colors = mAppWidgetId+"separate_colors";
	    		Boolean separate_colors_value = customsettings.getBoolean(separate_colors, false);
	    		
	    		if(!separate_colors_value)
	    		{
	    			int color_value = settings.getInt("activity", 0xffFFFFFF);
	    			
	    			String rimcolor = ClockWidgetConfigActivity.mAppWidgetId+"rimcolor";
//		    		int rim_color_value = settings.getInt("activity", 0xffFFFFFF);
		    		editor.putInt(rimcolor, color_value);
		    		
		    		String seccolor = ClockWidgetConfigActivity.mAppWidgetId+"seccolor";
//		    		int sec_color_value = settings.getInt("activity", 0xffFFFFFF);
		    		editor.putInt(seccolor, color_value);
		    		
		    		String mincolor = ClockWidgetConfigActivity.mAppWidgetId+"mincolor";
//		    		int min_color_value = settings.getInt("activity", 0xffFFFFFF);
		    		editor.putInt(mincolor, color_value);
		    		
		    		String hourcolor = ClockWidgetConfigActivity.mAppWidgetId+"hourcolor";
//		    		int hour_color_value = settings.getInt("activity", 0xffFFFFFF);
		    		editor.putInt(hourcolor, color_value);
	    		}
	    		
/*	    		String color = mAppWidgetId+"color";
	    		int color_value = settings.getInt("activity", 0xffFFFFFF);
	    		editor.putInt(color, color_value);*/
	    		
/*	    		String shadowseccolor = mAppWidgetId+"shadowseccolor";
	    		int shadowsec_color_value = settings.getInt("shadowseccolor", 0xff000000);
	    		editor.putInt(shadowseccolor, shadowsec_color_value);
	    		
	    		String shadowmincolor = mAppWidgetId+"shadowmincolor";
	    		int shadowmin_color_value = settings.getInt("shadowmincolor", 0xff000000);
	    		editor.putInt(shadowmincolor, shadowmin_color_value);
	    		
	    		String shadowhourcolor = mAppWidgetId+"shadowhourcolor";
	    		int shadowhour_color_value = settings.getInt("shadowhourcolor", 0xff000000);
	    		editor.putInt(shadowhourcolor, shadowhour_color_value);
	    		
	    		String shadowsecradius = mAppWidgetId+"shadowsecradius";
	    		float shadowsec_radius_value = settings.getFloat("shadowsecradius", 7.0f);
	    		editor.putFloat(shadowsecradius, shadowsec_radius_value);
	    		
	    		String shadowminradius = mAppWidgetId+"shadowminradius";
	    		float shadowmin_radius_value = settings.getFloat("shadowminradius", 7.0f);
	    		editor.putFloat(shadowminradius, shadowmin_radius_value);
	    		
	    		String shadowhourradius = mAppWidgetId+"shadowhourradius";
	    		float shadowhour_radius_value = settings.getFloat("shadowhourradius", 7.0f);
	    		editor.putFloat(shadowhourradius, shadowhour_radius_value);*/
	    		
	    		editor.commit();
	        }
	    }).start();
	}

	@Override
	public boolean onPreferenceClick(Preference preference) {
		// TODO Auto-generated method stub
		final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivity.this);
		String key = preference.getKey();
		if (key.equals("pref_coloractivity")) {

			Intent i = new Intent(this, ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, prefs.getInt("activity", 0xffFFFFFF));
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE);

			return true;
		}
/*		else if (key.equals("pref_shadowseccoloractivity")) {

			Intent i = new Intent(this, ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, 0xff888888);
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE2);

			return true;
		}
		else if (key.equals("pref_shadowmincoloractivity")) {

			Intent i = new Intent(this, ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, 0xff777777);
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE3);

			return true;
		}
		else if (key.equals("pref_shadowhourcoloractivity")) {

			Intent i = new Intent(this, ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, 0xff777777);
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE4);

			return true;
		}
		else if (key.equals("pref_shadowsecradius")) {
			 LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			 View layout = inflater.inflate(R.layout.dialog_layout, (ViewGroup) findViewById(R.id.dialog_root));
			 final EditText ed = (EditText)layout.findViewById(R.id.blur_radius);
			 AlertDialog.Builder builder = new AlertDialog.Builder(this).setView(layout);
			 builder.setMessage("Enter Blur Radius for shadow of Second hand").
			 	setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						if(!ed.getText().equals("") && !ed.getText().toString().contains(",") && !ed.getText().toString().contains(" "))
						{
							float x=7.0f;
							try
						    {
						        x = Float.parseFloat(ed.getText().toString());
						    }
						    catch(NumberFormatException nFE)
						    {
						    }
							SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivity.this);
							SharedPreferences.Editor editor = customSharedPreference.edit();
							editor.putFloat("shadowsecradius", x);
							editor.commit();
						}
					}
				})
			 	.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});
			 AlertDialog alertDialog = builder.create();
			 alertDialog.show();
			 return true;
		}
		else if (key.equals("pref_shadowminradius")) {
			 LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			 View layout = inflater.inflate(R.layout.dialog_layout, (ViewGroup) findViewById(R.id.dialog_root));
			 final EditText ed = (EditText)layout.findViewById(R.id.blur_radius);
			 AlertDialog.Builder builder = new AlertDialog.Builder(this).setView(layout);
			 builder.setMessage("Enter Blur Radius for shadow of Minute hand").
			 	setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						if(!ed.getText().equals("") && !ed.getText().toString().contains(",") && !ed.getText().toString().contains(" "))
						{
							float x=7.0f;
							try
						    {
						        x = Float.parseFloat(ed.getText().toString());
						    }
						    catch(NumberFormatException nFE)
						    {
						    }
							SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivity.this);
							SharedPreferences.Editor editor = customSharedPreference.edit();
							editor.putFloat("shadowminradius", x);
							editor.commit();
						}
					}
				})
			 	.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});
			 AlertDialog alertDialog = builder.create();
			 alertDialog.show();
			 return true;
		}
		else if (key.equals("pref_shadowhourradius")) {
			 LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			 View layout = inflater.inflate(R.layout.dialog_layout, (ViewGroup) findViewById(R.id.dialog_root));
			 final EditText ed = (EditText)layout.findViewById(R.id.blur_radius);
			 AlertDialog.Builder builder = new AlertDialog.Builder(this).setView(layout);
			 builder.setMessage("Enter Blur Radius for shadow of Hour hand").
			 	setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						if(!ed.getText().equals("") && !ed.getText().toString().contains(",") && !ed.getText().toString().contains(" "))
						{
							float x=7.0f;
							try
						    {
						        x = Float.parseFloat(ed.getText().toString());
						    }
						    catch(NumberFormatException nFE)
						    {
						    }
							SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivity.this);
							SharedPreferences.Editor editor = customSharedPreference.edit();
							editor.putFloat("shadowhourradius", x);
							editor.commit();
						}
					}
				})
			 	.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});
			 AlertDialog alertDialog = builder.create();
			 alertDialog.show();
			 return true;
		}*/
		return false;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, final Intent data) {

		
		if (requestCode == ACTIVITY_COLOR_PICKER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
			
			new Thread(new Runnable() {
		        public void run() {
			SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivity.this);
			SharedPreferences.Editor editor = customSharedPreference.edit();
			editor.putInt("activity", data.getIntExtra(
			ColorPickerActivity.RESULT_COLOR, 0xff000000));
			editor.commit();
		        }
		    }).start();

		}
/*		else if (requestCode == ACTIVITY_COLOR_PICKER_REQUEST_CODE2 && resultCode == Activity.RESULT_OK) {

			SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivity.this);
			SharedPreferences.Editor editor = customSharedPreference.edit();
			editor.putInt("shadowseccolor", data.getIntExtra(
			ColorPickerActivity.RESULT_COLOR, 0xff000000));
			editor.commit();

		}
		else if (requestCode == ACTIVITY_COLOR_PICKER_REQUEST_CODE3 && resultCode == Activity.RESULT_OK) {

			SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivity.this);
			SharedPreferences.Editor editor = customSharedPreference.edit();
			editor.putInt("shadowmincolor", data.getIntExtra(
			ColorPickerActivity.RESULT_COLOR, 0xff000000));
			editor.commit();

		}
		else if (requestCode == ACTIVITY_COLOR_PICKER_REQUEST_CODE4 && resultCode == Activity.RESULT_OK) {

			SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivity.this);
			SharedPreferences.Editor editor = customSharedPreference.edit();
			editor.putInt("shadowhourcolor", data.getIntExtra(
			ColorPickerActivity.RESULT_COLOR, 0xff000000));
			editor.commit();

		}*/
	}
}
