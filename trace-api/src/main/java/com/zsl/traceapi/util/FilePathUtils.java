package com.zsl.traceapi.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URLDecoder;


public class FilePathUtils {

    public static final String TEMP_PREFIX = "file/temp/";

    public static final String FILE_PATH_PREFIX = "file/upload/";

    public static String ROOT_PATH;

    /**
     * 获取临时文件地址
     * @return
     * @throws FileNotFoundException
     */
    public static String getTempFilePath() {
        File upload = new File(getPath(),"static/file/temp/");
        if(!upload.exists()){
            upload.mkdirs();
        }
        return upload.getAbsolutePath() + "/";
    }

        public static String getRootPath() {
        File upload = new File(getPath(),"static/");
        if(!upload.exists()){
            upload.mkdirs();
        }
        return upload.getAbsolutePath() + "/";
    }

    private static String getPath() {
        if (ROOT_PATH == null) {
            try {
                File path = new File(ResourceUtils.getURL("classpath:").getPath());
                if (!path.exists()){
                    path = new File("");
                }
                ROOT_PATH = URLDecoder.decode(path.getAbsolutePath(), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ROOT_PATH;
    }

    public static File mkdirs(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /**
     * 获取文件名后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
