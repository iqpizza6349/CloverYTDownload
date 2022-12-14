package com.github.iqpizza6349.cloverytdownloader.core;

import javax.swing.*;

public class YoutubeRequest {
    private final String youtubeUrl;
    private final String downloadDirectory;
    private final JProgressBar progressBar;

    public YoutubeRequest(String youtubeUrl, String downloadDirectory,
                          JProgressBar progressBar)
            throws IllegalArgumentException {
        this.youtubeUrl = checkUrl(youtubeUrl);
        checkDirectory(downloadDirectory);
        this.downloadDirectory = downloadDirectory;
        this.progressBar = progressBar;
    }

    public boolean downloadYT() {
        return Utils.sendRequest(youtubeUrl, downloadDirectory, progressBar);
    }

    private String checkUrl(String url) throws IllegalArgumentException {
        if (!Utils.isUrl(url)) {
            throw new IllegalArgumentException();
        }

        if (url.matches("https://youtube.com/shorts/(.*?)\\?feature=share")) {
            url = url.split("/shorts/")[1]
                    .split("\\?")[0];
        }
        if (url.matches("(.*)&ab_channel=(.*)")) {
            url = url.split("&")[0];
        }
        
        return url;
    }

    private void checkDirectory(String path) {
        if (!Utils.isDirectory(path)) {
            throw new IllegalArgumentException();
        }
    }
}
