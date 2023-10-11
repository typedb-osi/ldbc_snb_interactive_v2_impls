package org.ldbcouncil.snb.impls.workloads.typeql;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.impls.workloads.BaseDbConnectionState;
import org.ldbcouncil.snb.impls.workloads.QueryStore;

import com.vaticle.typedb.client.TypeDB;
import com.vaticle.typedb.client.api.TypeDBClient;
import com.vaticle.typedb.client.api.TypeDBSession;

import java.util.Map;

public class TypeQLDbConnectionState<TDbQueryStore extends QueryStore> extends BaseDbConnectionState<TDbQueryStore> {

    private TypeDBClient client;
    private TypeDBSession session;

    public TypeQLDbConnectionState(Map<String, String> properties, TDbQueryStore store) throws ClassNotFoundException  {
        super(properties, store);

        String endpoint = properties.getOrDefault("endpoint", "localhost:1729");
        String dbName = properties.getOrDefault("databaseName", "social_network");
        
        // Initializing client and session
        client = TypeDB.coreClient(endpoint);
        session = client.session(dbName, TypeDBSession.Type.DATA);
    }

    public TypeDBClient getClient() throws DbException{
        return client;
    }
    
    public TypeDBSession getSession() throws DbException{
        return session;
    }

    @Override
    public void close() {
        if (session != null) {
            session.close();
        }
        if (client != null) {
            client.close();
        }
    }
}
