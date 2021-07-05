package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public NetworkClient() {
        System.out.println("생성자가 호출되었습니다 url = "+this.url);

    }
    public void connect(){
        System.out.println("connected to url = " + url);
    }
    public void call(String message){
        System.out.println("message = " + message);
    }

    public void disconnect(){
        System.out.println("closed well"+this.url);
    }
    @PostConstruct
    public void init(){
        System.out.println("init method is called");
        connect();
        call("연결 초기화 메서드");
    }
    @PreDestroy
    public void close(){
        System.out.println("close method is called");
        disconnect();
    }
}
