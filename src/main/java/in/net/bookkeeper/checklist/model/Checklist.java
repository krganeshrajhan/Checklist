package in.net.bookkeeper.checklist.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by krganeshrajhan on 30/11/17.
 */
@Entity
@Data
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String text;

    private boolean done;

    /*public Checklist(String text) {
        this.text = text;
    }*/

}
