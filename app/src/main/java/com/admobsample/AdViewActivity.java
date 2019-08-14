package com.admobsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdViewActivity extends AppCompatActivity {

    @BindView(R.id.adView)
    AdView adView;

    AdRequest adRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_view);
        ButterKnife.bind(this);

        //create an ad request to call ads from google server
        adRequest = new AdRequest.Builder().build();

        //set adsize and adUnitId but only once eithe in xml or coding
       /* adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-7855716387239276/1976786371");*/

       //load ads
        adView.loadAd(adRequest);

    }

    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}
