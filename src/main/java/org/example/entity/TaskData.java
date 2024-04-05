package org.example.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }


    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String name){
        switch (name){
            case"ann":
                return this.annsTasks;
            case"bob":
                return this.bobsTasks;
            case"carol":
                return this.carolsTasks;
            case"all":
                return this.getUnion(bobsTasks,annsTasks,carolsTasks);

        }
        return new HashSet<>();
    }

    public Set<Task> getUnion(Set<Task>...sets) {
        HashSet<Task> total=new LinkedHashSet<>();
        for (Set<Task> taskSet:sets){
            total.addAll(taskSet);
        }
        return total;
    }

    public Set<Task> getIntersection(Set<Task> first,Set<Task> second){
        Set<Task> intersections = new HashSet<>(first);
        intersections.retainAll(second);
        return intersections;
    }

    public Set<Task> getDifferences(Set<Task> first, Set<Task> second){
        Set<Task> differences= new HashSet<>(first);
        differences.removeAll(second);
        return differences;
    }











}
