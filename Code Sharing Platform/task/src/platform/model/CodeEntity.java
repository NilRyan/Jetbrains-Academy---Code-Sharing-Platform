package platform.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "codes")
public class CodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "publish_date_time")
    private LocalDateTime publishDateTime;

    public CodeEntity(Long id, LocalDateTime publishDateTime) {
        this.id = id;
        this.publishDateTime = publishDateTime;
    }

    public CodeEntity() {
    }

    public CodeEntity(LocalDateTime publishDateTime) {
        this.publishDateTime = publishDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPublishDateTime() {
        return publishDateTime;
    }

    public void setPublishDateTime(LocalDateTime publishDateTime) {
        this.publishDateTime = publishDateTime;
    }

    @Override
    public String toString() {
        return "CodeEntity{" +
                "id=" + id +
                ", publishDateTime=" + publishDateTime +
                '}';
    }
}
