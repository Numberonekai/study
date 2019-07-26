package com.java.main.mybaties;

/**
 * @Auther: kai2.wang
 * @Date: 2019/6/26 09:27
 * @Description:
 */
public class SqlSession {


    //配置文件解析
    private KConfiguration kConfiguration;

    private KExecutor kExecutor;


    public SqlSession(KConfiguration kConfiguration, KExecutor kExecutor) {
        this.kConfiguration = kConfiguration;
        this.kExecutor = kExecutor;
    }

    /**
     * 查询结果
     *
     * @param sql
     * @param param
     * @param <T>
     * @return
     */
    public <T> T selectOne(String sql, Object param) {
        return kExecutor.query(sql, param);
    }

    public <T> T getMapper(Class classzz) {
        return kConfiguration.getMapper(classzz, this);
    }
}
