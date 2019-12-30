package com.zsl.traceapi.util;

import com.zsl.traceapi.dto.DeliverGoods;
import com.zsl.traceapi.service.RedisService;
import com.zsl.traceapi.service.TraceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @ClassName DeliverThread
 * @Description 发货线程
 * @Author binggleW
 * @Date 2019-12-25 10:57
 * @Version 1.0
 **/
public class DeliverThread extends Thread{
    private static Logger logger = LoggerFactory.getLogger(DeliverThread.class);

    private TraceService traceService = (TraceService) SpringContextUtil.getBean(TraceService.class);
    private RedisService redisService = (RedisService) SpringContextUtil.getBean(RedisService.class);

    private DeliverGoods deliverGoods;
    private String traceCodeNumber;

    public DeliverThread(DeliverGoods deliverGoods,String traceCodeNumber){
        this.deliverGoods = deliverGoods;
        this.traceCodeNumber = traceCodeNumber;
    }

    @Override
    public void run() {
        try {
            traceService.deliverGoods(deliverGoods);
            logger.info("批量发货成功" + new Date());
            redisService.remove("Deliver_"+traceCodeNumber);
        }catch (Exception e){
            logger.info(e.getMessage());
        }
    }
}
