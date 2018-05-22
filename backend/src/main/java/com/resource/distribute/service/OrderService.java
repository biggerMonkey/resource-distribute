package com.resource.distribute.service;

import org.springframework.web.multipart.MultipartFile;

import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dto.OrderQueryReq;
import com.resource.distribute.dto.OrderUpdateReq;
import com.resource.distribute.dto.ReceiveOrderReq;

/**
 * @author huangwenjun
 * @version 2018年5月21日 下午9:45:09
 */
public interface OrderService {


    public ReturnInfo importOrder(MultipartFile orderfile, Integer areaId) throws Exception;

    public ReturnInfo updateOrder(OrderUpdateReq orderReq);

    public ReturnInfo listOrder(OrderQueryReq queryReq);

    public ReturnInfo receiveOrderSearch(ReceiveOrderReq receiveOrderReq);

    public ReturnInfo receiveOrder(ReceiveOrderReq receiveOrderReq);
}
