//package com.quick.hbase.flink;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.flink.configuration.Configuration;
//import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
//import org.apache.kafka.common.config.Config;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
///**
// * @author LvZheng
// * 创建时间：2021/4/13
// */
//@Slf4j
//public class MySink extends RichSinkFunction<String> {
//
//    private AnnotationConfigApplicationContext ctx;
//
//    public MySink() {
//        log.info("MySink new");
//    }
//
//    @Override
//    public void open(Configuration parameters) throws Exception {
//        //todo 连接hbase数据库
//        this.ctx = new AnnotationConfigApplicationContext(Config.class);
//        log.info("MySink open");
//    }
//
//    @Override
//    public void invoke(String value, Context context) throws Exception {
//        //todo 逻辑处理
//        log.info(value);
//    }
//
//    @Override
//    public void close() throws Exception {
//        // 关闭容器
//        ctx.close();
//        log.info("MySink close");
//    }
//
//}
