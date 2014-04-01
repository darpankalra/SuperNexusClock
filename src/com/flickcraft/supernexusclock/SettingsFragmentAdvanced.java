package com.flickcraft.supernexusclock;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceFragment;

@SuppressLint("NewApi")
public class SettingsFragmentAdvanced extends PreferenceFragment {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences_advanced);
        ((ClockWidgetConfigActivityAdvanced)this.getActivity()).mRimActivityPreference = this.findPreference("pref_rimcoloractivity");
        ((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowRimActivityPreference = this.findPreference("pref_shadowrimcoloractivity");
        ((ClockWidgetConfigActivityAdvanced)this.getActivity()).mSecActivityPreference = this.findPreference("pref_seccoloractivity");
        ((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowSecActivityPreference = this.findPreference("pref_shadowseccoloractivity");
        ((ClockWidgetConfigActivityAdvanced)this.getActivity()).mMinActivityPreference = this.findPreference("pref_mincoloractivity");
        ((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowMinActivityPreference = this.findPreference("pref_shadowmincoloractivity");
        ((ClockWidgetConfigActivityAdvanced)this.getActivity()).mHourActivityPreference = this.findPreference("pref_hourcoloractivity");
        ((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowHourActivityPreference = this.findPreference("pref_shadowhourcoloractivity");
        ((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowSecDialogPreference = this.findPreference("pref_shadowsecradius");
        ((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowMinDialogPreference = this.findPreference("pref_shadowminradius");
        ((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowHourDialogPreference = this.findPreference("pref_shadowhourradius");
        ((ClockWidgetConfigActivityAdvanced)this.getActivity()).mSeparateColors = (CheckBoxPreference)this.findPreference("separate_colors");
        
        if(((ClockWidgetConfigActivityAdvanced)this.getActivity()).mRimActivityPreference!=null)
    		((ClockWidgetConfigActivityAdvanced)this.getActivity()).mRimActivityPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivityAdvanced)this.getActivity()));
        
        if(((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowRimActivityPreference!=null)
    		((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowRimActivityPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivityAdvanced)this.getActivity()));
        
        if(((ClockWidgetConfigActivityAdvanced)this.getActivity()).mSecActivityPreference!=null)
    		((ClockWidgetConfigActivityAdvanced)this.getActivity()).mSecActivityPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivityAdvanced)this.getActivity()));
        
        if(((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowSecActivityPreference!=null)
    		((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowSecActivityPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivityAdvanced)this.getActivity()));
    	
        if(((ClockWidgetConfigActivityAdvanced)this.getActivity()).mMinActivityPreference!=null)
    		((ClockWidgetConfigActivityAdvanced)this.getActivity()).mMinActivityPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivityAdvanced)this.getActivity()));
        
        if(((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowMinActivityPreference!=null)
    		((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowMinActivityPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivityAdvanced)this.getActivity()));
    	
        if(((ClockWidgetConfigActivityAdvanced)this.getActivity()).mHourActivityPreference!=null)
    		((ClockWidgetConfigActivityAdvanced)this.getActivity()).mHourActivityPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivityAdvanced)this.getActivity()));
        
        if(((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowHourActivityPreference!=null)
    		((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowHourActivityPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivityAdvanced)this.getActivity()));
    	
    	if(((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowSecDialogPreference!=null)
    		((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowSecDialogPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivityAdvanced)this.getActivity()));
    	
    	if(((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowMinDialogPreference!=null)
    		((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowMinDialogPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivityAdvanced)this.getActivity()));
    	
    	if(((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowHourDialogPreference!=null)
    		((ClockWidgetConfigActivityAdvanced)this.getActivity()).mShadowHourDialogPreference.setOnPreferenceClickListener(((ClockWidgetConfigActivityAdvanced)this.getActivity()));
    	
    	if(((ClockWidgetConfigActivityAdvanced)this.getActivity()).mSeparateColors!=null)
    		((ClockWidgetConfigActivityAdvanced)this.getActivity()).mSeparateColors.setChecked(false);
    }
}
