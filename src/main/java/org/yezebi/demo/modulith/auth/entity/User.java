package org.yezebi.demo.modulith.auth.entity;

import com.google.firebase.auth.UserRecord;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yezebi.demo.modulith.core.entity.Auditable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends Auditable {
  @Id private String id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String username;

  public static User from(final UserRecord record) {
    return User.builder()
        .id(record.getUid())
        .email(record.getEmail())
        .username(record.getDisplayName())
        .build();
  }
}
