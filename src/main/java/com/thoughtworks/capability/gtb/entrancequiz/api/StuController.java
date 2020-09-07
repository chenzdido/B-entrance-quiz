package com.thoughtworks.capability.gtb.entrancequiz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

@RestController
@Validated
public class StuController {
    Map<Integer, String> studentList=new HashMap<Integer, String>(){
        {
            put(1, "沈乐棋");
            put(2, "徐慧慧");
            put(3, "陈思聪");
            put(4, "王江林");
            put(5, "王登宇");
            put(6, "杨思雨");
            put(7, "江雨舟");
            put(8, "廖燊");
            put(9, "胡晓");
            put(10, "但杰");
            put(11, "盖迈达");
            put(12, "肖美琦");
            put(13, "黄云洁");
            put(14, "齐瑾浩");
            put(15, "刘亮亮");
            put(16, "肖逸凡");
            put(17, "王作文");
            put(18, "郭瑞凌");
            put(19, "郭瑞凌");
            put(20, "党泽");
            put(21, "肖伊佐");
            put(22, "贠晨曦");
            put(23, "李康宁");
            put(24, "马庆");
            put(25, "商婕");
            put(26, "余榕");
            put(27, "谌哲");
            put(28, "董翔锐");
            put(29, "陈泰宇");
            put(30, "赵允齐");
            put(31, "张柯");
            put(32, "廖文强");
            put(33, "刘轲");
            put(34, "廖浚斌");
            put(35, "凌凤仪");
        }
    };
    int count =35;
    Map<Integer, String> group1=Collections.emptyMap();
    Map<Integer, String> group2=Collections.emptyMap();
    Map<Integer, String> group3=Collections.emptyMap();
    Map<Integer, String> group4=Collections.emptyMap();
    Map<Integer, String> group5=Collections.emptyMap();
    Map<Integer, String> group6=Collections.emptyMap();
    Map<String, Map<Integer, String>> groupName=new HashMap<String, Map<Integer, String>>(){
        {
            put("Team 1",group1);
            put("Team 2",group2);
            put("Team 3",group3);
            put("Team 4",group4);
            put("Team 5",group5);
            put("Team 6",group6);
        }
    };

    @GetMapping("/students")
    @ResponseBody
    @CrossOrigin("http://localhost:1234")
    public ResponseEntity<Map<Integer, String>> getStudents(){
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/studentgroup")
    @ResponseBody
    @CrossOrigin("http://localhost:1234")
    public ResponseEntity<Map<Integer, String>> getStudentsGroup(){
        List<Integer> list =new LinkedList(studentList.keySet());
        Map<Integer, String> newStudent=new HashMap<Integer, String>();

        Collections.shuffle(list);
        for(int i=0;i<list.size();i++){
            int k=list.get(i);
            newStudent.put(k,studentList.get(k));
        }
        return ResponseEntity.ok(newStudent);
    }

    @PostMapping("/addStudent")
    @ResponseBody
    @CrossOrigin("http://localhost:1234")
    public ResponseEntity addStudent(@RequestBody String studentName){
        int id = count+1;
        studentList.put(id,studentName);
        return ResponseEntity.ok().build();
    }

}
