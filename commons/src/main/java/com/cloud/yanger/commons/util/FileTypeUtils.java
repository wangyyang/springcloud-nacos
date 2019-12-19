package com.cloud.yanger.commons.util;

public class FileTypeUtils {

    private static final String[] IMGS = { "bmp", "jpg", "jpeg", "png", "tiff", "gif", "pcx", "tga", "exif", "fpx", "svg", "psd",
            "cdr", "pcd", "dxf", "ufo", "eps", "ai", "raw", "wmf" };

    private static final String[] DOCS = { "txt", "doc", "docx", "xls", "htm", "html", "jsp", "rtf", "wpd", "pdf", "ppt" };

    private static final String[] VDOS = { "mp4", "avi", "mov", "wmv", "asf", "navi", "3gp", "mkv", "f4v", "rmvb", "webm" };

    private static final String[] MICS = { "mp3", "wma", "wav", "mod", "ra", "cd", "md", "asf", "aac", "vqf", "ape", "mid", "ogg",
            "m4a", "vqf" };
    /**
     * 判断文件类型
     * @param fileName 文件名
     */
    public static String fileType(String fileName) {
        if (fileName == null) {
            fileName = "文件名为空！";
            return fileName;

        } else {
            // 获取文件后缀名并转化为写，用于后续比较
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

            for (String img : IMGS) {
                if (img.equals(fileType)) {
                    return "img";
                }
            }

            for (String doc : DOCS) {
                if (doc.equals(fileType)) {
                    return "document";
                }
            }

            for (String vdo : VDOS) {
                if (vdo.equals(fileType)) {
                    return "video";
                }
            }

            for (String mic : MICS) {
                if (mic.equals(fileType)) {
                    return "music";
                }
            }

        }
        return "other";
    }
}
