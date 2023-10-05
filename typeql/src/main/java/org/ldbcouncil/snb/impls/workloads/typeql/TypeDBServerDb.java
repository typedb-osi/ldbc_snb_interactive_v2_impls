package org.ldbcouncil.snb.impls.workloads.typeql;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.driver.control.LoggingService;
import org.ldbcouncil.snb.driver.workloads.interactive.queries.*;
import org.ldbcouncil.snb.impls.workloads.db.BaseDb;
import org.ldbcouncil.snb.impls.workloads.typeql.converter.TypeDBServerConverter;
import org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers.ResultSet;
import org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers.TypeDBServerListOperationHandler;
import org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers.TypeDBServerMultipleUpdateOperationHandler;
import org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers.TypeDBServerSingletonOperationHandler;
import org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers.TypeDBServerUpdateOperationHandler;

import com.vaticle.typedb.client.api.concept.Concept;
import com.vaticle.typedb.client.common.exception.TypeDBException;

// import java.TypeDB.ResultSet;
// import java.TypeDB.TypeDBException;
import java.util.List;
import java.util.Map;

public abstract class TypeDBServerDb extends BaseDb<TypeDBServerQueryStore> {

    @Override
    protected void onInit(Map<String, String> properties, LoggingService loggingService) throws DbException {
        try {
            dcs = new TypeDBServerDbConnectionState(properties, new TypeDBServerQueryStore(properties.get("queryDir")));
        } catch (ClassNotFoundException e) {
            throw new DbException(e);
        }
    }


    public static class ShortQuery1PersonProfile extends TypeDBServerSingletonOperationHandler<LdbcShortQuery1PersonProfile, LdbcShortQuery1PersonProfileResult> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcShortQuery1PersonProfile operation) {
            return state.getQueryStore().getShortQuery1PersonProfile(operation);
        }
            

        @Override
        public LdbcShortQuery1PersonProfileResult convertSingleResult(Concept result) throws TypeDBException {
            
        }

        @Override
        public void executeOperation(LdbcShortQuery1PersonProfile operation, TypeDBServerDbConnectionState state,
                                     ResultReporter resultReporter) throws DbException {
            
        }
    }
}
