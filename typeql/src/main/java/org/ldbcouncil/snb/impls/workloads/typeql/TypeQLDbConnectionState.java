package org.ldbcouncil.snb.impls.workloads.typeql;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.impls.workloads.BaseDbConnectionState;
import org.ldbcouncil.snb.impls.workloads.QueryStore;

import com.google.protobuf.Type;
import com.vaticle.typedb.client.TypeDB;
import com.vaticle.typedb.client.api.TypeDBClient;
import com.vaticle.typedb.client.api.TypeDBSession;
import com.vaticle.typedb.client.api.TypeDBTransaction;

import java.util.Map;

public class TypeQLDbConnectionState<TDbQueryStore extends QueryStore> extends BaseDbConnectionState<TDbQueryStore> {

    private TypeDBClient client;
    private TypeDBSession session;
    private String dbName;
    private String endpoint;
    private int parallelisation;

    public TypeQLDbConnectionState(Map<String, String> properties, TDbQueryStore store) throws ClassNotFoundException  {
        super(properties, store);
        endpoint = properties.getOrDefault("endpoint", "localhost:1729");
        dbName = properties.getOrDefault("databaseName", "ldbcsnb");
        parallelisation = Integer.parseInt(properties.getOrDefault("parallelisation", "8")); 

        System.out.println("###2 Initializing TypeQLDbConnectionState");
    }

    /**
     * Gets the TypeDB client.
     *
     * @return The TypeDB client.
     */
    public TypeDBClient getClient() throws DbException {
        if (client == null) {
            client = TypeDB.coreClient(endpoint, parallelisation);
        }
        return client;
    }

    public TypeDBTransaction getTransaction() throws DbException {
        if (session == null || !session.isOpen()) {
            session = getClient().session(dbName, TypeDBSession.Type.DATA);
        }
        TypeDBTransaction transaction = session.transaction(TypeDBTransaction.Type.READ);
        return transaction;
    }

    @Override
    public void close() {
        if (session != null && session.isOpen()) {
            session.close();
        }
        if (client != null) {
            client.close();
        }
    }
}
