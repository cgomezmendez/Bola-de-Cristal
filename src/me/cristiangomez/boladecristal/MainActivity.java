package me.cristiangomez.boladecristal;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private CrystalBall mCrystalBall = new CrystalBall();
	private TextView mResponseLabel;
	private Button mGetResponseButton;
	private ImageView mCrystallBallImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mCrystallBallImage = (ImageView) findViewById(R.id.imageView1);
		mResponseLabel = (TextView) findViewById(R.id.responseLabel);
		mGetResponseButton = (Button) findViewById(R.id.getResponseButton);
		mGetResponseButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View getResponseButtonView) {
				// The button was clicked so we updated the responseLabel with
				// an response
				String response = "";
				response = mCrystalBall.getAnswer();
				mResponseLabel.setText(response);
				playSound();
				animateCrystalBall();
				animateAnswer();
			}
		});
	}

	private void animateCrystalBall() {
		mCrystallBallImage.setImageResource(R.drawable.ball_animation);
		AnimationDrawable ballAnimation = (AnimationDrawable) mCrystallBallImage
				.getDrawable();
		if (ballAnimation.isRunning()) {
			ballAnimation.stop();
		}
		ballAnimation.start();
	}

	private void animateAnswer() {
		AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
		fadeInAnimation.setDuration(1500);
		fadeInAnimation.setFillAfter(true);
		mResponseLabel.setAnimation(fadeInAnimation);
	}

	private void playSound() {
		MediaPlayer player = MediaPlayer.create(this, R.raw.crystal_ball);
		player.start();
		player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				mp.release();

			}
		});
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
