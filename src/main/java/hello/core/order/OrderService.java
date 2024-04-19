package hello.core.order;

public interface OrderService {
    Order craeteOrder(Long memberId, String itemName, int itemPrice); // 주문을 생성할 때 파라미터로 회원아이디, 상품이름, 상품가격을 반환한다.
}