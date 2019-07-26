package com.java.main.mybaties;

/**
 * @Auther: kai2.wang
 * @Date: 2019/6/26 13:46
 * @Description:
 */
public class KTest {

    public static void main(String[] args) {
        KConfiguration kConfiguration=new KConfiguration();
        SqlSession sqlSession=new SqlSession(kConfiguration,new KExecutor());
        TestMapper testMapper=sqlSession.getMapper(TestMapper.class);
        testMapper.queryById(1);
    }
}
