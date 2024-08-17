package backend.hanpum.domain.group.controller;

import backend.hanpum.config.jwt.UserDetailsImpl;
import backend.hanpum.domain.group.dto.requestDto.GroupPostReqDto;
import backend.hanpum.domain.group.dto.responseDto.GroupApplyListGetResDto;
import backend.hanpum.domain.group.dto.responseDto.GroupDetailGetResDto;
import backend.hanpum.domain.group.dto.responseDto.GroupListGetResDto;
import backend.hanpum.domain.group.dto.responseDto.GroupPostResDto;
import backend.hanpum.domain.group.service.GroupService;
import backend.hanpum.exception.format.code.ApiResponse;
import backend.hanpum.exception.format.response.ResponseCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Group 컨트롤러", description = "Group Controller API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupController {

    private final ApiResponse response;
    private final GroupService groupService;

    @Operation(summary = "모임 생성", description = "모임 생성 API")
    @PostMapping
    public ResponseEntity<?> groupPost(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                       @RequestBody @Valid GroupPostReqDto groupPostReqDto) {
        GroupPostResDto groupPostResDto = groupService.createGroup(userDetails.getMember().getMemberId(), groupPostReqDto);
        return response.success(ResponseCode.GROUP_CREATED_SUCCESS, groupPostResDto);
    }

    @Operation(summary = "모임 리스트 조회", description = "모임 리스트 조회 API")
    @GetMapping
    public ResponseEntity<?> getGroupList(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        GroupListGetResDto groupListGetResDto = groupService.getGroupList(userDetails.getMember().getMemberId());
        return response.success(ResponseCode.GROUP_LIST_FETCHED, groupListGetResDto);
    }

    @Operation(summary = "모임 상세 조회", description = "모임 상세 조회 API")
    @GetMapping("/{groupId}")
    public ResponseEntity<?> getGroupDetail(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                            @PathVariable Long groupId) {
        GroupDetailGetResDto groupDetailGetResDto = groupService.getGroupDetail(userDetails.getMember().getMemberId(), groupId);
        return response.success(ResponseCode.GROUP_DETAIL_FETCHED, groupDetailGetResDto);
    }

    @Operation(summary = "모임 신청", description = "모임 신청 API")
    @PostMapping("/{groupId}/apply")
    public ResponseEntity<?> applyGroup(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                        @PathVariable Long groupId) {
        groupService.applyGroup(userDetails.getMember().getMemberId(), groupId);
        return response.success(ResponseCode.GROUP_APPLY_SUCCESS);
    }

    @Operation(summary = "모임 신청 취소", description = "모임 신청 취소 API")
    @DeleteMapping("/{groupId}/apply")
    public ResponseEntity<?> removeApplyGroup(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                              @PathVariable Long groupId) {
        groupService.removeApplyGroup(userDetails.getMember().getMemberId(), groupId);
        return response.success(ResponseCode.GROUP_APPLY_REMOVE_SUCCESS);
    }

    @Operation(summary = "모임 신청 리스트 조회", description = "모임 신청 리스트 조회 API")
    @GetMapping("/{groupId}/apply-list")
    public ResponseEntity<?> getGroupApplyList(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                               @PathVariable Long groupId) {
        GroupApplyListGetResDto groupApplyListGetResDto = groupService.getGroupApplyList(userDetails.getMember().getMemberId(), groupId);
        return response.success(ResponseCode.GROUP_APPLY_LIST_FETCHED, groupApplyListGetResDto);
    }

    @Operation(summary = "모임 신청 수락", description = "모임 신청 수락 API")
    @PutMapping("/apply/{groupMemberId}/accept")
    public ResponseEntity<?> acceptGroupApply(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                              @PathVariable Long groupMemberId) {
        groupService.acceptGroupApply(userDetails.getMember().getMemberId(), groupMemberId);
        return response.success(ResponseCode.GROUP_APPLY_ACCEPT_SUCCESS);
    }

    @Operation(summary = "모임 신청 거절", description = "모임 신청 거절 API")
    @DeleteMapping("/apply/{groupMemberId}/decline")
    public ResponseEntity<?> declineGroupApply(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                               @PathVariable Long groupMemberId) {
        groupService.declineGroupApply(userDetails.getMember().getMemberId(), groupMemberId);
        return response.success(ResponseCode.GROUP_APPLY_DECLINE_SUCCESS);
    }
}