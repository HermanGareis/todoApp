package com.herman.springboottodoapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.herman.springboottodoapp.models.TodoItem;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {

}
