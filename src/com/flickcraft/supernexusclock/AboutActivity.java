package com.flickcraft.supernexusclock;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.TextView;

public class AboutActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.about_activity2);
		
		TextView mTextView = (TextView)findViewById(R.id.license_text);
		String license = "The mColorPicker was created by Daniel Nilsson and is licensed under Apache License 2.0, which can be read at ";
		String link = "<a href=\"http://www.apache.org/licenses/LICENSE-2.0\">http://www.apache.org/licenses/LICENSE-2.0</a>";
		mTextView.setText(Html.fromHtml(license + link));
		mTextView.setMovementMethod(LinkMovementMethod.getInstance());
		
		String This = "This ";
		String amazing = "<font color='#2b79c2'>amazing</font>";
		String created = " widget was created by flick";
		String c = "<font color='#00aeb7'>c</font>";
		String r = "<font color='#ff9900'>r</font>";
		String a = "<font color='#ba0000'>a</font>";
		String f = "<font color='#4db500'>f</font>";
		String t = "<font color='#267dc0'>t</font>";
		String chd = " at their Chandigarh HQ.";
		Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/HammersmithOne.ttf");
		TextView tv = (TextView)findViewById(R.id.about_text);
		
		switch(getResources().getDisplayMetrics().densityDpi)
		{
			case DisplayMetrics.DENSITY_LOW:
				tv.setTextSize(26);
				break;
			case DisplayMetrics.DENSITY_MEDIUM:
				tv.setTextSize(30);
				break;
		}
		
		tv.setText(Html.fromHtml(This+amazing+created+c+r+a+f+t+chd));
		tv.setTypeface(typeface);
	}
}
