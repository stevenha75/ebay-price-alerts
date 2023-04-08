package com.ebayalerter;

import okhttp3.*;
import java.io.IOException;
import org.json.JSONObject;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.SystemTray;
import javax.swing.ImageIcon;

// Handles notifications and sends via discord webhooks/desktop notifications
public class notification_handler {
    private String webhookUrl;

    public void setwebhookURL(String webhookURL) {
        this.webhookUrl = webhookURL;

    }

    public static void sendDiscordNotification(String message, String webhookUrl) {
        OkHttpClient client = new OkHttpClient();
        // Indicating that the mssage body should be sent in JSON format
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject json = new JSONObject();
        // Creating a key value pair with the 'content' key being used to specify the mssage content in the request body
        json.put("content", message);
        RequestBody body = RequestBody.create(mediaType, json.toString());
        Request request = new Request.Builder()
                .url(webhookUrl)
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            response.close();
        } catch (IOException e) {
            System.err.println("Failed to send HTTP request: " + e.getMessage());
        }
    }

    public static void sendNotification(String title, String message, String imagePath) {
        // Check if system tray is supported
        if (!SystemTray.isSupported()) {
            System.out.println("System tray is not supported");
            return;
        }

        // Get the system tray
        SystemTray tray = SystemTray.getSystemTray();

        // Load the image for the tray icon
        ImageIcon icon = new ImageIcon(imagePath);

        // Create a tray icon
        TrayIcon trayIcon = new TrayIcon(icon.getImage(), title);

        // Set the tray icon to display a message
        trayIcon.displayMessage(title, message, MessageType.INFO);
    }
}