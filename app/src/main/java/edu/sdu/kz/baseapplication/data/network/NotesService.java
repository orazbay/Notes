package edu.sdu.kz.baseapplication.data.network;


import java.util.ArrayList;

import edu.sdu.kz.baseapplication.data.network.models.DeleteNoteResponse;
import edu.sdu.kz.baseapplication.data.network.models.Note;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface NotesService {

    @GET("data/note")
    Single<ArrayList<Note>> getNotes(
            @Header("user-token") String user_token,
            @Query(value = "where",encoded = true) String whereString,
            @Query(value = "sortBy",encoded = true) String sortString

    );

    @POST("data/note")
    Single<Note> createNote(
            @Header("user-token") String user_token,
            @Body Note note
    );
    @PUT("data/note/{objectId}")
    Single<Note> updateNote(
            @Header("user-token") String user_token,
            @Body Note note,
            @Path("objectId") String objectId
    );
    @DELETE("data/note/{objectId}")
    Single<DeleteNoteResponse> deleteNote(
            @Header("user-token") String user_token,
            @Path("objectId") String objectId
    );




}
