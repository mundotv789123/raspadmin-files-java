package github.mundotv789123.raspadmin.models.entities;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "user_sessions")
public class UserSessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter int id;

    @Column(name = "refresh_token")
    private @Getter String refreshToken;

    @Column(name = "expire_at")
    private @Getter Calendar expireAt;

    @Column(name = "created_at")
    private @Getter Calendar createdAt = Calendar.getInstance();
    @Column(name = "updated_at")
    private @Getter Calendar updatedAt = Calendar.getInstance();

    public void setRefreshToken(String refreshToken, int expireMinutes, int activeMinutes) {
        this.refreshToken = refreshToken;

        this.expireAt = Calendar.getInstance();
        this.expireAt.add(Calendar.MINUTE, expireMinutes);

        this.updatedAt = Calendar.getInstance();
    }
}
