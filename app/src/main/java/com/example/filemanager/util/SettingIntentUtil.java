package com.example.filemanager.util;

import android.Manifest;
import android.app.NotificationManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.provider.AlarmClock;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class SettingIntentUtil {


    public static void intentSettingApp(Context context) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri =
                Uri.fromParts("package", context.getPackageName(), null);
        intent.setData(uri);
        context.startActivity(intent);
    }

    public static void intentSettingData(Context context) {
        try {
            Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
            intent.setClassName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void openCamera(Context context) {
//        val packageCamera = SettingUtils.getPackageCamera(context)
//        packageCamera?.let {
//            SettingUtils.intentOtherAppClearTask(context, packageCamera)
//        }
        try {
            Intent intent = new Intent(android.provider.MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startEmergencyCall(Context context) {
        Intent intent = new Intent("com.android.phone.EmergencyDialer.DIAL");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    // AIR PLANE SETTING
    public static boolean isAirplaneModeOn(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }

    public static void intentChangeAirPlane(Context context) {
        try {
            Intent i = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
            i.putExtra(":android:show_fragment", "com.android.settings.AirplaneModeSettings");
            i.putExtra(":android:no_headers", true);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Boolean isPowerSaveMode(Context context) {
        if (Build.MANUFACTURER.equalsIgnoreCase("Huawei")) {
            return isPowerSaveModeHuawei(context);
        } else if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            return isPowerSaveModeXiaomi(context);
        } else {
            return isPowerSaveModeAndroid(context);
        }
    }

    private static Boolean isPowerSaveModeAndroid(Context context) {
        boolean isPowerSaveMode = false;
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (pm != null) isPowerSaveMode = pm.isPowerSaveMode();
        return isPowerSaveMode;
    }

    private static Boolean isPowerSaveModeHuawei(Context context) {
        try {
            int value = Settings.System.getInt(context.getContentResolver(), "SmartModeStatus");
            return (value == 4);
        } catch (Settings.SettingNotFoundException e) {
            // Setting not found?  Return standard android mechanism and hope for the best...
            return isPowerSaveModeAndroid(context);
        }
    }

    private static Boolean isPowerSaveModeXiaomi(Context context) {
        try {
            int value = Settings.System.getInt(context.getContentResolver(), "POWER_SAVE_MODE_OPEN");
            return (value == 1);
        } catch (Settings.SettingNotFoundException e) {
            // Setting not found?  Return standard android mechanism and hope for the best...
            return isPowerSaveModeAndroid(context);
        }
    }


    public static String getGSM(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null && tm.getSimOperatorName() != null && !tm.getSimOperatorName().equals("")) {
            return tm.getSimOperatorName();
        }
        return "No sim";
    }

    //Check if the device has a sim card or not
    public static boolean hasSimCard(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null && tm.getSimOperatorName() != null && !tm.getSimOperatorName().equals("");
    }

    public static List<String> getNetworkOperator(final Context context) {
        // Get System TELEPHONY service reference
        List<String> carrierNames = new ArrayList<>();
        try {
            final String permission = Manifest.permission.READ_PHONE_STATE;
            if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) && (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED)) {
                final List<SubscriptionInfo> subscriptionInfos;
                subscriptionInfos = SubscriptionManager.from(context).getActiveSubscriptionInfoList();
                if (subscriptionInfos != null) {
                    for (int i = 0; i < subscriptionInfos.size(); i++) {
                        carrierNames.add(subscriptionInfos.get(i).getDisplayName().toString());
                    }
                }
            } else {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                // Get carrier name (Network Operator Name)
                carrierNames.add(telephonyManager.getNetworkOperatorName());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carrierNames;
    }

    public static boolean isDataEnable(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null) {
            if (!wifiManager.isWifiEnabled() && networkInfo.isAvailable()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void settingWifi(Context context) {
        WifiManager wifiManager;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            wifiManager = context.getSystemService(WifiManager.class);
        } else {
            wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        }
        wifiManager.setWifiEnabled(!wifiManager.isWifiEnabled());
    }

    public static String getNetworkType(Context context) {
        TelephonyManager mTelephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            int networkType = mTelephonyManager.getNetworkType();
            //Timber.e("networkType: " + networkType);
            switch (networkType) {
                case TelephonyManager.NETWORK_TYPE_GPRS:
                case TelephonyManager.NETWORK_TYPE_EDGE:
                case TelephonyManager.NETWORK_TYPE_CDMA:
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                case TelephonyManager.NETWORK_TYPE_IDEN:
                    return "2G";
                case TelephonyManager.NETWORK_TYPE_UMTS:
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                case TelephonyManager.NETWORK_TYPE_HSPA:
                case TelephonyManager.NETWORK_TYPE_EVDO_B:
                case TelephonyManager.NETWORK_TYPE_EHRPD:
                case TelephonyManager.NETWORK_TYPE_HSPAP:
                    return "3G";
                case TelephonyManager.NETWORK_TYPE_LTE:
                    return "LTE";
                default:
                    return "";
            }
        }
        return "";
    }

    public static boolean isEnableWifi(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isWifiEnabled();
    }

    public static boolean isEnableBluetooth(Context context) {
        PackageManager pm = context.getPackageManager();
        boolean hasBluetooth = pm.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH);
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (hasBluetooth && mBluetoothAdapter != null) {
            return mBluetoothAdapter.isEnabled();
        }
        return false;
    }

    // ROTATE SETTING
    public static void settingRotateForDevice(Context context) {
        try {
            int result = Settings.System.getInt(context.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION);
            if (result == 0) {
                Settings.System.putInt(context.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 1);
            } else if (result == 1) {
                Settings.System.putInt(context.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 0);
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean isRotateDevice(Context context) {
        try {
            int result = Settings.System.getInt(context.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION);
            if (result == 0) {
                return true;
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    // DO NOT DISTURB
    public static void settingDoNotDisturb(Context context) {
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!mNotificationManager.isNotificationPolicyAccessGranted()) {

                Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            } else {
                int type = mNotificationManager.getCurrentInterruptionFilter();
                if (type == NotificationManager.INTERRUPTION_FILTER_ALL) {
                    mNotificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_ALARMS);
                } else {
                    mNotificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_ALL);
                }
            }
        }
    }

    //  OPEN CAMERA
    public static String getPackageCamera(Context context) {
//        try {
//            Intent intent = new Intent("android.media.action.STILL_IMAGE_CAMERA");
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(intent);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        ResolveInfo cameraInfo;
        String packageName = null;
        List<ResolveInfo> pkgList = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (pkgList != null && pkgList.size() > 0) {
            cameraInfo = pkgList.get(0);
            packageName = cameraInfo.activityInfo.packageName;
        }
        return packageName;
    }

    // OPEN CLOCK
    public static void openClock(Context context) {
        try {
            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isLocationTurnOn(Context context) {
        LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled;
        try {
            gps_enabled = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            return gps_enabled;
        } catch (Exception ex) {
            return false;
        }
    }

    public static void intentSettingLocation(Context context) {
        try {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void intentPermissionWriteSetting(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Timber.d(e);
            }

        }
    }

    public static void intentOtherApp(Context context, String pka) {
        try {
            PackageManager pm = context.getPackageManager();
            Intent launchIntent = pm.getLaunchIntentForPackage(pka);
            if (launchIntent != null) {
                launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(launchIntent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void intentOtherAppClearTask(Context context, String pka) {
        try {
            PackageManager pm = context.getPackageManager();
            Intent launchIntent = pm.getLaunchIntentForPackage(pka);
            if (launchIntent != null) {
                launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                context.startActivity(launchIntent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Sync
    public static void setSyncAutomatically() {
        boolean b = ContentResolver.getMasterSyncAutomatically();
        if (b) {
            ContentResolver.setMasterSyncAutomatically(false);
        } else {
            ContentResolver.setMasterSyncAutomatically(true);
        }
    }

    public static boolean isSyncAutomaticallyEnable() {
        return ContentResolver.getMasterSyncAutomatically();
    }


    public static void setModeBrightness(Context context, int valueBrightness) {
        try {
            Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE, valueBrightness);
        } catch (Exception ignored) {
        }
    }

    public static String getForegroundPackage(UsageStatsManager usageStatsManager) {
        String packageName = null;
        final long INTERVAL = 1000 * 60;
        final long end = System.currentTimeMillis();
        final long begin = end - INTERVAL;
        final UsageEvents usageEvents = usageStatsManager.queryEvents(begin, end);
        while (usageEvents.hasNextEvent()) {
            UsageEvents.Event event = new UsageEvents.Event();
            usageEvents.getNextEvent(event);
            switch (event.getEventType()) {
                case UsageEvents.Event.MOVE_TO_FOREGROUND:
                    packageName = event.getPackageName();
                    break;
                case UsageEvents.Event.MOVE_TO_BACKGROUND:
//                    Timber.e("hoangld MOVE_TO_BACKGROUND:");
                    if (event.getPackageName().equals(packageName)) {
                        packageName = null;
                    }
            }
        }
        return packageName;
    }

}
