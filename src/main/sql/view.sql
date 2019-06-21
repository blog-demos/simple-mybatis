CREATE OR REPLACE VIEW view1 AS
    SELECT
        sc.id,
        st.name AS student,
        st.sex,
        co.name AS course,
        sc.score,
        sc.ctime
    FROM
        score AS sc
        INNER JOIN student AS st ON sc.sno=st.sno
        INNER JOIN course AS co ON sc.cn=co.cn;