package backend.hanpum.exception.format.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {

    /* 예시 */
    TEST_SUCCESS(HttpStatus.OK, "성공 예시용 테스트 코드입니다."),

    /* 일정 */
    SCHEDULE_LIST_FETCHED(HttpStatus.OK, "일정 정보가 성공적으로 조회되었습니다."),

    /* 경로 */
    COURSE_DETAIL_FETCHED(HttpStatus.OK, "경로 상세정보가 성공적으로 조회되었습니다."),
    COURSE_DAY_FETCHED(HttpStatus.OK, "경로 일차 정보가 성공적으로 조회되었습니다."),

    /* 인증 */
    AUTHENTICATION_MAIL_SEND_SUCCESS(HttpStatus.OK, "인증 메일이 성공적으로 전송되었습니다."),
    AUTHENTICATION_SUCCESS(HttpStatus.OK, "인증이 성공적으로 완료되었습니다."),
    LOGIN_ID_CHECK_SUCCESS(HttpStatus.OK, "사용할 수 있는 아이디입니다."),
    NICKNAME_CHECK_SUCCESS(HttpStatus.OK, "사용할 수 있는 닉네임입니다."),
    SING_UP_SUCCESS(HttpStatus.OK, "회원가입이 성공적으로 완료되었습니다."),
    ;

    private final HttpStatus status;
    private final String message;
}
