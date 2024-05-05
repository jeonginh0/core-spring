package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

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

    @Override
    public void afterPropertiesSet() throws Exception { // 의존관계 주입이 끝나면 호출한다
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception { // 빈이 종료될 때 호출된다.
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
