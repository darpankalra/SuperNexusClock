package com.flickcraft.supernexusclock;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class RgbColorDialog extends Activity implements SeekBar.OnSeekBarChangeListener {
	
	int alphaProgress=255;
	int redProgress = 0;
	int greenProgress = 0;
	int blueProgress = 0;
	SeekBar alphaSeek;
	SeekBar redSeek;
	SeekBar greenSeek;
	SeekBar blueSeek;
	EditText eda;
	EditText edr;
	EditText edg;
	EditText edb;
	private ColorPanelView mRgbColorPanel;
	public final static String CHOSEN_COLOR = "chosencolor";
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.rgb_color_dialog);
		
		alphaSeek = (SeekBar)findViewById(R.id.alpha_color);
		redSeek = (SeekBar)findViewById(R.id.red_color);
		greenSeek = (SeekBar)findViewById(R.id.green_color);
		blueSeek = (SeekBar)findViewById(R.id.blue_color);
		eda = (EditText)findViewById(R.id.alpha_edit);
		edr = (EditText)findViewById(R.id.red_edit);
		edg = (EditText)findViewById(R.id.green_edit);
		edb = (EditText)findViewById(R.id.blue_edit);
		mRgbColorPanel = (ColorPanelView)findViewById(R.id.rgb_color_panel);
		
		Bundle b = getIntent().getExtras();
		
		int chosenColor = 0xff000000;

		if (b != null) {
			chosenColor = b.getInt(ColorPickerActivity.CURRENT_COLOR);
		}
		
/*		if(Integer.toHexString(chosenColor).substring(0, 2)!=null)
			alphaProgress = Integer.parseInt(Integer.toHexString(chosenColor).substring(0, 2), 16);
		if(Integer.toHexString(chosenColor).substring(2, 4)!=null)
			redProgress = Integer.parseInt(Integer.toHexString(chosenColor).substring(2, 4), 16);
		if(Integer.toHexString(chosenColor).substring(4, 6)!=null)
			greenProgress = Integer.parseInt(Integer.toHexString(chosenColor).substring(4, 6), 16);
		if((Integer.toHexString(chosenColor).substring(6, 8)!=null))
			blueProgress = Integer.parseInt(Integer.toHexString(chosenColor).substring(6, 8), 16);*/
		
		alphaProgress = Color.alpha(chosenColor);
		redProgress = Color.red(chosenColor);
		blueProgress = Color.blue(chosenColor);
		greenProgress = Color.green(chosenColor);
		
		eda.setText(String.valueOf(alphaProgress));
		edr.setText(String.valueOf(redProgress));
		edg.setText(String.valueOf(greenProgress));
		edb.setText(String.valueOf(blueProgress));
		
		mRgbColorPanel.setColor(chosenColor);
		
		alphaSeek.setProgress(alphaProgress);
		redSeek.setProgress(redProgress);
		greenSeek.setProgress(greenProgress);
		blueSeek.setProgress(blueProgress);
		
		alphaSeek.setOnSeekBarChangeListener(this);
		redSeek.setOnSeekBarChangeListener(this);
		greenSeek.setOnSeekBarChangeListener(this);
		blueSeek.setOnSeekBarChangeListener(this);
		
		eda.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				int i;
				if(s.toString().equals(""))
				{
//					eda.setText(""+0);
					i=0;
				}
				else
				{
					i=Integer.parseInt(s.toString());
					if(i>255)
					{
						i=255;
						eda.setText(""+255);
					}
					if(i<0)
						i=0;
				}
				alphaSeek.setOnSeekBarChangeListener(null);
				alphaSeek.setProgress(i);
				int chosencolora = Color.argb(i, redSeek.getProgress(), greenSeek.getProgress(), blueSeek.getProgress());
				mRgbColorPanel.setColor(chosencolora);
				alphaSeek.setOnSeekBarChangeListener(RgbColorDialog.this);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		edr.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				int i;
				if(s.toString().equals(""))
				{
//					edr.setText(""+0);
					i=0;
				}
				else
				{
					i=Integer.parseInt(s.toString());
					if(i>255)
					{
						i=255;
						edr.setText(""+255);
					}
					if(i<0)
						i=0;
				}
				redSeek.setOnSeekBarChangeListener(null);
				redSeek.setProgress(i);
				int chosencolorr = Color.argb(alphaSeek.getProgress(), i, greenSeek.getProgress(), blueSeek.getProgress());
				mRgbColorPanel.setColor(chosencolorr);
				redSeek.setOnSeekBarChangeListener(RgbColorDialog.this);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		edg.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				int i;
				if(s.toString().equals(""))
				{
//					edg.setText(""+0);
					i=0;
				}
				else
				{
					i=Integer.parseInt(s.toString());
					if(i>255)
					{
						i=255;
						edg.setText(""+255);
					}
					if(i<0)
						i=0;
				}
				greenSeek.setOnSeekBarChangeListener(null);
				greenSeek.setProgress(i);
				int chosencolorg = Color.argb(alphaSeek.getProgress(), redSeek.getProgress(), i, blueSeek.getProgress());
				mRgbColorPanel.setColor(chosencolorg);
				greenSeek.setOnSeekBarChangeListener(RgbColorDialog.this);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		edb.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				int i;
				if(s.toString().equals(""))
				{
//					edb.setText(""+0);
					i=0;
				}
				else
				{
					i=Integer.parseInt(s.toString());
					if(i>255)
					{
						i=255;
						edb.setText(""+255);
					}
					if(i<0)
						i=0;
				}
				blueSeek.setOnSeekBarChangeListener(null);
				blueSeek.setProgress(i);
				int chosencolorb = Color.argb(alphaSeek.getProgress(), redSeek.getProgress(), greenSeek.getProgress(), i);
				mRgbColorPanel.setColor(chosencolorb);
				blueSeek.setOnSeekBarChangeListener(RgbColorDialog.this);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button ok = (Button)findViewById(R.id.ok_button);
		Button cancel = (Button)findViewById(R.id.cancel_button);
		
		ok.setOnClickListener(okButton);
		cancel.setOnClickListener(cancelButton);
	}

	View.OnClickListener okButton = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
//			int chosencolor = (int)Long.parseLong((Integer.toHexString(alphaProgress)+Integer.toHexString(redSeek.getProgress())
//					+Integer.toHexString(greenSeek.getProgress())+Integer.toHexString(blueSeek.getProgress())), 16);
			int chosencolor = Color.argb(alphaSeek.getProgress(), redSeek.getProgress(), greenSeek.getProgress(), blueSeek.getProgress());
			
//			Log.d("SuperNexusClock","sending color "+chosencolor);
/*			int chosencolor = redProgress;
//			chosencolor = (chosencolor << 8) + redProgress;
			chosencolor = (chosencolor << 8) + greenProgress;
			chosencolor = (chosencolor << 8) + blueProgress;*/
			
			Intent i = new Intent();
			i.putExtra(CHOSEN_COLOR, chosencolor);
			setResult(Activity.RESULT_OK, i);
			finish();
		}
	};
	
	View.OnClickListener cancelButton = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
		}
	};
	@Override
	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		switch (arg0.getId())
		{
			case R.id.alpha_color:
				eda.setText(String.valueOf(arg1));
				int chosencolora = Color.argb(alphaSeek.getProgress(), redSeek.getProgress(), greenSeek.getProgress(), blueSeek.getProgress());
				mRgbColorPanel.setColor(chosencolora);
				break;
			case R.id.red_color:
				edr.setText(String.valueOf(arg1));
				int chosencolorr = Color.argb(alphaSeek.getProgress(), redSeek.getProgress(), greenSeek.getProgress(), blueSeek.getProgress());
				mRgbColorPanel.setColor(chosencolorr);
				break;
			case R.id.green_color:
				edg.setText(String.valueOf(arg1));
				int chosencolorg = Color.argb(alphaSeek.getProgress(), redSeek.getProgress(), greenSeek.getProgress(), blueSeek.getProgress());
				mRgbColorPanel.setColor(chosencolorg);
				break;
			case R.id.blue_color:
				edb.setText(String.valueOf(arg1));
				int chosencolorb = Color.argb(alphaSeek.getProgress(), redSeek.getProgress(), greenSeek.getProgress(), blueSeek.getProgress());
				mRgbColorPanel.setColor(chosencolorb);
				break;
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
}
