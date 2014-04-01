package com.flickcraft.supernexusclock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Share extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
           
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

            intent.putExtra(Intent.EXTRA_TEXT,
                            getResources().getString(R.string.app_link));

            startActivity(Intent.createChooser(intent,
                            "How do you want to share?"));
           
            finish();
    }
}
