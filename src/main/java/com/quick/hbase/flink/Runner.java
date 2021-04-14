package com.quick.hbase.flink;

import lombok.extern.slf4j.Slf4j;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * @author LvZheng
 * 创建时间：2021/4/13
 */
@Slf4j
@Component
public class Runner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();

        //kafka
//        DataStreamSource<String> text = env.socketTextStream("hadoop100", 9001, "\n");
//        Properties properties = new Properties();
//        properties.setProperty("bootstrap.servers", "BOOTSTRAP_SERVERS");
//        properties.setProperty("group.id", "GROUP_ID");
//        //使用仅一次语义的kafkaProducer
//        FlinkKafkaProducer011<String> myProducer = new FlinkKafkaProducer011<>("topic", new KeyedSerializationSchemaWrapper<String>(new SimpleStringSchema()), properties, FlinkKafkaProducer011.Semantic.EXACTLY_ONCE);
//        text.addSink(myProducer);


        //有限流
        DataStream<String> stream1 = env.fromElements("1", "2");

        //无限流
        DataStream<String> stream = env.addSource(new SourceFunction<String>() {
            @Override
            public void run(SourceContext<String> sourceContext) throws Exception {
                long c = 0;
                while (true) {
                    sourceContext.collect("test" + c++);
                    Thread.sleep(3000);
                }
            }

            @Override
            public void cancel() {

            }
        }).setParallelism(1).name("lz");

        stream.addSink(new MySink());
        env.execute("springboot flink");
    }
}
