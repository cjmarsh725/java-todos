package com.lambdaschool.javatodos;

import com.lambdaschool.javatodos.models.Todo;
import com.lambdaschool.javatodos.models.Users;
import com.lambdaschool.javatodos.repository.TodoRepository;
import com.lambdaschool.javatodos.repository.UsersRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Todo List Application", description = "An application for tracking a todo list")
@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class TodolistController
{
    @Autowired
    TodoRepository todorepo;

    @Autowired
    UsersRepository usersrepo;


    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieved list"),
                    @ApiResponse(code = 401, message = "You are not authorized to the view the resource"),
                    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
            })
    @GetMapping("/users")
    public List<Users> allUsers()
    {
        return usersrepo.findAll();
    }

    @GetMapping("/todos")
    public List<Todo> allTodos()
    {
        return todorepo.findAll();
    }
/*
    GET /users/userid/{userid} - return the user based off of the user id

    GET /users/username/{username} - return the user based off of the user name

    GET /todos/todoid/{todoid} - return the todo based off of the todo id

    GET /todos/users - return a listing of the todos with its assigned user's name

    GET /todos/active - return a listing of the todos not yet completed.

    POST /users - adds a user

    POST /todos - adds a todo

    PUT /users/userid/{userid} - updates a user based on userid

    PUT /todos/todoid/{todoid} - updates a todo based on todoid

    DELETE /users/userid/{userid} - Deletes a user based off of their userid and deletes all their associated todos

    DELETE /todos/todoid/{todoid} - deletes a todo based off its todoid
    */

    @GetMapping("/user/userid/{userid}")
    public Users findUserById(@PathVariable int id)
    {
        var foundUser = usersrepo.findById(id);
        if (foundUser.isPresent()) {
            return foundUser.get();
        } else {
            return null;
        }
    }

    @GetMapping("/users/username/{username}")
    public Users findUserByName(@PathVariable String username)
    {
        var foundUser = usersrepo.findByUsername(username);
        if (foundUser != null) {
            return foundUser;
        } else {
            return null;
        }
    }

    @GetMapping("/todos/todoid/{todoid}")
    public Todo findTodoById(@PathVariable int todoid)
    {
        var foundTodo = todorepo.findById(todoid);
        if (foundTodo.isPresent()) {
            return foundTodo.get();
        } else {
            return null;
        }
    }
}
