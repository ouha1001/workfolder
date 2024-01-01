CREATE TABLE rateme_rating (
rating_id int auto_increment primary key 
, user_id int NOT NULL
, osm_id bigint NOT null
, txt  varchar(2000) not null
,FOREIGN KEY (user_id) REFERENCES rateme_user(user_id)
,FOREIGN KEY (osm_id) REFERENCES rateme_poi(osm_id)
) CHARACTER SET utf8mb4;
