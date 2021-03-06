package ru.otus.ovodkov.homework8.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Document(collection = "genres")
public class Genre {

    @Id
    private ObjectId id;

    private String name;

    @Override
    public String toString() {
        return "Genre{" +
                " genreId = " + id +
                ", name = " + name +
                " }";
    }
}
