## Google AdMob integration in native android

# This tutorial is going to walk yoo through the integration of Google’s monitization sdk or otherwise known as Google AdMob, into your native android application, which in-turn help you to generate revenue by publishing your application on Google Play Store.

So let’s get going.

# Setup
1.	Create account on AdMob’s  website if not created already. Go to the link below and follow the instructions. 
Link: https://admob.google.com/home/?gclid=Cj0KCQjw4s7qBRCzARIsAImcAxY00nLKpGVUP9fu4uayj9r8ntR29S_s7OSOF5htewllezBMyd5EqyIaAjUcEALw_wcB
2.	If already have an account then login and create a new application to connect your application to admob account. Go to link below and follow the instructions.
Link: https://apps.admob.com/v2/home?_ga=2.45170796.930457615.1565775324-2083913432.1563518114&_gac=1.223671657.1565775324.Cj0KCQjw4s7qBRCzARIsAImcAxY00nLKpGVUP9fu4uayj9r8ntR29S_s7OSOF5htewllezBMyd5EqyIaAjUcEALw_wcB&pli=1
Application Setup
1.	Click on GET STARTED button.
2.	Select yes/no based on if your apllication is already availabale on any of the mentioned app stores.
3.	Enter  the name of the application you want to create. 
4.	Select Android as the platform for your application.
5.	Next create AdUnit and  copy the App Id for fututre uses. 
6.	Select BANNER AD to display your first banner ad. 
7.	Provide a name for your Banner Ad. 
8.	Copy the App ID and AD unit ID to use in it your project. 
9.	Click on DONE and you are good to go.
Add Dependencies
In your  Projectbuild.gradle place the following dependencies and sync your project.
classpath 'com.google.gms:google-services:4.0.1'

In your  App build.gradle place the following dependencies and sync your project.
implementation 'com.google.android.gms:play-services-ads:11.8.0'

# Implementation
In your activity_man.xml, place the following UI element to view your banner AD and replace the adUnitID with your Ad Unit ID
<com.google.android.gms.ads.AdView
    android:id="@+id/adView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_gravity="bottom"
    ads:adSize="BANNER"
    ads:adUnitId="ca-app-pub-xxxxxxxxxxxxxxxx/xxxxxxxxx">
</com.google.android.gms.ads.AdView>

In your MainActivity.java class add the following code in your onCreate method
//initialize adView element
AdView adView=findViewByID(R.id. adView);


//create an ad request to call ads from google server
adRequest = new AdRequest.Builder().build();

//load ads
 adView.loadAd(adRequest);

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

Build and run your project and you should be able to see your first banner AD in your project.
Notes
If you just created your AdMob account today, then it will take 36-48 hours to show the first AD in your project. 
Happy coding…………!
