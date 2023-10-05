package org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.driver.Operation;
import org.ldbcouncil.snb.driver.ResultReporter;
import org.ldbcouncil.snb.impls.workloads.operationhandlers.ListOperationHandler;
import org.ldbcouncil.snb.impls.workloads.typeql.TypeDBServerDbConnectionState;

// import java.TypeDB.*;
import java.util.ArrayList;
import java.util.List;
 

public abstract class TypeDBServerListOperationHandler<TOperation extends Operation<List<TOperationResult>>, TOperationResult>
        implements ListOperationHandler<TOperationResult, TOperation, TypeDBServerDbConnectionState> {

    @Override
    public void executeOperation(TOperation operation, TypeDBServerDbConnectionState state,
                                 ResultReporter resultReporter) throws DbException {
        try {
            ResultSet result = null;
            Connection conn = state.getConnection();
            List<TOperationResult> results = new ArrayList<>();
            int resultCount = 0;

            String queryString = getQueryString(state, operation);
            try (final Statement stmt = conn.createStatement()) {
                state.logQuery(operation.getClass().getSimpleName(), queryString);

                result = stmt.executeQuery(queryString);
                while (result.next()) {
                    resultCount++;

                    TOperationResult tuple = convertSingleResult(result);
                    if (state.isPrintResults()) {
                        System.out.println(tuple.toString());
                    }
                    results.add(tuple);
                }
        } catch (TypeDBException e) {
            throw new DbException(e);
        }
        finally{
            if (result != null){
                result.close();
            }
            conn.close();
        }
        resultReporter.report(resultCount, results, operation);
    }
    catch (TypeDBException e) {
        throw new DbException(e);
    }
}

    public abstract TOperationResult convertSingleResult(ResultSet result) throws TypeDBException;

}
