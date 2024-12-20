import { colors } from '@/styles/colorPalette';
import styled from 'styled-components';

export const Container = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  background-color: ${colors.white};
`;

export const MainContainer = styled.div`
  width: 100%;
  flex: 1;
  display: flex;
  flex-direction: column;
  overflow-y: auto;
  padding: 6rem 0 0 0;
`;

export const RouteCard = styled.div`
  width: 100%;
  height: 9.5rem;
  display: flex;
  flex-direction: row;
  align-items: start;
  justify-content: center;
  border-bottom: 0.1rem solid ${colors.grey1};
  margin-bottom: 2.4rem;
  flex-shrink: 0;
`;

export const ContentBox = styled.div`
  width: 90%;
  height: 7.1rem;
  display: flex;
  flex-direction: row;
`;

export const Img = styled.img`
  width: 9rem;
  height: 100%;
  border-radius: 1.2rem;
`;

export const TextBox = styled.div`
  width: 58%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 0 0 0 1.6rem;
`;

export const Title = styled.p`
  font-size: 1.4rem;
  font-weight: 700;
  margin-bottom: 0.6rem;
`;

export const RouteTextBox = styled.div`
  width: 9rem;
  height: 1.5rem;
  display: flex;
  flex-direction: row;
  font-size: 1rem;
  justify-content: space-around;
  color: ${colors.grey2};
`;

export const ScoreBox = styled.div`
  width: 5rem;
  height: 1.7rem;
  display: flex;
  flex-direction: row;
  align-items: center;
`;

export const Score = styled.p`
  font-size: 1.2rem;
  font-weight: bold;
  margin-left: 0.3rem;
`;

export const Review = styled.p`
  font-size: 1.2rem;
  margin-left: 0.5rem;
`;

export const DateBox = styled.div`
  width: 15%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: end;
  justify-content: space-between;
`;

export const Date = styled.div`
  width: 5.5rem;
  height: 2.4rem;
  display: flex;
  align-items: center;
  justify-content: center;
  color: ${colors.white};
  background-color: ${colors.main};
  font-size: 1.2rem;
  font-weight: bold;
  border-radius: 10rem;
`;

export const RouteTypeContainer = styled.div`
  width: 100%;
  height: 4rem;
  display: flex;
  align-items: center;
  box-shadow: 0px 4px 4px 0 rgba(0, 0, 0, 0.25);
`;

export const ReviewHeaderText = styled.p`
  color: ${colors.grey2};
  margin-left: 2.4rem;
`;

export const RouteDistanceBox = styled.div`
  width: 20%;
  height: 80%;
  display: flex;
  align-items: center;
  justify-content: start;
  padding: 0 0 0 0.4rem;
  color: ${colors.grey2};
  border-left: 0.1rem solid ${colors.grey2};
`;

export const ReviewHeaderTextBox = styled.div`
  display: flex;
  flex-direction: row;
`;
