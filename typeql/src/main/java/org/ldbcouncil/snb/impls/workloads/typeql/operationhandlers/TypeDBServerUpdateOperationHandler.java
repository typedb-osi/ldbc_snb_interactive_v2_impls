package org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.driver.Operation;
import org.ldbcouncil.snb.driver.ResultReporter;
import org.ldbcouncil.snb.driver.workloads.interactive.queries.LdbcNoResult;
import org.ldbcouncil.snb.impls.workloads.operationhandlers.UpdateOperationHandler;
import org.ldbcouncil.snb.impls.workloads.typeql.TypeDBServerDbConnectionState;

import java.TypeDB.Connection;
import java.TypeDB.TypeDBException;
import java.TypeDB.Statement;

public abstract class TypeDBServerUpdateOperationHandler<TOperation extends Operation<LdbcNoResult>>
    implements UpdateOperationHandler<TOperation, TypeDBServerDbConnectionState> {

    @Override
    public void executeOperation(TOperation operation, TypeDBServerDbConnectionState state,
                                    ResultReporter resultReporter) throws DbException {
        try {
            Connection conn = state.getConnection();
            String queryString = getQueryString(state, operation);
                try (final Statement stmt = conn.createStatement()) {
                    state.logQuery(operation.getClass().getSimpleName(), queryString);
                    stmt.execute(queryString);
                } catch (Exception e) {
                    throw new DbException(e);
                }
                finally {
                    conn.close();
                }
                resultReporter.report(0, LdbcNoResult.INSTANCE, operation);
        }
        catch (TypeDBException e) {
            throw new DbException(e);
        }
    }
}