package com.lambdaschool.javatodos;

import com.lambdaschool.javatodos.models.Todo;
import com.lambdaschool.javatodos.models.Users;
import com.lambdaschool.javatodos.repository.TodoRepository;
import com.lambdaschool.javatodos.repository.UsersRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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

    @ApiOperation(value = "Returns all todos", response = Todo.class)
    @GetMapping("/todos")
    public List<Todo> allTodos()
    {
        return todorepo.findAll();
    }

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

    @GetMapping("/todos/users")
    public List<Object[]> getTodosAndUsers()
    {
        return todorepo.todosWithUsers();
    }

    @GetMapping("/todos/active")
    public List<Todo> getActiveTodos()
    {
        return todorepo.activeTodos();
    }

    @PostMapping("/users")
    public Users newUser(@RequestBody Users user) throws URISyntaxException
    {
        return usersrepo.save(user);
    }

    @PostMapping("/todos")
    public Todo newTodo(@RequestBody Todo todo) throws URISyntaxException
    {
        return todorepo.save(todo);
    }

    @PutMapping("/users/userid/{userid}")
    public Users changeUser(@RequestBody Users newUser, @PathVariable int id) throws URISyntaxException
    {
        Optional<Users> updateUser = usersrepo.findById(id);
        if (updateUser.isPresent()) {
            newUser.setUserid(id);
            usersrepo.save(newUser);
            return newUser;
        } else {
            return null;
        }
    }

    @PutMapping("/todos/todoid/{todoid}")
    public Todo changeTodo(@RequestBody Todo newTodo, @PathVariable int id) throws URISyntaxException
    {
        Optional<Todo> updateTodo = todorepo.findById(id);
        if (updateTodo.isPresent()) {
            newTodo.setTodoid(id);
            todorepo.save(newTodo);
            return newTodo;
        } else {
            return null;
        }
    }

    @DeleteMapping("/users/userid/{userid}")
    public Users deleteUser(@PathVariable int userid)
    {
        var foundUser = usersrepo.findById(userid);
        if (foundUser.isPresent())
        {
            usersrepo.deleteById(userid);
            return foundUser.get();
        }
        else
        {
            return null;
        }
    }

    @DeleteMapping("/todos/todoid/{todoid}")
    public Todo deleteTodo(@PathVariable int todoid)
    {
        var foundTodo = todorepo.findById(todoid);
        if (foundTodo.isPresent())
        {
            todorepo.deleteById(todoid);
            return foundTodo.get();
        }
        else
        {
            return null;
        }
    }

}
