
UPDATE w_users t
SET t.password = 'e10adc3949ba59abbe56e057f20f883e'
WHERE t.username IN ('admin', 'wubin');


SELECT *
FROM w_users t;

DELETE FROM w_users
WHERE uid IN (5, 7, 8, 9);

COMMIT;

SELECT *
#   count(*)
FROM w_contents;

UPDATE w_contents t
SET t.tags = '性感荷官在线发牌';



DELIMITER //;
CREATE PROCEDURE INSERT_contents_batch(IN indexs INT)
  BEGIN
    DECLARE i INT DEFAULT 10;
    SET i = indexs;
    WHILE i < 30 DO
      INSERT INTO w_contents (cid, title, slug, created, modified, content, author_id, type, status, tags, categories, hits, comments_num, allow_comment, allow_ping, allow_feed)
      VALUES
        (i, '预置文章 My Blog', NULL, 1487861184, 1487872798,
            '## Hello  World.\r\n\r\n> ...\r\n\r\n----------\r\n\r\n\r\n<!--more-->\r\n\r\njava\r\npublic static void main(String[] args){\r\n    System.out.println(\"Hello W Blog.\");\r\n}\r\n',
            1, 'post', 'publish', '', 'default', 10, 0, 1, 1, 1);
      SET i = i + 1;
    END WHILE;
  END;
SET @indexs = 10;
call INSERT_contents_batch(@indexs);

DROP PROCEDURE INSERT_contents_batch;
