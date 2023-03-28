package com.ebayalerter;

import okhttp3.*;

// Handles notifications and sends via discord webhooks/desktop notifications
public class notification_handler {
    private String webhookUrl;
    
    public void setwebhookURL(String webhookURL){
        this.webhookURL = webhookURL;
    }

    public void sendDiscordNotification(String webhookUrl){
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"content\": \"Hello, world!\"}");
        Request request = new Request.Builder()
          .url(webhookUrl)
          .post(body)
          .build();
        
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
