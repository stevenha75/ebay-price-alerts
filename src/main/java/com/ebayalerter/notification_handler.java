package com.ebayalerter;

import okhttp3.*;
import java.io.IOException;
import org.json.JSONObject;

// Handles notifications and sends via discord webhooks
public class notification_handler {
    private static String webhookUrl;

    public static String getWebhookUrl(){
        return webhookUrl;
    }

    public static boolean setWebhook(String newWeebhookUrl){
        webhookUrl = newWeebhookUrl;
        return sendDiscordNotification("This is a test message");
    }

    public static boolean sendDiscordNotification(String message) {
        OkHttpClient client = new OkHttpClient();
        // Indicating that the mssage body should be sent in JSON format
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject json = new JSONObject();
        // Creating a key value pair with the 'content' key being used to specify the
        // mssage content in the request body
        json.put("content", message);
        RequestBody body = RequestBody.create(mediaType, json.toString());
        try {
        Request request = new Request.Builder()
                .url(webhookUrl)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        response.close();
        return true;
        } catch (IOException|IllegalArgumentException e){
            System.err.println("Failed to send HTTP request: " + e.getMessage());
            return false;
        }
    }
}