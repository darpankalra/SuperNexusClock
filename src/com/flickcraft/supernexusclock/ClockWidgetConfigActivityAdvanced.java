package com.flickcraft.supernexusclock;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ClockWidgetConfigActivityAdvanced extends PreferenceActivity implements
Preference.OnPreferenceClickListener {
	
	public Preference mRimActivityPreference;
	public Preference mShadowRimActivityPreference;
	public Preference mSecActivityPreference;
	public Preference mShadowSecActivityPreference;
	public Preference mMinActivityPreference;
	public Preference mShadowMinActivityPreference;
	public Preference mHourActivityPreference;
	public Preference mShadowHourActivityPreference;
	public Preference mShadowSecDialogPreference;
	public Preference mShadowMinDialogPreference;
	public Preference mShadowHourDialogPreference;
	public CheckBoxPreference mSeparateColors;
	
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE2 = 1001;
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE3 = 1002;
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE4 = 1003;
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE5 = 1005;
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE6 = 1006;
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE7 = 1007;
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE8 = 1008;
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE9 = 1009;
	
	@SuppressLint("NewApi")
	@Override
    public void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
        
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if(currentapiVersion >= Build.VERSION_CODES.HONEYCOMB_MR1)
        {
        	final SettingsFragmentAdvanced sfa = new SettingsFragmentAdvanced();
        	final FragmentManager sfManager = getFragmentManager();
        	
//        	new Thread(new Runnable() {
//    	        public void run() {
    	        	
    	        	sfManager.beginTransaction()
    	            .replace(R.id.frag, sfa)
    	            .commit();
    	        	
    	        	
/*    	        	new Thread(new Runnable() {
    	    	        public void run() {
        	
    	    mShadowRimActivityPreference = sfa.findPreference("pref_shadowrimcoloractivity");
        	mShadowSecActivityPreference = sfa.findPreference("pref_shadowseccoloractivity");
        	mShadowMinActivityPreference = sfa.findPreference("pref_shadowmincoloractivity");
        	mShadowHourActivityPreference = sfa.findPreference("pref_shadowhourcoloractivity");
        	mShadowRimDialogPreference = sfa.findPreference("pref_shadowrimradius");
        	mShadowSecDialogPreference = sfa.findPreference("pref_shadowsecradius");
        	mShadowMinDialogPreference = sfa.findPreference("pref_shadowminradius");
        	mShadowHourDialogPreference = sfa.findPreference("pref_shadowhourradius");
        	
        	if(mShadowRimActivityPreference!=null)
    			mShadowRimActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
        	
        	if(mShadowSecActivityPreference!=null)
    			mShadowSecActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
        	
        	if(mShadowMinActivityPreference!=null)
    			mShadowMinActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
        	
        	if(mShadowHourActivityPreference!=null)
    			mShadowHourActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
        	
        	if(mShadowRimDialogPreference!=null)
    			mShadowRimDialogPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
        	
        	if(mShadowSecDialogPreference!=null)
    			mShadowSecDialogPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
        	
        	if(mShadowMinDialogPreference!=null)
    			mShadowMinDialogPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
        	
        	if(mShadowHourDialogPreference!=null)
    			mShadowHourDialogPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
    	        }
    	    }).start();*/
//        	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        	setContentView(R.layout.activity_main2);
        	new Thread(new Runnable() {
    	        public void run() {
    	        	PreferenceManager.setDefaultValues(ClockWidgetConfigActivityAdvanced.this, R.xml.preferences_advanced, true);
    	        	
//    	        	SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
    	        }
    	    }).start();
        }
        else
        {
        	new Thread(new Runnable() {
    	        public void run() {
		        	addPreferencesFromResource(R.xml.preferences_advanced);
		        	mRimActivityPreference = findPreference("pref_rimcoloractivity");
		        	mShadowRimActivityPreference = findPreference("pref_shadowrimcoloractivity");
		        	mSecActivityPreference = findPreference("pref_seccoloractivity");
		        	mShadowSecActivityPreference = findPreference("pref_shadowseccoloractivity");
		        	mMinActivityPreference = findPreference("pref_mincoloractivity");
		        	mShadowMinActivityPreference = findPreference("pref_shadowmincoloractivity");
		        	mHourActivityPreference = findPreference("pref_hourcoloractivity");
		        	mShadowHourActivityPreference = findPreference("pref_shadowhourcoloractivity");
		        	mShadowSecDialogPreference = findPreference("pref_shadowsecradius");
		        	mShadowMinDialogPreference = findPreference("pref_shadowminradius");
		        	mShadowHourDialogPreference = findPreference("pref_shadowhourradius");
		        	mSeparateColors = (CheckBoxPreference)findPreference("separate_colors");
		        	
		        	if(mRimActivityPreference!=null)
		    			mRimActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
		        	
		        	if(mShadowRimActivityPreference!=null)
		    			mShadowRimActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
		        	
		        	if(mSecActivityPreference!=null)
		    			mSecActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
		        	
		        	if(mShadowSecActivityPreference!=null)
		    			mShadowSecActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
		        	
		        	if(mMinActivityPreference!=null)
		    			mMinActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
		        	
		        	if(mShadowMinActivityPreference!=null)
		    			mShadowMinActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
		        	
		        	if(mHourActivityPreference!=null)
		    			mHourActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
		        	
		        	if(mShadowHourActivityPreference!=null)
		    			mShadowHourActivityPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
		        	
		        	if(mShadowSecDialogPreference!=null)
		    			mShadowSecDialogPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
		        	
		        	if(mShadowMinDialogPreference!=null)
		    			mShadowMinDialogPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
		        	
		        	if(mShadowHourDialogPreference!=null)
		    			mShadowHourDialogPreference.setOnPreferenceClickListener(ClockWidgetConfigActivityAdvanced.this);
		        	
		        	if(mSeparateColors!=null)
		        		mSeparateColors.setChecked(false);
    	        }
    	    }).start();
        	
        	//edit
//        	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        	setContentView(R.layout.activity_main);
        	new Thread(new Runnable() {
    	        public void run() {
//    	        	PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
    	        	PreferenceManager.setDefaultValues(ClockWidgetConfigActivityAdvanced.this, R.xml.preferences_advanced, false);
    	        	
/*    	        	SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
    	    		SharedPreferences.Editor editor = settings.edit();
    	    		
    	    		String separate_colors = ClockWidgetConfigActivity.mAppWidgetId+"separate_colors";
    	    		editor.putBoolean(separate_colors,false);
    	    		editor.commit();*/
    	        }
    	    }).start();
        }
        
        Button ok=(Button)findViewById(R.id.okbutton);
        ok.setOnClickListener(mOnClickListener);
//        Log.d("SuperNexusClock", "i am here3");
        
        Button cancel=(Button)findViewById(R.id.cancelbutton);
        cancel.setOnClickListener(mOnClickListener2);
        
        
    }
	
	public void copyPreferences(final Context context)
	{
		new Thread(new Runnable() {
	        public void run() {
	        	SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
	    		SharedPreferences customsettings = getSharedPreferences(ClockWidgetConfigActivity.PREFS_NAME, 0);
	    		SharedPreferences.Editor editor = customsettings.edit();
	    		
/*	    		String sec_hand = mAppWidgetId+"sec_hand";
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
	    		
	    		String color = mAppWidgetId+"color";
	    		int color_value = settings.getInt("activity", 0xffFFFFFF);
	    		editor.putInt(color, color_value);*/
	    		
	    		String separate_colors = ClockWidgetConfigActivity.mAppWidgetId+"separate_colors";
	    		Boolean separate_colors_value = settings.getBoolean("separate_colors", false);
	    		editor.putBoolean(separate_colors, separate_colors_value);
	    		
	    		String shadow_rim = ClockWidgetConfigActivity.mAppWidgetId+"shadow_rim";
	    		Boolean shadow_rim_value = settings.getBoolean("shadow_rim", false);
	    		editor.putBoolean(shadow_rim, shadow_rim_value);
	    		
	    		String rimcolor = ClockWidgetConfigActivity.mAppWidgetId+"rimcolor";
	    		int rim_color_value = settings.getInt("rimcolor", 0xffFFFFFF);
	    		editor.putInt(rimcolor, rim_color_value);
	    		
	    		String shadowrimcolor = ClockWidgetConfigActivity.mAppWidgetId+"shadowrimcolor";
	    		int shadowrim_color_value = settings.getInt("shadowrimcolor", 0xff000000);
	    		editor.putInt(shadowrimcolor, shadowrim_color_value);
	    		
	    		String seccolor = ClockWidgetConfigActivity.mAppWidgetId+"seccolor";
	    		int sec_color_value = settings.getInt("seccolor", 0xffFFFFFF);
	    		editor.putInt(seccolor, sec_color_value);
	    		
	    		String shadowseccolor = ClockWidgetConfigActivity.mAppWidgetId+"shadowseccolor";
	    		int shadowsec_color_value = settings.getInt("shadowseccolor", 0xff000000);
	    		editor.putInt(shadowseccolor, shadowsec_color_value);
	    		
	    		String mincolor = ClockWidgetConfigActivity.mAppWidgetId+"mincolor";
	    		int min_color_value = settings.getInt("mincolor", 0xffFFFFFF);
	    		editor.putInt(mincolor, min_color_value);
	    		
	    		String shadowmincolor = ClockWidgetConfigActivity.mAppWidgetId+"shadowmincolor";
	    		int shadowmin_color_value = settings.getInt("shadowmincolor", 0xff000000);
	    		editor.putInt(shadowmincolor, shadowmin_color_value);
	    		
	    		String hourcolor = ClockWidgetConfigActivity.mAppWidgetId+"hourcolor";
	    		int hour_color_value = settings.getInt("hourcolor", 0xffFFFFFF);
	    		editor.putInt(hourcolor, hour_color_value);
	    		
	    		String shadowhourcolor = ClockWidgetConfigActivity.mAppWidgetId+"shadowhourcolor";
	    		int shadowhour_color_value = settings.getInt("shadowhourcolor", 0xff000000);
	    		editor.putInt(shadowhourcolor, shadowhour_color_value);
	    		
	    		String shadowsecradius = ClockWidgetConfigActivity.mAppWidgetId+"shadowsecradius";
	    		float shadowsec_radius_value = settings.getFloat("shadowsecradius", 5.0f);
	    		editor.putFloat(shadowsecradius, shadowsec_radius_value);
	    		
	    		String shadowminradius = ClockWidgetConfigActivity.mAppWidgetId+"shadowminradius";
	    		float shadowmin_radius_value = settings.getFloat("shadowminradius", 5.0f);
	    		editor.putFloat(shadowminradius, shadowmin_radius_value);
	    		
	    		String shadowhourradius = ClockWidgetConfigActivity.mAppWidgetId+"shadowhourradius";
	    		float shadowhour_radius_value = settings.getFloat("shadowhourradius", 5.0f);
	    		editor.putFloat(shadowhourradius, shadowhour_radius_value);
	    		
	    		editor.commit();
	        }
	    }).start();
	}
	
	View.OnClickListener mOnClickListener = new View.OnClickListener() {
		
		public void onClick(View v) {
			
			final Context context = ClockWidgetConfigActivityAdvanced.this;
			copyPreferences(context);	    	
	    	
			/*AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
	    	RemoteViews views = new RemoteViews(context.getPackageName(),
	    	R.layout.widget);
	    	appWidgetManager.updateAppWidget(mAppWidgetId, views);
	    	Intent resultValue = new Intent();
	    	resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
	    	setResult(RESULT_OK, resultValue);*/
			
	    	ClockWidgetConfigActivityAdvanced.this.finish();
		}
	}; 
	
	View.OnClickListener mOnClickListener2 = new View.OnClickListener() {	
		public void onClick(View v) {
	    	finish();
		}
	};
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == ACTIVITY_COLOR_PICKER_REQUEST_CODE6 && resultCode == Activity.RESULT_OK) {

			SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
			SharedPreferences.Editor editor = customSharedPreference.edit();
			editor.putInt("rimcolor", data.getIntExtra(
			ColorPickerActivity.RESULT_COLOR, 0xffFFFFFF));
			editor.commit();

		}
		else if (requestCode == ACTIVITY_COLOR_PICKER_REQUEST_CODE5 && resultCode == Activity.RESULT_OK) {

			SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
			SharedPreferences.Editor editor = customSharedPreference.edit();
			editor.putInt("shadowrimcolor", data.getIntExtra(
			ColorPickerActivity.RESULT_COLOR, 0xff000000));
			editor.commit();

		}
		else if (requestCode == ACTIVITY_COLOR_PICKER_REQUEST_CODE7 && resultCode == Activity.RESULT_OK) {

			SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
			SharedPreferences.Editor editor = customSharedPreference.edit();
			editor.putInt("seccolor", data.getIntExtra(
			ColorPickerActivity.RESULT_COLOR, 0xffFFFFFF));
			editor.commit();

		}
		else if (requestCode == ACTIVITY_COLOR_PICKER_REQUEST_CODE2 && resultCode == Activity.RESULT_OK) {

			SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
			SharedPreferences.Editor editor = customSharedPreference.edit();
			editor.putInt("shadowseccolor", data.getIntExtra(
			ColorPickerActivity.RESULT_COLOR, 0xff000000));
			editor.commit();

		}
		else if (requestCode == ACTIVITY_COLOR_PICKER_REQUEST_CODE8 && resultCode == Activity.RESULT_OK) {

			SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
			SharedPreferences.Editor editor = customSharedPreference.edit();
			editor.putInt("mincolor", data.getIntExtra(
			ColorPickerActivity.RESULT_COLOR, 0xffFFFFFF));
			editor.commit();

		}
		else if (requestCode == ACTIVITY_COLOR_PICKER_REQUEST_CODE3 && resultCode == Activity.RESULT_OK) {

			SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
			SharedPreferences.Editor editor = customSharedPreference.edit();
			editor.putInt("shadowmincolor", data.getIntExtra(
			ColorPickerActivity.RESULT_COLOR, 0xff000000));
			editor.commit();

		}
		else if (requestCode == ACTIVITY_COLOR_PICKER_REQUEST_CODE9 && resultCode == Activity.RESULT_OK) {

			SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
			SharedPreferences.Editor editor = customSharedPreference.edit();
			editor.putInt("hourcolor", data.getIntExtra(
			ColorPickerActivity.RESULT_COLOR, 0xffFFFFFF));
			editor.commit();

		}
		else if (requestCode == ACTIVITY_COLOR_PICKER_REQUEST_CODE4 && resultCode == Activity.RESULT_OK) {

			SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
			SharedPreferences.Editor editor = customSharedPreference.edit();
			editor.putInt("shadowhourcolor", data.getIntExtra(
			ColorPickerActivity.RESULT_COLOR, 0xff000000));
			editor.commit();

		}
	}
	
	@Override
	public boolean onPreferenceClick(Preference preference) {
		// TODO Auto-generated method stub
		final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
		String key = preference.getKey();
		if (key.equals("pref_rimcoloractivity")) {

			Intent i = new Intent(this, ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, prefs.getInt("rimcolor", 0xffFFFFFF));
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE6);

			return true;
		}
		else if (key.equals("pref_shadowrimcoloractivity")) {

			Intent i = new Intent(this, ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, 0xff888888);
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE5);

			return true;
		}
		else if (key.equals("pref_seccoloractivity")) {

			Intent i = new Intent(this, ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, prefs.getInt("seccolor", 0xffFFFFFF));
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE7);

			return true;
		}
		else if (key.equals("pref_shadowseccoloractivity")) {

			Intent i = new Intent(this, ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, 0xff888888);
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE2);

			return true;
		}
		else if (key.equals("pref_mincoloractivity")) {

			Intent i = new Intent(this, ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, prefs.getInt("mincolor", 0xffFFFFFF));
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE8);

			return true;
		}
		else if (key.equals("pref_shadowmincoloractivity")) {

			Intent i = new Intent(this, ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, 0xff777777);
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE3);

			return true;
		}
		else if (key.equals("pref_hourcoloractivity")) {

			Intent i = new Intent(this, ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, prefs.getInt("hourcolor", 0xffFFFFFF));
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE9);

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
							SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
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
							SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
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
							SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(ClockWidgetConfigActivityAdvanced.this);
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
		}
		return false;
	}
}
