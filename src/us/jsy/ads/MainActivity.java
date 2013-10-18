package us.jsy.ads;

import java.util.EnumSet;
import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.amazon.ags.api.AmazonGamesCallback;
import com.amazon.ags.api.AmazonGamesClient;
import com.amazon.ags.api.AmazonGamesFeature;
import com.amazon.ags.api.AmazonGamesStatus;
import com.amazon.ags.api.whispersync.GameDataMap;
import com.amazon.ags.api.whispersync.model.SyncableAccumulatingNumber;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		AmazonGamesCallback callback = new AmazonGamesCallback() {
			@Override
			public void onServiceNotReady(AmazonGamesStatus status) {
				// unable to use service
			}

			@Override
			public void onServiceReady(AmazonGamesClient amazonGamesClient) {
				// agsClient = amazonGamesClient;
				// ready to use GameCircle
			}
		};

//		// list of features your game uses (in this example, achievements and
//		// leaderboards)
//		EnumSet<AmazonGamesFeature> myGameFeatures = EnumSet
//				.of(AmazonGamesFeature.Whispersync);
//
//		AmazonGamesClient.initialize(this, callback, myGameFeatures);
//		final GameDataMap map = AmazonGamesClient.getWhispersyncClient()
//				.getGameData();
//		final SyncableAccumulatingNumber accumulatingNumber = map
//				.getAccumulatingNumber("https://voved.firebaseio.com/read/home");
//		accumulatingNumber.increment(1);
//		map.getLatestString("name").set("This is my very long string. sjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
//		final Set<String> latestStringKeys = map.getLatestStringKeys();
//		System.out.println("count: " + accumulatingNumber.asLong());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
