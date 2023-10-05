package org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.driver.Operation;
import org.ldbcouncil.snb.driver.ResultReporter;
import org.ldbcouncil.snb.impls.workloads.operationhandlers.SingletonOperationHandler;
import org.ldbcouncil.snb.impls.workloads.typeql.TypeDBServerDbConnectionState;

import java.TypeDB.*;

public abstract class TypeDBServerSingletonOperationHandler<TOperation extends Operation<TOperationResult>, TOperationResult>
        implements SingletonOperationHandler<TOperationResult, TOperation, TypeDBServerDbConnectionState> {

    @Override
    public void executeOperation(TOperation operation, TypeDBServerDbConnectionState state,
                                 ResultReporter resultReporter) throws DbException {
        try {
            TOperationResult tuple = null;
            Connection conn = state.getConnection();
            int resultCount = 0;
            String queryString = getQueryString(state, operation);

            try (final Statement stmt = conn.createStatement()) {
                state.logQuery(operation.getClass().getSimpleName(), queryString);
    
                ResultSet result = stmt.executeQuery(queryString);
                resultCount++;
                tuple = convertSingleResult(result);
                if (state.isPrintResults())
                    System.out.println(tuple.toString());
               
            }
            catch (Exception e) {
                throw new DbException(e);
            }
            finally {
                conn.close();
            }
            resultReporter.report(resultCount, tuple, operation);
        }
        catch (TypeDBException e){
            throw new DbException(e);
        }
    }

    public abstract TOperationResult convertSingleResult(ResultSet result) throws TypeDBException;
}
