package com.tv.springbootwork.util;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;
@Slf4j
@Component
public class BatchTool {
    private final SqlSessionFactory sqlSessionFactory;

    public BatchTool(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 使用 batch 執行 mapper 操作
     *
     * @param mapperClass MyBatis 的 mapper interface 類別
     * @param <T>         Mapper 類型
     */
    public <T> void executeBatch(Class<T> mapperClass, Consumer<T> operation) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false)) {
            T mapper = sqlSession.getMapper(mapperClass);
            operation.accept(mapper);
            sqlSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("執行批次操作失敗", e);
        }
    }
}
