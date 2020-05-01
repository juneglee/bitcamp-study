/* union 과 union all */
-- 중복을 유무에 따라서 달라진다
-- all 모두 포함되는 가


/* select 결과 합치기 
   union : 중복 값 자동 제거*/
select distinct bank from stnt
union 
select distinct bank from tcher;

/* 
 * 
select distinct user_no from points
union 
select distinct user_no from users;
 * */


/* union all: 중복 값 제거 안함*/
select distinct bank from stnt
union all
select distinct bank from tcher;







