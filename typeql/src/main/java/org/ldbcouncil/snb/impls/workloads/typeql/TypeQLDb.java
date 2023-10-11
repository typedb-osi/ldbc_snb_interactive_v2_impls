package org.ldbcouncil.snb.impls.workloads.typeql;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.driver.ResultReporter;
import org.ldbcouncil.snb.driver.control.LoggingService;
import org.ldbcouncil.snb.driver.workloads.interactive.queries.LdbcShortQuery1PersonProfile;
import org.ldbcouncil.snb.driver.workloads.interactive.queries.LdbcShortQuery1PersonProfileResult;
import org.ldbcouncil.snb.impls.workloads.QueryType;
import org.ldbcouncil.snb.impls.workloads.db.BaseDb;
import org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers.TypeQLSingletonOperationHandler;
import org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers.TypeQLSingletonOperationHandler;

import com.vaticle.typedb.client.api.concept.Concept;
import com.vaticle.typedb.client.api.answer.ConceptMap;
import com.vaticle.typedb.client.api.concept.thing.Attribute;
import com.vaticle.typedb.client.api.TypeDBTransaction;

import java.text.ParseException;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class TypeQLDb extends BaseDb<TypeQLQueryStore> {

    @Override
    protected void onInit(Map<String, String> properties, LoggingService loggingService) throws DbException {
        try {
            dcs = new TypeQLDbConnectionState(properties, new TypeQLQueryStore(properties.get("queryDir")));
        } catch (ClassNotFoundException e) {
            throw new DbException(e);
        }
    }

    // Interactive short reads
    public static class ShortQuery1PersonProfile extends TypeQLSingletonOperationHandler<LdbcShortQuery1PersonProfile,LdbcShortQuery1PersonProfileResult>
    {
        @Override
        public String getQueryString(TypeQLDbConnectionState state, LdbcShortQuery1PersonProfile operation) {
            return state.getQueryStore().getParameterizedQuery(QueryType.InteractiveShortQuery1);
        }

        @Override
        public Map<String, Object> getParameters(TypeQLDbConnectionState state, LdbcShortQuery1PersonProfile operation) {
            return state.getQueryStore().getShortQuery1PersonProfileMap(operation);
        }

        @Override
        public LdbcShortQuery1PersonProfileResult toResult( ConceptMap result ) throws ParseException
        {
            if (result != null){
                String firstName = result.get("fn").asAttribute().asString().getValue();
                String lastName = result.get("ln").asAttribute().asString().getValue();
                long birthday = result.get("bd").asAttribute().asLong().getValue();
                String locationIP = result.get("ip").asAttribute().asString().getValue();
                String browserUsed = result.get("bu").asAttribute().asString().getValue();
                long cityId = result.get("oc-id").asAttribute().asLong().getValue();
                String gender = result.get("g").asAttribute().asString().getValue();
                long creationDate = result.get("cd").asAttribute().asLong().getValue();
                return new LdbcShortQuery1PersonProfileResult(
                        firstName,
                        lastName,
                        birthday,
                        locationIP,
                        browserUsed,
                        cityId,
                        gender,
                        creationDate );
            }
            else
            {
                return null;
            }

        }
    }
}
