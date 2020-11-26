package com.xl.sm.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.File;
import java.util.UUID;

/**
 * @ClassName ALiOSSUtil
 * @Description TODO
 * @Author 1
 * @Date 2020/11/26
 **/
public class AliOSSUtil {
    public static String ossUpload(File file){
        String bucketDomian="https://image-un.oss-cn-zhangjiakou.aliyuncs.com";
        String endpoint="https://oss-cn-zhangjiakou.aliyuncs.com";
        String accessKeyId="LTAI4G8dUd4xwK5CgmPZ7T5y";
        String accessKeySecret="KgeGkUTM3EryDC5cVydLUrBXd8kwSD";
        String bucketName="image-un";
        String fileDir="image/rxl";
        String fileName=file.getName();
        String fileKey= UUID.randomUUID().toString()+fileName.substring(fileName.indexOf("."));
        OSS ossClient=new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        ossClient.putObject(bucketName,fileDir+fileKey,file);
        ossClient.shutdown();
        return bucketDomian+"/"+fileDir+fileKey;
    }

    public static void main(String[] args) {
        File file=new File("C:/Users/1/Pictures/0.jpg");
        String url=ossUpload(file);
        System.out.println(url);
    }
}

