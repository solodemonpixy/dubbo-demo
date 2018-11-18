package cn.alex.demo.dubbo.mockservice.config;

import brave.Tracing;
import brave.propagation.B3Propagation;
import brave.propagation.ThreadLocalCurrentTraceContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.kafka11.KafkaSender;

@Configuration
public class ZipkinConfig {

    @Bean
    public Sender sender(){
        return KafkaSender.create("127.0.0.1:9092");
    }

    @Bean
    public AsyncReporter<Span> spanReporter() {
        return AsyncReporter.create(sender());
    }

    @Bean("tracing")
    public Tracing tracing(@Value("${spring.application.name}") String serviceName) {
        return Tracing.newBuilder()
                .localServiceName(serviceName)
                .propagationFactory(B3Propagation.FACTORY)
                .currentTraceContext(ThreadLocalCurrentTraceContext.newBuilder()
                        .build()
                )
                .spanReporter(spanReporter()).build();
    }

}
