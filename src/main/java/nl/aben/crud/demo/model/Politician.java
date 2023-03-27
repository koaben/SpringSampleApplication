package nl.aben.crud.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Politician implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;
    private String party;
    private int age;
    private boolean inCabinet;

    // Constructor, Getter and Setter
}
