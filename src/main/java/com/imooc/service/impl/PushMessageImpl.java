package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.PushMessage;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class PushMessageImpl implements PushMessage {

    @Autowired
    private WxMpService wxMpService;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();

        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            templateMessage.setTemplateId("");
            templateMessage.setToUser("");
            List<WxMpTemplateData> data = Arrays.asList(
                    new WxMpTemplateData("first", "亲，请记得收获"),
                    new WxMpTemplateData("keyword1", "微信点餐"),
                    new WxMpTemplateData("keyword2", "12345678"),
                    new WxMpTemplateData("keyword3", orderDTO.getOrderId()),
                    new WxMpTemplateData("keyword4", orderDTO.getOrderStatusEnum().getMessage()),
                    new WxMpTemplateData("keyword5", "¥" + orderDTO.getOrderAmount()),
                    new WxMpTemplateData("remark", "欢迎再次光临！")
                    );
            templateMessage.setData(data);
        } catch (WxErrorException e) {
            log.error("[微信模版消息] 发送失败，{}", e);
        }
    }
}