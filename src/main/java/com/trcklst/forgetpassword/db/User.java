package com.trcklst.forgetpassword.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document("users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Integer id;
    @Field
    private String username;
    @Field
    private String password;
    @Field
    private String restPasswordToken;
}
