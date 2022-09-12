package com.herman.springboottodoapp.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.herman.springboottodoapp.models.TodoItem;
import com.herman.springboottodoapp.repositories.TodoItemRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class TodoItemDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (todoItemRepository.count() == 0) {
            TodoItem todoItem1 = new TodoItem("Example");
            todoItemRepository.save(todoItem1); 
        }

        logger.info("Number of TodoItems: {}", todoItemRepository.count());
        
    }
    
}
