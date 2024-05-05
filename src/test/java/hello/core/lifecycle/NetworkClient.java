package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    //서비스 시작 시 호출 
    public void connect() {
        System.out.println("connect: " + url);
    }
    
    public void call(String massage) {
        System.out.println("call = " + url + ", massage = " + massage);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init() { // 의존관계 주입이 끝나면 호출한다
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() { // 빈이 종료될 때 호출된다.
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
