--- SELECT 1.1 : 查询<id, name, sex, name, score, ctime>

SELECT
    sc.id,
    st.name AS student,
    st.sex,
    co.name AS course,
    sc.score,
    sc.ctime
FROM
    student AS st,
    course AS co,
    score AS sc
WHERE
    sc.sno=st.sno AND
    sc.cn=co.cn;
