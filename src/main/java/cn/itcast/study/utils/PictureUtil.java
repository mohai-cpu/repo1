package cn.itcast.study.utils;



import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

@Component
public class PictureUtil {

    private static final Logger logger = LoggerFactory.getLogger(PictureUtil.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 生成6位数字编号，用零补位
     *
     * @return
     */
    public String getProductionId() {
        String randomNum = null;
        String productionId = null;
        if (this.redisTemplate.hasKey("TSHPC_RANDOMNUM")) {
            randomNum = this.redisTemplate.opsForValue().get("TSHPC_RANDOMNUM");
            productionId = String.format("%06d", this.redisTemplate.opsForValue().increment(randomNum, 1));
            this.redisTemplate.opsForValue().set("TSHPC_RANDOMNUM", productionId);
        }
        return productionId;
    }

    /**
     * 没有文件夹则创建新的,centos中调用java的mkdirs方法
     */

    public static void createDir(File picturePath) {
        if (picturePath == null) {
            return;
        }
        if (picturePath.exists()) {
            return;
        }
        if (!picturePath.exists()) {
            picturePath.mkdirs();
        }
    }

    /**
     * 创建原图文件
     *
     * @param wholePictureFile
     */
    public void createFile(File wholePictureFile) {
        if (wholePictureFile == null) {
            return;
        }
        if (wholePictureFile.exists()) {
            return;
        }
        File parentFile = wholePictureFile.getParentFile();
        createDir(parentFile);
        try {
            if (wholePictureFile.createNewFile()) {
                logger.info("wholePictureFile createNewFile success!");
            }
        } catch (IOException e) {
            logger.info("wholePictureFile createNewFile fail!", e);
        }
    }

    /**
     * 创建原图文件 TSHTC
     *
     * @param wholePictureFile
     */
    public static void createFile2(File wholePictureFile) {
        if (wholePictureFile == null) {
            return;
        }
        if (wholePictureFile.exists()) {
            return;
        }
        File parentFile = wholePictureFile.getParentFile();
        createDir(parentFile);
        try {
            if (wholePictureFile.createNewFile()) {
                logger.info("wholePictureFile createNewFile success!");
            }
        } catch (IOException e) {
            logger.info("wholePictureFile createNewFile fail!", e);
        }
    }


    /**
     * 创建缩略图文件
     *
     * @param fileBytes
     * @param miniPictureFile
     */
    public static void createThumbnaiFile(byte[] fileBytes, File miniPictureFile, String width) {
        if (miniPictureFile == null) {
            return;
        }
        if (miniPictureFile.exists()) {
            return;
        }
        File parentFile = miniPictureFile.getParentFile();
        createDir(parentFile);
        try {
            int parseWidth = Integer.parseInt(width);
            //按比例缩放
            if (parseWidth > 1000) {
                float num = (float) 300 / Integer.parseInt(width);
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                String radio = decimalFormat.format(num);
                Thumbnails.of(new ByteArrayInputStream(fileBytes)).scale(Float.parseFloat(radio)).toFile(miniPictureFile);
                logger.info("miniPictureFile createNewFile  success!");
            } else {
                Thumbnails.of(new ByteArrayInputStream(fileBytes)).scale(0.3f).toFile(miniPictureFile);
            }
        } catch (IOException e) {
            logger.info("miniPictureFile createNewFile fail!", e);
        }
    }
    /**
     * 创建缩略图文件，避免透明背景压缩后成黑色背景，效果不佳，弃用
     *  TSHTC
     * @param imageFile
     * @param miniPictureFile
     */
    public static void createThumbnaiFile2(MultipartFile imageFile, File miniPictureFile, String width) {
        if (miniPictureFile == null) {
            return;
        }
        if (miniPictureFile.exists()) {
            return;
        }
        File parentFile = miniPictureFile.getParentFile();
        createDir(parentFile);
        try {
            int parseWidth = Integer.parseInt(width);
            //按比例缩放
            if (parseWidth > 1000) {
                float num = (float) 300 / Integer.parseInt(width);
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                String radio = decimalFormat.format(num);
                //Thumbnails.of(imageFile.getInputStream()).imageType(BufferedImage.TYPE_INT_ARGB.scale(Float.parseFloat(radio)).toFile(miniPictureFile);
                //Thumbnails.of(imageFile.getInputStream()).imageType(BufferedImage.TYPE_INT_ARGB_PRE).scale(Float.parseFloat(radio)).toFile(miniPictureFile);
                //Thumbnails.of(imageFile.getInputStream()).imageType(BufferedImage.TYPE_4BYTE_ABGR).scale(Float.parseFloat(radio)).toFile(miniPictureFile);
                Thumbnails.of(imageFile.getInputStream()).imageType(BufferedImage.TYPE_4BYTE_ABGR_PRE).scale(Float.parseFloat(radio)).toFile(miniPictureFile);

                logger.info("miniPictureFile createNewFile  success!");
            } else {
                //Thumbnails.of(imageFile.getInputStream()).imageType(BufferedImage.TYPE_INT_ARGB).scale(0.3f).toFile(miniPictureFile);
                //Thumbnails.of(imageFile.getInputStream()).imageType(BufferedImage.TYPE_INT_ARGB_PRE).scale(0.3f).toFile(miniPictureFile);
                //Thumbnails.of(imageFile.getInputStream()).imageType(BufferedImage.TYPE_4BYTE_ABGR).scale(0.3f).toFile(miniPictureFile);
                Thumbnails.of(imageFile.getInputStream()).imageType(BufferedImage.TYPE_4BYTE_ABGR_PRE).scale(0.3f).toFile(miniPictureFile);
            }
        } catch (IOException e) {
            logger.info("miniPictureFile createNewFile fail!", e);
        }
    }
}
