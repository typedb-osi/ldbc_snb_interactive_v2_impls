package org.ldbcouncil.snb.impls.workloads.typeql;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.driver.control.LoggingService;
import org.ldbcouncil.snb.driver.workloads.interactive.queries.*;
import org.ldbcouncil.snb.impls.workloads.QueryType;
import org.ldbcouncil.snb.impls.workloads.db.BaseDb;
import org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers.*;
import com.vaticle.typedb.client.api.answer.ConceptMap;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.time.ZoneId;


public abstract class TypeQLDb extends BaseDb<TypeQLQueryStore> {

    @Override
    protected void onInit(Map<String, String> properties, LoggingService loggingService) throws DbException {
        System.out.println("###1 Initializing TypeQLDb");
        try {
            dcs = new TypeQLDbConnectionState<TypeQLQueryStore>(properties, new TypeQLQueryStore(properties.get("queryDir")));
        } catch (ClassNotFoundException e) {
            throw new DbException(e);
        }
    }

    // Interactive Complex Reads
    
    // public static class InteractiveQuery1 extends TypeQLListOperationHandler<LdbcQuery1,LdbcQuery1Result>
    // {

    //     @Override
    //     public String getQueryString(TypeQLDbConnectionState state, LdbcQuery1 operation) {
    //         return state.getQueryStore().getParameterizedQuery(QueryType.InteractiveComplexQuery1);
    //     }

    //     @Override
    //     public Map<String, Object> getParameters(TypeQLDbConnectionState state, LdbcQuery1 operation) {
    //         return state.getQueryStore().getQuery1Map(operation);
    //     }

    //     @Override
    //     public LdbcQuery1Result toResult(ConceptMap result) throws ParseException {
    //         if (result != null) {

    //             // Extracting individual attributes
    //             long friendId = result.get("friendId").asAttribute().asLong().getValue();
    //             String friendLastName = result.get("friendLastName").asAttribute().asString().getValue();
    //             int distanceFromPerson = result.get("distanceFromPerson").asAttribute().asLong().getValue().intValue();
    //             long friendBirthday = result.get("friendBirthday").asAttribute().asLong().getValue();
    //             long friendCreationDate = result.get("friendCreationDate").asAttribute().asLong().getValue();
    //             String friendGender = result.get("friendGender").asAttribute().asString().getValue();
    //             String friendBrowserUsed = result.get("friendBrowserUsed").asAttribute().asString().getValue();
    //             String friendLocationIp = result.get("friendLocationIp").asAttribute().asString().getValue();
    //             String friendCityName = result.get("friendCityName").asAttribute().asString().getValue();

    //             // Extracting lists
    //             List<String> emails = extractList(result, "emails");
    //             List<String> languages = extractList(result, "languages");
    //             List<LdbcQuery1Result.Organization> universities = asOrganization(extractList(result, "universities"));
    //             List<LdbcQuery1Result.Organization> companies = asOrganization(extractList(result, "companies"));

    //             // Constructing the result
    //             return new LdbcQuery1Result(
    //                 friendId,
    //                 friendLastName,
    //                 distanceFromPerson,
    //                 friendBirthday,
    //                 friendCreationDate,
    //                 friendGender,
    //                 friendBrowserUsed,
    //                 friendLocationIp,
    //                 emails,
    //                 languages,
    //                 friendCityName,
    //                 universities,
    //                 companies
    //             );
    //         } else {
    //             return null;
    //         }
    //     }
    // }

    public static class InteractiveQuery2 extends TypeQLListOperationHandler<LdbcQuery2,LdbcQuery2Result>
    {

        @Override
        public String getQueryString(TypeQLDbConnectionState state, LdbcQuery2 operation) {
            return state.getQueryStore().getParameterizedQuery(QueryType.InteractiveComplexQuery2);
        }

        @Override
        public Map<String, Object> getParameters(TypeQLDbConnectionState state, LdbcQuery2 operation) {
            return state.getQueryStore().getQuery2Map(operation);
        }

        @Override
        public LdbcQuery2Result toResult(ConceptMap result) throws ParseException {
            if (result != null) {
                long friendId = result.get("id").asAttribute().asLong().getValue();
                String name = result.get("name").asAttribute().asString().getValue();
                String surname = result.get("surname").asAttribute().asString().getValue();
                long messageId = result.get("messageId").asAttribute().asLong().getValue();
                String messageContent = result.get("messageContent").asAttribute().asString().getValue();
                long messageCreationDate = result.get("messageDate").asAttribute().asDateTime().getValue().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                return new LdbcQuery2Result(
                    friendId,
                    name,
                    surname,
                    messageId,
                    messageContent,
                    messageCreationDate
                );
            } else {
                return null;
            }
        }
    }

    // Interactive short reads
    // public static class ShortQuery1PersonProfile extends TypeQLSingletonOperationHandler<LdbcShortQuery1PersonProfile,LdbcShortQuery1PersonProfileResult>
    // {
    //     @Override
    //     public String getQueryString(TypeQLDbConnectionState state, LdbcShortQuery1PersonProfile operation) {
    //         return state.getQueryStore().getParameterizedQuery(QueryType.InteractiveShortQuery1);
    //     }

    //     @Override
    //     public Map<String, Object> getParameters(TypeQLDbConnectionState state, LdbcShortQuery1PersonProfile operation) {
    //         return state.getQueryStore().getShortQuery1PersonProfileMap(operation);
    //     }

    //     @Override
    //     public LdbcShortQuery1PersonProfileResult toResult(ConceptMap result) throws ParseException {
    //         if (result != null) {
    //             String firstName = result.get("fn").asAttribute().asString().getValue();
    //             String lastName = result.get("ln").asAttribute().asString().getValue();
    //             long birthday = result.get("bd").asAttribute().asLong().getValue();
    //             String locationIP = result.get("ip").asAttribute().asString().getValue();
    //             String browserUsed = result.get("bu").asAttribute().asString().getValue();
    //             long cityId = result.get("oc-id").asAttribute().asLong().getValue();
    //             String gender = result.get("g").asAttribute().asString().getValue();
    //             long creationDate = result.get("cd").asAttribute().asLong().getValue();
    //             return new LdbcShortQuery1PersonProfileResult(
    //                     firstName,
    //                     lastName,
    //                     birthday,
    //                     locationIP,
    //                     browserUsed,
    //                     cityId,
    //                     gender,
    //                     creationDate );
    //         }
    //         else
    //         {
    //             return null;
    //         }
        
    //     }
    // }
}
