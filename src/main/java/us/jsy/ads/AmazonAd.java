package us.jsy.ads;

import android.app.Activity;
import android.util.Log;
//import android.app.ActionBar.LayoutParams;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdTargetingOptions;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.customevent.CustomEventBanner;
import com.google.ads.mediation.customevent.CustomEventBannerListener;

//import com.google.


public class AmazonAd implements CustomEventBanner {
    AdLayout adLayout;

    private AdLayout getAdLayout(Activity activity) {
        if (adLayout == null) {
            adLayout = new AdLayout(activity, com.amazon.device.ads.AdSize.SIZE_320x50);

            LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
            adLayout.setLayoutParams(layoutParams);
        }

        return adLayout;
    }

    @Override
    public void destroy() {
        // Clean up custom event variables.
        if (adLayout != null) {
            adLayout.destroy();
            adLayout = null;
        }
    }

	@Override
	public void requestBannerAd(final CustomEventBannerListener listener,
			final Activity activity, String label, String serverParameter,
			AdSize adSize, MediationAdRequest request, Object customEventExtra) {
//		serverParameter = "3789793d6b13462ca76e93dfce6c6d2f";
		Log.d(this.getClass().getSimpleName(), "appKey " + serverParameter);
		AdRegistration.setAppKey(serverParameter);
		AdRegistration.enableTesting(false);
		AdRegistration.enableLogging(true);

        final AdLayout adLayout = getAdLayout(activity);
		
		adLayout.setListener(new AdListener() {			
			@Override
			public void onAdLoaded(AdLayout arg0, AdProperties arg1) {
				listener.onReceivedAd(adLayout);
			}
			
			@Override
			public void onAdFailedToLoad(AdLayout arg0, AdError err) {
				listener.onFailedToReceiveAd();
				Log.e(AmazonAd.this.getClass().getSimpleName(), err.getMessage());
			}
			
			@Override
			public void onAdExpanded(AdLayout arg0) {
				// TODO Auto-generated method stub
				listener.onClick();
			}
			
			@Override
			public void onAdCollapsed(AdLayout arg0) {
				// TODO Auto-generated method stub
				listener.onDismissScreen();
			}
		});
		
		AdTargetingOptions adOptions = new AdTargetingOptions();
//		adOptions.
		adLayout.loadAd(adOptions);
        
//		ImageView imageView = new ImageView(activity);
//		imageView.setImageResource(R.drawable.icon);
//		imageView.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				try {
//					listener.onClick();
//					listener.onPresentScreen();
//					listener.onLeaveApplication();
//					Intent intent = new Intent(Intent.ACTION_VIEW, Uri
//							.parse("market://details?id=com.labpixies.flood"));
//					activity.startActivity(intent);
//				} catch (Throwable t) {
//					// Something went wrong, oh well.
//				}
//			}
//		});
		
//		if (++i % 2 == 0)
//			listener.onReceivedAd(imageView);
//		else
//			listener.onFailedToReceiveAd();
		/*
		 * This custom event will always succeed, so we haven't called the
		 * onFailedToReceiveAd method
		 */
	}

}