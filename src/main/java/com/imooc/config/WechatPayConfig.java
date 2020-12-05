package com.imooc.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class WechatPayConfig {

    @Autowired
    private WechatAccountConfig AccountConfig;

    @Bean
    public BestPayServiceImpl bestPayService() {
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config(wxPayH5Config());
        return bestPayService;
    }

    @Bean
    public WxPayH5Config wxPayH5Config() {
        WxPayH5Config wxPayH5Config = new WxPayH5Config();
        wxPayH5Config.setAppId(AccountConfig.getMpAppId());
        wxPayH5Config.setAppSecret(AccountConfig.getMpAppSecret());
        wxPayH5Config.setMchId(AccountConfig.getMchId());
        wxPayH5Config.setMchKey(AccountConfig.getMchKey());
        wxPayH5Config.setKeyPath(AccountConfig.getKeyPath());
        wxPayH5Config.setNotifyUrl(AccountConfig.getNotifyUrl());
        return wxPayH5Config;
    }
}
