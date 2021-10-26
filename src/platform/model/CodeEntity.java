package platform.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "codes")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CodeEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "code")
    private String code;

    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    
    @Column(name = "time")
    private long time;

    @Column(name = "views")
    private long views;

    @Column(name = "view_count")
    private long viewCount;

    @Column(name = "is_secret")
    private boolean isSecret;

    public CodeEntity() {
    }

    public CodeEntity(String code, LocalDateTime date, long time, long views, long viewCount, boolean isSecret) {
        this.code = code;
        this.date = date;
        this.time = time;
        this.views = views;
        this.viewCount = viewCount;
        this.isSecret = isSecret;
    }

    public boolean isSecret() {
        return isSecret;
    }

    public void setSecret(boolean secret) {
        isSecret = secret;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CodeEntity{" +
                "id=" + id +
                ", publishDateTime=" + date +
                '}';
    }
}
