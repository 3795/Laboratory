package com.github.laboratory.assemble;

import com.github.laboratory.assemble.color.Yellow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Created At 2021/5/11
 */
@Configuration
public class ColorRegisterConfiguration {

    @Bean
    public Yellow yellow() {
        return new Yellow();
    }
}
