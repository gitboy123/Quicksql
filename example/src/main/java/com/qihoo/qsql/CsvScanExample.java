package com.qihoo.qsql;

import com.qihoo.qsql.api.SqlRunner;
import com.qihoo.qsql.api.SqlRunner.Builder.RunnerType;
import com.qihoo.qsql.env.RuntimeEnv;
import java.io.IOException;

public class CsvScanExample {
    public static void main(String[] args) throws IOException {
        RuntimeEnv.init();
        String sql = "select * from DEPTS";
        SqlRunner.Builder.RunnerType runnerType = RunnerType.DEFAULT;
        SqlRunner runner = SqlRunner.builder()
            .setTransformRunner(runnerType)
            .setSchemaPath(RuntimeEnv.metadata)
            .setAppName("test_csv_app")
            .setAcceptedResultsNum(100)
            .ok();
        runner.sql(sql).show().run();
        System.exit(-1);
    }
}
