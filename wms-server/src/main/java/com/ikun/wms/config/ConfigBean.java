package com.ikun.wms.config;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring6.data.redis.GenericFastJsonRedisSerializer;
import com.alibaba.fastjson2.support.spring6.http.converter.FastJsonHttpMessageConverter;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Properties;

@Configuration
public class ConfigBean {

//    @Bean // 配置数据源druid
//    public DruidDataSource druidDataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl("jdbc:mysql://localhost:3306/crm");
//        druidDataSource.setUsername("root");
//        druidDataSource.setPassword("gyw123...");
//        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        return druidDataSource;
//    }
    // 配置Redis序列化
//    @Bean
//    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
//
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//        GenericFastJsonRedisSerializer fastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
//
//        redisTemplate.setDefaultSerializer(fastJsonRedisSerializer);//设置默认的Serialize，包含 keySerializer & valueSerializer
//        redisTemplate.setKeySerializer(fastJsonRedisSerializer);//单独设置keySerializer
//        redisTemplate.setValueSerializer(fastJsonRedisSerializer);//单独设置valueSerializer
//        return redisTemplate;
//    }
    @Bean  // 配置FastJson
    public HttpMessageConverter<?> fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //自定义配置...
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd HH-mm-ss");

        config.setReaderFeatures(JSONReader.Feature.FieldBased, JSONReader.Feature.SupportArrayToBean);
        config.setWriterFeatures(JSONWriter.Feature.WriteMapNullValue, JSONWriter.Feature.PrettyFormat);

        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));

        return converter;
    }


    @Bean//加密
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = "captchaProducer")
    public Producer captchaProducer() {
        DefaultKaptcha kaptcha = new DefaultKaptcha();

        Properties props = new Properties();
        // 自定义配置
        props.setProperty("kaptcha.textproducer.font.names", "Arial, Courier");
        props.setProperty("kaptcha.textproducer.char.length", "4");
        props.setProperty("kaptcha.image.width","120");
        props.setProperty("kaptcha.image.height","45");
        // 更多配置项...

        Config config = new Config(props);
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
