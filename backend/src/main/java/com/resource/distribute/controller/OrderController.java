package com.resource.distribute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.resource.distribute.common.CodeEnum;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dto.CountReq;
import com.resource.distribute.dto.OrderQueryReq;
import com.resource.distribute.dto.OrderUpdateReq;
import com.resource.distribute.dto.ReceiveOrderReq;
import com.resource.distribute.service.OrderService;

/**
 * @author huangwenjun
 * @version 2018年5月21日 下午9:54:19
 */
@RestController
@RequestMapping("/resource/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/import/{area-id}/{order-type}")
    public ReturnInfo importOrder(@RequestParam("orderFile") MultipartFile orderFile,
            @PathVariable("area-id") Integer areaId, @PathVariable("order-type") Integer orderType)
            throws Exception {
        if (orderFile == null || areaId == null || orderType == null) {
            return ReturnInfo.create(CodeEnum.REQUEST_PARAM_ERROR);
        }
        return orderService.importOrder(orderFile, areaId, orderType);
    }

    @PostMapping("/update")
    public ReturnInfo updateOrder(@RequestBody OrderUpdateReq orderReq) {
        return orderService.updateOrder(orderReq);
    }

    @PostMapping("/query")
    public ReturnInfo listOrder(@RequestBody OrderQueryReq queryReq) {
        return orderService.listOrder(queryReq);
    }

    @PostMapping("/receive/search")
    public ReturnInfo receiveOrderSearch(@RequestBody ReceiveOrderReq receiveOrderReq) {
        return orderService.receiveOrderSearch(receiveOrderReq);
    }

    @PostMapping("/receive")
    public ReturnInfo receiveOrder(@RequestBody ReceiveOrderReq receiveOrderReq) {
        return orderService.receiveOrder(receiveOrderReq);
    }

    @GetMapping("/main/meal")
    public ReturnInfo mainMeal() {
        return orderService.mainMeal();
    }

    @GetMapping("/second/meal")
    public ReturnInfo secondMeal() {
        return orderService.secondMeal();
    }

    @RequestMapping("/count")
    public ReturnInfo countOrder(@RequestBody CountReq countReq) {
        return orderService.orderCount(countReq);
    }
}
