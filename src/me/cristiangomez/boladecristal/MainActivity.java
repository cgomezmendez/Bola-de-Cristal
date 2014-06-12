package me.cristiangomez.boladecristal;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private CrystalBall mCrystalBall = new CrystalBall();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Declare View variables and assign them the views from layout
		final TextView responseLabel = (TextView) findViewById(R.id.responseLabel);
		final Button getResponseButton = (Button) findViewById(R.id.getResponseButton);
		getResponseButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View getResponseButtonView) {
				// The button was clicked so we updated the responseLabel with
				// an response
				String response = "";
				response = mCrystalBall.getAnswer();
				responseLabel.setText(response);
				animateCrystalBall();
			}
		});
	}
	
	private void animateCrystalBall() {
		ImageView crystallBallImage = (ImageView) findViewById(R.id.imageView1);
		crystallBallImage.setImageResource(R.drawable.ball_animation);
		AnimationDrawable ballAnimation =  (AnimationDrawable) crystallBallImage.getDrawable();
		if (ballAnimation.isRunning()){
			ballAnimation.stop();
		}
		ballAnimation.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
