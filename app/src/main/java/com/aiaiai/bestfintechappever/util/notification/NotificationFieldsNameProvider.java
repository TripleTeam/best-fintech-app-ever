package com.aiaiai.bestfintechappever.util.notification;


//// FIXME: 22.04.17 make interface and resolve for every device mandatory.
//// This fields name are tested only on Nexus 5
// TODO: 22.04.17 Provide as dependency instead of using  static
public class NotificationFieldsNameProvider {

    public static String getTitleName() {
        return "android.title";
    }

    public static String getSubTextName() {
        return "android.subtext";
    }

    public static String getTextName() {
        return "android.text";
    }

    public static String getBigTextName() {
        return "android.bigText";
    }

    public static String getInfoTextName() {
        return "android.infoText";
    }
}
