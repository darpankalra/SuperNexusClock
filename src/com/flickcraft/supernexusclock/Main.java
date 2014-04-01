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

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class Main extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
	setContentView(R.layout.installed_activity2);
		
		TextView tv1=(TextView)findViewById(R.id.installed_text);
		TextView tv2=(TextView)findViewById(R.id.installed_text2);
		Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/HammersmithOne.ttf");
		
		int size=42;
		switch(getResources().getDisplayMetrics().densityDpi)
		{
			case DisplayMetrics.DENSITY_LOW:
				tv1.setTextSize(26);
				tv2.setTextSize(26);
				size=34;
				break;
			case DisplayMetrics.DENSITY_MEDIUM:
				tv1.setTextSize(30);
				tv2.setTextSize(30);
				size=38;
				break;
		}
		
		String The = "The";
		String amazing =" Super Nexus Clock Widget";
		String is = " is";
		String installed = " now installed.";
		
		tv1.setText(The+amazing+is+installed, BufferType.SPANNABLE);
		Spannable s = (Spannable)tv1.getText();
		int start = The.length();
		int end = start + amazing.length();
		
		s.setSpan(new ForegroundColorSpan(0xFF2b79cf), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		s.setSpan(new AbsoluteSizeSpan(size,true), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		start=end+is.length();
		end=start+installed.length();
		s.setSpan(new AbsoluteSizeSpan(size,true), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		tv2.setText("Please select it from the widgets view.");
		
		tv1.setTypeface(typeface);
		tv2.setTypeface(typeface);
	}
}