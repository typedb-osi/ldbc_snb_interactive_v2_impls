package org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers;

import org.apache.commons.math3.analysis.function.Log;
import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.driver.Operation;
import org.ldbcouncil.snb.driver.ResultReporter;
import org.ldbcouncil.snb.impls.workloads.typeql.TypeQLDbConnectionState;
import org.ldbcouncil.snb.impls.workloads.operationhandlers.ListOperationHandler;
import org.ldbcouncil.snb.impls.workloads.operationhandlers.SingletonOperationHandler;

import com.vaticle.typedb.client.api.TypeDBSession;
import com.vaticle.typedb.client.api.answer.ConceptMap;
import com.vaticle.typedb.client.api.TypeDBTransaction;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Stream;

public abstract class TypeQLListOperationHandler<TOperation extends Operation<List<TOperationResult>>, TOperationResult>
        implements ListOperationHandler<TOperationResult,TOperation,TypeQLDbConnectionState>
{
    public abstract TOperationResult toResult(ConceptMap concept) throws ParseException;

    public abstract Map<String, Object> getParameters(TypeQLDbConnectionState<?> state, TOperation operation );

    @Override
    public void executeOperation(TOperation operation, TypeQLDbConnectionState state,
                                 ResultReporter resultReporter) throws DbException
    {
        System.out.println("Executing operation: " + operation.getClass().getSimpleName());
        String query = getQueryString(state, operation);
        final Map<String, Object> parameters = getParameters(state, operation);

        try(TypeDBTransaction transaction = state.getTransaction()){

            final List<TOperationResult> results = new ArrayList<>();
            //replace parameters in query
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                String valueString = entry.getValue().toString().replace("\"", "").replace("\'","");
                query = query.replace(":" + entry.getKey(), valueString);
            }

            final Stream<ConceptMap> result = transaction.query().match(query);
            
            result.forEach(concept -> {
                try {
                    results.add(toResult(concept));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
            transaction.close();
            resultReporter.report(results.size(), results, operation);
            
        }
    }
}
