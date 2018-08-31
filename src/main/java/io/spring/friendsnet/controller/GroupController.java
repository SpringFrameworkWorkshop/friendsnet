package io.spring.friendsnet.controller;

import io.spring.friendsnet.entity.Group;
import io.spring.friendsnet.manager.GroupManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupManager manager;

    @GetMapping
    public List<Group> getAll(){
        return (List<Group>) manager.findAll();
    }

    @GetMapping("/{id}")
    public Group getById(@PathVariable Long id){
        return null;
    }

    @PostMapping
    public Group create(@RequestBody Group group){
        return manager.save(group);
    }

    @PostMapping("/{id}/relate")
    public Group relate(@PathVariable Long id, @RequestBody List<Long> persons){
        return null;
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        manager.remove(id);
    }
}
