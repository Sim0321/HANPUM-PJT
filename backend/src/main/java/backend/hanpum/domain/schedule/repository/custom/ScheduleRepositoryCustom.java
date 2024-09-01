package backend.hanpum.domain.schedule.repository.custom;

import backend.hanpum.domain.schedule.dto.responseDto.*;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepositoryCustom {

    Optional<List<ScheduleResDto>> getMyScheduleByMemberId(Long memberId);

    Optional<ScheduleResDto> getGroupScheduleByMemberId(Long memberId);

    Optional<ScheduleDetailResDto> getScheduleDetail(Long memberId, Long scheduleId);

    // 일차별 하나씩만
    Optional<ScheduleDayResDto> getScheduleDayResDto(Long memberId, Long scheduleId, int day);

    Optional<List<ScheduleDayResDto>> getScheduleDayResDtoList(Long memberId, Long scheduleId);

    int activateScheduleForToday(String startDate);

    Optional<ScheduleTempResDto> getScheduleTempResDto(Long memberId);

    Optional<Long> checkMyScheduleCnt(Long memberId);
}
