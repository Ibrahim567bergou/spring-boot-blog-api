package com.blog.blogrbac_system.entity;

import com.blog.blogrbac_system.constant.NotificationType;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Table(name = "notifications", schema = "articles")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_gen")
    @SequenceGenerator(name = "notification_id_gen", sequenceName = "notification_pkid_notification_seq", allocationSize = 1, schema = "articles")
    @Column(name = "pkid_notification")
    private Integer id;

    @Column(name = "message", nullable = false, columnDefinition = "text")
    private String message;

    @Column(name = "type", nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @Column(name = "is_read", nullable = false)
    private boolean isRead;

    @Column(name = "create_at")
    private Instant createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkid_user")
    private User fkidUser;
}
