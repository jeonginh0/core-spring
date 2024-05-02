package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // Type 이라고 하면 클래스 레벨에 붙는다.
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
