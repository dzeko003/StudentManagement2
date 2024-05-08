package com.studentmanagement.tools;

import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class Notification {
	// 
	public static void notifSuccess(String title, String message) {
		// envois des notification
		NotificationType notification = NotificationType.SUCCESS; // titre et message
        
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(notification);
        tray.showAndDismiss(Duration.seconds(2));
	}
	
	public static void notifError(String title, String message) {
		NotificationType notification = NotificationType.ERROR;
        
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(notification);
        tray.showAndDismiss(Duration.seconds(2));
	}
	
	public static void notifInformation(String title, String message) {
		NotificationType notification = NotificationType.INFORMATION;
        
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(notification);
        tray.showAndDismiss(Duration.seconds(2));
	}
	// avertissement
	public static void notifWarning(String title, String message) {
		NotificationType notification = NotificationType.WARNING;
        
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(notification);
        tray.showAndDismiss(Duration.seconds(2)); // apparait et disparait apres 2 s
	}


}
