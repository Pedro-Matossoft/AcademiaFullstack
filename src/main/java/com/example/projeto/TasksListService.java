package com.example.projeto;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TasksListService {

    private static List<TasksList> TasksLists = new ArrayList<>();
    private static int id = 0;

    static {
        TasksLists.add(new TasksList(++id,"Admin","Test1", LocalDate.now(),false));
        TasksLists.add(new TasksList(++id,"Admin","Test2", LocalDate.now(),false));
        TasksLists.add(new TasksList(++id,"User","Test3", LocalDate.now(),false));
        TasksLists.add(new TasksList(++id,"User","Test4", LocalDate.now(),false));
    }

    public static List<TasksList> findByUsername(String username) {
        return TasksLists;
    }

    public static void newtasks(String username, String description, LocalDate date, boolean done){
        TasksList TasksList = new TasksList(++id,username,description,date,done);
        TasksLists.add(TasksList);
    }

    public void deleteById(int id) {
        TasksLists.removeIf(TasksList -> TasksList.getId() == id);
    }
}