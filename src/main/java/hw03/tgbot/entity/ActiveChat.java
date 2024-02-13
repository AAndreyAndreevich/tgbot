package hw03.tgbot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CHAT_ID")
public class ActiveChat {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "CHAT_ID")
    private Long chatId;
}