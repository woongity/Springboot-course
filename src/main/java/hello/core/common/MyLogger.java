package hello.core.common;

import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
// 가짜 프록시 객체를 만듦..
@Scope(value= "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL){
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("["+this.uuid+"]"+"["+requestURL+"]"+"["+message+"]");
    }
    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("["+this.uuid+"] request bean scope created"+this);

    }
    @PreDestroy
    public void shutdown(){
        System.out.println("["+this.uuid+"] request bean scope close"+this);
    }
}
