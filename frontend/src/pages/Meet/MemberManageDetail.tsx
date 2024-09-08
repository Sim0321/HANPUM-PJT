import { useEffect, useState } from 'react';
import * as M from '@/components/Style/Meet/MeetRequest';
import Header from '@/components/common/Header/Header';
import styled from 'styled-components';
import { useLocation, useNavigate } from 'react-router-dom';
import { GetMeetMemberDetailList } from '@/api/meet/GET';
import { MemberDetailDataProps } from '@/models/meet';
import { toast } from 'react-toastify';
import memberImg from '../../assets/img/memberImg.svg';
import BottomSheet from '@/components/Style/Route/BottomSheet';
import { DeleteMeetExile } from '@/api/meet/Delete';

function MemberManageDetail() {
  const navigate = useNavigate();
  const [memberData, setMemberData] = useState<MemberDetailDataProps | null>(
    null,
  );
  const [isRejectModalOpen, setIsRejectModalOpen] = useState<boolean>(false);
  const [loading, setLoading] = useState<boolean>(false);
  const [isOpen, setIsOpen] = useState<boolean>(false);
  const [bsType, setBsType] = useState<string>('설정');
  const [reviewType, setReviewType] = useState<string>('공개 여부');
  /** 멤버 아이디 넘겨받기 */
  const location = useLocation();
  const { groupId, memberId } = location.state || {};

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await GetMeetMemberDetailList(groupId, memberId);
        if (response && response.status === 'SUCCESS') {
          setMemberData(response.data || null);
        } else {
          console.error('error');
        }
      } catch (error) {
        toast.error('에러');
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  const getGenderText = (gender: 'MAN' | 'WOMAN' | undefined): string => {
    if (gender === 'MAN') {
      return '남자';
    } else if (gender === 'WOMAN') {
      return '여자';
    } else {
      return '정보 없음';
    }
  };

  const dummyMemberData = memberData
    ? [
        {
          img: memberData.profilePicture || '',
          nickname: memberData.nickname || '',
          name: memberData.name || '',
          gender: getGenderText(memberData.gender),
          birth: memberData.birthDate || '',
          applyContent: memberData.applyPost || '-',
        },
      ]
    : [];

  const profileDetails =
    dummyMemberData.length > 0
      ? [
          { title: '이름', content: dummyMemberData[0].name },
          { title: '성별', content: dummyMemberData[0].gender },
          { title: '생년월일', content: dummyMemberData[0].birth },
        ]
      : [];

  const rejectModalOpen = () => {
    setIsRejectModalOpen(true);
  };

  const rejectModalClose = () => {
    setIsRejectModalOpen(false);
  };

  /** 내보내기 */
  const deleteMemeber = async () => {
    try {
      setLoading(true);
      const response = await DeleteMeetExile(memberId);
      if (response && response.status === 'SUCCESS') {
        toast.success('수락 완료되었습니다.');
        setIsOpen(false);
      } else {
        toast.error('수락 실패했습니다.');
      }
    } catch (error) {
      toast.error('에러 발생');
    } finally {
      setIsOpen(false);
      setLoading(false);
    }
  };

  return (
    <MainPageContainer>
      <Header
        purpose="schedule"
        title="모임 인원관리"
        clickBack={() => navigate(-1)}
        clickOption={() => {
          setIsOpen(true);
          setBsType('모임관리');
        }}
      />
      <M.InfoWrap>
        <M.ProfileBox>
          <M.Img>
            <img
              src={
                dummyMemberData.length > 0
                  ? dummyMemberData[0].img.trim()
                  : memberImg
              }
              alt="프로필 이미지"
            />
          </M.Img>
          <M.Name>
            {dummyMemberData.length > 0
              ? dummyMemberData[0].nickname
              : '정보 없음'}
          </M.Name>
        </M.ProfileBox>
        <M.ProfileInfo>
          {profileDetails.map((detail, index) => (
            <M.ProfileInfoDetail key={index}>
              <M.ProfileInfoTitle>{detail.title}</M.ProfileInfoTitle>
              <M.ProfileInfoContent>{detail.content}</M.ProfileInfoContent>
            </M.ProfileInfoDetail>
          ))}
        </M.ProfileInfo>
        <M.InfoInputBox>
          <M.InfoText>지원글</M.InfoText>
          <M.InfoInput disabled>
            {dummyMemberData.length > 0 ? dummyMemberData[0].applyContent : '-'}
          </M.InfoInput>
        </M.InfoInputBox>
      </M.InfoWrap>
      {isOpen && (
        <BottomSheet
          selected={reviewType}
          setSelected={setReviewType}
          bsType={bsType}
          setIsOpen={setIsOpen}
          route="모임관리"
          bsTypeText={'설정'}
          onExport={deleteMemeber}
        />
      )}
    </MainPageContainer>
  );
}

export default MemberManageDetail;

const MainPageContainer = styled.div`
  width: 100vw;
  height: 100vh;
  display: flex;
  flex-direction: column;
  background-color: #fff;
  overflow-y: auto;
`;
