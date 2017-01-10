package com.inmobia.classified.service;

import com.inmobia.classified.dto.Content;
import com.inmobia.classified.service.Bean.ContentDetail;
import com.inmobia.classified.service.Bean.SmsContent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Duncan Ndiithi
 */
public class ContentEditor implements Runnable {

    private static Logger logger = Logger.getLogger(ContentEditor.class.getName());

    private Content cnt;
    private SmsContent smsContent;
    private String content;
    private int telcoId;
    private String category;
    private int remoteContentId;
    private int remoteContentDetailId;
    
    
    public ContentEditor(Content cnt,int remoteContentId,int remoteContentDetailId ) {
        
        this.remoteContentDetailId=remoteContentDetailId;
        this.remoteContentId=remoteContentId;
        this.cnt = cnt;
        
        //remove
        this.content = content;
        this.telcoId = telcoId;
        this.category = category;

    }

    public void run() {
        logger.info("values in thread: " + cnt + " " + content + " " + telcoId);
        ContentBuilder contentBuilder = new ContentBuilder();
        SmsContent smsContent = contentBuilder.buildContent(cnt, content, category, telcoId);

        logger.info("SMS content to subumit(text): " + smsContent.getText());
        logger.info("SMS content to subumit(headline): " + smsContent.getHeadline());
        logger.info("SMS content to subumit(id): " + smsContent.getContentId());
        
       
        
        String url = "http://m.inmobia.com/icpc/main/content/{id}";

        RestTemplate restTemplate = new RestTemplate();

        smsContent = restTemplate.postForObject(url, smsContent, SmsContent.class,remoteContentId);

        logger.debug("The content id  returned: " + smsContent.getId());

        url = "http://m.inmobia.com/icpc/main/content/detail/{id}";
        ContentDetail cntDetail = new ContentDetail();

        cntDetail.setContentId(smsContent.getId());
        try {
            cntDetail.setDescription(cnt.getShortDescription());
        } catch (Exception e) {

        }

        try {
            cntDetail.setEmail(cnt.getEmail());

        } catch (Exception e) {

        }

        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                cntDetail.setExpiryDate(df.parse(cnt.getExpiryDate()));
            } catch (ParseException ex) {
                logger.error(ex.getMessage());
            }

        } catch (Exception e) {

        }
        try {
            cntDetail.setLocation(cnt.getLocation());

        } catch (Exception e) {

        }
        try {
            cntDetail.setNegotiable((cnt.getIsNegotiable() == 1) ? true : false);

        } catch (Exception e) {

        }
        try {
            cntDetail.setPhoneNumber(cnt.getPhone());

        } catch (Exception e) {

        }
        try {
            cntDetail.setPrice(cnt.getPrice());
        } catch (Exception e) {

        }

        cntDetail = restTemplate.postForObject(url, cntDetail, ContentDetail.class,remoteContentDetailId);

    }

}
