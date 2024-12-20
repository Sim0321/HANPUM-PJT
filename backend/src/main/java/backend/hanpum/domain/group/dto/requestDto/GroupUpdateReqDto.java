package backend.hanpum.domain.group.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupUpdateReqDto {
    private String title;
    private String description;
    private int recruitmentCount;
    private Date recruitmentPeriod;
}
