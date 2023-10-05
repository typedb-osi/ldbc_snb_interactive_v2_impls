package org.ldbcouncil.snb.impls.workloads.typeql;

import org.ldbcouncil.snb.driver.DbException;
import org.ldbcouncil.snb.driver.control.LoggingService;
import org.ldbcouncil.snb.driver.workloads.interactive.queries.*;
import org.ldbcouncil.snb.impls.workloads.db.BaseDb;
import org.ldbcouncil.snb.impls.workloads.typeql.converter.TypeDBServerConverter;
import org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers.TypeDBServerListOperationHandler;
import org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers.TypeDBServerMultipleUpdateOperationHandler;
import org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers.TypeDBServerSingletonOperationHandler;
import org.ldbcouncil.snb.impls.workloads.typeql.operationhandlers.TypeDBServerUpdateOperationHandler;

// import java.TypeDB.ResultSet;
// import java.TypeDB.TypeDBException;
import java.util.List;
import java.util.Map;

public abstract class TypeDBServerDb extends BaseDb<TypeDBServerQueryStore> {

    @Override
    protected void onInit(Map<String, String> properties, LoggingService loggingService) throws DbException {
        try {
            dcs = new TypeDBServerDbConnectionState(properties, new TypeDBServerQueryStore(properties.get("queryDir")));
        } catch (ClassNotFoundException e) {
            throw new DbException(e);
        }
    }

    // Interactive complex reads

    public static class Query1 extends TypeDBServerListOperationHandler<LdbcQuery1, LdbcQuery1Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery1 operation) {
            return state.getQueryStore().getQuery1(operation);
        }

        @Override
        public LdbcQuery1Result convertSingleResult(ResultSet result) throws TypeDBException {
            LdbcQuery1Result qr = new LdbcQuery1Result(
                    result.getLong(1),
                    result.getString(2),
                    result.getInt(3),
                    TypeDBServerConverter.stringTimestampToEpoch(result, 4),
                    TypeDBServerConverter.stringTimestampToEpoch(result, 5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8),
                    TypeDBServerConverter.arrayToStringArray(result, 9),
                    TypeDBServerConverter.arrayToStringArray(result, 10),
                    result.getString(11),
                    TypeDBServerConverter.arrayToOrganizationArray(result, 12),
                    TypeDBServerConverter.arrayToOrganizationArray(result, 13));
            return qr;
        }
    }

    public static class Query2 extends TypeDBServerListOperationHandler<LdbcQuery2, LdbcQuery2Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery2 operation) {
            return state.getQueryStore().getQuery2(operation);
        }

        @Override
        public LdbcQuery2Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery2Result(
                    result.getLong(1),
                    result.getString(2),
                    result.getString(3),
                    result.getLong(4),
                    result.getString(5),
                    TypeDBServerConverter.stringTimestampToEpoch(result, 6));
        }

    }

    public static class Query3a extends TypeDBServerListOperationHandler<LdbcQuery3a, LdbcQuery3Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery3a operation) {
            return state.getQueryStore().getQuery3(operation);
        }

        @Override
        public LdbcQuery3Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery3Result(
                    result.getLong(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getInt(5),
                    result.getInt(6));
        }
    }

    public static class Query3b extends TypeDBServerListOperationHandler<LdbcQuery3b, LdbcQuery3Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery3b operation) {
            return state.getQueryStore().getQuery3(operation);
        }

        @Override
        public LdbcQuery3Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery3Result(
                    result.getLong(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getInt(5),
                    result.getInt(6));
        }
    }

    public static class Query4 extends TypeDBServerListOperationHandler<LdbcQuery4, LdbcQuery4Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery4 operation) {
            return state.getQueryStore().getQuery4(operation);
        }

        @Override
        public LdbcQuery4Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery4Result(
                    result.getString(1),
                    result.getInt(2));
        }

    }

    public static class Query5 extends TypeDBServerListOperationHandler<LdbcQuery5, LdbcQuery5Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery5 operation) {
            return state.getQueryStore().getQuery5(operation);
        }

        @Override
        public LdbcQuery5Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery5Result(
                    result.getString(1),
                    result.getInt(2));
        }

    }

    public static class Query6 extends TypeDBServerListOperationHandler<LdbcQuery6, LdbcQuery6Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery6 operation) {
            return state.getQueryStore().getQuery6(operation);
        }

        @Override
        public LdbcQuery6Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery6Result(
                    result.getString(1),
                    result.getInt(2));
        }

    }

    public static class Query7 extends TypeDBServerListOperationHandler<LdbcQuery7, LdbcQuery7Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery7 operation) {
            return state.getQueryStore().getQuery7(operation);
        }

        @Override
        public LdbcQuery7Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery7Result(
                    result.getLong(1),
                    result.getString(2),
                    result.getString(3),
                    TypeDBServerConverter.stringTimestampToEpoch(result, 4),
                    result.getLong(5),
                    result.getString(6),
                    result.getInt(7),
                    result.getBoolean(8));
        }

    }

    public static class Query8 extends TypeDBServerListOperationHandler<LdbcQuery8, LdbcQuery8Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery8 operation) {
            return state.getQueryStore().getQuery8(operation);
        }

        @Override
        public LdbcQuery8Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery8Result(
                    result.getLong(1),
                    result.getString(2),
                    result.getString(3),
                    TypeDBServerConverter.stringTimestampToEpoch(result, 4),
                    result.getLong(5),
                    result.getString(6));
        }

    }

    public static class Query9 extends TypeDBServerListOperationHandler<LdbcQuery9, LdbcQuery9Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery9 operation) {
            return state.getQueryStore().getQuery9(operation);
        }

        @Override
        public LdbcQuery9Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery9Result(
                    result.getLong(1),
                    result.getString(2),
                    result.getString(3),
                    result.getLong(4),
                    result.getString(5),
                    TypeDBServerConverter.stringTimestampToEpoch(result, 6));
        }

    }

    public static class Query10 extends TypeDBServerListOperationHandler<LdbcQuery10, LdbcQuery10Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery10 operation) {
            return state.getQueryStore().getQuery10(operation);
        }

        @Override
        public LdbcQuery10Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery10Result(
                    result.getLong(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getString(5),
                    result.getString(6));
        }

    }

    public static class Query11 extends TypeDBServerListOperationHandler<LdbcQuery11, LdbcQuery11Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery11 operation) {
            return state.getQueryStore().getQuery11(operation);
        }

        @Override
        public LdbcQuery11Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery11Result(
                    result.getLong(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getInt(5));
        }
    }

    public static class Query12 extends TypeDBServerListOperationHandler<LdbcQuery12, LdbcQuery12Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery12 operation) {
            return state.getQueryStore().getQuery12(operation);
        }

        @Override
        public LdbcQuery12Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery12Result(
                    result.getLong(1),
                    result.getString(2),
                    result.getString(3),
                    TypeDBServerConverter.arrayToStringArray(result, 4),
                    result.getInt(5));
        }

    }

    public static class Query13a extends TypeDBServerSingletonOperationHandler<LdbcQuery13a, LdbcQuery13Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery13a operation) {
            return state.getQueryStore().getQuery13(operation);
        }

        @Override
        public LdbcQuery13Result convertSingleResult(ResultSet result) throws TypeDBException {
            if (result.next())
            {
                return new LdbcQuery13Result(result.getInt(1));
            }
            else
            {
                return new LdbcQuery13Result(-1);
            }
        }
    }

    public static class Query13b extends TypeDBServerSingletonOperationHandler<LdbcQuery13b, LdbcQuery13Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery13b operation) {
            return state.getQueryStore().getQuery13(operation);
        }

        @Override
        public LdbcQuery13Result convertSingleResult(ResultSet result) throws TypeDBException {
            if (result.next())
            {
                return new LdbcQuery13Result(result.getInt(1));
            }
            else
            {
                return new LdbcQuery13Result(-1);
            }
        }
    }

    public static class Query14a extends TypeDBServerListOperationHandler<LdbcQuery14a, LdbcQuery14Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery14a operation) {
            return state.getQueryStore().getQuery14(operation);
        }

        @Override
        public LdbcQuery14Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery14Result(
                    TypeDBServerConverter.arrayToLongArray(result, 1),
                    result.getLong(2));
        }
    }

    public static class Query14b extends TypeDBServerListOperationHandler<LdbcQuery14b, LdbcQuery14Result> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcQuery14b operation) {
            return state.getQueryStore().getQuery14(operation);
        }

        @Override
        public LdbcQuery14Result convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcQuery14Result(
                    TypeDBServerConverter.arrayToLongArray(result, 1),
                    result.getLong(2));
        }
    }

    public static class ShortQuery1PersonProfile extends TypeDBServerSingletonOperationHandler<LdbcShortQuery1PersonProfile, LdbcShortQuery1PersonProfileResult> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcShortQuery1PersonProfile operation) {
            return state.getQueryStore().getShortQuery1PersonProfile(operation);
        }

        @Override
        public LdbcShortQuery1PersonProfileResult convertSingleResult(ResultSet result) throws TypeDBException {
            if (result.next())
            {
                return new LdbcShortQuery1PersonProfileResult(
                    result.getString(1),
                    result.getString(2),
                    TypeDBServerConverter.stringTimestampToEpoch(result, 3),
                    result.getString(4),
                    result.getString(5),
                    result.getLong(6),
                    result.getString(7),
                    TypeDBServerConverter.stringTimestampToEpoch(result, 8));
            }
            else
            {
                return null;
            }
        }
    }

    public static class ShortQuery2PersonPosts extends TypeDBServerListOperationHandler<LdbcShortQuery2PersonPosts, LdbcShortQuery2PersonPostsResult> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcShortQuery2PersonPosts operation) {
            return state.getQueryStore().getShortQuery2PersonPosts(operation);
        }

        @Override
        public LdbcShortQuery2PersonPostsResult convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcShortQuery2PersonPostsResult(
                    result.getLong(1),
                    result.getString(2),
                    TypeDBServerConverter.stringTimestampToEpoch(result, 3),
                    result.getLong(4),
                    result.getLong(5),
                    result.getString(6),
                    result.getString(7));
        }

    }

    public static class ShortQuery3PersonFriends extends TypeDBServerListOperationHandler<LdbcShortQuery3PersonFriends, LdbcShortQuery3PersonFriendsResult> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcShortQuery3PersonFriends operation) {
            return state.getQueryStore().getShortQuery3PersonFriends(operation);
        }

        @Override
        public LdbcShortQuery3PersonFriendsResult convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcShortQuery3PersonFriendsResult(
                    result.getLong(1),
                    result.getString(2),
                    result.getString(3),
                    TypeDBServerConverter.stringTimestampToEpoch(result, 4));
        }

    }

    public static class ShortQuery4MessageContent extends TypeDBServerSingletonOperationHandler<LdbcShortQuery4MessageContent, LdbcShortQuery4MessageContentResult> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcShortQuery4MessageContent operation) {
            return state.getQueryStore().getShortQuery4MessageContent(operation);
        }

        @Override
        public LdbcShortQuery4MessageContentResult convertSingleResult(ResultSet result) throws TypeDBException {
            if(result.next())
            {
                return new LdbcShortQuery4MessageContentResult(
                    result.getString(1),
                    TypeDBServerConverter.stringTimestampToEpoch(result, 2));
            }
            else
            {
                return null;
            }

        }

    }

    public static class ShortQuery5MessageCreator extends TypeDBServerSingletonOperationHandler<LdbcShortQuery5MessageCreator, LdbcShortQuery5MessageCreatorResult> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcShortQuery5MessageCreator operation) {
            return state.getQueryStore().getShortQuery5MessageCreator(operation);
        }

        @Override
        public LdbcShortQuery5MessageCreatorResult convertSingleResult(ResultSet result) throws TypeDBException {
            if (result.next())
            {
                return new LdbcShortQuery5MessageCreatorResult(
                    result.getLong(1),
                    result.getString(2),
                    result.getString(3));
            }
            else
            {
                return null;
            }
        }

    }

    public static class ShortQuery6MessageForum extends TypeDBServerSingletonOperationHandler<LdbcShortQuery6MessageForum, LdbcShortQuery6MessageForumResult> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcShortQuery6MessageForum operation) {
            return state.getQueryStore().getShortQuery6MessageForum(operation);
        }

        @Override
        public LdbcShortQuery6MessageForumResult convertSingleResult(ResultSet result) throws TypeDBException {
            if (result.next())
            {
                return new LdbcShortQuery6MessageForumResult(
                    result.getLong(1),
                    result.getString(2),
                    result.getLong(3),
                    result.getString(4),
                    result.getString(5));
            }
            else
            {
                return null;
            }
        }

    }

    public static class ShortQuery7MessageReplies extends TypeDBServerListOperationHandler<LdbcShortQuery7MessageReplies, LdbcShortQuery7MessageRepliesResult> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcShortQuery7MessageReplies operation) {
            return state.getQueryStore().getShortQuery7MessageReplies(operation);
        }

        @Override
        public LdbcShortQuery7MessageRepliesResult convertSingleResult(ResultSet result) throws TypeDBException {
            return new LdbcShortQuery7MessageRepliesResult(
                    result.getLong(1),
                    result.getString(2),
                    TypeDBServerConverter.stringTimestampToEpoch(result, 3),
                    result.getLong(4),
                    result.getString(5),
                    result.getString(6),
                    result.getBoolean(7));
        }

    }
    public static class Insert1AddPerson extends TypeDBServerMultipleUpdateOperationHandler<LdbcInsert1AddPerson> {

        @Override
        public List<String> getQueryString(TypeDBServerDbConnectionState state, LdbcInsert1AddPerson operation) {
            return state.getQueryStore().getInsert1Multiple(operation);
        }

    }

    public static class Insert2AddPostLike extends TypeDBServerUpdateOperationHandler<LdbcInsert2AddPostLike> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcInsert2AddPostLike operation) {
            return state.getQueryStore().getInsert2(operation);
        }

    }

    public static class Insert3AddCommentLike extends TypeDBServerUpdateOperationHandler<LdbcInsert3AddCommentLike> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcInsert3AddCommentLike operation) {
            return state.getQueryStore().getInsert3(operation);
        }
    }

    public static class Insert4AddForum extends TypeDBServerMultipleUpdateOperationHandler<LdbcInsert4AddForum> {

        @Override
        public List<String> getQueryString(TypeDBServerDbConnectionState state, LdbcInsert4AddForum operation) {
            return state.getQueryStore().getInsert4Multiple(operation);
        }
    }

    public static class Insert5AddForumMembership extends TypeDBServerUpdateOperationHandler<LdbcInsert5AddForumMembership> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcInsert5AddForumMembership operation) {
            return state.getQueryStore().getInsert5(operation);
        }
    }

    public static class Insert6AddPost extends TypeDBServerMultipleUpdateOperationHandler<LdbcInsert6AddPost> {

        @Override
        public List<String> getQueryString(TypeDBServerDbConnectionState state, LdbcInsert6AddPost operation) {
            return state.getQueryStore().getInsert6Multiple(operation);
        }
    }

    public static class Insert7AddComment extends TypeDBServerMultipleUpdateOperationHandler<LdbcInsert7AddComment> {

        @Override
        public List<String> getQueryString(TypeDBServerDbConnectionState state, LdbcInsert7AddComment operation) {
            return state.getQueryStore().getInsert7Multiple(operation);
        }

    }

    public static class Insert8AddFriendship extends TypeDBServerUpdateOperationHandler<LdbcInsert8AddFriendship> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcInsert8AddFriendship operation) {
            return state.getQueryStore().getInsert8(operation);
        }
    }

    // Deletions
    public static class Delete1RemovePerson extends TypeDBServerUpdateOperationHandler<LdbcDelete1RemovePerson> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcDelete1RemovePerson operation) {
            return state.getQueryStore().getDelete1(operation);
        }
    }

    public static class Delete2RemovePostLike extends TypeDBServerUpdateOperationHandler<LdbcDelete2RemovePostLike> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcDelete2RemovePostLike operation) {
            return state.getQueryStore().getDelete2(operation);
        }
    }

    public static class Delete3RemoveCommentLike extends TypeDBServerUpdateOperationHandler<LdbcDelete3RemoveCommentLike> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcDelete3RemoveCommentLike operation) {
            return state.getQueryStore().getDelete3(operation);
        }
    }

    public static class Delete4RemoveForum extends TypeDBServerUpdateOperationHandler<LdbcDelete4RemoveForum> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcDelete4RemoveForum operation) {
            return state.getQueryStore().getDelete4(operation);
        }
    }

    public static class Delete5RemoveForumMembership extends TypeDBServerUpdateOperationHandler<LdbcDelete5RemoveForumMembership> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcDelete5RemoveForumMembership operation) {
            return state.getQueryStore().getDelete5(operation);
        }
    }

    public static class Delete6RemovePostThread extends TypeDBServerUpdateOperationHandler<LdbcDelete6RemovePostThread> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcDelete6RemovePostThread operation) {
            return state.getQueryStore().getDelete6(operation);
        }
    }

    public static class Delete7RemoveCommentSubthread extends TypeDBServerUpdateOperationHandler<LdbcDelete7RemoveCommentSubthread> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcDelete7RemoveCommentSubthread operation) {
            return state.getQueryStore().getDelete7(operation);
        }
    }

    public static class Delete8RemoveFriendship extends TypeDBServerUpdateOperationHandler<LdbcDelete8RemoveFriendship> {

        @Override
        public String getQueryString(TypeDBServerDbConnectionState state, LdbcDelete8RemoveFriendship operation) {
            return state.getQueryStore().getDelete8(operation);
        }
    }
}
