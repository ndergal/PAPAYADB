package fr.umlv.papayaDB.databaseManagementSystem;

import java.io.IOException;
import java.util.stream.Stream;

import fr.umlv.papayaDB.databaseManagementSystem.document.Document;
import io.vertx.core.json.JsonObject;

public interface Queryable {
	
	/**
	 * Create the database called name
	 * @param name = The name of the database
	 * @return a empty Stream
	 * @throws IOException if it'snt possible to create the database on the physical storage
	 * @throws IllegalArgumentException if the database already exists
	 */
	public Stream<Document> createDB(String name) throws IOException;
	
	/**
	 * Return all documents containing into the database
	 * @param name = The name of the database
	 * @return a Stream containing all documents of the database
	 * @throws IOException if the database doesn't exist
	 */
	public Stream<Document> getDB(String name) throws IOException;
	
	/**
	 * Drop the database corresponding to the name
	 * @param name = The name of the database
	 * @return a empty Stream
	 * @throws IOException if the database doesn't exist 
	 */
	public Stream<Document> dropDB(String name) throws IOException;
	
	/**
	 * Get documents corresponding to the request in the database
	 * @param name = name of the database
	 * @param request = The criteria of selecting documents
	 * @return a Stream containing all documents corresponding to the request in the database
	 * @throws IOException if the database doesn't exist
	 */
	public Stream<Document> get(String name, String request) throws IOException;
	
	/**
	 * Delete documents of the database corresponding to the name of document in the parameter request
	 * @param name = name of the database
	 * @param request = the name of the document to delete
	 * @return a empty Stream
	 * @throws IOException if the database doesn't exist or it'snt possible to drop on the physical storage
	 */
	public Stream<Document> drop(String name, String request) throws IOException;

	/**
	 * Insert the document in the database
	 * @param name = name of the database
	 * @param request = a JsonObject in String containing all the fields and associated values of the new document
	 * @return a empty Stream
	 * @throws IOException if the database doesn't exist or it'snt possible to create on the physical storage
	 * 
	 */
	public Stream<Document> create(String name, JsonObject request) throws IOException;
}
