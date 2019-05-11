package in.net.bookkeeper.checklist.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by krganeshrajhan on 30/11/17.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String text;

    private boolean done;

    private Date createdDate;

    private Date updatedDate;

    private Date completedDate;


    @PrePersist
    public void prePersist() {
        if (createdDate == null) {
            createdDate = new Date();
        }
        updatedDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = new Date();
    }


}
