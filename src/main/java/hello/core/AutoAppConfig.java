package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages =  "hello.core.member",
        basePackageClasses =  AutoAppConfig.class, // autoappconfig의 클래스를 기준으로 찾음
        // 이걸 default로 해준다면, 설정정보 패키지를 기준으로..
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = Configuration.class))

public class AutoAppConfig {
}
