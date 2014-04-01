package com.flickcraft.supernexusclock;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;

@SuppressLint("NewApi")
public class SettingsFragment extends PreferenceFragment {
	
/*	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE = 1000;
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE2 = 1001;
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE3 = 1002;
	private final static int ACTIVITY_COLOR_PICKER_REQUEST_CODE4 = 1003;*/
	@Override
	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
        
/*        if(this.findPreference("pref_shadowseccoloractivity")==null)
        {
        	Log.d("SuperNexusClock", "null here also");
        }
        else
        {
        	Log.d("SuperNexusClock", "not null here");
        }*/
        ((ClockWidgetConfigActivity)this.getActivity()).mActivityPreference = this.findPreference("pref_coloractivity");
    /*    ((ClockWidgetConfigActivity)this.getActivity()).mShadowSecActivityPreference = this.findPreference("pref_shadowseccoloractivity");
        ((ClockWidgetConfigActivity)this.getActivity()).mShadowMinActivityPreference = this.findPreference("pref_shadowmincoloractivity");
        ((ClockWidgetConfigActivity)this.getActivity()).mShadowHourActivityPreference = this.findPreference("pref_shadowhourcoloractivity");
        ((ClockWidgetConfigActivity)this.getActivity()).mShadowSecDialogPreference = this.findPreference("pref_shadowsecradius");
        ((ClockWidgetConfigActivity)this.getActivity()).mShadowMinDialogPreference = this.findPreference("pref_shadowminradius");
        ((ClockWidgetConfigActivity)this.getActivity()).mShadowHourDialogPreference = this.findPreference("pref_shadowhourradius");*/
    	
        if(((ClockWidgetConfigActivity)this.getActivity()).mActivityPreference!=null)
    		((ClockWidgetConfigActivity)this.getActivity()).mActivityPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivity)this.getActivity()));
        
    /*    if(((ClockWidgetConfigActivity)this.getActivity()).mShadowSecActivityPreference!=null)
    		((ClockWidgetConfigActivity)this.getActivity()).mShadowSecActivityPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivity)this.getActivity()));
    	
    	if(((ClockWidgetConfigActivity)this.getActivity()).mShadowMinActivityPreference!=null)
    		((ClockWidgetConfigActivity)this.getActivity()).mShadowMinActivityPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivity)this.getActivity()));
    	
    	if(((ClockWidgetConfigActivity)this.getActivity()).mShadowHourActivityPreference!=null)
    		((ClockWidgetConfigActivity)this.getActivity()).mShadowHourActivityPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivity)this.getActivity()));
    	
    	if(((ClockWidgetConfigActivity)this.getActivity()).mShadowSecDialogPreference!=null)
    		((ClockWidgetConfigActivity)this.getActivity()).mShadowSecDialogPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivity)this.getActivity()));
    	
    	if(((ClockWidgetConfigActivity)this.getActivity()).mShadowMinDialogPreference!=null)
    		((ClockWidgetConfigActivity)this.getActivity()).mShadowMinDialogPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivity)this.getActivity()));
    	
    	if(((ClockWidgetConfigActivity)this.getActivity()).mShadowHourDialogPreference!=null)
    		((ClockWidgetConfigActivity)this.getActivity()).mShadowHourDialogPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivity)this.getActivity()));*/
    }
	
/*	public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference)
	{
		final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
		String key = preference.getKey();
		if (key.equals("pref_coloractivity")) {

			Intent i = new Intent(this.getActivity(), ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, prefs.getInt("activity", 0xffFFFFFF));
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE);

			return true;
		}
		else if (key.equals("pref_shadowseccoloractivity")) {

			Intent i = new Intent(this.getActivity(), ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, 0xff888888);
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE2);

			return true;
		}
		else if (key.equals("pref_shadowmincoloractivity")) {

			Intent i = new Intent(this.getActivity(), ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, 0xff777777);
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE3);

			return true;
		}
		else if (key.equals("pref_shadowhourcoloractivity")) {

			Intent i = new Intent(this.getActivity(), ColorPickerActivity.class);
			i.putExtra(ColorPickerActivity.INTENT_DATA_INITIAL_COLOR, 0xff777777);
			startActivityForResult(i, ACTIVITY_COLOR_PICKER_REQUEST_CODE4);

			return true;
		}
		else if (key.equals("pref_shadowsecradius")) {
			 LayoutInflater inflater = (LayoutInflater) this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			 View layout = inflater.inflate(R.layout.dialog_layout, (ViewGroup) this.getActivity().findViewById(R.id.dialog_root));
			 final EditText ed = (EditText)layout.findViewById(R.id.blur_radius);
			 AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity()).setView(layout);
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
							SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(SettingsFragment.this.getActivity());
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
			 LayoutInflater inflater = (LayoutInflater) this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			 View layout = inflater.inflate(R.layout.dialog_layout, (ViewGroup) this.getActivity().findViewById(R.id.dialog_root));
			 final EditText ed = (EditText)layout.findViewById(R.id.blur_radius);
			 AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity()).setView(layout);
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
							SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(SettingsFragment.this.getActivity());
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
			 LayoutInflater inflater = (LayoutInflater) this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			 View layout = inflater.inflate(R.layout.dialog_layout, (ViewGroup) this.getActivity().findViewById(R.id.dialog_root));
			 final EditText ed = (EditText)layout.findViewById(R.id.blur_radius);
			 AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity()).setView(layout);
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
							SharedPreferences customSharedPreference = PreferenceManager.getDefaultSharedPreferences(SettingsFragment.this.getActivity());
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
	}*/
}
