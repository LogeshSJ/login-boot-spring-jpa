package com.codewithlogesh.loginbootspring.jpa.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequest {
    private int id;
    private String todo;
    private int user_id;


}
