package org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.driver.Operation;
import org.ldbcouncil.snb.driver.ResultReporter;
import org.ldbcouncil.snb.impls.workloads.typeql.TypeQLDbConnectionState;
import org.ldbcouncil.snb.impls.workloads.operationhandlers.SingletonOperationHandler;

import com.vaticle.typedb.client.api.TypeDBSession;
import com.vaticle.typedb.client.api.answer.ConceptMap;
import com.vaticle.typedb.client.api.TypeDBTransaction;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;

public abstract class TypeQLSingletonOperationHandler<TOperation extends Operation<TOperationResult>, TOperationResult>
        implements SingletonOperationHandler<TOperationResult,TOperation,TypeQLDbConnectionState<?>>
{
    public abstract TOperationResult toResult(ConceptMap concept) throws ParseException;

    public abstract Map<String, Object> getParameters(TypeQLDbConnectionState<?> state, TOperation operation );

    @Override
    public void executeOperation(TOperation operation, TypeQLDbConnectionState<?> state,
                                 ResultReporter resultReporter) throws DbException
    {
        String query = getQueryString(state, operation);
        final Map<String, Object> parameters = getParameters(state, operation);

        try(TypeDBSession session = state.getSession()){
            try(TypeDBTransaction transaction = session.transaction(TypeDBTransaction.Type.READ)){
                Iterator<ConceptMap> result = transaction.query().match(query).iterator();

                if (result.hasNext()) {
                    resultReporter.report(1, toResult(result.next()), operation);
                } else {
                    resultReporter.report(0, toResult(null), operation);
                }
            }
        }
        catch (ParseException e) {
            throw new DbException(e);
        }
    }
}
