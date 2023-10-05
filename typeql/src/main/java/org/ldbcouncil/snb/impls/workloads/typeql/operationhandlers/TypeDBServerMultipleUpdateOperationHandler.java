package org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.driver.Operation;
import org.ldbcouncil.snb.driver.ResultReporter;
import org.ldbcouncil.snb.driver.workloads.interactive.queries.LdbcNoResult;
import org.ldbcouncil.snb.impls.workloads.operationhandlers.MultipleUpdateOperationHandler;
import org.ldbcouncil.snb.impls.workloads.typeql.TypeDBServerDbConnectionState;


public abstract class TypeDBServerMultipleUpdateOperationHandler<TOperation extends Operation<LdbcNoResult>>
        implements MultipleUpdateOperationHandler<TOperation, TypeDBServerDbConnectionState> {

    @Override
    public void executeOperation(TOperation operation, TypeDBServerDbConnectionState state,
                                 ResultReporter resultReporter) throws DbException {
    }
}
