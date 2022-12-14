package com.github.iqpizza6349.cloverytdownloader.frame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public final class ResourceUtil {

    public static final String BLANK = "                     ";
    private static String youtubeURL = "";
    private static String downloadPath = "";

    private ResourceUtil() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static String getYoutubeDLBinPath() {
        URL url = ResourceUtil.class.getProtectionDomain()
                .getCodeSource().getLocation();
        String fullPath = url.toString();
        String[] args = fullPath.split("/");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < args.length - 1; i++) {
            stringBuilder.append(args[i])
                    .append("/");
        }
        stringBuilder.append("ffmpeg-win64-gpl");

        return stringBuilder.append("/bin").toString();
    }

    private static Image getImage(String name) {
        ClassLoader classLoader = ResourceUtil.class.getClassLoader();
        try (final InputStream inputStream = classLoader.getResourceAsStream(name)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("file not found!");
            }

            return ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getFolderImage() {
        return getImage("icon/folder_icon.png");
    }

    public static Image getLogoIcon() {
        return getImage("icon/logo.png");
    }

    public static String getYoutubeURL() {
        return youtubeURL;
    }

    public static void setYoutubeURL(String youtubeURL) {
        ResourceUtil.youtubeURL = youtubeURL;
    }

    public static String getDownloadPath() {
        return downloadPath;
    }

    public static void setDownloadPath(String downloadPath) {
        ResourceUtil.downloadPath = downloadPath;
    }
}
