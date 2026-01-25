package com.taskmind.userservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//We put this file under the model folder because it's a part of the MongoDB.
@Document(collection = "database_sequences")
@Data
public class DatabaseSequence {
    @Id
    private String id; // the name of thr sequence (for example "users_sequence")
    private long seq;  // current number
}