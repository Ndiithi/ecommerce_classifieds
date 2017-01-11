package com.inmobia.classified.service;

import com.inmobia.classified.dao.ContentDao;
import com.inmobia.classified.dao.CountryDao;
import com.inmobia.classified.dto.Content;
import com.inmobia.classified.service.Bean.ContentDetail;
import com.inmobia.classified.service.Bean.SmsContent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Duncan Ndiithi
 */
@EnableAsync
public class ContentEditor {

    private static Logger logger = Logger.getLogger(ContentEditor.class.getName());

    @Autowired
    CountryDao countryDao;

    @Autowired
    ContentDao contentDao;

    @Autowired
    ContentBuilder contentBuilder;

    private Content cnt;
    private SmsContent smsContent;
    private String content;
    private int telcoId;
    private String category;
    private int remoteContentId;
    private int remoteContentDetailId;
    private CategoryResolver categoryResolver;
    
    @Async
    public void editContent(Content cnt) {
        logger.debug("Content short description: " + cnt.getShortDescription());
        logger.debug("Content country symbol: " + cnt.getCountry());
        this.telcoId = countryDao.getCountryIdBySysmbol(cnt.getCountry());
        logger.debug("telco id: " + telcoId);
        categoryResolver = new CategoryResolver(cnt.getContent_category(), cnt.getSub_category(), this.telcoId);
        this.content = categoryResolver.getContentNameUsedInRemote();
        logger.debug("The content: " + content);
        this.cnt = cnt;
        this.category = categoryResolver.getCategoryNameUsedInRemote();
        logger.debug("telco category: " + category);

        Thread.currentThread().setName("Edit thread ContentId: " + cnt.getContentId());
        logger.info("values in edit thread: " + content + " " + telcoId);

        SmsContent smsContent = contentBuilder.buildContent(cnt, content, category, telcoId);

        logger.info("SMS content to edit(text): " + smsContent.getText());
        logger.info("SMS content to edit(headline): " + smsContent.getHeadline());
        logger.info("SMS content to edit(id): " + smsContent.getContentId());

        String url = "http://m.inmobia.com/icpc/main/content/{id}";

        RestTemplate restTemplate = new RestTemplate();
        
        logger.debug("Transmitting content for edit...: ");
        restTemplate.put(url, smsContent, cnt.getRemoteContentId());
        

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
         logger.debug("Transmitting content details for edit...: ");
      restTemplate.put(url, cntDetail, cnt.getRemoteContentDetailId());

    }

}
