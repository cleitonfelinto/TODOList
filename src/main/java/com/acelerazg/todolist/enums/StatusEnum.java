package com.acelerazg.todolist.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public enum StatusEnum {

    TODO(1, "Task that needs to be done"),
    DOING(2, "Task that is already being doing"),
    DONE(3, "Task that is done");

    Integer id;

    String description;

    public static Optional<StatusEnum> getById(Integer id) {
        if(id == null){
            return Optional.empty();
        }

        for(StatusEnum c : StatusEnum.values()){
            if(c.id.equals(id)){
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }
}
