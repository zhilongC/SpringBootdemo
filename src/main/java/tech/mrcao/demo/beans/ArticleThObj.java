package tech.mrcao.demo.beans;

import lombok.Data;
import org.apache.logging.log4j.spi.LoggerRegistry;

import java.io.Serializable;
import java.util.Date;

@Data
public class ArticleThObj implements Serializable {
    private String title;
    private String summary;
    private String content;
//    private Date updateTime;
    private String pictureContent;

//    public Date getUpdateTime() {
//        if (updateTime == null) {
//            return null;
//        }
//        return (Date) updateTime.clone();
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        if (updateTime == null) {
//            this.updateTime = null;
//        } else {
//            this.updateTime = (Date) updateTime.clone();
//        }
//    }
}
