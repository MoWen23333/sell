package com.imooc.service;

import com.imooc.dto.OrderDTO;

public interface PushMessage {
    /* 订单状态变更消息 */
    void orderStatus(OrderDTO orderDTO);
}
