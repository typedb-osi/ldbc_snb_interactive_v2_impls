package org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.driver.Operation;
import org.ldbcouncil.snb.driver.ResultReporter;
import org.ldbcouncil.snb.impls.workloads.operationhandlers.SingletonOperationHandler;
import org.ldbcouncil.snb.impls.workloads.typeql.TypeDBServerDbConnectionState;

public abstract class TypeDBServerSingletonOperationHandler<TOperation extends Operation<TOperationResult>, TOperationResult>
        implements SingletonOperationHandler<TOperationResult, TOperation, TypeDBServerDbConnectionState> {

    @Override
    public void executeOperation(TOperation operation, TypeDBServerDbConnectionState state,
                                 ResultReporter resultReporter) throws DbException {
    }

    public abstract TOperationResult convertSingleResult(ResultSet result) throws TypeDBException;
}
