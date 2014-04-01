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
package com.flickcraft.supernexusclock;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class ColorPickerActivity extends Activity implements
		View.OnClickListener {

	public final static String INTENT_DATA_INITIAL_COLOR = "color";
	public final static String RESULT_COLOR = "color";
	public final static String CURRENT_COLOR = "ccolor";

	private ColorPickerView mColorPickerView;
	private ColorPanelView mOldColorPanel;
	private ColorPanelView mNewColorPanel;

	private Button mCancelButton;
	private Button mOkButton;
	private ImageButton mRgbButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// To fight color branding.
		getWindow().setFormat(PixelFormat.RGBA_8888);

		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_color_picker);

		Bundle b = getIntent().getExtras();
		int initialColor = 0xff000000;

		if (b != null) {
			initialColor = b.getInt(INTENT_DATA_INITIAL_COLOR);
		}

		setUp(initialColor);

	}

	private void setUp(int color) {
		mColorPickerView = (ColorPickerView) findViewById(R.id.color_picker_view);
		mOldColorPanel = (ColorPanelView) findViewById(R.id.old_color_panel);
		mNewColorPanel = (ColorPanelView) findViewById(R.id.new_color_panel);
		mOkButton = (Button) findViewById(R.id.ok_button);
		mCancelButton = (Button) findViewById(R.id.cancel_button);
		mRgbButton = (ImageButton) findViewById(R.id.chooseRgb);
		
		((LinearLayout) mOldColorPanel.getParent()).setPadding(Math
				.round(mColorPickerView.getDrawingOffset()), 0, Math
				.round(mColorPickerView.getDrawingOffset()), 0);

		mColorPickerView
				.setOnColorChangedListener(new ColorPickerView.OnColorChangedListener() {

					@Override
					public void onColorChanged(int color) {
						mNewColorPanel.setColor(color);
					}
				});

		mOldColorPanel.setColor(color);
		mColorPickerView.setColor(color, true);
		mColorPickerView.setAlphaSliderVisible(true);
		mColorPickerView.setSliderTrackerColor(0xffCECECE);
		mColorPickerView.setBorderColor(0xff7E7E7E);
		mOldColorPanel.setBorderColor(mColorPickerView.getBorderColor());
		mNewColorPanel.setBorderColor(mColorPickerView.getBorderColor());

		mOkButton.setOnClickListener(this);
		mCancelButton.setOnClickListener(this);
		mRgbButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.ok_button:

			Intent i = new Intent();
			i.putExtra(RESULT_COLOR, mColorPickerView.getColor());

			setResult(Activity.RESULT_OK, i);
			finish();

			break;

		case R.id.cancel_button:

			setResult(Activity.RESULT_CANCELED);
			finish();

			break;
		case R.id.chooseRgb:
			Intent choosergb = new Intent(this, RgbColorDialog.class);
			choosergb.putExtra(CURRENT_COLOR, mColorPickerView.getColor());
			startActivityForResult(choosergb, 1004);
			break;
		}

	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		Log.d("SuperNexusClock","received color");
		if(requestCode == 1004 && resultCode == Activity.RESULT_OK)
		{
			Log.d("SuperNexusClock","received color2");
			mColorPickerView
			.setOnColorChangedListener(new ColorPickerView.OnColorChangedListener() {

				@Override
				public void onColorChanged(int color) {
					mNewColorPanel.setColor(color);
				}
			});
			Log.d("SuperNexusClock","received color3");
			int receivedColor = data.getIntExtra(RgbColorDialog.CHOSEN_COLOR, 0xff000000);
			Log.d("SuperNexusClock","received color4 "+receivedColor);
			mColorPickerView.setColor(receivedColor, true);
		}
	}
}
