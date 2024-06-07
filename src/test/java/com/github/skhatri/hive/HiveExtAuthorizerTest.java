package com.github.skhatri.hive;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.ql.metadata.AuthorizationException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.metadata.Table;
import org.apache.hadoop.hive.ql.security.authorization.Privilege;
import org.junit.jupiter.api.Test;

public class HiveExtAuthorizerTest {

    @Test
    public void testInit() throws HiveException {
        HiveExtAuthorizer authorizer = new HiveExtAuthorizer();
        authorizer.init(new Configuration());
    }

    @Test
    public void testAuthorize() throws HiveException, AuthorizationException {
        HiveExtAuthorizer authorizer = new HiveExtAuthorizer();
        authorizer.authorize(new Table(), new Privilege[0], new Privilege[0]);
    }
}
