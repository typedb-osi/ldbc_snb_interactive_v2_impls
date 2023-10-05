package org.ldbcouncil.snb.impls.workloads.typeql;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.impls.workloads.BaseDbConnectionState;
import org.ldbcouncil.snb.impls.workloads.QueryStore;

import java.util.Properties;
import java.util.Map;

public class TypeDBServerDbConnectionState<TDbQueryStore extends QueryStore> extends BaseDbConnectionState<TDbQueryStore> {

    protected String endPoint;

    public TypeDBServerDbConnectionState(Map<String, String> properties, TDbQueryStore store) throws ClassNotFoundException {
        super(properties, store);

        
    }

    public getConnection() throws DbException {
    }

    @Override
    public void close() {
    }
}
