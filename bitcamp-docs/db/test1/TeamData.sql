-- 유저
DROP TABLE IF EXISTS users RESTRICT;
-- 포인트내역
DROP TABLE IF EXISTS points RESTRICT;
-- 코스
DROP TABLE IF EXISTS courses RESTRICT;
-- 리뷰
DROP TABLE IF EXISTS reviews RESTRICT;
-- 인포
DROP TABLE IF EXISTS infos RESTRICT;
-- 방문장소
DROP TABLE IF EXISTS course_places RESTRICT;
-- 데이
DROP TABLE IF EXISTS course_days RESTRICT;
-- 데이리뷰
DROP TABLE IF EXISTS review_days RESTRICT;
-- 장소리뷰
DROP TABLE IF EXISTS review_place RESTRICT;
-- 인포장소
DROP TABLE IF EXISTS info_places RESTRICT;
-- 유저장소스크랩
DROP TABLE IF EXISTS place_scraps RESTRICT;
-- 유저데이스크랩
DROP TABLE IF EXISTS day_scraps RESTRICT;
-- 유저 인포장소 스크랩
DROP TABLE IF EXISTS info_scraps RESTRICT;
-- 리뷰장소 사진 모음
DROP TABLE IF EXISTS review_place_photo RESTRICT;
-- 인포 사진 모음
DROP TABLE IF EXISTS info_photo RESTRICT;


------------------------------------------------------------------------------------------------

-- 유저 Data
insert into users (user_no , user_name, birthday, gender, email, password, phone_number,
  zip_code, basic_address, detail_address , photo, nickname, account, bank )
values(1, 'user1', '1980-01-01', 1, 'test@gmail.com', '1234', '010-1234-5678',
  16501, '서울특별시 강남구 강남역 12번출구', '비트캠프', '비트캠프.gif', 'test1', 1111, '국민은행');
-- gender(남자 1, 여자 2)
-- account(수정 요망 - 번호가 길면 안써짐)

------------------------------------------------------------------------------------------------
-- 포인트 내역 Data
insert into points (point_no, user_no, trader_no, point_type, content,  price )
values(1, 1, 1, 1, 1, 20000);
-- point_type ( 입금 1,  출금 2)
-- 입출급 내용 content인데 int임
-- user_no와 trader_no 참조되어 번호가 같지 않으면 에러가 발생함

------------------------------------------------------------------------------------------------
-- 코스 Data
insert into courses (course_no,  user_no) 
values(1, 1);

-- 데이 Data
insert into course_days (course_day_no, course_no, title,  day_date)
values(1, 1, '서울 투어', '2020-04-10');

-- 데이 방문장소 Data
insert into course_places (place_no, course_day_no, place_name,  place_address, etc)
values(1, 1, '스타벅스','서울특별시 강남대로390', '만남의 장소로 선정');

insert into course_places (place_no, course_day_no, place_name,  place_address, etc)
values(2, 1, '원조남산왕돈까스','서울특별시 중구 예장동 소파로 107', '테마파크 가기 전 점심식사');

insert into course_places (place_no, course_day_no, place_name,  place_address, etc)
values(3, 1, '롯데월드','서울특별시 송파구 잠실동 올림픽로 240', '');

insert into course_places (place_no, course_day_no, place_name,  place_address, etc)
values(4, 1, 'N서울타워 한쿡','서울특별시 용산구 용산2가동 남산공원길 105',
'');

insert into course_places (place_no, course_day_no, place_name,  place_address, etc)
values(5, 1, '반포한강공원','서울특별시 서초구 반포2동 신반포로11길 40',
'');


------------------------------------------------------------------------------------------------
-- 리뷰 Data
insert into reviews (review_no, user_no, status)
values(1, 1, 1);
-- status (완성 1, 미완성 2)

-- 데이리뷰 Data
insert into review_days (review_day_no, main_photo, title ,day_date , day_review ,review_no , status)
values(1, '서울투어.gif', '서울 투어', '2020-04-10', '놀이기구 타기, 벚꽃 구경 등 하루를 알차게 보냈음',1,1);
-- status (공개 1, 비공개 2)

-- 장소리뷰 Data
insert into review_place (review_place_no,  place_name, place_address,  place_review, main_photo,      
  review_day_no, status)
values(1, '스타벅스' , '서울특별시 강남대로390' , '스타벅스를 평가할 필요가 있을까...??
항상 사람이 많고 모임이 있다. 세계 각지의 사람들과 바쁘게 움직이는 사람들을 구경하기에 좋은곳', '커피.gif', 1,1);
-- status (공개 1, 비공개 2)

insert into review_place (review_place_no,  place_name, place_address,  place_review, main_photo,      
  review_day_no, status)
values(2, '원조남산왕돈까스' , '서울특별시 중구 예장동 소파로 107' , '옛날 경양식 돈까스 맛이 좋습니다.
깍두기와 스프와 그리고 고추가 느끼한 돈까스 맛을 잡아 줍니다. 돈까스 두께가 많이 얇아 진거 같아요
생선까스는 양도 적당하고 맛도 그대로 네요~ 물가상승률에 따라 가격도 올랐네요', '돈까스.gif', 1,1);

insert into review_place (review_place_no,  place_name, place_address,  place_review, main_photo,      
  review_day_no, status)
values(3, '롯데월드' , '서울특별시 송파구 잠실동 올림픽로 240' , '다양한 놀이기구들이 있고 멋진 뷰가 있어요.
실내이므로 날씨가 좋지 못해도 이용이 가능합니다. 물론 야외 놀이시설도 있고 많은 사람들이 이용을 하여 인기있는 놀이기구는 오랜시간 대기를 해야 이용이 가능합니다.
우리나라 유명 관광명소이므로 외국인들이 눈에 많이 띕니다.', '놀이기구.gif', 1,1);

insert into review_place (review_place_no,  place_name, place_address,  place_review, main_photo,      
  review_day_no, status)
values(4, 'N서울타워 한쿡' , '서울특별시 강남대로390' , 
'문을 연 이 상징적인 타워는 도심의 탁 트인 전망을 자랑하며 회전식 레스토랑', '레스토랑.gif', 1,1);

insert into review_place (review_place_no,  place_name, place_address,  place_review, main_photo,      
  review_day_no, status)
values(5, '반포한강공원' , '서울특별시 강남대로390' , '한강을 보면서 쉴수 있는 장소로 많은 시민들이 방문하는 곳입니다. 
금요일,토요일에는 야시장을 운영을 합니다. 특히 금요일,토요일은 야시장운영으로 인해 교통체증이 심해요. 
농구장과 자전거 전용도로가 있어요. 가족과 함께 봄,여름에 여유있게 즐기기 좋은 장소 입니다.', '공원.gif', 1,1);

-- 리뷰장소 사진 모음
insert into review_place_photo (photo_no, review_place_no, photo_file)
values(1, 1, '스타벅스1');
insert into review_place_photo (photo_no, review_place_no, photo_file)
values(2, 1, '스타벅스2');
insert into review_place_photo (photo_no, review_place_no, photo_file)
values(3, 1, '스타벅스3');

insert into review_place_photo (photo_no, review_place_no, photo_file)
values(1, 2, '돈까스1');
insert into review_place_photo (photo_no, review_place_no, photo_file)
values(2, 2, '돈까스2');
insert into review_place_photo (photo_no, review_place_no, photo_file)
values(3, 2, '돈까스3');

insert into review_place_photo (photo_no, review_place_no, photo_file)
values(1, 3, '롯데월드1');
insert into review_place_photo (photo_no, review_place_no, photo_file)
values(2, 3, '롯데월드2');
insert into review_place_photo (photo_no, review_place_no, photo_file)
values(3, 3, '롯데월드3');

insert into review_place_photo (photo_no, review_place_no, photo_file)
values(1, 4, '남산타워1');
insert into review_place_photo (photo_no, review_place_no, photo_file)
values(2, 4, '남산타워2');
insert into review_place_photo (photo_no, review_place_no, photo_file)
values(3, 4, '남산타워3');

insert into review_place_photo (photo_no, review_place_no, photo_file)
values(1, 5, '한강공원1');
insert into review_place_photo (photo_no, review_place_no, photo_file)
values(2, 5, '한강공원2');
insert into review_place_photo (photo_no, review_place_no, photo_file)
values(3, 5, '한강공원3');

------------------------------------------------------------------------------------------------
-- 인포장소 Data
insert into info_places (place_no, start_date, last_date, place_name, place_address)
values(1, '2020-04-02', '2020-04-10', '석촌호수 벚꽃축제', '서울특별시 송파구 잠실동 47');
insert into info_places (place_no, start_date, last_date, place_name, place_address)
values(2, '2020-04-12', '2020-04-20', '철쭉동산', ' 경기도 군포시 산본동 1152-14');
insert into info_places (place_no, start_date, last_date, place_name, place_address)
values(3, '2020-04-14', '2020-05-11', '태안 세계튤립공원2020', '충청남도 태안군 안면읍 꽃지해안로 400');
insert into info_places (place_no, start_date, last_date, place_name, place_address)
values(4, '2020-04-22', '2020-04-30', '해운대 빛축제', '부산광역시 해운대구 중1동 1373-30');
insert into info_places (place_no, start_date, last_date, place_name, place_address)
values(5, '2020-05-15', '2020-05-31', '서울장미축제', '서울특별시 중랑구 묵2동 중랑천로 332일대');
-- 장소인포번호?? 인포장소번호??
-- 종료일 null??


-- 인포 Data
insert into infos (info_no, category, content, photo_file, main_photo, place_no )
values(1, 1, '서울의 대표 봄축제인 석촌호수 벚꽃축제는 4.2.(금) ~ 4.10.(일)까지 8일간 진행된다.
벚꽃프린지, 벚꽃음악회, 벚꽃버스킹, 호수 위의 피아노, 벚꽃가요제 등 다채로운 공연부터
벚꽃마켓, 벚꽃체험, 벚꽃시네마, 푸드트럭 등 다양한 볼거리와 즐길거리를 제공한다.', '벚꽃', '벚꽃.gif', 1);
insert into infos (info_no, category, content, photo_file, main_photo, place_no )
values(2, 1, ' 백만 그루 철쭉이 마음을 물들이는 곳...활짝 피어난 진분홍 꽃물결이 도심 가득 넘실대는
군포는 지금 축제 중!', '철쭉', '철쭉.gif', 2);
insert into infos (info_no, category, content, photo_file, main_photo, place_no )
values(3, 1, ' 봄날의 화창함을 더해주는 튤립을 보며 각박한 도시생활에서 벗어나 여유를 만끽하고
태안의 아름다운 바다와 맛있는 먹거리들로 즐거운 여행이 되실 수 있습니다. 화려한 꽃들이 만연한
태안 꽃 축제에서 가족과 연인과 함께 더욱 뜻 깊고, 소중한 추억을 만드시길 바랍니다. ', '튤립', '튤립.gif', 3);
insert into infos (info_no, category, content, photo_file, main_photo, place_no )
values(4, 1, '해운대, 빛의 바다를 슬로건으로 개최되는 해운대 빛축제는 
해운대해수욕장 백사장 위에 환상적인 빛의 파도를 표현했다.
밤바다 넘실대는 파도소리를 들으며, 신비로운 빛의 바다를 걷다보면 곳곳에서 포토존을 만날 수 있고, 
빛의 성 아쿠아몬드에 도달하게 된다. ', '빛', '빛.gif', 4);
insert into infos (info_no, category, content, photo_file, main_photo, place_no )
values(5, 1, '축제의 콘셉트는 ROSE GARDEN & ROSE PICNIC으로 가족·연인·친구와 함께하는 
사랑의 장미정원, 그리고 아름다운 프로포즈 포토존에서 최고의 인생샷을 남길 수 있는
 축제가 될 것입니다', '장미', '장미.gif', 5);
-- category ( 분류 확인)
-- category  재확인
-- photo_file ( 사진파일 모음 테이블 중복 ) 


-- 인포 사진 모음
insert into info_photo (photo_no, info_no, photo_file)
values(1, 1, '벚꽃1');
insert into info_photo (photo_no, info_no, photo_file)
values(2, 1, '벚꽃2');
insert into info_photo (photo_no, info_no, photo_file)
values(3, 1, '벚꽃3');

insert into info_photo (photo_no, info_no, photo_file)
values(1, 2, '철쭉1');
insert into info_photo (photo_no, info_no, photo_file)
values(2, 2, '철쭉2');
insert into info_photo (photo_no, info_no, photo_file)
values(3, 2, '철쭉3');


insert into info_photo (photo_no, info_no, photo_file)
values(1, 3, '튤립1');
insert into info_photo (photo_no, info_no, photo_file)
values(2, 3, '튤립2');
insert into info_photo (photo_no, info_no, photo_file)
values(3, 3, '튤립3');

insert into info_photo (photo_no, info_no, photo_file)
values(1, 4, '빛1');
insert into info_photo (photo_no, info_no, photo_file)
values(2, 4, '빛2');
insert into info_photo (photo_no, info_no, photo_file)
values(3, 4, '빛3');

insert into info_photo (photo_no, info_no, photo_file)
values(1, 5, '장미1');
insert into info_photo (photo_no, info_no, photo_file)
values(2, 5, '장미2');
insert into info_photo (photo_no, info_no, photo_file)
values(3, 5, '장미3');


------------------------------------------------------------------------------------------------

-- 유저장소 스크램
insert into place_scraps (user_no, review_place_no )
values(1, 1);

-- 유저데이 스크랩
insert into day_scraps  (user_no, review_day_no)
values(1, 1);

-- 유저 인포장소 스크랩
insert into info_scraps  (user_no, place_no )
values(1, 1);



