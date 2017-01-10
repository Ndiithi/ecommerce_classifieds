package com.inmobia.classified.service;

import com.inmobia.classified.dao.CountryDao;
import com.inmobia.classified.dto.Content;
import com.inmobia.classified.service.Bean.ContentDetail;
import com.inmobia.classified.service.Bean.SmsContent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Duncan Ndiithi
 */
public class ContentSaver implements Runnable {
    @Autowired
    CategoryResolver categoryResolver;
    @Autowired
    CountryDao countryDao;
    
    private static Logger logger = Logger.getLogger(ContentSaver.class.getName());

    private Content cnt;
    private SmsContent smsContent;
    private String content;
    private int telcoId;
    private String category;

    public ContentSaver(Content cnt, String content, String category, int telcoId) {
        //contService.submitContent(content, "Classifieds-Land for sale", "Lusaka", 203);
        
        //content looks like 'Classifieds-Land for sale' in remote
        //category looks like 'Lusaka' or 'Nairobi' in remote
        
         this.content=categoryResolver.getContentTypeNameUsedInRemote(
                cnt.getContent_category(), cnt.getSub_category(), countryDao.getCountryIdBySysmbol(cnt.getCountry()));
        
        
        this.cnt = cnt;
        
        this.telcoId = telcoId;
        this.category = category;

    }

    public void run() {
        logger.info("values in thread: " + cnt + " " + content + " " + telcoId);
        ContentBuilder contentBuilder = new ContentBuilder();
        SmsContent smsContent = contentBuilder.buildContent(cnt, content, category, telcoId);

        logger.info("SMS content to bumit(text): " + smsContent.getText());
        logger.info("SMS content to bumit(headline): " + smsContent.getHeadline());
        logger.info("SMS content to bumit(id): " + smsContent.getContentId());

        String url = "http://m.inmobia.com/icpc/main/content";

        RestTemplate restTemplate = new RestTemplate();
        //send content object
        smsContent = restTemplate.postForObject(url, smsContent, SmsContent.class);

        logger.debug("The content id  returned: " + smsContent.getId());

        url = "http://m.inmobia.com/icpc/main/content/detail";
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
        //send content detail object
        cntDetail = restTemplate.postForObject(url, cntDetail, ContentDetail.class);

    }

}
