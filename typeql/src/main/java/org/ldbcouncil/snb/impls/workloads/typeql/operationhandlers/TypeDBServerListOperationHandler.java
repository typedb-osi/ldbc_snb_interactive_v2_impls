package org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.driver.Operation;
import org.ldbcouncil.snb.driver.ResultReporter;
import org.ldbcouncil.snb.impls.workloads.operationhandlers.ListOperationHandler;
import org.ldbcouncil.snb.impls.workloads.typeql.TypeDBServerDbConnectionState;

import com.vaticle.typedb.client.api.answer.ConceptMap;
import com.vaticle.typedb.client.common.exception.TypeDBException;

import java.util.List;
 

public abstract class TypeDBServerListOperationHandler<TOperation extends Operation<List<TOperationResult>>, TOperationResult>
        implements ListOperationHandler<TOperationResult, TOperation, TypeDBServerDbConnectionState> {

    @Override
    public void executeOperation(TOperation operation, TypeDBServerDbConnectionState state,
                                 ResultReporter resultReporter) throws DbException {}
        
    
    public abstract TOperationResult convertSingleResult(ConceptMap result) throws TypeDBException;

}
