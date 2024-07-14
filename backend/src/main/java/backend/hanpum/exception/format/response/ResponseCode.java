package backend.hanpum.exception.format.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {

    /* 예시 */
    TEST_SUCCESS(HttpStatus.OK, "성공 예시용 테스트 코드입니다.");

    private final HttpStatus status;
    private final String message;
}